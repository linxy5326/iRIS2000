/* Copyright (c) 2017, www.bige.com  Inc. All rights reserved.
 version: 1.0.0
 author:yehui
 date:2017/11/18
*/
(function () {
    if (typeof xabg == "undefined" || !xabg) {
        //xabg全局名称空间对象. 如果xabg已经定义，原先的xabg对象不会被覆写，所以定义过的名称空间是受保护的。
        var xabg = {};
    }

    xabg = {
         /**
     * 说明：	返回指定的名称空间，如果该名称空间不存在就创建它。
     * <pre>
     * xabg.namespace("property.package");
     * xabg.namespace("xabg.property.package");
     * </pre>
     * 上面的两种方式都会创建xabg.property，然后创建xabg.property.package。
     * @method ns
     * @static
     * @param  {String*} 1个或更多个需要创建的名称空间。
     * @return {Object}  所创建的名称空间对象中最后一个的引用。
     */
        ns: function () {
            var a = arguments, obj = null, i, j, d;
            for (i = 0; i < a.length; i = i + 1) {
                d = ("" + a[i]).split(".");
                obj = xabg;

                // xabg is implied, so it is ignored if it is included
                for (j = (d[0] == "xabg") ? 1 : 0; j < d.length; j = j + 1) {
                    obj[d[j]] = obj[d[j]] || {};
                    obj = obj[d[j]];
                }
            }
            return obj;
        },
        delay: function (t, fn, isFor) {
            //延时函数，接收两个参数 t延迟时间秒为单位，fn要执行的函数,//请注意还要个免费的this参数可以让这个delay更完美
            var _this = this,
                d = setTimeout(function () {
                    clearTimeout(d);
                    fn.apply(_this);
                    if (isFor)
                        _this.delay(t, fn, isFor);
                }, t * 1000);
            return d;
        },
        strFormat: function () {
            var args = arguments, result = arguments[0];
            if (args.length > 0) {
                for (var i = 1; i < arguments.length; i++) {
                    if (arguments[i] === undefined || arguments[i] == null) {
                        arguments[i] = "";
                    }
                    var reg = new RegExp("({)" + (i - 1) + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
            return result;
        } ,
        /*打开一个新窗口
           *参数 option ={url:打开的网址，title:窗口标题}, "toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no"
           */
        openWin: function (option) {
            if (option)
                window.open(option.url || "", option.title || "");
            else
                alert("请指定打开网址");
        },
        getCookie: getCk,
        setCookie: setCk,
        clearCookie: clearCk
    };

    //设置cookie
    var passKey = '4c05c54d952b11e691d76c0b843ea7f9';
    function setCk(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toUTCString();
        document.cookie = cname + "=" + encrypt(escape(cvalue), passKey) + "; " + expires + "; path =/";
        path = "/";
    }
    //获取cookie
    function getCk(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') c = c.substring(1);
            if (c.indexOf(name) != -1) {
                var cnameValue = unescape(c.substring(name.length, c.length));
                return decrypt(cnameValue, passKey);
            }
        }
        return "";
    }
    //清除cookie
    function clearCk(cname) {
    	setCk(cname, "", -1);
    }

    xabg.ns("xabg.core");
    //xabg.ns("mui.plugin");
    //xabg.ns("mui.controls");
    //xabg.ns("mui.ui");

    window.xabg = xabg;
})();
