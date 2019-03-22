$(function(){
	$(".menu>li").hover(function(){
		
		$("ul",this).slideDown("fast");		
		},function(){
			$(".sub_menu").slideUp("fast");
			})
	$(".leftmenu h3").click(function(){
			$(this).next("ul").slideToggle(300).siblings("ul").slideUp("slow");
			
	});
	
	//全选功能和反选功能
	$(":button[name='selectall']").click(function() {
		$(":checkbox[name='chk']").each(function() {
			$(this).attr("checked", true);
		});
	});

	$(":button[name='noselect']").click(function() {
		$(":checkbox[name='chk']").each(function() {
			$(this).attr("checked", false);
		});
	});

	$(":button[name='inverse']").click(function() {
		$(":checkbox[name='chk']").each(function() {
			$(this).attr("checked",!$(this).attr("checked"));
		});
	});
});

function confirm(content, yes, no){
	art.dialog({
	    width:300,
		  height:100,
	    title: '警告',
	    content: 'hello',
	    lock: false,
	    fixed: true,
	    ok: function (here) {
            return yes.call(this, here);
        },
        cancel: function (here) {
            return no && no.call(this, here);
        }
	    });
}

function artDialogAlert(content,callback){
	art.dialog({
	    width:300,
		  height:100,
	    title: '信息',
	    content: content,
	    lock: false,
	    fixed: true,
	    ok: true,
	    close: callback
    });
}

	
	
	


