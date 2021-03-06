﻿(function () {

    var mui = mui || {};

    var defaultfont = "normal 20px 微软雅黑", colors = ['rgba(255, 255, 255, 1)', 'rgba(0, 0, 0, 1)', '#5B9BD5'];
    var defdata = {
        name: "导向系统",
        time: "2017年11月25 11：03",
        ets: "上海精密仪器制造厂",
        ergs: "上海米度",
        prodata: {
            name: "导向系统",
            proname: "1号线[2标段]",
            secline: "碧城东路~同风路区间-右线",
            tbm: {
                name: "CREC1811",
                workstate: "掘进",
                tjlc: 1560,
                tjring: 890
            }
        },
        war: { err: ["刀盘液压油温异常", "密封油脂低于下限", "推力过大"] },
        dx: {
            x: 0, y: 0, ex: 0, ey: 0, roll: 0, pitch: 0,
            h_pc: 0, v_pc: 0, qk_h: 0, dz_h: 0, dw: 0, qk_v: 0, dz_v: 0, dw_v: 0,
            a_xc: 0, b_xc: 0, c_xc: 0,
            d_xc: 0, a_xc: 10, b_xc: 10, c_xc: 10, d_xc: 10,
            tjlc: 0, dqlc: 0, ring: 0, ring_count: 0, qklc: 0, dwlc: 0, tjjd: 0
        },
        conf: {
            x: 0, y: 0, width: 1920, height: 1080
        }
    };
    //定义导向图形界面
    var guide = function (option) {
        console.log(option);
        this.g = option.g;
        this.cfg = option.cfg;
        return this;
    }

    //公共方法
    guide.prototype = {
        init: function (option) {
            var d = this.data;
            drawtools(this.g, { x: 10, y: 20 }, d.prodata);
            //表格
            drawTable(this.g, { x: 180, y: 800, linewidth: 1.5, color: "#25BEEB" },
                { a1: d.dx.tjlc, a2: d.dx.dqlc, a3: d.dx.ring, a4: d.dx.ring_count, a5: d.dx.qklc, a6: d.dx.dwlc, a7: d.dx.tjjd, b1: d.time, b2: d.ets, b3: d.ergs });
            drawCir(this.g, { x: 1300, y: 470, rds: 220 });
            return this;
        },
        setdata: function (option) {
            drawcatstatus(this.g, { x: 1650, y: 120 }, { status: 1, utime: 12344422213 });
            drawPaper(this.g, { x: 1300, y: 470, radius: 220 }, this.data.dx);
            drawRule(this.g, { x: 1300, y: 470, radius: 200 }, this.data.dx);
            drawCross(this.g, { x: 300, y: 250, width: 450, height: 450 }, this.data.dx);
            drawtjxc(this.g, { x: 660, y: 260, width: 200, height: 20 }, this.data.dx);
            return this;
        },
        setbg: function (color) {
            this.g.fillStyle = color || "#00000";
            this.g.fillRect(0, 0, this.g.canvas.width * 2, this.g.canvas.height * 2);
            return this;
        },
        scale: function (x, y) {
            x = x || 0;
            y = y || x;
            this.g.scale(x, y);
            return this;
        },
        erasebg: function () {
            this.g.translate(-100, -100);
            this.g.clearRect(0, 0, this.g.canvas.width * 2, this.g.canvas.height * 2);
            this.g.translate(100, 100);
            return this;
        },
        data: defdata
    };

    function drawTitle(g, conf, data) {
        var x = conf.x, y = conf.y, width = conf.width, height = conf.height;
        var d = {
            name: data.name,
            proname: data.pro.proname || "",
            secline: data.pro.secline || "",
            workstate: data.tbm.workstate || "",
            tjlc: data.tbm.tjlc || 0,
            tjring: data.tbm.tjring || 0
        };
        g.save();
        g.font = defaultfont;
        g.textAlign = 'left';
        g.fillStyle = colors[2];

        //页面名称
        g.fillText(d.name, x + width * 0.1, y + height * 0.3, 200);

        g.font = "12pt 微软雅黑";
        g.textAlign = "left";
        g.fillText(d.proname, x + width * 0.2, y + 20, 200);
        g.fillText(d.secline, x + width * 0.2, y + 45, 200);

        g.font = " bold 16pt 微软雅黑";
        g.fillText(d.workstate, x + width * 0.38, y + height * 0.3, 200);

        g.font = "12pt 微软雅黑";

        g.fillText("推进里程", x + width * 0.53, y + 20, 200);
        g.fillText("推进环数", x + width * 0.63, y + 20, 200);
        g.font = "14pt 微软雅黑";
        g.textAlign = "center";
        g.fillText(d.tjlc, x + width * 0.55, y + height * 0.41, 200);
        g.fillText(d.tjring, x + width * 0.65, y + height * 0.41, 200);
        g.restore();
    }

    function drawtools(g, conf, d) {
        var x = conf.x, y = conf.y;
        var imgsrc = "../../images/mac/",
            imgs = ["caption.png", "projectName.png", "pushon.png", "mileage.png", "ringno.png", "alert.png", "circle.png", "tab1.png", "tab2.png", "tab3.png"];
        g.save();
        g.translate(x, y);
        darwimg(g, 20, 20, imgsrc + imgs[0]);
        darwimg(g, 400, -20, imgsrc + imgs[1]);
        darwimg(g, 730, -10, imgsrc + imgs[2]);
        darwimg(g, 890, -10, imgsrc + imgs[3]);
        darwimg(g, 1150, -10, imgsrc + imgs[4]);
        darwimg(g, 1445, 0, imgsrc + imgs[5]);

        darwimg(g, 30, 980, imgsrc + imgs[6]);
        darwimg(g, 80, 990, imgsrc + imgs[7]);
        darwimg(g, 410, 990, imgsrc + imgs[8]);
        darwimg(g, 740, 990, imgsrc + imgs[9]);

        var style = {
            font: ' 14pt 微软雅黑',
            color: '#25d5ff'
        };
        //写数据
        style.font = 'bold 14pt 微软雅黑'

        //盾构机名称
        text(g, 60, 45, d.tbm.name, style);
        //页面名称
        text(g, 260, 45, d.name, style);
        //项目名称
        style.font = ' 12pt 微软雅黑'
        style.color = "#3FB633";
        style.maxWidth = 200;
        text(g, 490, 5, d.proname, style);
        text(g, 490, 30, d.secline, style);
        //状态
        style.font = 'bold 14pt 微软雅黑'
        style.color = "#E50101";
        text(g, 815, 20, d.tbm.workstate, style);
        //里程
        style.font = ' 16pt 微软雅黑';
        style.color = "#fff";
        text(g, 1030, 23, d.tbm.tjlc, style);
        //环号
        style.color = "#22C8F4";
        text(g, 1300, 23, d.tbm.tjring, style);

        g.restore();
    }

    //画导向圆
    function drawCir(g, option) {
        var x = option.x, y = option.y, radius = option.rds;
        var w = 0, h = 0;

        g.save();
        g.lineWidth = 2;
        g.fillStyle = colors[2];
        g.strokeStyle = "#0E4D79";


        var grd = g.createRadialGradient(x, y, radius / 6, x, y, radius);
        grd.addColorStop(0, '#0E5082');
        grd.addColorStop(0.6, '#0A3367');
        grd.addColorStop(0.8, '#072559');
        grd.addColorStop(1, '#06144B');

        g.save();
        g.beginPath();
        g.arc(x, y, radius, 0, Math.PI * 2, false);
        g.clip();
        g.fillStyle = grd;
        g.fillRect(x - radius, y - radius, x - x + radius * 2, y + radius / 2);

        drawarc(g, x, y, radius);
        g.restore();

        //小圆
        g.strokeStyle = "#AAFC12";
        drawarc(g, x, y, radius / 2);

        //十字线
        var cw = 10;
        g.lineWidth = 2;
        g.strokeStyle = "#1887BB";
        drawline(g, x - (radius + cw), y, x + (radius + cw), y);
        drawline(g, x, y - (radius + cw), x, y + (radius + cw));

        //刻度线

        w = radius / 4;
        h = radius / 14;
        for (var i = 1; i < 4; i++) {

            // X轴
            drawline(g, x - w * i, y - h, x - w * i, y + h);
            drawline(g, x + w * i, y - h, x + w * i, y + h);
            //Y轴
            drawline(g, x - h, y - w * i, x + h, y - w * i);
            drawline(g, x - h, y + w * i, x + h, y + w * i);
        }

        w = radius / 2;
        h = radius / 8;
        g.font = defaultfont;
        g.textAlign = "center";
        g.textBaseline = "middle";
        g.fillStyle = "#AAFC12";
        //X轴
        g.fillText("-100", x - w, y - h, 100);
        g.fillText("-200", x - w * 2, y - h, 100);
        g.fillText("100", x + w, y - h, 100);
        g.fillText("200", x + w * 2, y - h, 100);

        g.fillText("(mm)", x + w * 2, y - h + 40, 50);

        w = radius / 5;
        h = radius / 2;
        //Y轴
        g.fillText("100", x + w, y - h, 100);
        g.fillText("200", x + w, y - h * 2, 100);
        g.fillText("-100", x + w, y + h, 100);
        g.fillText("-200", x + w, y + h * 2, 100);



        g.lineWidth = 1;
        g.strokeStyle = colors[2];

        w = radius + (radius / 8);
        h = radius + (radius / 3);
        //水平
        drawline(g, x - w, y + (radius + radius / 3.6), x + w, y + (radius + radius / 3.6));
        w = radius - (radius / 15);
        hline(g, { x: x - w + 5, y: y + h, width: 410, height: 25, space: 50 });
        hline(g, { x: x - w + 5, y: y + h, width: 410, height: 20, space: 10 });

        //垂直的
        w = radius + (radius / 3);
        h = radius - (radius / 10);
        vline(g, { x: x - w, y: y - h, width: 410, height: 25, space: 50 });
        vline(g, { x: x - w, y: y - h, width: 410, height: 20, space: 10 });

        w = radius + (radius / 2.6);
        drawline(g, x - w, y - (radius + radius / 8), x - w, y + (radius + radius / 8));


        w = radius + (radius / 5);
        h = radius + (radius / 6);
        //俯仰角刻度
        //滚动角刻度
        g.font = defaultfont;
        g.textAlign = "right";
        g.fillStyle = "#96C43C";
        for (var i = 0; i < 5; i++) {
            g.fillText(-i, x - w, y + (i * 50));
            g.fillText(i, x - w, y - (i * 50));

            g.fillText(i, x + 5 + (i * 50), y + h);
            g.fillText(-i, x + 5 - (i * 50), y + h);
        }

        g.restore();
    }

    //画纸飞机   左 -  右 +   上 +  下 -
    function drawPaper(g, conf, data) {
        var x = conf.x || 0, y = conf.y || 0, r = conf.radius || 0;
        var d = { X: data.x || 0, Y: data.y || 0, eX: data.ex || 0, eY: data.ey || 0, scale: 1, rotate: 0 };

        var kd = r * 0.005;

        //转换头坐标
        var headx1 = d.X * kd + x, heady1 = (-d.Y * kd) + y,
            //转换尾坐标
            footx1 = d.eX * kd + x, footy1 = (-d.eY * kd) + y,
            //左尾
            footxl = d.eX * kd - 35 + x, footyl = (-d.eY * kd) + y,
            //右尾
            footxr = d.eX * kd + 35 + x, footyr = (-d.eY * kd) + y,
            //上尾
            footxu = d.eX * kd + x, footyu = (-d.eY * kd - 35) + y,
            //下尾
            footxd = d.eX * kd + x, footyd = (-d.eY * kd + 35) + y;

        var A = { X: headx1, Y: heady1 }, B = { X: footx1, Y: footy1 }, C = { X: footxl, Y: footyl };

        g.save();
        g.strokeStyle = "#67992D";
        g.fillStyle = "rgba(170,251,34,0.8)";
        //判断前点X和后点X坐标大小
        if (parseInt(headx1) - parseInt(footx1) <= 0) {
            C.X = footxr; C.Y = footyr;
        }
        drawTriangle(g, A, B, C);

        g.fillStyle = "rgba(170,251,34,0.6)";
        B.X = footxu; B.Y = footyu;
        C.X = footxd; C.Y = footyd;
        drawTriangle(g, A, B, C);

        g.fillStyle = "rgba(170,251,34,0.8)";
        B = { X: footx1, Y: footy1 }
        C.X = footxr; C.Y = footyr;
        if (parseInt(headx1) - parseInt(footx1) <= 0) {
            C.X = footxl; C.Y = footyl;
        }
        drawTriangle(g, A, B, C);

        g.restore();
    }

    //滚动角标尺
    function drawRule(g, conf, data) {
        var x = conf.x, y = conf.y, radius = conf.radius, w = 0, h = 0;
        //unit= 'mm/m'||'deg'
        var d = { roll: data.roll || 0, pitch: data.pitch || 0, unit: "deg" };

        var roll = d.roll, pitch = d.pitch;
        if (d.unit === 'mm/m') {
            roll = mTorad(d.roll);
            pitch = mTorad(d.pitch);
        } else {
            d.roll = dTomm(d.roll);
            d.pitch = dTomm(d.pitch);
        }

        w = radius + (radius / 2);
        h = radius + (radius / 3);
        g.save();
        g.translate(x - w - 18, y - 13);
        drawms(g, 0, 0, 30, 30, { value: roll, base: 50, min: -5, max: 5 });

        h = radius + (radius / 2);
        drawms(g, w - 19, h + 33, 30, 30, { value: pitch, base: 50, min: -5, max: 5 }, true);

        //画标题
        g.font = '14pt 微软雅黑';
        g.fillStyle = colors[2];
        g.textAlign = "center";
        g.fillText("俯仰角(°)", 0 + 20, 0 - (radius + 70), 200);
        g.fillText("滚动角(°)", 0 + radius * 3.1, 0 + h - 20, 200);

        g.fillStyle = "#AEFA25";
        //mm/M
        g.fillText(d.roll + "(mm/m)", 0 + 30, 0 - (radius + 40), 150);
        g.fillText(d.pitch + "(mm/m)", 0 + radius * 3.2, 0 + h + 10, 200);
        g.restore();

    }

    //趋势
    function drawCross(g, conf, data) {
        var x = conf.x || 0, y = conf.y || 0, width = conf.width || 0, height = conf.height || 0;
        var d = {
            h_pc: data.h_pc || 0,
            v_pc: data.v_pc || 0,
            qk_h: data.qk_h || 0,
            dz_h: data.dz_h || 0,
            dw_h: data.dw_h || 0,
            qk_v: data.qk_v || 0,
            dz_v: data.dz_v || 0,
            dw_v: data.dw_v || 0
        };
        g.save();
        g.strokeStyle = colors[2];
        //画轴
        drawline(g, x, y, x, y + height);
        drawline(g, x - width / 6, y + height - height / 6, x + width, y + height - height / 6);

        g.font = '16pt 微软雅黑';
        g.textAlign = "center";
        g.textBaseline = "top";
        g.fillStyle = colors[2];
        g.fillText("水平趋势", x + width + width / 8, y + height - height / 4, 100);
        g.fillText("垂直趋势", x, y - 60, 100);
        g.font = '12pt 微软雅黑';

        g.fillStyle = "#AEFA25";
        //实时数据
        g.fillText(d.h_pc + " mm", x + width + width / 8, y + height - height / 6, 100);
        g.fillText(d.v_pc + " mm", x, y - 30, 100);

        g.strokeStyle = "#AEFA25";

        var ax = x + d.dw_v,
            ay = y + height - height / 3,
            aw = x + d.qk_v,
            ah = y + height / 6;

        //垂直绑定数据
        drawarrow(g, ax, ay, aw, ah, 30, 15, 2, "#AEFA25");

        ah = y + height / 8;


        //写标签
        g.fillText("切口 " + d.qk_v + " mm", aw, ah, 100);
        g.fillText("盾尾 " + d.dw_v + " mm", ax, ay, 100);

        ax = x + width / 6;
        ay = (y + height - height / 6) + d.dw_h;
        aw = x + width - width / 4;
        ah = (y + height - height / 6) + d.qk_h
        //水平
        drawarrow(g, ax, ay, aw, ah, 30, 15, 2, "#AEFA25");
        ah = (y + height - height / 7) + d.qk_h

        g.fillText("切口 " + d.qk_h + " mm", aw, ah, 100);
        g.fillText("盾尾 " + d.dw_h + " mm", ax, ay, 100);

        g.restore();
    }

    //油缸行程
    function drawtjxc(g, conf, data) {
        var x = conf.x || 0, y = conf.y || 0, wdith = conf.width || 0, height = conf.height || 0;
        var d = { a_xc: data.a_xc || 0, b_xc: data.b_xc || 0, c_xc: data.c_xc || 0, d_xc: data.d_xc || 0 }

        g.save();
        g.translate(x, y);
        //标题
        g.font = '14pt 微软雅黑';

        g.strokeStyle = "#5B9BD5";
        g.fillStyle = '#27CBF6';
        g.fillText("推进油缸行程", 0, -20, 200);

        g.font = '12pt 微软雅黑';
        g.fillStyle = '#27CBF6';
        g.fillText("A 组：", -50, 18, 80);
        g.fillText("B 组：", -50, 48, 80);
        g.fillText("C 组：", -50, 78, 80);
        g.fillText("D 组：", -50, 108, 80);


        g.fillStyle = '#AAFC12';
        g.fillText(d.a_xc + " mm", wdith / 3, 16, 80);
        g.fillText(d.b_xc + " mm", wdith / 3, 46, 80);
        g.fillText(d.c_xc + " mm", wdith / 3, 76, 80);
        g.fillText(d.d_xc + " mm", wdith / 3, 106, 80);

        d.a_xc = d.a_xc > 2000 ? 2000 : (d.a_xc < 0 ? 0 : d.a_xc);
        d.b_xc = d.b_xc > 2000 ? 2000 : (d.b_xc < 0 ? 0 : d.b_xc);
        d.c_xc = d.c_xc > 2000 ? 2000 : (d.c_xc < 0 ? 0 : d.c_xc);
        d.d_xc = d.d_xc > 2000 ? 2000 : (d.d_xc < 0 ? 0 : d.d_xc);



        var dw = (wdith / 2000);
        g.fillStyle = 'rgba(254,242,36,0.6)';
        g.strokeRect(-2, -2, wdith + 4, height + 4);
        g.fillRect(0, 0, dw * d.a_xc, height);
        g.strokeRect(-2, 30 - 2, wdith + 4, height + 4);
        g.fillRect(0, 30, dw * d.b_xc, height);

        g.strokeRect(-2, 60 - 2, wdith + 4, height + 4);
        g.fillRect(0, 60, dw * d.c_xc, height);

        g.strokeRect(-2, 90 - 2, wdith + 4, height + 4);
        g.fillRect(0, 90, dw * d.d_xc, height);
        g.restore();

    }

    //通信状态
    function drawcatstatus(g, conf, data) {
        var x = conf.x, y = conf.y;
        var d = { status: data.status || 0, uptime: data.uptime || 0 };

        g.save();
        g.translate(x, y);
        g.font = '12pt 微软雅黑';

        g.fillStyle = '#17A8D0';
        g.fillText("通信状态：", 0, 0, 200);
        g.strokeStyle = "#17A8D0";
        g.fillStyle = "#AEFA25";
        g.lineWidth = 2.5;
        darwfillarc(g, 90, -5, 10);
        g.restore();
    }

    //画数据表格
    function drawTable(g, option, d) {
        var x = option.x, y = option.y, w = 0, h = 0;
        g.lineWidth = option.linewidth || 1;
        g.strokeStyle = option.color || "#000";

        //横线
        w = 1540;
        g.save();
        //画矩型
        //第一行
        g.fillStyle = "#0A2B60";
        g.fillRect(x, y, x + w - x, y - y + 50);
        //第三行
        g.fillRect(x, y + 100, x - x + w / 7, y - y + 50);

        //第三行第三列
        g.fillRect(x + (w / 7) * 2, y + 100, x - x + w / 7, y - y + 50);
        //第三行第四列
        g.fillRect(x + (w / 7) * 4, y + 100, x - x + w / 7, y - y + 50);

        for (var i = 0; i < 4; i++) {
            h = 50 * i;
            drawline(g, x, y + h, x + w, y + h);
        }

        w = 0;
        for (var i = 0; i < 8; i++) {
            h = 150;
            w = (1540 / 7) * i;

            if (i == 6) {
                h = 100;
            }

            drawline(g, x + w, y, x + w, y + h);
        }

        w = 1540;

        //表头
        g.font = ' 14pt 微软雅黑';
        g.textAlign = "center";
        g.fillStyle = "#23B2E0";//填充的颜色
        g.fillText("盾构总里程(m)", x + 100, y + 28, 200);
        g.fillText("当前里程(m)", (x + 330), y + 28, 200);
        g.fillText("拼装环数(环)", (x + 550), y + 28, 200);
        g.fillText("拼装总环数(环)", (x + 770), y + 28, 200);
        g.fillText("切口里程(m)", (x + 990), y + 28, 200);
        g.fillText("盾尾里程(m)", (x + 1210), y + 28, 200);
        g.fillText("掘进进度(%)", (x + 1430), y + 28, 200);
        g.fillText("数据时间", x + 100, y + 132, 200);
        g.fillText("导向系统", (x + 550), y + 132, 200);
        g.fillText("测量仪器", (x + 980), y + 132, 200);


        //绘数据
        g.font = ' 16pt 微软雅黑';
        g.fillStyle = "#AEFA25";//填充的颜色
        g.fillText(d.a1, x + 100, y + 80, 200);
        g.fillText(d.a2, (x + 330), y + 80, 200);
        g.fillText(d.a3, (x + 550), y + 80, 200);
        g.fillText(d.a4, (x + 770), y + 80, 200);
        g.fillText(d.a5, (x + 990), y + 80, 200);
        g.fillText(d.a6, (x + 1210), y + 80, 200);
        g.fillText(d.a7, (x + 1430), y + 80, 200);
        g.fillText(d.b1, (x + 325), y + 130, 190);

        g.fillText(d.b3, (x + 770), y + 130, 180);
        var textwidth = textlen(g, d.b2);
        if (textwidth > 400) textwidth = 400;
        g.fillText(d.b2, (x + 1210) + textwidth / 2, y + 130, textwidth);
        g.restore();
    };

    function drawarc(g, x, y, radius) {
        g.beginPath();
        g.arc(x, y, radius, 0, Math.PI * 2, false);
        g.stroke();
    }

    function darwfillarc(g, x, y, radius) {
        g.beginPath();
        g.arc(x, y, radius, 0, Math.PI * 2, false);
        g.fill();
        g.stroke();
    }

    //画线
    function drawline(g, x, y, x1, y1) {
        g.beginPath();
        drawlinefor(g, x, y, x1, y1);
        g.closePath();
        g.stroke();
    }
    //非路径画线
    function drawlinefor(g, x, y, x1, y1) {
        g.moveTo(x, y);
        g.lineTo(x1, y1);
    }

    //水平刻度组件
    function hline(g, conf) {
        var x = conf.x, y = conf.y, w = conf.width, h = conf.height, space = conf.space;
        var count = w / space;

        for (var i = 0; i < count; i++) {
            drawline(g, x, y, x, y - h);
            x = x + space;
        }
    }
    //垂直刻度组件
    function vline(g, conf) {
        var x = conf.x, y = conf.y, w = conf.width, h = conf.height, space = conf.space;
        var count = w / space;

        for (var i = 0; i < count; i++) {
            drawline(g, x, y, x - h, y);
            y = y + space;
        }
    }

    function drawms(g, x, y, w, h, value, direction) {
        var _x = x || 0, _y = -y || 0, _w = w || 50, _h = h || 30;
        var v = { value: 0, base: 0, min: 0, max: 0 };
        if (value) {
            v.value = value.value || v.value;
            v.base = value.base || v.base;
            v.min = value.min || v.min;
            v.max = value.max || v.max;
            if (v.value > v.max)
                v.value = v.max;
            if (v.value < v.min)
                v.value = v.min;

            _y = _y - v.value * v.base;
        }
        g.save();
        if (direction) {
            g.rotate(Math.PI * 0.5);
        }

        g.lineWidth = 2;
        g.strokeStyle = 'rgba(230,0,1,0.4)';
        g.beginPath();
        g.moveTo(_x, _y + _h * 0.25);
        g.lineTo(_x, _y);
        g.lineTo(_x + _w * 0.25, _y);

        g.moveTo(_x + _w * 0.75, _y);
        g.lineTo(_x + _w, _y);
        g.lineTo(_x + _w, _y + _h * 0.25);
        g.stroke();

        //中缝线
        g.save();
        g.strokeStyle = 'rgba(170,249,36,0.8)';
        g.beginPath();
        g.moveTo(_x, _y + _h * 0.5);
        g.lineTo(_x + _w, _y + _h * 0.5);

        g.stroke();
        g.restore();

        g.moveTo(_x + _w, _y + _h * 0.75);
        g.lineTo(_x + _w, _y + _h);
        g.lineTo(_x + _w * 0.75, _y + _h);

        g.moveTo(_x, _y + _h * 0.75);
        g.lineTo(_x, _y + _h);
        g.lineTo(_x + _w * 0.25, _y + _h);
        g.stroke();



        //g.moveTo(_x, _y + _h * 0.25);
        g.font = '14pt 微软雅黑';
        g.fillStyle = "#AEFA25";
        g.textBaseline = "middle";
        g.textAlign = "left";
        var tlen = g.measureText(v.value).width;


        if (direction) {
            g.translate(_x, _y);
            g.rotate(Math.PI * -0.5);
            _x = 0 - tlen + 5;
            _y = 0 + _h + 10;
        }
        else {
            _x = _x - (tlen + 10);
            _y = _y + _h * 0.5
        }
        g.fillText(v.value, _x, _y, 100);
        g.restore();


    }

    //绘制三角形
    function drawTriangle(g, PointA, PointB, PointC) {
        var A = { X: PointA.X || 0, Y: PointA.Y || 0 }, B = { X: PointB.X || 0, Y: PointB.Y || 0 }, C = { X: PointC.X || 0, Y: PointC.Y || 0 };
        g.lineWidth = 1;
        g.beginPath();
        g.moveTo(A.X, A.Y);
        g.lineTo(B.X, B.Y);
        g.lineTo(C.X, C.Y);
        g.lineTo(A.X, A.Y);
        g.closePath();
        g.fill();
        g.stroke();
    };

    //不规则多边形
    function drawirrpol(g, conf) {

        var x = conf && conf.x || 0,
            y = conf && conf.y || 0,
            points = conf && conf.points,
            fstyle = conf && conf.fillStyle;

        g.beginPath();
        g.moveTo(x, y);

        for (var i = 0; i < option.length; i++) {
            g.lineTo(option[i].x, option[i].y);
        }
        g.closePath();
        g.stroke();
        if (fillStyle) {
            g.fillStyle = fillStyle;
            g.fill();
        }
    }


    //二次贝塞尔曲线
    function drawqc(g, conf) {
        var x = conf.x, y = conf.y, p1 = { x: conf.p1.x, y: conf.p1.y }, p2 = { x: conf.p2.x, y: conf.p2.y };
        g.beginPath();
        g.moveTo(x, y);
        g.quadraticCurveTo(p1.x, p1.y, p2.x, p2.y);
        g.stroke();
    }

    function textlen(g, text) {
        return text ? g.measureText(text).width : 0;
    }

    //中心多边形
    var drawPolygon = function (g, conf) {
        var x = conf && conf.x || 0;  //中心点x坐标
        var y = conf && conf.y || 0;  //中心点y坐标
        var num = conf && conf.num || 3;   //图形边的个数
        var r = conf && conf.r || 100;   //图形的半径
        var width = conf && conf.width || 5;
        var strokeStyle = conf && conf.strokeStyle;
        var fillStyle = conf && conf.fillStyle;
        //开始路径
        g.beginPath();
        var startX = x + r * Math.cos(2 * Math.PI * 0 / num);
        var startY = y + r * Math.sin(2 * Math.PI * 0 / num);
        g.moveTo(startX, startY);
        for (var i = 1; i <= num; i++) {
            var newX = x + r * Math.cos(2 * Math.PI * i / num);
            var newY = y + r * Math.sin(2 * Math.PI * i / num);
            g.lineTo(newX, newY);
        }
        g.closePath();
        //路径闭合
        if (strokeStyle) {
            g.strokeStyle = strokeStyle;
            g.lineWidth = width;
            g.lineJoin = 'round';
            g.stroke();
        }
        if (fillStyle) {
            g.fillStyle = fillStyle;
            g.fill();
        }
    }
    //单向箭头
    function drawarrow(g, fromX, fromY, toX, toY, theta, headlen, width, color) {
        theta = typeof (theta) != 'undefined' ? theta : 30;
        headlen = typeof (theta) != 'undefined' ? headlen : 10;
        width = typeof (width) != 'undefined' ? width : 1;
        color = typeof (color) != 'color' ? color : '#000';

        // 计算各角度和对应的P2,P3坐标
        var angle = Math.atan2(fromY - toY, fromX - toX) * 180 / Math.PI,
            angle1 = (angle + theta) * Math.PI / 180,
            angle2 = (angle - theta) * Math.PI / 180,
            topX = headlen * Math.cos(angle1),
            topY = headlen * Math.sin(angle1),
            botX = headlen * Math.cos(angle2),
            botY = headlen * Math.sin(angle2);

        g.save();
        g.beginPath();

        var arrowX = fromX - topX,
            arrowY = fromY - topY;

        g.moveTo(arrowX, arrowY);
        g.moveTo(fromX, fromY);
        g.lineTo(toX, toY);
        arrowX = toX + topX;
        arrowY = toY + topY;
        g.moveTo(arrowX, arrowY);
        g.lineTo(toX, toY);
        arrowX = toX + botX;
        arrowY = toY + botY;
        g.lineTo(arrowX, arrowY);
        g.strokeStyle = color;
        g.lineWidth = width;
        g.stroke();
        g.restore();

    }

    //写文本
    function text(g, x, y, text, style) {
        var font = '12pt 微软雅黑', color = "#000000", maxWidth = 100;
        if (style) {
            g.font = style.font || font;
            g.fillStyle = style.color || color;
            g.textAlign = style.align || "start";
            g.textBaseline = style.vline || "alphabetic";
            maxWidth = style.maxWidth || maxWidth;
        }
        if (style && style.strokeStyle) {
            g.strokeText(text, x, y, maxWidth);
        }
        g.fillText(text, x, y, maxWidth);

        //计算宽高
        var w = g.measureText(text).width;
        var h = g.measureText('W').width;
        h = h + h / 6;
        return { width: w, height: h };

    }
    //加载图片
    function darwimg(g, x, y, image) {
        //创建新的图片对象
        var img = new Image();
        //指定图片的URL
        img.src = image;
        //浏览器加载图片完毕后再绘制图片
        img.onload = function () {
            //以Canvas画布上的坐标(10,10)为起始点，绘制图像
            g.drawImage(img, x, y);
        }
    }

    //毫米/米  转 度
    function mTorad(mM) {
        return (mM && !isNaN(mM)) ? parseFloat((mM * 0.001) * 180 / Math.PI).toFixed(2) : 0;
    }
    //度 转 毫米/米
    function dTomm(deg) {
        return (deg && !isNaN(deg)) ? parseFloat(((Math.PI / 180) * deg) * 1000).toFixed(2) : 0;
    }

    //gon 转弧度。Gon，百分度制(GRAD)角度单位，用G表示。1G = 直角的1%。
    function gTorad(gon) {
        return gon * 0.005;
    }

    mui.guide = guide;
    window.mui = mui;

})();