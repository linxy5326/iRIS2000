(function () {
    var class2type = {},
        core_deletedIds = [],
        core_slice = core_deletedIds.slice,
        core_toString = class2type.toString,
        core_hasOwn = class2type.hasOwnProperty;

    // 百度地图API功能
    var _bMap, map;

    _bMap = function (option) {
        return new _bMap.fn.init_map(option);
    }

    _bMap.fn = _bMap.prototype = {
        constructor: _bMap,
        init_map: function (option) {
            map = new BMap.Map(option.conname, { mapType: BMAP_HYBRID_MAP });    // 创建Map实例
            map.centerAndZoom(option.point, option.zoom);  // 初始化地图,设置中心点坐标和地图级别108.953, 34.267, , BMAP_HYBRID_MAP, BMAP_NORMAL_MAP
            //添加地图类型控件
            map.addControl(new BMap.MapTypeControl({ mapTypes: [BMAP_HYBRID_MAP, BMAP_NORMAL_MAP] }));
            map.setCurrentCity(option.city);            // 设置地图显示的城市 此项是必须设置的
            map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
            map.addControl(new BMap.ScaleControl());    // 添加默认比例尺控件
            map.addControl(new BMap.OverviewMapControl());          //添加默认缩略地图控件

            //扩展实例属性
            _bMap.fn.map = map;
            _bMap.fn.zoom = map.getZoom();

            //设置地图样式
            blueStyle();
            //注册事件
            // bmap_event(map);
            return this;
        },
        toArray: function () {
            return core_slice.call(this);
        }
    };

    _bMap.fn.init_map.prototype = _bMap.fn;

    _bMap.extend = _bMap.fn.extend = function () {
        var options, name, src, copy, copyIsArray, clone, target = arguments[0] || {}, i = 1, length = arguments.length, deep = false;
        if (typeof target === "boolean") {
            deep = target;
            target = arguments[1] || {};
            // skip the boolean and the target
            i = 2;
        }
        if (typeof target !== "object" && !_bMap.isFunction(target)) {
            target = {};
        }
        if (length === i) {
            target = this;
            --i;
        }
        for (; i < length; i++) {
            if ((options = arguments[i]) != null) {
                for (name in options) {
                    src = target[name];
                    copy = options[name];
                    if (target === copy) {
                        continue;
                    }
                    if (deep && copy && (_bMap.isPlainObject(copy) || (copyIsArray = _bMap.isArray(copy)))) {
                        if (copyIsArray) {
                            copyIsArray = false;
                            clone = src && _bMap.isArray(src) ? src : [];
                        } else {
                            clone = src && _bMap.isPlainObject(src) ? src : {};
                        }
                        target[name] = _bMap.extend(deep, clone, copy);
                    } else if (copy !== undefined) {
                        target[name] = copy;
                    }
                }
            }
        }
        return target;
    }

    _bMap.extend({
        isFunction: function (obj) {
            return _bMap.type(obj) === "function";
        },
        isArray: Array.isArray || function (obj) {
            return _bMap.type(obj) === "array";
        },
        isWindow: function (obj) {
            /* jshint eqeqeq: false */
            return obj != null && obj == obj.window;
        },
        type: function (obj) {
            if (obj == null) {
                return String(obj);
            }
            return typeof obj === "object" || typeof obj === "function" ?
                class2type[core_toString.call(obj)] || "object" :
                typeof obj;
        },
        each: function (obj, callback) {
            var length, i = 0;

            if (isArrayLike(obj)) {
                length = obj.length;
                for (; i < length; i++) {
                    if (callback.call(obj[i], i, obj[i]) === false) {
                        break;
                    }
                }
            } else {
                for (i in obj) {
                    if (callback.call(obj[i], i, obj[i]) === false) {
                        break;
                    }
                }
            }
            return obj;
        },
        isPlainObject: function (obj) {
            var key;
            if (!obj || _bMap.type(obj) !== "object" || obj.nodeType || _bMap.isWindow(obj)) {
                return false;
            }

            try {
                if (obj.constructor &&
                    !core_hasOwn.call(obj, "constructor") &&
                    !core_hasOwn.call(obj.constructor.prototype, "isPrototypeOf")) {
                    return false;
                }
            } catch (e) {

                return false;
            }
            for (key in obj) { }

            return key === undefined || core_hasOwn.call(obj, key);
        }
    });
    function isArrayLike(obj) {
        var length = !!obj && "length" in obj && obj.length,
            type = _bMap.type(obj);

        if (type === "function" || _bMap.isWindow(obj)) {
            return false;
        }

        return type === "array" || length === 0 ||
            typeof length === "number" && length > 0 && (length - 1) in obj;
    }

    _bMap.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function (i, name) {
        class2type["[object " + name + "]"] = name.toLowerCase();
    });

    //给覆盖物注册事件
    function bmap_marker_event(marker) {

        //点击标注图标后会触发此事件
        map_event(marker).click(function (e) {

        });
        //鼠标双击地图时会触发此事件
        map_event(marker).dbclick(function (e) {

        });
        //右键单击地图时触发此事件。
        map_event(marker).rightclick(function (e) {

        });
        //鼠标离开标注时触发此事件
        map_event(marker).mouseout(function (e) {

        });
        //当鼠标进入标注图标区域时会触发此事件
        map_event(marker).mouseover(function (e) {

        });
    }

    //常用事件注册类
    function map_event(target) {
        return {
            click: function (fn) {
                target.addEventListener("click", fn);
            }, dbclick: function (fn) {
                target.addEventListener("dbclick", fn);
            },
            rightclick: function (fn) {
                target.addEventListener("rightclick", fn);
            },
            mousemove: function (fn) {
                target.addEventListener("mousemove", fn);
            },
            mouseover: function (fn) {
                target.addEventListener("mouseover", fn);
            },
            mouseout: function (fn) {
                target.addEventListener("mouseout", fn);
            }, customer: function (event, fn) {
                if (event)
                    target.addEventListener(event, fn);
            }
        };
    }

    //给地图注册事件
    _bMap.fn.extend({
        click: function (fn) {
            map.addEventListener("click", fn);
        }, dblclick: function (fn) {
            map.addEventListener("dblclick", fn);
        }, rightclick: function (fn) {
            map.addEventListener("rightclick", fn);
        },
        mousedown: function (fn) {
            map.addEventListener("mousedown", fn);
        },
        mousemove: function (fn) {
            map.addEventListener("mousemove", fn);
        }, movestart: function (fn) {
            map.addEventListener("movestart", fn);
        },
        zoomstart: function (fn) {
            map.addEventListener("zoomstart", fn);
        }, zoomend: function (fn) {
            map.addEventListener("zoomend", fn);
        }
    });
    //扩展地图方法
    _bMap.fn.extend({
        marker: addMarker,
        polyline: drawPolyline
    });

    /**
markerOptions:
*offset Size 标注的位置偏移值
*icon Icon 标注所用的图标对象
*enableMassClear Boolean 是否在调用map.clearOverlays清除此覆盖物，默认为true
*enableDragging Boolean 是否启用拖拽，默认为false
*enableClicking Boolean 是否响应点击事件。默认为true
*raiseOnDrag Boolean 拖拽标注时，标注是否开启离开地图表面效果。默认为false
*draggingCursor String 拖拽标注时的鼠标指针样式。此属性值需遵循CSS的cursor属性规范
*rotation Number 旋转角度
*shadow Icon 阴影图标
*title String 鼠标移到marker上的显示内容
     */
    function addMarker(opt) {
        if (opt) {
            var marker = new BMap.Marker(opt.point, opt.options);  // 创建标注
            map.addOverlay(marker);              // 将标注添加到地图中

            if (opt.click)
                map_event(marker).click(opt.click);
            if (opt.dbclick)
                map_event(marker).dbclick(opt.dbclick);
            if (opt.rightclick)
                map_event(marker).rightclick(opt.rightclick);
            if (opt.mouseover)
                map_event(marker).mouseover(opt.mouseover);
            if (opt.mouseout)
                map_event(marker).mouseout(opt.mouseout);

            if (opt.load) {
                opt.load(marker);
            }

            return marker;
        }
    }

    /**
     * 画线
     * @param bMap
     * @param opt={points:[],style:{}}
     */
    function drawPolyline(opt) {
        var style = {
            strokeColor: "blue",
            strokeWeight: 8,
            strokeOpacity: 0.6
        };

        style = opt && opt.style || style;
        var pline = new BMap.Polyline(opt.points, style);
        // 画线
        map.addOverlay(pline);

        if (opt.click)
            map_event(pline).click(opt.click);
        if (opt.dbclick)
            map_event(pline).dbclick(opt.dbclick);
        if (opt.rightclick)
            map_event(pline).rightclick(opt.rightclick);
        if (opt.mouseover)
            map_event(pline).mouseover(opt.mouseover);
        if (opt.mouseout)
            map_event(pline).mouseout(opt.mouseout);
        return pline;
    }


    function blueStyle() {
        var styleJson = [
            {
                "featureType": "all",
                "elementType": "geometry",
                "stylers": {
                    "hue": "#007fff",
                    "saturation": 89
                }
            },
            {
                "featureType": "water",
                "elementType": "all",
                "stylers": {
                    "color": "#ffffff"
                }
            }
        ];
        map.setMapStyle({ styleJson: styleJson });
    }

    window.baiduMap = _bMap;
})();