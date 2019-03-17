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
       console.log("mapid:"+mapID);
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

});