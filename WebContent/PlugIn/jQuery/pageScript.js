function showWindow(url, name, width, height) {
    var top = (window.screen.availHeight - 40 - height) / 2;       //获得窗口的垂直位置;
    var left = (window.screen.availWidth - 20 - width) / 2;           //获得窗口的水平位置;    
    window.open(url, name, "height=" + height + ", width=" + width +",left="+left+",top="+top+ ", resizable=yes, scrollbars=yes");
    return false;
}


function add(){
    $("input[type='button'][name='add']").click(function(){
        showWindow($(this).attr("url"),"add",1024,600); 
    });    
}

function del(){
    $("input[type='button'][name='del']").click(function(){
        //showWindow($(this).attr("url"),"add",1024,600); 
    	
    	if(window.confirm('你确定要删除吗？')){
          
    		
    		var f = document.createElement("form");
    		document.body.appendChild(f);
    		var i = document.createElement("input");
    		i.type = "hidden";
    		f.appendChild(i);
    		i.value = $(this).attr("Id");
    		i.name = "Id";
    		
    		
    		var ii = document.createElement("input");
    		ii.type = "hidden";
    		f.appendChild(ii);
    		ii.value = $(this).attr("Key");
    		ii.name = "key";
    		
    		f.action = "";
    		f.submit();
    		
            return true;
         }else{
     
        	
            return false;
        }
    	
    
    });    
}
function close(){
$("input[type='button'][name='close']").click(function(){window.close();});
}
function bind(){
    close();
    add();
    del();

}