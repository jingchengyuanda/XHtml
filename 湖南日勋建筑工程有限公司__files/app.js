/*********************************************
 * 自定义
 ********************************************/

(function(){
	
	$('#ipro').scroller({
		offset: 20
	});
	
	$('#inews').scroller({
		offset: 70
	});
   
})();

$(function(){
//悬浮
$(".jing_pointer").bind('click', function(){
	if($(this).hasClass('active')){
		$(this).removeClass('active').siblings().show();
	}else{
		$(this).addClass('active').siblings().hide();
	}
});

  	$('.itop').click(function(){ 
      $('html, body').stop().animate({'scrollTop': 0}, 200);
	})
    
    $('.sso').bind('click', function(){
        if($(this).siblings('.searcher').is(':hidden')){
			$(this).siblings('.searcher').slideDown(300);//  超链接跳转
        }else{
            	$(this).siblings('.searcher').slideUp(300);
        }
    })
    
    $('#iproul li').bind({
	'mouseenter': function(){
		var $ai = $(this).find('.ai');
		
		$ai.stop().animate({'top': 0, 'right': 0}, 300, 'jswing');
	},
	'mouseleave': function(){
		var $ai = $(this).find('.ai');
		
		$ai.stop().animate({'top': -510, 'right': -412}, 200, 'jswing');
	}
})
  
});

(function(){
  $(".nav li").each(function() {
        if(!$(this).find("a").length){
			$(this).children(".subNav").remove();
		}
    })
	$(".nav li").hover(
		function(){
			$(this).children(".subNav").stop().slideDown(300);
		},
		function(){
			$(this).children(".subNav").stop().slideUp(300);
		}
	)
  

    $('#menu dd').each(function(){
        if(!$(this).find('.drop li').length){
			$(this).find('.drop').remove();
        }
    })
    
	$('#menu dd').hover(
		function(){
			$(this).addClass('active');
			$(this).children('.drop').stop().slideDown(200);
		},
		function(){
			$(this).removeClass('active');
            if(!$(this).hasClass('current')){
                $(this).children('.drop').stop().slideUp(200);
            }
		}
	)
	
	
}());

(function(){
	var $toolbar = $('#toolbar');
	$toolbar.find('.code a').bind({
		'mouseenter': function(){
			$(this).next().stop().show(200);
		},
		'mouseleave': function(){
			$(this).next().stop().hide(200);
		}
	})
	$toolbar.find('.tel a').bind({
		'mouseenter': function(){
			$(this).next().stop().animate({'width': 162}, 200);
		},
		'mouseleave': function(){
			$(this).next().stop().animate({'width': 0}, 200);
		}
	})
	
	$toolbar.find('.close').bind({
		'click': function(){
			$toolbar.children('.pointer').show(300).next().hide();
		}
	})
	
	$toolbar.find('.pointer').bind({
		'click': function(){
			$toolbar.children('.inner').show(300).prev().hide();
		}
	})
}());