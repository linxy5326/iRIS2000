
    /*********************
      name: 辅助作图函数包
    author: 叶辉
      date: 2017-11-23
    **********************/
(function () {

    var peix = { x: 0, y: 0 };
    //背景辅助网格
    function drawGrid(g, stepx, stepy) {
        g.save();
        g.strokeStyle = GRID_STYLE;
        //设置线宽为0.5
        g.lineWidth = GRID_LINE_WIDTH;
        var m = 0, n0;
        for (var i = stepx + 0.5; i < g.canvas.width; i = i + stepx) {
            //开启路径
            m++;
            if (m % 10 == 0) {
                g.strokeStyle = GRID_STYLE_LIGHT;
                g.lineWidth = 1.5;
            } else {
                g.strokeStyle = GRID_STYLE;
                g.lineWidth = GRID_LINE_WIDTH;
            }
            g.beginPath();
            g.moveTo(i, 0);
            g.lineTo(i, g.canvas.height);
            g.stroke();

        }
        m = 0;
        //绘制y轴网格
        for (var i = stepy + 0.5; i < g.canvas.height; i = i + stepy) {
            m++;
            if (m % 10 == 0) {
                g.strokeStyle = GRID_STYLE_LIGHT;
                g.lineWidth = 1.5;
            } else {
                g.strokeStyle = GRID_STYLE;
                g.lineWidth = GRID_LINE_WIDTH;
            }
            g.beginPath();
            g.moveTo(0, i);
            g.lineTo(g.canvas.width, i);
            g.stroke();
        }
        g.restore();
    }
    //绘制水平线
    function drawHorizontalLine(g, y) {
        g.beginPath();
        g.moveTo(0, y + 0.5);
        g.lineTo(g.canvas.width, y + 0.5);
        g.stroke();
    }
    //绘制垂直线
    function drawVerticalLine(g, x) {
        g.beginPath();
        g.moveTo(x + 0.5, 0);
        g.lineTo(x + 0.5, g.canvas.height);
        g.stroke();
    }
    //绘制辅助用的线
    function drawGuideWires(g, x, y, showlab) {
        //画笔保护
        //计算经过的x,y像素
        var px = x - peix.x, py = y - peix.y;
        g.save();

        g.strokeStyle = '#ffc600';
        g.lineWidth = 1;
        drawHorizontalLine(g, y);
        drawVerticalLine(g, x);

        //画连接线
        g.beginPath();
        g.lineWidth = 0.5
        g.moveTo(peix.x, peix.y);
        g.lineTo(x, y);
        g.stroke();

        var ant = Math.atan2(peix.x - x, peix.y - y);
        ant = (180 / Math.PI) * ant;

        g.font = Font;
        g.fillStyle = "#ffc600";
        var v = "(" + parseInt(x) + "," + parseInt(y) + ")";
        var tl = g.measureText(v).width, x1, y1, x2, y2;
        x = x + 10;
        y = y + 20;
        x1 = x; y1 = y + 25;
        y2 = y1 + 25;

        if (x > g.canvas.width * 0.5) {
            x = x - (tl + 20);
            x1 = x - 5;
        }

        if (y > g.canvas.height * 0.5) {
            y = y - 25;
            y1 = y - 25;
            y2 = y1 - 25;
        }
        x2 = x1;
        //当前坐标
        g.fillText(v, x, y, 100);

        if (showlab) {
            //距选中点的坐标差
            var v = "(" + parseInt(px) + "," + parseInt(py) + ") ";
            g.fillStyle = "#24D5FF";
            g.fillText(v, x1, y1, 100);
            g.fillStyle = "#2efb20";
            g.fillText(ant.toFixed(1) + "°", x2, y2, 100);
        }
        g.restore();
    }

    //事件
    function mouseEvent() {
        var loc, dragging = false, ea = 0;

        canvas.onmousedown = function (e) {
            e.preventDefault();
            if (dragging) {
                restoreDrawingSurface();
                tempImagData = null;
                dragging = false;
            }
            else {
                loc = windowToCanvas(e.clientX, e.clientY);
                peix.x = loc.x;
                peix.y = loc.y;
                saveDrawingSurface();
                dragging = true;
                drawGuideWires(g, loc.x, loc.y);
                saveTempData();
            }
        }
        cvs.onmousemove = function (e) {
            restoreTempData();
            if (dragging) {

                loc = windowToCanvas(e.clientX, e.clientY);
                drawGuideWires(g, loc.x, loc.y, true);

            }
        }
        cvs.onmouseup = function (e) {
        }
        cvs.onmouseout = function (e) {
            if (e.target.tagName == "CANVAS") {
                if (dragging) {
                    //restoreDrawingSurface();
                    //dragging = false;
                }
            }
        }
        cvs.mouseover = function (e) {

        }
    }
    //临时图像
    function saveTempData() {
        tempImagData = g.getImageData(0, 0, canvas.width, canvas.height);
    }

    function restoreTempData() {
        if (tempImagData)
            g.putImageData(tempImagData, 0, 0);
    }

    function saveDrawingSurface() {
        drawingSurfaceImageData = g.getImageData(0, 0, canvas.width, canvas.height);
    }

    function restoreDrawingSurface() {
        if (drawingSurfaceImageData)
            g.putImageData(drawingSurfaceImageData, 0, 0);
    }

    function windowToCanvas(x, y) {
        var bbox = canvas.getBoundingClientRect();
        var x1 = x - bbox.left * (canvas.width / bbox.width),
            y1 = y - bbox.top * (canvas.height / bbox.height);

        return {
            x: x1,
            y: y1
        };
    }

    function mousePos(e) {
        //获取鼠标所在位置的坐标，相对于整个页面
        var x, y;
        var e = e || window.event;
        return {
            x: e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft,
            y: e.clientY + document.body.scrollTop + document.documentElement.scrollTop
        };
    }

    var event_util = {
        //添加事件
        addHandler: function (element, type, handler) {
            if (element.addEventListener) {
                element.addEventListener(type, handler, false);
            } else if (element.attachEvent) {
                element.attachEvent("on" + type, handler);
            } else {
                element["on" + type] = handler;
            }
        },
        //移除事件
        removeHandler: function (element, type, handler) {
            if (element.removeEventListener) {
                element.removeEventListener(type, handler, false);
            } else if (element.detachEvent) {
                element.detachEvent("on" + type, handler);
            } else {
                element["on" + type] = null;
            }
        },
        //获取事件对象
        getEvent: function (event) {
            return event ? event : window.event;
        },
        //获取事件目标
        getTarget: function (event) {
            return event.target || event.srcElement;
        },
        //阻止事件冒泡
        stopPropagation: function (event) {
            if (event.stopPropagation) {
                event.stopPropagation();
            } else {
                event.cancelBubble = true;
            }
        },
        //取消事件默认行为
        preventDefault: function (event) {
            if (event.preventDefault) {
                event.preventDefault();
            } else {
                event.returnValue = false;
            }
        },
        //获取相关元素
        getRelatedTarget: function (event) {
            if (event.relatedTarget) {
                return event.relatedTarget;
            } else if (event.fromElement) {
                return event.fromElement;
            } else if (event.toElement) {
                return event.toElement;
            } else {
                return null;
            }
        },
        //获取button属性值
        getButton: function (event) {
            if (document.implementation.hasFeature("MouseEvents", "2.0")) {
                return event.button;
            } else {
                switch (event.button) {
                    case 0:
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                        return 0;
                    case 2:
                    case 6:
                        return 2;
                    case 4:
                        return 1;
                }
            }
        },
        //获取鼠标滚轮增量值
        getWheelDelta: function (event) {
            if (event.wheelDelta) {
                return event.wheelDelta;
            } else {
                return -event.detail * 40;
            }
        }
    };
})();
