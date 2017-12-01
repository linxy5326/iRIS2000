/*
  Web API JS 请求接口
*/

(function () {

    var _webApi = function (selector, context, fn) {
        return new _webApi.fn.init(selector, context, fn);
    };

    var baseUrl = "http://localhost:8080/api";

    var url, _fn;
    var api_err;

    _webApi.fn = _webApi.prototype = {
        constructor: _webApi,//原型字面量方式会将对象的constructor变为Object，此外强制指回Person
        version: "1.0",
        init: function (url, context, fn) {

            if (url && typeof url === "string") {
                url = url;
            }
            else if (isFunction(url)) {
                _fn = url;
            }

            if (context && isFunction(context)) {
                _fn = context;
            }
            return this;
        },
        get: function (param) {
            var requesturl = url || baseUrl;
            if (param)
                requesturl = requesturl + param;
            $.ajax({
                type: "GET",
                url: requesturl,
                data: null,
                success: function (result) {
                    if (_fn) _fn(result);
                },
                error: function (xhr) {
                    //{readyState: 0, responseText: "", status: 0, statusText: "error"}
                    console.log(xhr);
                    if (_fn) _fn(xhr);
                }
            });
            return this;
        },
        post: function (data) {

        },
        put: function (data) {

        },
        del: function () {

        }
    };

    function isFunction(obj) {
        return obj && typeof obj === "function";
    }


    _webApi.fn.GetRequest = function GetRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

    //实例方法
    _webApi.fn.init.prototype = _webApi.fn;

    window.webApi = _webApi;

    return _webApi;
})();
//(function () {
//    //本地存储
//    localData = {
//        hname: location.hostname ? location.hostname : 'localStatus',
//        isLocalStorage: window.localStorage ? true : false,
//        dataDom: null,

//        initDom: function () { //初始化userData
//            if (!this.dataDom) {
//                try {
//                    this.dataDom = document.createElement('input');//这里使用hidden的input元素
//                    this.dataDom.type = 'hidden';
//                    this.dataDom.style.display = "none";
//                    this.dataDom.addBehavior('#default#userData');//这是userData的语法
//                    document.body.appendChild(this.dataDom);
//                    var exDate = new Date();
//                    exDate = exDate.getDate() + 30;
//                    this.dataDom.expires = exDate.toUTCString();//设定过期时间
//                } catch (ex) {
//                    return false;
//                }
//            }
//            return true;
//        },
//        set: function (key, value) {
//            if (this.isLocalStorage) {
//                window.localStorage.setItem(key, value);
//            } else {
//                if (this.initDom()) {
//                    this.dataDom.load(this.hname);
//                    this.dataDom.setAttribute(key, value);
//                    this.dataDom.save(this.hname);
//                }
//            }
//        },
//        get: function (key) {
//            if (this.isLocalStorage) {
//                return window.localStorage.getItem(key);
//            } else {
//                if (this.initDom()) {
//                    this.dataDom.load(this.hname);
//                    return this.dataDom.getAttribute(key);
//                }
//            }
//        },
//        remove: function (key) {
//            if (this.isLocalStorage) {
//                localStorage.removeItem(key);
//            } else {
//                if (this.initDom()) {
//                    this.dataDom.load(this.hname);
//                    this.dataDom.removeAttribute(key);
//                    this.dataDom.save(this.hname);
//                }
//            }
//        }
//    };
//})();
