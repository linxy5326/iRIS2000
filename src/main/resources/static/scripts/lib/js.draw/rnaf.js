

window.requestNextAnimationFrame =
   (function () {
       var originalWebkitRequestAnimationFrame = undefined,
           wrapper = undefined,
           callback = undefined,
           geckoVersion = 0,
           userAgent = navigator.userAgent,
           index = 0,
           self = this;

       // Workaround for Chrome 10 bug where Chrome
       // does not pass the time to the animation function

       if (window.webkitRequestAnimationFrame) {
           // Define the wrapper

           wrapper = function (time) {
               if (time === undefined) {
                   time = +new Date();
               }
               self.callback(time);
           };

           // Make the switch

           originalWebkitRequestAnimationFrame = window.webkitRequestAnimationFrame;

           window.webkitRequestAnimationFrame = function (callback, element) {
               self.callback = callback;

               // Browser calls the wrapper and wrapper calls the callback

               originalWebkitRequestAnimationFrame(wrapper, element);
           }
       }
       if (window.mozRequestAnimationFrame) {
           // Check the Gecko version. Gecko is used by browsers
           // other than Firefox. Gecko 2.0 corresponds to
           // Firefox 4.0.

           index = userAgent.indexOf('rv:');

           if (userAgent.indexOf('Gecko') != -1) {
               geckoVersion = userAgent.substr(index + 3, 3);

               if (geckoVersion === '2.0') {
                   // Forces the return statement to fall through
                   // to the setTimeout() function.

                   window.mozRequestAnimationFrame = undefined;
               }
           }
       }

       return window.requestAnimationFrame ||
          window.webkitRequestAnimationFrame ||
          window.mozRequestAnimationFrame ||
          window.oRequestAnimationFrame ||
          window.msRequestAnimationFrame ||

          function (callback, element) {
              var start,
                  finish;

              window.setTimeout(function () {
                  start = +new Date();
                  callback(start);
                  finish = +new Date();

                  self.timeout = 1000 / 60 - (finish - start);

              }, self.timeout);
          };
   }
   )();

//cancelNextRequestAnimationFrame Event
window.cancelNextRequestAnimationFrame = window.cancelRequestAnimationFrame
    || window.webkitCancelAnimationFrame
    || window.webkitCancelRequestAnimationFrame
    || window.mozCancelRequestAnimationFrame
    || window.oCancelRequestAnimationFrame
    || window.msCancelRequestAnimationFrame
    || clearTimeout;

Stopwatch = function () {
};

// You can get the elapsed time while the timer is running, or after it's
// stopped.

Stopwatch.prototype = {
    startTime: 0,
    running: false,
    elapsed: undefined,

    start: function () {
        this.startTime = +new Date();
        this.elapsedTime = undefined;
        this.running = true;
    },

    stop: function () {
        this.elapsed = (+new Date()) - this.startTime;
        this.running = false;
    },

    getElapsedTime: function () {
        if (this.running) {
            return (+new Date()) - this.startTime;
        }
        else {
            return this.elapsed;
        }
    },

    isRunning: function () {
        return this.running;
    },

    reset: function () {
        this.elapsed = 0;
    }
};
// AnimationTimer..................................................................
//

AnimationTimer = function (duration, timeWarp) {
    this.timeWarp = timeWarp;

    if (duration !== undefined) this.duration = duration;
    else this.duration = 1000;

    this.stopwatch = new Stopwatch();
};

AnimationTimer.prototype = {
    start: function () {
        this.stopwatch.start();
    },

    stop: function () {
        this.stopwatch.stop();
    },

    getRealElapsedTime: function () {
        return this.stopwatch.getElapsedTime();
    },

    getElapsedTime: function () {
        var elapsedTime = this.stopwatch.getElapsedTime(),
            percentComplete = elapsedTime / this.duration;

        if (!this.stopwatch.running) return undefined;
        if (this.timeWarp == undefined) return elapsedTime;

        return elapsedTime * (this.timeWarp(percentComplete) / percentComplete);
    },

    isRunning: function () {
        return this.stopwatch.running;
    },

    isOver: function () {
        return this.stopwatch.getElapsedTime() > this.duration;
    },

    reset: function () {
        this.stopwatch.reset();
    }
};

//缓出
AnimationTimer.makeEaseOut = function (strength) {
    return function (percentComplete) {
        return 1 - Math.pow(1 - percentComplete, strength * 2);
    };
};
//缓入
AnimationTimer.makeEaseIn = function (strength) {
    return function (percentComplete) {
        return Math.pow(percentComplete, strength * 2);
    };
};
//缓入缓出
AnimationTimer.makeEaseInOut = function () {
    return function (percentComplete) {
        return percentComplete - Math.sin(percentComplete * 2 * Math.PI) / (2 * Math.PI);
    };
};
//弹簧运动
AnimationTimer.makeElastic = function (passes) {
    passes = passes || 3;
    return function (percentComplete) {
        return ((1 - Math.cos(percentComplete * Math.PI * passes)) *
                (1 - percentComplete)) + percentComplete;
    };
};
//弹跳运动
AnimationTimer.makeBounce = function (bounces) {
    var fn = AnimationTimer.makeElastic(bounces);
    return function (percentComplete) {
        percentComplete = fn(percentComplete);
        return percentComplete <= 1 ? percentComplete : 2 - percentComplete;
    };
};
//线性运动
AnimationTimer.makeLinear = function () {
    return function (percentComplete) {
        return percentComplete;
    };
};
/**************
 * 计时器对象
 * yehui
 * 2015年6月27日  
 *****************/
AnimateTimer = function (fn, time) {
    this.Time = time;
    this.fn = fn;
    this.pushAT;
};

AnimateTimer.prototype = {
    TimerStart: function (time) {
        if (!time)
            time = this.Time;
        if (!this.fn || typeof (this.fn) != "function") return;
        this.pushAT = new AnimationTimer(time);
        var fn = this.fn, anime = this.pushAT;
        function timer_Enable() {
            if (anime.isRunning() && anime.isOver()) {
                fn();
                anime.stop();
            }
            else if (!anime.isRunning()) {
                anime.start();
            }
            requestAnimationFrame(timer_Enable);
        };
        timer_Enable();
    },
    TimerEnd: function () {
        if (this.pushAT) {
            this.pushAT.stop();
        }
    }
};


/*******************
*远程监控界面JS代码
*作者：叶辉
*日期：2016年2月23日
*******************/
(function () {
    var _monitor;
    _monitor = function (selector, context) {
        return _monitor.fn.init(selector, context);
    };

    _monitor.fn = _monitor.prototype = {
        init: function (selector, context) {

        },
        win_size: function () {
            var winWidth = 0;
            var winHeight = 0;
            //获取窗口宽度
            if (window.innerWidth)
                winWidth = window.innerWidth;
            else if ((document.body) && (document.body.clientWidth))
                winWidth = document.body.clientWidth;
            //获取窗口高度
            if (window.innerHeight)
                winHeight = window.innerHeight;
            else if ((document.body) && (document.body.clientHeight))
                winHeight = document.body.clientHeight;
            //通过深入Document内部对body进行检测，获取窗口大小
            if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) {
                winHeight = document.documentElement.clientHeight;
                winWidth = document.documentElement.clientWidth;
            }
            return { windth: winWidth, height: winHeight };
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
        encodeURI: function (parameter) {
            return encodeURIComponent ? encodeURIComponent(parameter) : escape(parameter);
        },
        requestData: function (option) {
            if (option) {
                $.ajax(option);
            }
        },
        failStyle: function (obj, interval, speed) {
            var oBox = obj, display = "none";
            var timer = null;
            var i = 0;
            if (oBox) {
                display = oBox.style.display;
                clearInterval(timer);
                timer = setInterval(function () {
                    if (i === speed) {
                        oBox.style.display = display;
                        clearInterval(timer);
                    }
                    oBox.style.display = i++ % 2 ? "none" : "block";
                    i > speed && (clearInterval(timer))
                }, interval)
            }
        },
        convertValue: function (obj, scle) {
            var value = 0, s = 0;
            if (scle && _monitor.isNumeric(scle)) s = scle;
            if (obj && obj !== "") {

                if (_monitor.isNumeric(obj)) {
                    value = parseFloat(obj).toFixed(scle);
                }
            }
            return value;
        }
    };


    //实例方法
    _monitor.fn.init.prototype = _monitor.fn;


    // extend方法为自身对象和init对象的prototype扩展方法
    // 同时具有独立的扩展普通对象的功能
    _monitor.extend = _monitor.fn.extend = function () {
        /***********************
   　　 *target被扩展的对象
    　　*length参数的数量
    　　*deep是否深度操作
    　　***********************/
        var options, name, src, copy, copyIsArray, clone, target = arguments[0] || {}, i = 1, length = arguments.length, deep = false;
        // target为第一个参数，如果第一个参数是Boolean类型的值，则把target赋值给deep
        // deep表示是否进行深层面的复制，当为true时，进行深度复制，否则只进行第一层扩展
        // 然后把第二个参数赋值给target
        if (typeof target === "boolean") {
            deep = target;
            target = arguments[1] || {};
            // 将i赋值为2，跳过前两个参数
            i = 2;
        }
        // target既不是对象也不是函数则把target设置为空对象。
        if (typeof target !== "object" && _monitor.isFunction(target)) {
            target = {};
        }
        // 如果只有一个参数，则把jQuery对象赋值给target，即扩展到自身对象上
        if (length === i) {
            target = this;
            // i减1，指向被扩展对象
            --i;
        }

        // 开始遍历需要被扩展到target上的参数
        for (; i < length; i++) {
            // 处理第i个被扩展的对象，即除去deep和target之外的对象
            if ((options = arguments[i]) != null) {
                // 遍历第i个对象的所有可遍历的属性
                for (name in options) {
                    // 根据被扩展对象的键获得目标对象相应值，并赋值给src
                    src = target[name];
                    // 得到被扩展对象的值
                    copy = options[name];
                    // 这里为什么是比较target和copy？不应该是比较src和copy吗？
                    if (target === copy) {
                        continue;
                    }
                    // 当用户想要深度操作时，递归合并
                    // copy是纯对象或者是数组
                    if (deep && copy && (typeof copy === "object" || (copyIsArray = _monitor.isArray(copy)))) {
                        // 如果是数组
                        if (copyIsArray) {
                            // 将copyIsArray重新设置为false，为下次遍历做准备。
                            copyIsArray = false;
                            // 判断被扩展的对象中src是不是数组
                            clone = src && _monitor.isArray(src) ? src : [];
                        } else {
                            // 判断被扩展的对象中src是不是纯对象
                            clone = src && typeof src === "object" ? src : {};
                        }
                        // 递归调用extend方法，继续进行深度遍历
                        target[name] = _monitor.extend(deep, clone, copy);

                        // 如果不需要深度复制，则直接把copy（第i个被扩展对象中被遍历的那个键的值）
                    } else if (copy !== undefined) {
                        target[name] = copy;
                    }
                }
            }
        }
        // 原对象被改变，因此如果不想改变原对象，target可传入{}
        return target;
    }

    _monitor.extend({
        isLog: true,
        getType: function (obj) {
            var _t;
            return ((_t = typeof (o)) == "object" ? o == null && "null" || Object.prototype.toString.call(o).slice(8, -1) : _t).toLowerCase();
        },
        isFunction: function (obj) {
            return obj && typeof obj === "function";
        },
        isArray: Array.isArray || function (obj) {
            return obj && typeof obj === "array";
        },
        isWindow: function (obj) {
            return obj != null && obj == obj.window;
        },
        isNumeric: function (obj) {
            return !isNaN(parseFloat(obj)) && isFinite(obj);
        },
        log: function (obj, isEx) {
            (_monitor.isLog || isEx) ? console.log(obj || "") : null;
        }
    });
    _monitor.extend({ tools: {} });
    _monitor.extend(_monitor.tools, {
        foreach: function (obj, fn) {
            var cindex = 0;
            if (_monitor.isArray(obj)) {
                function each() {
                    if (cindex >= obj.length) return;
                    fn(cindex, obj[cindex]);
                    cindex++;
                    each();
                }
                each();
            }
        },
        localStorage: function storage(option) {//HTML5本地存储
            var result;
            try {
                'localStorage' in window && window['localStorage'] !== null ? (option ? (typeof option === "string" ? result = localStorage.getItem(option) : localStorage.setItem(option.key, option.value)) : result = window.localStorage) : undefined;
            } catch (e) {
                return undefined;
            }
            return result;
        }
    });
    
    window.Monitor = _monitor;


    //扩展Date 类型，添加格式化方法。
    Date.prototype.format = function (format) {
        var o = {
            "M+": this.getMonth() + 1, //month
            "d+": this.getDate(),    //day
            "h+": this.getHours(),   //hour
            "m+": this.getMinutes(), //minute
            "s+": this.getSeconds(), //second
            "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
            "S": this.getMilliseconds() //millisecond
        }
        if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
 (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o) if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1,
 RegExp.$1.length == 1 ? o[k] :
 ("00" + o[k]).substr(("" + o[k]).length));
        return format;
    };
}());