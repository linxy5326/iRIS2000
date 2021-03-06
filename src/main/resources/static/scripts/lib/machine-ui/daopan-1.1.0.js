﻿(function () {

    var FONT_SIZE_REG = "/\d+(\.\d+)?(px|pt|em|%)/ig";
    var defdata = {
        //刀盘
        dp_tjsd: 0, dp_nj: 0, dp_ztl: 0, dp_grd: 0, dp_cwl: 0, dp_ctl: 0,
        dp_zx: 1, dp_zs: 0, dp_clyw: 0, dp_tjyy: 0, dp_tjtiem: 0, dp_ty1: 0,
        dp_ty2: 0, dp_ty3: 0, dp_ty4: 0, dp_ty5: 0, dp_ty6: 0, lx_zs: 0,
        lx_nj: 0, lx_q_pre: 0, lx_h_pre: 0, lx_s_kd: 0, lx_x_kd: 0,
        //油缸
        yg_a_pre: 0, yg_b_pre: 0, yg_c_pre: 0, yg_d_pre: 0, yg_a_dis: 0, yg_b_dis: 0,
        yg_c_dis: 0, yg_d_dis: 0, ep_n_pre: 0, ep_w_pre: 0, hwb_n_pre: 0, heb_w_pre: 0,
        //注浆
        sc_count: 0, sc_l1: 0, sc_l2: 0, sc_l3: 0, sc_l4: 0,
        sc_pre1: 0, sc_pre2: 0, sc_pre3: 0, sc_pre4: 0,
        //铰接 压力
        h_pre1: 0, h_pre2: 0, h_pre3: 0, h_pre4: 0,
        //行程
        h_dis1: 0, h_dis2: 0, h_dis3: 0, h_dis4: 0,
        //上下角度
        ang_ud: 0,
        //左右角度
        ang_lr: 0,
        prodata: {
            name: "导向系统",
            proname: "",
            secline: "",
            tbm: {
                name: "CREC1811",
                workstate: "掘进",
                tjlc: 0,
                tjring: 0
            }
        },
        war: {}
    };
    var mui = mui || {};
    var GRID_STYLE = "rgba(36,213,255,0.3)", GRID_STYLE_LIGHT = "rgba(36,213,255,0.5)", GRID_LINE_WIDTH = 0.5,
        Font = "12pt 微软雅黑";
    var cvs, g, drawingSurfaceImageData, tempImagData;

    var graphs = [{ x: 65, y: 1015, r: 30 }, {}];


    var daopan = function (option) {
        g = option.g;
        cvs = g.canvas;
        this.cfg = option.cfg;
        return this;
    };

    var conf = { x: 0, y: 0, width: 0, height: 0, radius: 0 };

    daopan.prototype = {
        init: function (option) {
            drawcatstatus(g, { x: 1650, y: 120 }, { status: 1, utime: 12344422213 });
            drawtools(g, { x: 10, y: 20 }, this.data.prodata);
            drawdaopan(g, { x: 680, y: 550, radius: 260 }, this.data);

            //注册事件
            canvas_event();
            return this;
        },
        setdata: function (option) {
            drawtxtlabel(g, { x: 80, y: 200, radius: 260 }, this.data);
            drawjiaojie(g, { x: 1550, y: 360, radius: 170 }, this.data);
            drawzhujian(g, { x: 1550, y: 780, radius: 170 }, this.data);
            return this;
        },
        setbg: function (color) {
            g.fillStyle = color || "#00000";
            g.fillRect(0, 0, cvs.width, cvs.height);
            return this;
        },
        scale: function (x, y) {
            x = x || 0;
            y = y || x;
            g.scale(x, y);
            return this;
        },
        erasebg: function () {
            this.g.translate(-100, -100);
            this.g.clearRect(0, 0, cvs.width * 2, cvs.height * 2);
            return this;
        },
        data: defdata
    };

    function canvas_event() {
        canvas.addEventListener("click", function (e) {
            e.preventDefault();
        });
        canvas.addEventListener("mousemove", function (e) {

        });

        canvas.addEventListener("mousedown", function (e) {

        });

        canvas.addEventListener("mouseup", function (e) {

        });
    }

    function drawtools(g, conf, d) {
        var x = conf.x, y = conf.y;
        var imgsrc = "../../images/mac/",
            imgs = ["caption.png", "projectName.png", "pushon.png", "mileage.png", "ringno.png", "alert.png", "max.png", "close.png", "circle.png", "tab1.png", "tab2.png", "tab3.png"];
        g.save();
        g.translate(x, y);

        darwimg(g, 20, 20, imgsrc + imgs[0]);
        darwimg(g, 400, -20, imgsrc + imgs[1]);
        darwimg(g, 730, -10, imgsrc + imgs[2]);
        darwimg(g, 890, -10, imgsrc + imgs[3]);
        darwimg(g, 1150, -10, imgsrc + imgs[4]);
        darwimg(g, 1445, 0, imgsrc + imgs[5]);

        //darwimg(g, 1870, 0, imgsrc + imgs[6]);
        //darwimg(g, 1895, 0, imgsrc + imgs[7]);

        darwimg(g, 30, 980, imgsrc + imgs[8]);
        darwimg(g, 80, 990, imgsrc + imgs[9]);
        darwimg(g, 410, 990, imgsrc + imgs[10]);
        darwimg(g, 740, 990, imgsrc + imgs[11]);


        //开始图标
        g.fillStyle = "rgba(36,213,255,0.4)";
        drawarc(g, 56, 997, 30).fill();

        var style = {
            font: ' 14pt 微软雅黑',
            color: '#25d5ff'
        };
        //写数据
        style.font = 'bold 14pt 微软雅黑';

        //盾构机名称
        text(g, 60, 45, d.tbm.name, style);
        //页面名称
        text(g, 260, 45, d.name, style);
        //项目名称
        style.font = ' 12pt 微软雅黑';
        style.color = "#3FB633";
        style.maxWidth = 200;
        text(g, 490, 5, d.proname, style);
        text(g, 490, 30, d.secline, style);
        //状态
        style.font = 'bold 14pt 微软雅黑';
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

    //刀盘
    function drawdaopan(g, conf, d) {
        var x = conf.x; y = conf.y, r = conf.radius, r1 = r - 8;
        g.save();
        g.translate(x, y);
        g.lineWidth = 1;
        g.strokeStyle = "#1DA2CC";
        g.save();
        g.fillStyle = "rgba(36,213,255,0.14)";
        drawholcir(g, 0, 0, r, r - r * 0.64);
        g.fill();
        drawholcir(g, 0, 0, r1, r - r * 0.64);
        g.fill();
        g.restore();
        g.lineWidth = 2;
        drawarc(g, 0, 0, r);
        drawarc(g, 0, 0, r1);
        //小扇形
        g.fillStyle = "rgba(36,213,255,0.14)";
        drawsector(g, 0, 0, r1, -50, 10).fill();
        drawsector(g, 0, 0, r - 30, 0, 60).fill();
        drawsector(g, 0, 0, r - 8, 62, 80).fill();
        drawsector(g, 0, 0, r - 30, 100, 120).fill();
        drawsector(g, 0, 0, r - 8, 130, 145).fill();
        drawsector(g, 0, 0, r - 8, 165, 210).fill();
        drawsector(g, 0, 0, r - 30, 195, 270).fill();
        //三号圆
        g.fillStyle = "rgba(3,6,61,0.4)";
        drawarc(g, 0, 0, r - r * 0.3).fill();
        //四号圆
        g.fillStyle = "rgba(36,213,255,0.1)";
        g.strokeStyle = g.fillStyle;
        drawarc(g, 0, 0, r - r * 0.35).fill();
        g.fillStyle = "rgba(36,213,255,0.2)";
        drawsector(g, 0, 0, r - r * 0.48, 5, 65).fill();
        drawsector(g, 0, 0, r - r * 0.48, 200, 275).fill();
        drawsector(g, 0, 0, r - r * 0.42, 158, 162).fill();
        drawsector(g, 0, 0, r - r * 0.48, 120, 140).fill();
        drawsector(g, 0, 0, r - 30, 155, 168).fill();
        g.strokeStyle = "rgba(36,213,255,0.2)";
        drawarc(g, 0, 0, r - r * 0.64);
        //5
        g.strokeStyle = "#1570A0";
        g.lineWidth = 5;
        drawarcd(g, 0, 0, r - r * 0.54);
        // 小圆环
        g.lineWidth = 1;
        g.fillStyle = "#1570A0";
        drawholcir(g, 0, 0, r - r * 0.72, r - r * 0.8);
        g.fill();
        //8
        g.fillStyle = "#1570A0";
        drawarc(g, 0, 0, r - r * 0.84);
        g.fill();
        //9
        g.fillStyle = "rgba(3,6,61,1)";
        g.font = "bold " + Font;
        g.textAlign = "center";
        drawarc(g, 0, 0, r - r * 0.88);
        g.fill();
        g.fillStyle = "#afff15";
        g.fillText("刀盘", 0, 5, 200);
        g.lineWidth = 2;
        g.strokeStyle = "#73DFF5";
        drawdaopanline(g, conf);
        //油缸
        drawdaopyougan(g, conf);
        //土压
        drawtuya(g, conf);
        g.restore();
    }
    function drawtuya(g, conf) {
        var x = conf.x, y = conf.y, r = conf.radius, r1 = 6;
        r = r * 0.5;
        var ang = 60;
        g.save();
        g.fillStyle = "#afff15";
        g.strokeStyle = g.fillStyle;
        g.rotate(rads(40));
        for (var i = 0; i < 6; i++) {
            drawarc(g, r * cos(ang * i), r * sin(ang * i), r1);
            g.fill();
        }
        g.restore();

        g.fillStyle = "#25d5ff";
        g.font = " 12pt 微软雅黑";
        g.fillText("土压1(bar)", 30, -140, 200);
        g.fillText("土压2(bar)", 120, -60, 200);
        g.fillText("土压3(bar)", 110, 70, 200);
        g.fillText("土压4(bar)", -20, 114, 200);
        g.fillText("土压5(bar)", -130, 30, 200);
        g.fillText("土压6(bar)", -100, -100, 200);

    }
    function drawtxtlabel(g, conf, d) {
        var x = conf.x, y = conf.y, r = conf.radius;

        var style = {
            padding: 5, color: "#90ef42", bgcolor: "#092B60"
        };
        g.font = '14pt 微软雅黑';
        g.save();
        g.translate(x + 50, y);

        drawtext(g, 0, 0, 50, 25, { title: "推进速度", value: d.dp_tjsd, unit: "mm/min" }, style);
        drawtext(g, 0, 0 + 40, 50, 25, { title: "刀盘扭矩", value: d.dp_nj, unit: "KN.m" }, style);
        drawtext(g, 0, 0 + 80, 50, 25, { title: "总  推  力", value: d.dp_ztl, unit: "KN" }, style);
        drawtext(g, 0, 0 + 120, 50, 25, { title: "贯  入  度", value: d.dp_grd, unit: "mm/rpm" }, style);
        drawtext(g, 0, 0 + 160, 50, 25, { title: "超  挖  量", value: d.dp_cwl, unit: "mm" }, style);
        drawtext(g, 0, 0 + 200, 50, 25, { title: "出  土  量", value: d.dp_ctl, unit: "m2" }, style);

        g.translate(x - 50, y + 340);
        g.save();
        g.strokeStyle = "#25d5ff";
        drawline(g, 0 - 20, 0 - 20, 40, 0 - 20).stroke();
        g.fillStyle = "#25d5ff";
        g.fillText("EP2 压力", 0 + 50, 0 - 10, 200);
        drawline(g, 0 + 130, 0 - 20, 190, 0 - 20).stroke();
        drawline(g, 0 - 20, 0 + 90, 40, 0 + 90).stroke();
        g.fillStyle = "#25d5ff";
        g.fillText("HWB 压力", 0 + 45, 0 + 100, 200);
        drawline(g, 0 + 135, 0 + 90, 195, 0 + 90).stroke();
        g.restore();
        //ep2
        drawtext(g, 0, 0 + 30, 50, 25, { title: "内密封", value: d.ep_n_pre, unit: "bar" }, style);
        drawtext(g, 0, 0 + 60, 50, 25, { title: "外密封", value: d.ep_w_pre, unit: "bar" }, style);
        //hwb
        drawtext(g, 0, 0 + 140, 50, 25, { title: "内密封", value: d.hwb_n_pre, unit: "bar" }, style);
        drawtext(g, 0, 0 + 170, 50, 25, { title: "外密封", value: d.heb_w_pre, unit: "bar" }, style);
        g.restore();

        g.save();
        g.translate(x + x + 50, y + y + 160);
        drawtext(g, 0, 0, 50, 25, { title: "C 组行程", value: d.yg_c_dis, unit: "mm" }, style);
        drawtext(g, 0, 0 + 30, 50, 25, { title: "C 组压力", value: d.yg_c_pre, unit: "bar" }, style);

        g.translate(x + r * 2.6, 0);
        drawtext(g, 0, 0, 50, 25, { title: "A 组行程", value: d.yg_a_dis, unit: "mm" }, style);
        drawtext(g, 0, 0 + 30, 50, 25, { title: "A 组压力", value: d.yg_a_pre, unit: "bar" }, style);
        g.restore();

        g.save();
        g.translate(x + r * 2, y + 30);
        drawtext(g, 0, 0, 50, 25, { title: "D 组行程", value: d.yg_d_dis, unit: "mm" }, style);
        drawtext(g, 0, 0 + 30, 50, 25, { title: "D 组压力", value: d.yg_d_pre, unit: "bar" }, style);

        g.translate(0, y + r * 1.7);
        drawtext(g, 0, 0, 50, 25, { title: "B 组行程", value: d.yg_b_dis, unit: "mm" }, style);
        drawtext(g, 0, 0 + 30, 50, 25, { title: "B 组压力", value: d.yg_b_pre, unit: "bar" }, style);
        g.restore();

        //土压
        g.save();
        g.translate(x + 600, y + 350);
        drawlabel(g, -150, -50, 50, 25, d.dp_ty1, style);
        drawlabel(g, 80, -80, 50, 25, d.dp_ty1, style);
        drawlabel(g, 100, 50, 50, 25, d.dp_ty1, style);
        drawlabel(g, -40, -100, 50, 25, d.dp_ty1, style);
        drawlabel(g, -150, 80, 50, 25, d.dp_ty1, style);
        drawlabel(g, -10, 150, 50, 25, d.dp_ty1, style);
        g.restore();

        g.save();
        g.translate(x + r * 3.6, y);

        var zx = "停止";
        if (d.dp_zx == 1)
            zx = "正向";
        if (d.dp_zx == -1)
            zx = "反向";

        drawtext(g, 0, 0, 50, 25, { title: "刀盘转向", value: zx, unit: "" }, style);
        drawtext(g, 0, 0 + 40, 50, 25, { title: "刀盘转速", value: d.dp_zs, unit: "mm/min" }, style);
        drawtext(g, 0, 0 + 80, 50, 25, { title: "齿轮油温", value: d.dp_clyw, unit: "mm/min" }, style);
        drawtext(g, 0, 0 + 120, 50, 25, { title: "推进油压", value: d.dp_tjyy, unit: "mm/min" }, style);
        drawtext(g, 0, 0 + 160, 50, 25, { title: "推进时长", value: d.dp_tjtiem, unit: "m2" }, style);

        g.translate(0, y + r + 40);
        drawtext(g, 0, 0, 50, 25, { title: "螺机转速", value: d.lx_zs, unit: "mm/min" }, style);
        drawtext(g, 0, 0 + 40, 50, 25, { title: "螺机扭矩", value: d.lx_nj, unit: "mm/min" }, style);
        drawtext(g, 0, 0 + 80, 50, 25, { title: "前部压力", value: d.lx_q_pre, unit: "mm/min" }, style);
        drawtext(g, 0, 0 + 120, 50, 25, { title: "后部压力", value: d.lx_h_pre, unit: "mm/min" }, style);
        drawtext(g, 0, 0 + 160, 50, 25, { title: "上  闸  门", value: d.lx_s_kd, unit: "m2" }, style);
        drawtext(g, 0, 0 + 200, 50, 25, { title: "下  闸  门", value: d.lx_x_kd, unit: "m2" }, style);
        g.restore();

    }
    function drawjiaojie(g, conf, d) {
        var x = conf.x, y = conf.y, r = conf.radius;
        var style = { color: "#90EF42", bgcolor: '#092B60', bodercolor: '#092B60' };

        g.save();
        g.translate(x, y);
        g.fillStyle = "rgba(36,213,255,0.28)";
        g.strokeStyle = "rgba(36,213,255,1)";
        drawarc(g, 0, 0, r);
        g.lineWidth = 2;
        g.stroke();

        //遮盖圆
        g.fillStyle = "rgba(36,213,255,0.1)";
        drawarc(g, 0, 0, r * 0.92).fill();

        drawholcir(g, 0, 0, r, r * 0.7);
        g.fill();
        g.fillStyle = "rgba(36,213,255,0.14)";
        drawsector(g, 0, 0, r * 0.92, 20, 80).fill();
        drawsector(g, 0, 0, r * 0.92, -90, -40).fill();
        drawsector(g, 0, 0, r * 0.92, 140, 220).fill();

        g.fillStyle = "rgba(36,213,255,0.24)";
        drawsector(g, 0, 0, r * 0.75, -105, -55).fill();
        drawsector(g, 0, 0, r * 0.75, 10, 60).fill();

        drawsector(g, 0, 0, r * 0.75, 125, 205).fill();

        g.strokeStyle = "rgba(36,213,255,0.14)";
        g.lineWidth = 10;
        drawarcd1(g, 0, 0, r * 0.9);
        //遮盖圆
        g.strokeStyle = "rgba(36,213,255,0.1)";
        g.fillStyle = "rgba(36,213,255,0.1)";
        drawarc(g, 0, 0, r * 0.6).fill();

        g.rotate(rads(15));
        g.lineWidth = 8;
        drawarcd1(g, 0, 0, r * 0.7);
        g.rotate(rads(15));

        g.fillStyle = "rgba(3,6,61,1)";
        drawarc(g, 0, 0, r * 0.55);
        g.fill();

        drawJJP(g, { x: x, y: y, radius: r, count: 4 });

        g.restore();

        g.lineWidth = 1;
        g.strokeStyle = "rgba(36,213,255,1)";
        drawline(g, x - r + 50, y, x - 50, y);
        drawline(g, x + r - 50, y, x + 50, y);
        drawline(g, x, y - 50, x, y - r + 50);
        drawline(g, x, y + 50, x, y + r - 50);
        g.save();
        g.translate(x, y - (r + 10));
        g.font = ' bold 14pt 微软雅黑';
        g.textAlign = "center";
        g.fillStyle = "rgba(36,213,255,1)";
        g.fillText("铰    接", 0, 0, 200);
        g.font = ' 12pt 微软雅黑';
        g.fillText("位移(mm)", 0, 0 + r * 0.3, 200);
        g.fillText("压力(bar)", 0, 0 + r * 0.8, 200);

        g.restore();
        g.save();
        g.translate(x - 80, y + 5);
        g.font = ' bold 14pt 微软雅黑';
        g.fillStyle = "rgba(36,213,255,1)";
        g.fillText("角度", 0, 0, 200);
        g.font = '  12pt 微软雅黑';
        g.fillText("上下", 50, -15, 200);
        g.fillText("左右", 50, 15, 200);
        g.translate(80, 0);
        drawlabel(g, 10, -10, 50, 20, d.ang_ud, style);
        drawlabel(g, 10, 20, 50, 20, d.ang_lr, style);
        g.restore();

        g.save();
        g.translate(x, y);
        //压力标签
        drawlabel(g, 90, -120, 50, 25, d.h_dis1, style);
        drawlabel(g, 90, 145, 50, 25, d.h_dis2, style);
        drawlabel(g, -130, 145, 50, 25, d.h_dis3, style);
        drawlabel(g, -130, -120, 50, 25, d.h_dis4, style);
        //位移标签
        drawlabel(g, 60, -60, 50, 25, d.h_pre1, style);
        drawlabel(g, 60, 85, 50, 25, d.h_pre2, style);
        drawlabel(g, -100, 85, 50, 25, d.h_pre3, style);
        drawlabel(g, -100, -60, 50, 25, d.h_pre4, style);
        g.restore();

    }
    function drawzhujian(g, conf, d) {
        var x = conf.x, y = conf.y, r = conf.radius;
        var style = { color: "#90EF42", bgcolor: '#092B60', bodercolor: '#092B60' };
        g.save();
        g.translate(x, y);
        g.fillStyle = "rgba(36,213,255,0.28)";
        g.strokeStyle = "rgba(36,213,255,1)";
        drawarc(g, 0, 0, r);
        g.lineWidth = 2;
        g.stroke();
        drawholcir(g, 0, 0, r, r * 0.74);
        g.fill();

        g.fillStyle = "rgba(36,213,255,0.14)";
        drawsector(g, 0, 0, r, 20, 80).fill();
        drawsector(g, 0, 0, r, -90, -40).fill();
        drawsector(g, 0, 0, r, 140, 220).fill();


        g.fillStyle = "rgba(36,213,255,0.24)";
        drawsector(g, 0, 0, r * 0.45, -105, -55).fill();
        drawsector(g, 0, 0, r * 0.45, 10, 60).fill();

        drawsector(g, 0, 0, r * 0.45, 125, 205).fill();

        g.strokeStyle = "rgba(36,213,255,0.14)";
        g.lineWidth = 10;
        drawarcd1(g, 0, 0, r * 0.9);
        g.rotate(rads(15));
        g.lineWidth = 8;
        drawarcd1(g, 0, 0, r * 0.8);

        //遮盖圆
        g.strokeStyle = "rgba(36,213,255,0.1)";
        g.fillStyle = "rgba(36,213,255,0.1)";
        drawarc(g, 0, 0, r * 0.6).fill();

        g.fillStyle = "rgba(3,6,61,1)";
        drawarc(g, 0, 0, r * 0.5);
        g.fill();

        drawJJP(g, { x: x, y: y, radius: r, count: 4 });
        g.restore();
        r = r * 0.7;
        g.lineWidth = 1;
        g.strokeStyle = "rgba(36,213,255,1)";
        drawline(g, x - r, y, x + r, y);
        drawline(g, x, y - r, x, y + r);

        g.save();
        g.translate(x, y - r * 1.6);
        g.font = ' bold 14pt 微软雅黑';
        g.textAlign = "center";
        g.fillStyle = "rgba(36,213,255,1)";
        g.save();
        g.translate(0 - 40, 0);
        g.fillText("同步注浆 总量：", 0, 0, 200);
        g.font = ' 14pt 微软雅黑';
        g.textAlign = "left";
        g.fillStyle = style.color;
        g.fillText(d.sc_count, 0 + 60 + 10, 0, 200);
        g.fillStyle = "rgba(36,213,255,1)";
        g.textAlign = "center";
        var tl = g.measureText(d.sc_count).width + 10;
        g.fillText("m", 0 + 75 + tl, 0, 200);
        g.font = ' 10pt 微软雅黑';
        g.fillText("3", 0 + 75 + tl + 12, 0 - 5, 200);
        g.restore();
        g.restore();

        g.save();
        g.translate(x + r * cos(rads(1)), y + r * sin(rads(1)));
        //注浆量
        drawlabel(g, 0 - 50, 0 - 90, 50, 25, d.sc_l1, style);
        drawlabel(g, 0 - 50, 0 + 110, 50, 25, d.sc_l2, style);
        drawlabel(g, 0 - r * 2, 0 + 110, 50, 25, d.sc_l3, style);
        drawlabel(g, 0 - r * 2, 0 - 90, 50, 25, d.sc_l4, style);

        g.restore();

        g.save();
        g.translate(x, y);
        g.fillStyle = "rgba(36,213,255,1)";
        g.textAlign = "center";
        g.font = ' 12pt 微软雅黑';
        g.fillText("注浆量(m", 0, 0 - 140, 200);
        g.font = ' 10pt 微软雅黑';
        g.fillText("3", 0 + 40, 0 - 145, 200);
        g.font = ' 12pt 微软雅黑';
        g.fillText(")", +48, 0 - 140, 200);
        g.fillText("压力(bar)", 0, 0 - 60, 200);
        g.font = ' 14pt 微软雅黑';
        //压力
        drawlabel(g, 0 + 20, 0 - 15, 50, 25, d.sc_pre1, style);
        drawlabel(g, 0 + 20, 0 + 40, 50, 25, d.sc_pre2, style);
        drawlabel(g, 0 - 80, 0 + 40, 50, 25, d.sc_pre3, style);
        drawlabel(g, 0 - 80, 0 - 15, 50, 25, d.sc_pre4, style);

        g.restore();
    }

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
    //标签
    function drawlabel(g, x, y, w, h, text, style) {
        var value = "";
        if (text !== undefined) {
            value = text;
        }
        var tl = g.measureText(value).width + 10, pd = style && style.padding || 0;

        g.save();
        g.textAlign = style && style.align || "left";
        g.textBaseline = "bottom";
        g.fillStyle = style && style.bgcolor || "#092b60";
        g.strokeStyle = style && style.bodercolor || "#092b60";
        if (tl >= w)
            w = tl + pd;
        else
            w = w + pd;
        drawroundrect(g, x, y - h, w, h, 5).fill();

        g.fillStyle = style && style.color || "#25d5ff";
        g.fillText(value, x + 5 + pd, y, 150);
        g.restore();
    }

    //文本标签
    function drawtext(g, x, y, width, height, data, style) {
        var d = { title: data.title || "", value: "", unit: data.unit || "" };
        var superscript = ["m2", "m3"];
        if (data && data.value !== undefined) {
            d.value = data.value;
        }
        var v = d.value + " " + d.unit;
        var tl = g.measureText(d.title).width + 5, tl1 = g.measureText(v).width + 5;
        var pd = style && style.padding || 0;
        g.font = style && style.font || '14pt 微软雅黑';
        g.textAlign = style && style.align || "left";
        g.textBaseline = "bottom";

        g.save();
        g.fillStyle = style && style.labcolor || "#25d5ff";
        g.fillText(d.title, x, y, 200);
        g.fillStyle = style && style.bgcolor || "#092b60";
        g.strokeStyle = style && style.bodercolor || "#092b60";
        if (tl1 >= width)
            width = tl1 + pd;
        else
            width = width + pd;
        drawroundrect(g, x + tl + 10, y - height, width, height, 5).fill();
        g.fillStyle = style && style.color || "#25d5ff";
        g.fillText(d.value, x + tl + 10 + pd, y, 150);
        //画数据单位
        var vw = g.measureText(d.value).width + tl + 15 + pd;
        tl = g.measureText(d.unit).width;
        if (d.unit == "m2" || d.unit == "m3") {
            var unitpre = d.unit.match(/^\w/ig), th = g.measureText('W').width, us = d.unit.substr(1, 1);
            g.fillText(unitpre, x + vw, y);
            g.font = '10pt 微软雅黑';
            g.fillText(us, x + vw + th, y - th / 3, tl * 0.8);
        }
        else {

            g.fillText(d.unit, x + vw, y, tl * 0.8);
        }

        g.restore();
    }
    //圆角矩形
    function drawroundrect(g, x, y, w, h, r) {
        g.beginPath();
        g.moveTo(x + r, y);
        g.arcTo(x + w, y, x + w, y + h, r);
        g.arcTo(x + w, y + h, x, y + h, r);
        g.arcTo(x, y + h, x, y, r);
        g.arcTo(x, y, x + w, y, r);
        g.closePath();
        g.stroke();
        return g;
    }
    //六条线
    function drawdaopanline(g, conf) {
        var x = conf.x, y = conf.y, r = conf.radius;

        g.save();
        g.rotate(0.4);
        for (var i = 1; i <= 6; i++) {
            g.rotate(1);
            drawline(g, 0 + 60, 0 + 60, 128, 128);
        }
        g.restore();
    }

    //铰接油缸
    function drawJJP(g, conf) {
        var x = conf.x, y = conf.y, r = conf.radius;
        r = r * 0.86;
        var r1 = r * 0.08, count = conf.count || 16;

        g.save();
        g.lineWidth = 2;
        g.fillStyle = "#ffc600";
        var ang = 360 / count;
        g.rotate(rads(15));
        for (var i = 0; i < count; i++) {
            drawarc(g, r * cos(ang * i), r * sin(ang * i), r1);
            g.fill();
        }
        g.restore();
    }

    function drawdaopyougan(g, conf) {
        var x = conf.x, y = conf.y, r = conf.radius;
        r = r * 0.84;
        var r1 = r * 0.06, count = conf.count || 32;
        var fs = 'rgba(36, 213, 255, 0.4)';

        g.save();
        g.lineWidth = 2;
        g.fillStyle = fs;
        g.strokeStyle = 'rgba(36, 213, 255, 0.8)';
        var ang = 360 / count;
        g.rotate(rads(-90));
        for (var i = 1; i <= count; i++) {

            drawarc(g, r * cos(ang * i), r * sin(ang * i), r1);
            if (i == 8 || i == 18 || i == 24 || i == 32) {
                g.fillStyle = "#ffc600";
            } else {
                g.fillStyle = fs;
            }
            g.fill();
        }
        //油缸连接线
        g.save();

        g.lineWidth = 1.5;
        g.rotate(rads(11));
        g.beginPath();
        g.arc(0, 0, r + 13, 0, Math.PI * 0.07);
        g.stroke();
        g.beginPath();
        g.arc(0, 0, r - 13, 0, Math.PI * 0.07);
        g.stroke();
        g.closePath();
        for (var i = 0; i < 15; i++) {
            if (i > 5) {
                g.rotate(rads(22.5));
            } else {
                g.rotate(rads(22.3));
            }
            g.beginPath();
            g.arc(0, 0, r + 13, 0, Math.PI * 0.07);
            g.stroke();
            g.beginPath();
            g.arc(0, 0, r - 13, 0, Math.PI * 0.07);
            g.stroke();
            g.closePath();
        }
        g.restore();
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

        if (d.status) {
            g.fillStyle = "#AEFA25";
        }
        else
            g.fillStyle = "#e50101";
        g.strokeStyle = g.fillStyle;
        g.lineWidth = 2.5;
        drawarc(g, 90, -5, 10).fill();
        g.stroke();
        g.restore();
    }
    //---------------基础绘图方法-----------------------------------
    function drawholcir(g, x, y, radius1, radius2) {
        g.beginPath();
        g.arc(x, y, radius1, 0, Math.PI * 2, false);
        g.arc(x, y, radius2, 0, Math.PI * 2, true);
        g.closePath();
        g.fill();
        return g;
    }

    function drawarcd(g, x, y, radius) {
        g.save();
        // 虚线圆环
        g.translate(x, y); // 改变旋转中心
        g.beginPath();
        g.arc(0, 0, radius * 2 / 3 + 4, 0, Math.PI * 0.03);
        g.stroke();
        g.closePath();
        for (var i = 0; i < 40; i++) {
            g.beginPath();
            g.rotate(10 * Math.PI / 180);
            g.arc(0, 0, radius * 2 / 3 + 4, 0, Math.PI * 0.03);
            g.stroke();
            g.closePath();
        }
        g.restore();
        return g;
    }

    function drawarcd1(g, x, y, radius) {
        g.save();
        // 虚线圆环
        g.translate(x, y); // 改变旋转中心
        g.beginPath();
        g.arc(0, 0, radius * 2 / 3 + 4, 0, Math.PI * 0.28);
        g.stroke();
        g.closePath();
        for (var i = 0; i < 6; i++) {
            g.beginPath();
            g.rotate(60 * Math.PI / 180);
            g.arc(0, 0, radius * 2 / 3 + 4, 0, Math.PI * 0.28);
            g.stroke();
            g.closePath();
        }
        g.restore();
        return g;
    }

    function drawsector(g, x, y, r, s, e) {

        g.beginPath();
        g.moveTo(x, y);
        g.arc(x, y, r, rads(s), rads(e), false);
        g.closePath();
        return g;
    }

    function drawarc(g, x, y, radius) {
        g.save();
        g.beginPath();
        g.arc(x, y, radius, 0, Math.PI * 2, false);
        g.stroke();
        g.restore();
        return g;
    }

    function darwfillarc(g, x, y, radius) {
        g.beginPath();
        g.arc(x, y, radius, 0, Math.PI * 2, false);
    }

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

    //画线
    function drawline(g, x, y, x1, y1) {
        g.beginPath();
        drawlinefor(g, x, y, x1, y1);
        g.closePath();
        g.stroke();
        return g;
    }
    //非路径画线
    function drawlinefor(g, x, y, x1, y1) {
        g.moveTo(x, y);
        g.lineTo(x1, y1);
    }

    function PI() {
        return Math.PI;
    }

    function rads(x) {
        return Math.PI * x / 180;
    }

    function cos(a) {
        return Math.cos(rads(a));
    }
    function sin(a) {
        return Math.sin(rads(a));
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

    mui.daopan = daopan;
    window.mui = mui;
})();