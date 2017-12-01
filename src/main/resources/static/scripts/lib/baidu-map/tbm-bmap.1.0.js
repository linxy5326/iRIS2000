
//盾构地图
!function () {
    var mainWidth = window.innerWidth, mainHeight = window.innerHeight;
    $(".mainContainer").css("width", mainWidth);
    $(".mainContainer").css("height", mainHeight);
    $(".mapContainer").css("width", mainWidth * 0.92);
    $(".mapContainer").css("height", mainHeight * 0.92 - 80);

    var newpoint;   //一个经纬度

    var projectInfo = {
        id: 17110001,
        pi_name: "西安市6号线二标三区段",
        pi_province: "陕西省西安市",
        pi_position: "108.852502,34.177797",
        pi_sgdw: "城轨公司",
        pi_opendate: "2017-11-27",
        pi_status: 1,
        pi_desc: "西韦区间(西部大道站～韦斗路站区间),本区间自出西部大道后，沿西太路下敷设，后进入韦斗路站。区间右线起讫里程：YDK10+000.00～YDK11+000.00，全长1000.00m；隧道直径6.0m，隧道结构底板埋深18.0～25.0m。",
        pi_flag: 2,
        section: [{
            id: 17110001001,
            ps_name: "西韦区间",
            remark: "西部大道站～韦斗路站区间",
            pro_id: 17110001,
            line: [{
                id: 1711000100101,
                sl_name: "左线",
                coords: ["108.852502, 34.177797", "108.852717, 34.169793", "108.852744, 34.169614", "108.853346, 34.166153"]
            },
            {
                id: 1711000100102,
                sl_name: "右线",
                coords: ["108.853697, 34.166183", "108.853005, 34.16964", "108.852973, 34.170611", "108.853153, 34.177831"]
            }]
        }]
    };


    var menu = document.querySelector('.menu');
    function showMenu(x, y) {
        menu.style.left = x + 'px';
        menu.style.top = y + 'px';
        menu.classList.add('show-menu');
        $(".menu-item>button").on("mousedown", function (e) {
            e.preventDefault();
            hideMenu();
            alert("功能暂未开通");   
            this.off();
        });
    }
    function hideMenu() {
        menu.classList.remove('show-menu');
    }
    $(document).on("mousedown", function () {
        hideMenu();
    });

    //初始化地图
    var bmap = baiduMap({ conname: "allmap", city: "西安", point: new BMap.Point(108.852502, 34.177797), zoom: 15 });
    bmap.mousedown(function (e) {
        hideMenu();
    });

    var linejj = { windth: 100, show: 0 };
    var label = new BMap.Label("西韦区间-左线：<br/>总里程:1560 米 总环数：1040 环<br/>当前里程:890 米 当前环数：593 环", { offset: new BMap.Size(30, -50) });
    label.setStyle({
        color: "#24D5FF",
        fontSize: "12px",
        height: "60px",
        lineHeight: "20px",
        border: "1px solid #bbb",
        backgroundColor: "#0E4D7F"
    });


    var points = [
        new BMap.Point(108.852502, 34.177797),
        new BMap.Point(108.852717, 34.169793),
        new BMap.Point(108.852744, 34.169614),
        new BMap.Point(108.853346, 34.166153)];

    var points1 = [
        new BMap.Point(108.853697, 34.166183),
        new BMap.Point(108.853005, 34.16964),
        new BMap.Point(108.852973, 34.170611),
        new BMap.Point(108.853153, 34.177831)];

    var pl1 = bmap.polyline({ points: points });
    var pl2 = bmap.polyline({
        points: points1
        , click: function (e) {
            // alert(e.point.lng + ", " + e.point.lat);
        },
        mouseover: function (e) {


        }, mouseout: function (e) {
        }
    });

    var pl3, pl4, style = {
        strokeColor: "#16F106",
        strokeWeight: 8,
        strokeOpacity: 1
    };
    pl3 = bmap.polyline({ points: [new BMap.Point(108.852502, 34.177797), new BMap.Point(108.852588, 34.175393)], style: style });
    pl4 = bmap.polyline({
        points: [new BMap.Point(108.853153, 34.177831), new BMap.Point(108.853009, 34.171603)], style: style, rightclick: function (e) {
            // bmap.map.map.getContainer().appendChild(div);
            console.log(e);
            showMenu(e.clientX, e.clientY);
        }
    });

    //添加盾构机图标
    var myIcon = new BMap.Icon("../../images/mac/yunxing.png", new BMap.Size(32, 32));
    var myIcon1 = new BMap.Icon("../../images/mac/weixiu.png", new BMap.Size(32, 32));
    var myIcon3 = new BMap.Icon("../../images/mac/xianzhi.png", new BMap.Size(32, 32));
    bmap.marker({
        point: new BMap.Point(108.853009, 34.171603), options: { icon: myIcon }, click: function (e) {
            $(".hboxContainer").css("display", "block");
            $.ajax("../machine/tbm_daopan.html", {
                type: "GET", success: function (d) {
                    $("#hBox .content").html(d);
                }
            });
        },
        load: function (target) {

            target.setLabel(label);

            var win = tbm_info({ point: new BMap.Point(108.852588, 34.175393), info: ["运行", "西安市6号线二标三区段", "王三", "CREC1811", "土压平衡盾构机", "中铁装备", "2017年8月", "租凭"] });
            target.addEventListener("mouseover", function (e) {
                target.openInfoWindow(win);
            });
            target.addEventListener("mouseout", function (e) {
                win.hide();
            });
        }
    });

    bmap.marker({
        point: new BMap.Point(108.852588, 34.175393),
        options: { icon: myIcon1 } });

    //实时获取经纬度
    bmap.click(function (e) {
        //newpoint = new BMap.Point(e.point.lng, e.point.lat);
        console.log(e.point.lng + "," + e.point.lat);
    });

    bmap.zoomend(function (e) {
        var zoom = this.getZoom();
        if (zoom <= 11) {
            $(label.V).css("display", "none");
        } else {
            $(label.V).css("display", "block");
        }
    });

    $(".start>.cur-pro").on("click", function (e) {
        btn_project_click($(this), e);
    });

    $(".back").on("click", function (e) {
        bmap.map.setZoom(5);
        bmap.map.panTo(new BMap.Point(108.852502, 34.177797));
    })


    function btn_project_click(target, e) {

        if (typeof target === 'undefined') {
            target = $(this);
        }

        var location = target.data("position"), lnglat;
        if (location) {
            lnglat = location.split(',');

            if (lnglat.length == 2) {

                //修改地图中心点
                bmap.map.setZoom(18);
                bmap.map.panTo(new BMap.Point(lnglat[0], lnglat[1]));
            }
        }
    }

    $(".pro.caption").click(function (e) {

        if ($(this).next().attr("class").indexOf("display_no") == -1) {
            btn_project_click($(this), e);
        }
    });

    //移动地图到指定的施工线路上
    $(".sec-item.line>a").click(function (e) {
        btn_project_click($(this).parent(), e);
    });
    //盾构机信息窗口
    function tbm_info(option) {
        var _info = "<div class='tbm-info-box'><ul>";
        _info += "<li><span>状态：</span>{0} </li>";
        _info += "<li><hr /></li>";
        _info += "<li><span>项目名称：</span>{1} </li>";
        _info += "<li><span>项目负责人：</span>{2} </li>";
        _info += "<li><span>盾构机名称：</span>{3} </li>";
        _info += "<li><span>型号：</span>{4} </li>";
        _info += "<li><span>生产厂家：</span>{5}</li>";
        _info += "<li><span>出厂日期：</span>{6}</li>";
        _info += " <li><hr /></li>";
        _info += "<li><span>资产归属：</span>{7}</li>";
        _info += " </ul></div>";

        _info = xabg.strFormat(_info, option.info[0], option.info[1], option.info[2], option.info[3], option.info[4], option.info[5], option.info[6], option.info[7]);

        var linejj = { windth: 350, show: 0 };
        var infoWindow = new BMap.InfoWindow(_info, linejj);
        return infoWindow;
    }

}();
