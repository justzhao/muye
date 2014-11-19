

    function checklogin(form){
    	
/*
    	var username=$("#username").val();
    	var passwd=$("#password").val();
    	
    	
    	if(''==username||''==passwd){
    		
    		alert('用户名或者密码不能为空!');
    		return false;
    	}
   
    */
    	document.adminlogin.onsubmit();
    	
    }
    
    
    
	function killerror()
	{
		return true;	
	}
	window.onerror=killerror;
	$(document).ready(function(){
		$('#username').focus();
		$('#adminlogin').submit(function(){
			if($.trim($('#username').val())=='')
			{
				$('#username').css("border-color","#ff9900");
				$('#username').focus();
				return false;
			}
			else
			{
				$('#username').css("border-color","");
			}

			if($.trim($('#password').val())=='')
			{
				$('#password').css("border-color","#ff9900");
				$('#password').focus();
				return false;
			}
			else
			{
				$('#password').css("border-color","");
			}
			
			if($.trim($('#checkcode').val()).length!=4)
			{
				$('#checkcode').css("border-color","#ff9900");
				$('#checkcode').focus();
				return false;
			}
			else
			{
				$('#checkcode').css("border-color","");
			}
			return true;
		})
	});
