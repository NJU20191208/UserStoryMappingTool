$(function(){
    $("#login_btn").click(function () {

    });

    $("#signup_btn").click(function () {
        var username = $("#Name").val();
        var password = $("#Password").val();
        console.log(username);
        var user = {
            username: username,
            password: password
        };
        console.log(user);
        $.ajax({
            url: "/add_user",
            type: "post",
            traditional: true,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "text",
            data: user,
            success: function (data) {
                console.log(data);
                if(data=="OK"){
                    alert("注册成功");
                    location.href = "/login";
                }else{
                    alert(data);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
            },
        });
    });

    function saveAndGoBack(){
        alert("saveAndGoBack");
    }

    function addStoryMap(action){
        var name = $("#storymap-name").val();
        var description = $("#description").val();
        var storyMap = {
            name: name,
            description: description
        };
        console.log(user);
        $.ajax({
            url: "/add_map",
            type: "post",
            traditional: true,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "text",
            data: storyMap,
            success: function (data) {
                console.log(data);
                if(data.status=="OK"){
                    //保存后回到workspace
                    if(action == 1){
                        location.href = "/workspace";
                    }else{
                        //保存后打开map
                        location.href = "/storymap?mapid="+data.mapid;
                    }
                }else{
                    alert(data);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);

            },
        });
    }

});