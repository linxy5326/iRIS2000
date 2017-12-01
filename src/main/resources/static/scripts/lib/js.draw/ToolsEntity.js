
var p_x = 0;
var p_y = 0;
var p_width = 0;
var p_height = 0;
var p_ratio = 1;
//矩形实体
var Rectangle = function (x, y, width, height, radian, strokeStyle, fillStyle) {
    this.x = x;
    this.y = y;
    this.width = parseInt(width);
    this.height = parseInt(height);
    this.radian = parseInt(radian);
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
    this.x = (this.x + p_x);
    this.y = (this.y + p_y);
    this.width = (this.width + p_width) * p_ratio;
    this.height = (this.height + p_height) * p_ratio;
    this.globalAlpha = 1;

}
Rectangle = function (x, y, width, height, radian, strokeStyle, fillStyle, globalAlpha) {
    this.x = x;
    this.y = y;
    this.width = parseInt(width);
    this.height = parseInt(height);
    this.radian = parseInt(radian);
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
    this.x = (this.x + p_x);
    this.y = (this.y + p_y);
    this.width = (this.width + p_width) * p_ratio;
    this.height = (this.height + p_height) * p_ratio;
    this.globalAlpha = globalAlpha;

}
Rectangle.prototype = {
    createPath: function (context) {
        context.beginPath();
        context.lineWidth = 0;
        context.strokeStyle = this.strokeStyle;
        // $("#showMsg").html(this.x + "," + this.y + "," + this.width + "," + this.height + "," + this.radian + "," + this.strokeStyle + ",");
        if (this.radian > 0) {
            context.moveTo(this.x + this.radian, this.y);
            context.lineTo(this.x + this.width - this.radian, this.y);
            context.arc(this.x + this.width - this.radian, this.y + this.radian, this.radian, 3 * Math.PI / 2, 2 * Math.PI, false);
            context.lineTo(this.x + this.width, this.y + this.height - this.radian);
            context.arc(this.x + this.width - this.radian, this.y + this.height - this.radian, this.radian, 0, Math.PI / 2, false);
            context.lineTo(this.x + this.radian, this.y + this.height);
            context.arc(this.x + this.radian, this.y + this.height - this.radian, this.radian, Math.PI / 2, Math.PI, false);
            context.lineTo(this.x, this.y + this.radian);
            context.arc(this.x + this.radian, this.y + this.radian, this.radian, Math.PI, 3 * Math.PI / 2, false);
        } else {
            context.rect(this.x, this.y, this.width, this.height);
        }
        context.closePath();
        context.stroke();
    },
    stroke: function (context) {
        context.save();
        context.lineWidth = 1;
        this.createPath(context);
        if (this.strokeStyle) {
            context.strokeStyle = this.strokeStyle;
            context.stroke();
        }
        context.restore();
    },
    fill: function (context) {
        if (this.fillStyle == "none") return;
        context.save();
        this.createPath(context);
        context.globalAlpha = this.globalAlpha;
        context.fillStyle = this.fillStyle;
        context.fill();
        context.restore();
    },
    printCode: function () {
        var code = "";
        if (this.radian > 0) {
            code += "\r\n" + "context.beginPath();";
            code += "\r\n" + "context.strokeStyle ='" + this.strokeStyle + "';";
            code += "\r\n" + "context.moveTo(" + (this.x + this.radian) + ", " + this.y + ");";
            code += "\r\n" + "context.lineTo(" + (this.x + this.width - this.radian) + ", " + this.y + ");";
            code += "\r\n" + "context.arc(" + (this.x + this.width - this.radian) + ", " + (this.y + this.radian) + ", " + this.radian + ", 3 * Math.PI / 2, 2 * Math.PI, false);";
            code += "\r\n" + "context.lineTo(" + (this.x + this.width) + ", " + (this.y + this.height - this.radian) + ");";
            code += "\r\n" + "context.arc(" + (this.x + this.width - this.radian) + ", " + (this.y + this.height - this.radian) + ", " + this.radian + ", 0, Math.PI / 2, false);";
            code += "\r\n" + "context.lineTo(" + (this.x + this.radian) + ", " + (this.y + this.height) + ");";
            code += "\r\n" + "context.arc(" + (this.x + this.radian) + ", " + (this.y + this.height - this.radian) + ", " + this.radian + ", Math.PI / 2, Math.PI, false);";
            code += "\r\n" + "context.lineTo(" + this.x + ", " + (this.y + this.radian) + ");";
            code += "\r\n" + "context.arc(" + (this.x + this.radian) + ", " + (this.y + this.radian) + ", " + this.radian + ",  Math.PI,3 * Math.PI/2, false);";
            code += "\r\n" + "context.closePath();";
            code += "\r\n" + "context.stroke();";
        } else {
            code += "\r\n" + "context.beginPath();";
            code += "\r\n" + "context.rect(" + this.x + ", " + this.y + ", " + this.width + ", " + this.height + ");";
            code += "\r\n" + "context.closePath();";
            code += "\r\n" + "context.strokeStyle ='" + this.strokeStyle + "';";
            code += "\r\n" + "context.stroke();";

        }
        if (this.fillStyle != "none") {
            code += "\r\n" + "context.fillStyle = '" + this.fillStyle + "';";
            code += "\r\n" + "context.fill();";
        }
        return code;
    },
    printCodeEx: function () {
        var code = "";
        code += "\r\n" + " rectangle = new Rectangle(" + this.x + "," + this.y + "," + this.width + "," + this.height + "," + this.radian + ",'" + this.strokeStyle + "','" + this.fillStyle + "');";
        code += "\r\n" + " rectangle.createPath(context);";
        code += "\r\n" + " rectangle.fill(context);";
        code += "\r\n" + " rectangle.stroke(context);";

        return code;
    }
};

//直线实体
var Line = function (startX, startY, endX, endY, width, height, strokeStyle, fillStyle) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.width = width;
    this.height = height;
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
    this.lineWidth = 1;
    if (width == 0)
        this.endX = this.startX;
    if (height == 0)
        this.endY = this.startY;
    this.startX = (this.startX + p_x);
    this.startY = (this.startY + p_y);
    this.endX = (this.endX + p_x);
    this.endY = (this.endY + p_y);
    this.width = (this.width + p_width) * p_ratio;
    this.height = (this.height + p_height) * p_ratio;

};

Line = function (startX, startY, endX, endY, width, height, strokeStyle, fillStyle, lineWidth) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.width = width;
    this.height = height;
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
    this.lineWidth = lineWidth;
    if (width == 0)
        this.endX = this.startX;
    if (height == 0)
        this.endY = this.startY;
    this.startX = (this.startX + p_x);
    this.startY = (this.startY + p_y);
    this.endX = (this.endX + p_x);
    this.endY = (this.endY + p_y);
    this.width = (this.width + p_width) * p_ratio;
    this.height = (this.height + p_height) * p_ratio;

};
Line.prototype = {
    createPath: function (context) {
        context.beginPath();
        context.lineWidth = this.lineWidth;
        context.strokeStyle = this.strokeStyle;
        context.moveTo(this.startX, this.startY);
        context.lineTo(this.endX, this.endY);
        context.closePath();
    },
    stroke: function (context) {
        context.save();
        this.createPath(context);
        context.strokeStyle = this.strokeStyle;
        context.stroke();
        context.restore();
    },
    fill: function (context) {
        context.save();
        this.createPath(context);
        context.fillStyle = this.fillStyle;
        context.fill();
        context.restore();
    },
    printCode: function () {
        var code = "";
        code += "\r\n" + "context.beginPath();";
        code += "\r\n" + "context.moveTo(" + this.startX + "," + this.startY + ");";
        code += "\r\n" + "context.lineTo(" + this.endX + "," + this.endY + ");";
        code += "\r\n" + "context.closePath();";
        code += "\r\n" + "context.strokeStyle ='" + this.strokeStyle + "';";
        code += "\r\n" + "context.stroke();";
        if (this.fillStyle != "none") {
            code += "\r\n" + "context.fillStyle = '" + this.fillStyle + "';";
            code += "\r\n" + "context.fill();";
        }
        return code;
    },
    printCodeEx: function () {
        var code = "";
        code += "\r\n" + " line = new Line(" + this.startX + "," + this.startY + "," + this.endX + "," + this.endY + "," + this.width + "," + this.height + ",'" + this.strokeStyle + "','" + this.fillStyle + "');";
        code += "\r\n" + " line.createPath(context);";
        code += "\r\n" + " line.fill(context);";
        code += "\r\n" + " line.stroke(context);";

        return code;
    }

};
var Font = function (font_text, font_size, font_family, font_style, font_weight) {
    this.font_text = font_text;
    this.font_size = font_size;
    this.font_family = font_family;
    this.font_style = font_style;
    this.font_weight = font_weight;
}
//文字实体
var Text = function (x, y, font, width, height, strokeStyle, fillStyle) {
    this.x = x;
    this.y = y;
    this.font = new Font();
    this.font = font;
    this.width = width;
    this.height = height;
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
};
Text.prototype = {
    createPath: function (context) {
        context.beginPath();
        context.strokeStyle = this.strokeStyle;
        context.fillStyle = this.fillStyle;
        context.font = this.font.font_style + " " + this.font.font_weight + " " + this.font.font_size + "px " + this.font.font_family;
        context.closePath();
        context.fillText(this.font.font_text, this.x, this.y);

    },
    stroke: function (context) {
        context.save();
        this.createPath(context);
        context.strokeStyle = this.strokeStyle;
        context.stroke();
        context.restore();
    },
    fill: function (context) {
        context.save();
        context.fillStyle = this.fillStyle;
        this.createPath(context);
        context.fill();
        context.restore();
    },
    printCode: function () {
        var code = "";
        code += "\r\n" + "context.beginPath();";
        code += "\r\n" + "context.font='" + this.font.font_style + " " + this.font.font_weight + " " + this.font.font_size + "px " + this.font.font_family + "';";
        code += "\r\n" + "context.fillText('" + this.font.font_text + "'," + this.x + "," + this.y + ");";
        code += "\r\n" + "context.closePath();";
        code += "\r\n" + "context.strokeStyle ='" + this.strokeStyle + "';";
        code += "\r\n" + "context.stroke();";
        if (this.fillStyle != "none") {
            code += "\r\n" + "context.fillStyle = '" + this.fillStyle + "';";
            code += "\r\n" + "context.fill();";
        }
        return code;
    },
    printCodeEx: function () {
        var code = "";
        code += "\r\n" + " text = new Text(" + this.x + "," + this.y + ",new Font('" + this.font.font_text + "'," + this.font.font_size + ",'" + this.font.font_family + "','','')," + this.width + "," + this.height + ",'" + this.strokeStyle + "','" + this.fillStyle + "');";
        code += "\r\n" + " text.createPath(context);";
        code += "\r\n" + " text.fill(context);";
        code += "\r\n" + " text.stroke(context);";
        return code;
    }

};
//圆形实体
var Circle = function (centerX, centerY, radius, sAngle, eAngle, width, height, strokeStyle, fillStyle) {
    this.x = centerX;
    this.y = centerY;
    this.radius = parseFloat(radius);
    this.sAngle = parseFloat(sAngle);
    this.eAngle = parseFloat(eAngle);
    this.width = width;
    this.height = height;
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
    if (sAngle == 0) this.sAngle = 0;
    if (eAngle == 0) this.eAngle = Math.PI * 2;
    if (this.radius == 0) {
        this.radius = this.width / 2;
    }

};
Circle.prototype = {
    createPath: function (context) {
        context.beginPath();
        context.lineWidth = "1";
        context.strokeStyle = this.strokeStyle;
        context.arc(this.x, this.y, this.radius, this.sAngle, this.eAngle, false);
        context.stroke();
        context.closePath();
    },
    stroke: function (context) {
        context.save();
        this.createPath(context);
        context.strokeStyle = this.strokeStyle;
        context.stroke();
        context.restore();
    },
    fill: function (context) {
        if (this.fillStyle == "none") return;
        context.save();
        this.createPath(context);
        context.fillStyle = this.fillStyle;
        context.fill();
        context.restore();
    },
    printCode: function () {
        var code = "";
        code += "\r\n" + "context.beginPath();";
        code += "\r\n" + "context.arc(" + this.x + "," + this.y + "," + this.radius + "," + this.sAngle + "," + this.eAngle + "," + false + ");";
        code += "\r\n" + "context.closePath();";
        code += "\r\n" + "context.strokeStyle ='" + this.strokeStyle + "';";
        code += "\r\n" + "context.stroke();";
        if (this.fillStyle != "none") {
            code += "\r\n" + "context.fillStyle = '" + this.fillStyle + "';";
            code += "\r\n" + "context.fill();";
        }
        return code;
    },
    printCodeEx: function () {
        var code = "";
        code += "\r\n" + " circle = new Circle(" + this.x + "," + this.y + "," + this.radius + "," + this.sAngle + "," + this.eAngle + "," + this.width + "," + this.height + ",'" + this.strokeStyle + "','" + this.fillStyle + "');";
        code += "\r\n" + " circle.createPath(context);";
        code += "\r\n" + " circle.fill(context);";
        code += "\r\n" + " circle.stroke(context);";

        return code;
    }

};


//多边形实体          
var Polygon = function (centerX, centerY, radius, sides, startAngle, strokeStyle, fillStyle) {
    this.x = centerX;
    this.y = centerY;
    this.radius = radius;
    this.sides = sides;
    this.startAngle = startAngle;
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
    this.x = (this.x + p_x);
    this.y = (this.y + p_y);
    this.width = (width + p_width) * p_ratio;
    this.height = (height + p_height) * p_ratio;
};
var Point = function (x, y) {
    this.x = x;
    this.y = y;
};

var Area = function (width, height, left, top) {
    this.width = width;
    this.height = height;
    this.left = left;
    this.top = top;
}
Polygon.prototype = {
    getPoints: function () {
        var points = [];
        var angle = this.startAngle || 0;

        for (var i = 0; i < this.sides; ++i) {
            points.push(new Point(this.x + this.radius * Math.sin(angle),
                              this.y - this.radius * Math.cos(angle)));
            angle += 2 * Math.PI / this.sides;
        }
        return points;
    },

    createPath: function (context) {
        var points = this.getPoints();

        context.beginPath();
        context.strokeStyle = this.strokeStyle;
        context.moveTo(points[0].x, points[0].y);

        for (var i = 1; i < this.sides; ++i) {
            context.lineTo(points[i].x, points[i].y);
        }
        context.closePath();
        context.stroke();
    },

    stroke: function (context) {
        context.save();
        context.strokeStyle = this.strokeStyle;
        this.createPath(context);
        context.stroke();
        context.restore();
    },

    fill: function (context) {
        if (this.fillStyle == "none") return;
        context.save();
        this.createPath(context);
        context.fillStyle = this.fillStyle;
        context.fill();
        context.restore();
    },

    move: function (x, y) {
        this.x = x;
        this.y = y;
    },
    getArea: function () {
        var area = new Area();
        var points = this.getPoints();
        var pointsX = points.sort(function (a, b) { return a.x > b.x ? 1 : -1 });
        area.left = Math.abs(pointsX[0].x);
        pointsX = points.sort(function (a, b) { return a.x < b.x ? 1 : -1 });
        area.width = Math.abs(pointsX[0].x - area.left);
        var pointsY = points.sort(function (a, b) { return a.y > b.y ? 1 : -1 });
        area.top = Math.abs(pointsX[0].y);
        pointsY = points.sort(function (a, b) { return a.y < b.y ? 1 : -1 });
        area.height = Math.abs(pointsY[0].y - area.top);
        return area;
    },
    printCode: function () {
        var code = "";
        var points = this.getPoints();
        code += "\r\n" + "context.beginPath();";
        code += "\r\n" + "context.moveTo(" + points[0].x + "," + points[0].y + ");";

        for (var i = 1; i < this.sides; ++i) {
            code += "\r\n" + "context.lineTo(" + points[i].x + "," + points[i].y + ");";
        }
        code += "\r\n" + "context.closePath();";
        code += "\r\n" + "context.strokeStyle ='" + this.strokeStyle + "';";
        code += "\r\n" + "context.stroke();";
        if (this.fillStyle != "none") {
            code += "\r\n" + "context.fillStyle = '" + this.fillStyle + "';";
            code += "\r\n" + "context.fill();";
        }
        return code;
    },
    printCodeEx: function () {
        var code = "";
        code += "\r\n" + " polygon = new Polygon(" + this.x + "," + this.y + "," + this.radius + "," + this.sides + "," + this.sAngle + "," + this.eAngle + ",'" + this.strokeStyle + "','" + this.fillStyle + "');";
        code += "\r\n" + " polygon.createPath(context);";
        code += "\r\n" + " polygon.fill(context);";
        code += "\r\n" + " polygon.stroke(context);";

        return code;
    }
};

//曲线实体
var Curve = function (startX, startY, endX, endY, ctrlX, ctrlY, ctrl2X, ctrl2Y, strokeStyle, fillStyle) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.ctrlX = ctrlX;
    this.ctrlY = ctrlY;
    this.ctrl2X = ctrl2X;
    this.ctrl2Y = ctrl2Y;
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
};
Curve.prototype = {
    createPath: function (context) {
        context.clearRect(0, 0, 800, 500);
        context.beginPath();
        context.moveTo(this.startX, this.startY);
        context.bezierCurveTo(this.ctrlX, this.ctrlY, this.ctrl2X, this.ctrl2Y, this.endX, this.endY);
        context.stroke();
        //画控制线1
        context.beginPath();
        context.moveTo(this.startX, this.startY);
        context.lineTo(this.ctrlX, this.ctrlY);
        context.stroke();
        //画控制线2
        context.beginPath();
        context.moveTo(this.endX, this.endY);
        context.lineTo(this.ctrl2X, this.ctrl2Y);
        context.stroke();
        //画4个控制点
        context.strokeRect(this.startX - 1, this.startY - 1, 3, 3);
        context.strokeRect(this.endX - 1, this.endY - 1, 3, 3);
        context.fillRect(this.ctrlX - 1, this.ctrlY - 1, 3, 3);
        context.fillRect(this.ctrl2X - 1, this.ctrl2Y - 1, 3, 3);
    },

    stroke: function (context) {
        context.save();
        this.createPath(context);
        context.strokeStyle = this.strokeStyle;
        context.stroke();
        context.restore();
    },

    fill: function (context) {
        context.save();
        this.createPath(context);
        context.fillStyle = this.fillStyle;
        context.fill();
        context.restore();
    },
    select: function (x, y) {
        if (this.endX == 0 && this.endY == 0)
            return "";//仅有起点时，退出。
        if (this.ctrlX - 5 < x && x < this.ctrlX + 5 && this.ctrlY - 5 < y && y < this.ctrlY + 5) {    //选中控制点1
            return "ctrl1";
        }
        else if (this.ctrl2X - 5 < x && x < this.ctrl2X + 5 && this.ctrl2Y - 5 < y && y < this.ctrl2Y + 5) {  //选中控制点2
            return "ctrl2";
        }
        else if (this.startX - 5 < x && x < this.startX + 5 && this.startY - 5 < y && y < this.startY + 5) {  //选中起点
            return "start";
        }
        else if (this.endX - 5 < x && x < this.endX + 5 && this.endY - 5 < y && y < this.endY + 5) {  //选中终点
            return "end";
        }
    },
    move: function (type, x, y) {
        switch (type) {
            case 'start': //拖动起点
                this.ctrlX = this.ctrlX + (x - this.startX);
                this.ctrlY = this.ctrlY + (y - this.startY);
                this.startX = x;
                this.startY = y;
                break;
            case 'end':
                this.ctrl2X = this.ctrl2X + (x - this.endX);
                this.ctrl2Y = this.ctrl2Y + (y - this.endY);
                this.endX = x;
                this.endY = y;
                break;
            case 'ctrl1':
                this.ctrlX = x;
                this.ctrlY = y;
                break;
            case 'ctrl2':
                this.ctrl2X = x;
                this.ctrl2Y = y;
                break;
            default: break;
        }
    },
    drawpoint: function (context, x, y) {
        context.fillRect(x - 1, y - 1, 3, 3);
    },
    printCode: function () {
        var code = "";
        code += "\r\n" + "context.beginPath();";
        code += "\r\n" + "context.bezierCurveTo(" + this.ctrlX + "," + this.ctrlY + "," + this.ctrl2X + "," + this.ctrl2Y + "," + this.endX + "," + this.endY + ")";
        code += "\r\n" + "context.closePath();";
        code += "\r\n" + "context.strokeStyle ='" + this.strokeStyle + "';";
        code += "\r\n" + "context.stroke();";
        if (this.fillStyle != "none") {
            code += "\r\n" + "context.fillStyle = '" + this.fillStyle + "';";
            code += "\r\n" + "context.fill();";
        }
        return code;
    }
};

function DashedRectangle(context, x, y, width, height) {
    x = toFloat(x);
    y = toFloat(y);
    width = toFloat(width);
    height = toFloat(height);
    var moveToFunction = CanvasRenderingContext2D.prototype.moveTo;
    CanvasRenderingContext2D.prototype.lastMoveToLocation = {};
    CanvasRenderingContext2D.prototype.moveTo = function (x, y) {
        moveToFunction.apply(context, [x, y]);
        this.lastMoveToLocation.x = x;
        this.lastMoveToLocation.y = y;
    };
    CanvasRenderingContext2D.prototype.dashedLineTo = function (x, y, dashLength) {
        dashLength = dashLength === undefined ? 5 : dashLength;

        var startX = this.lastMoveToLocation.x;
        var startY = this.lastMoveToLocation.y;

        var deltaX = x - startX;
        var deltaY = y - startY;
        var numDashes = Math.floor(Math.sqrt(deltaX * deltaX + deltaY * deltaY) / dashLength);

        for (var i = 0; i < numDashes; ++i) {
            this[i % 2 === 0 ? 'moveTo' : 'lineTo']
               (startX + (deltaX / numDashes) * i, startY + (deltaY / numDashes) * i);
        }
        this.moveTo(x, y);
    };
    context.beginPath();
    context.lineWidth = 0.5;
    context.strokeStyle = '#ff9900';
    context.moveTo(x, y);
    context.dashedLineTo(x + width, y);
    context.dashedLineTo(x + width, y + height);
    context.dashedLineTo(x, y + height);
    context.dashedLineTo(x, y);
    context.stroke();
    context.closePath();
};
function toFloat(str) {
    return parseFloat(str);
};
Function.prototype.hookend = function (hook) {
    var fn = this;
    return function () {
        ret = fn.apply(this, arguments);
        hook.apply(this, arguments);
        return;
    }
};
//格式化指定小数位
function formatFloat(src, pos) {
    return Math.round(src * Math.pow(10, pos)) / Math.pow(10, pos);
}