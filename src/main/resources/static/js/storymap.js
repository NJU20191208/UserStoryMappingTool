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
                    alert(data);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
                alert("服务发生错误！");
            },
        });
    }

});