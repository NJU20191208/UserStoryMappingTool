$(function(){

    $("#add_map").click(function () {
        addStoryMap(1);
    });

    $("#add_and_open_map").click(function () {
        addStoryMap(2);
    });

    $("#go-to-new-storymap").click(function () {
        location.href = "/newstorymap";
    });

    $(".tile-storymaps").click(function () {
        location.href = "/drawmap";
    });


    function addStoryMap(action){
        var name = $("#storymap-name").val();
        var description = $("#description").val();
        var storyMap = {
            name: name,
            description: description
        };
        $.ajax({
            url: "/add_map",
            type: "post",
            traditional: true,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "text",
            data: storyMap,
            success: function (data) {
                console.log(data);

                if(data > 0){
                    //保存后回到workspace
                    if(action == 1){
                        location.href = "/workspace";
                    }else{
                        //保存后打开map
                        location.href = "/storymap?mapid="+data;
                    }
                }else{
                    $.alert(data);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
                $.alert("服务发生错误！");
            },
        });
    }

    $(".favorite-storymap").click(function(event){
       event.stopPropagation();
       var deleteMap = $(this).parent().parent();
       var mapID = $(this).prev().html();
       var storyMap = {
           mapid: mapID
       };
       $.confirm({
            title: '删除地图',
            content: '是否确认删除地图？',
            buttons: {
                ok: {
                    text: '确认',
                    btnClass: 'btn-blue',
                    action: function () {
                        $.ajax({
                            url: "/delete_map",
                            type: "post",
                            traditional: true,
                            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                            dataType: "text",
                            data: storyMap,
                            success: function (data) {
                                console.log(data);
                                if(data > 0){
                                    $.alert("删除成功！");
                                    deleteMap.remove();
                                }else{
                                    $.alert(data);
                                }
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                console.log(XMLHttpRequest.status);
                                console.log(XMLHttpRequest.readyState);
                                console.log(textStatus);
                                $.alert("服务发生错误！");
                            },
                        });
                    }
                },
                cancel: {
                    text: '取消',
                    action: function () {
                    }
                },
            }
        });

    });

    $("#search-panel-on-dashboard").click(function(){
        $("#storymap-search-panel").show();
    });

    $("#close-search-panel").click(function(){
        $("#storymap-search-panel").hide();
    });

    $('.storymap-search-keywords').bind('keydown',function(event){
        if(event.keyCode == "13") {
            var keyword = $("#keyword").val();
            console.log("keyword:"+keyword);
            if(keyword.trim() == ""){
                return;
            }
            $(".matching-storymap-lists").empty();
            var storyMap = {
                keyword: keyword
            };
            $.ajax({
                url: "/search_map",
                type: "post",
                traditional: true,
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                dataType: "text",
                data: storyMap,
                success: function (data) {
                    console.log(data);
                    data = eval(data);
                    if(data.length > 0){
                        $.each(data, function(i, item){
                            console.log(item);
                            var map = $("#base-result").clone();
                            map.find("a").html(item["name"]);
                            map.find("a").attr("href", "/storymap?mapid="+item["mapid"]);
                            $(".matching-storymap-lists").append(map);
                            map.show();
                        });
                    }else{
                        $(".matching-storymap-lists").html("未找到结果！");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                    $.alert("服务发生错误！");
                },
            });
        }
    });

});