  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="left1">
      <div class="wenti1"> 
        <script>
			$(function(){
				$('dt').hover(function(){
					if($(this).hasClass('expand1')) return;
					$(this).attr('class','focus1');
				},function(){
					if($(this).hasClass('expand1')) return;
					$(this).attr('class','original1');}
				);
 
				$('dt').click(function(){
					if($(this).hasClass('expand1')){
						$(this).next().hide();
						$(this).attr('class','original1');;
						return;
					}
					$('dd').hide();
					$('dt').attr('class','original1');
					$(this).attr('class','expand1');
					$(this).next().show();
				});
 
			})
		</script>
        <dl>
          <dt class="original1">菜单管理</dt>
          <dd> 
            <a href="3levelMenu.jsp" class="h_hover2">三级菜单</a>
             <a href="#" >子菜单二</a></dd>
             
             
          <dt class="original1">消息群发</dt>
          <dd>
            <a href="sendGroupNews.jsp"  class="h_hover2">发送消息</a> 
            <a href="#" >子菜单二</a> 
            <a href="#" >子菜单三</a></dd>
          <dt class="original1">日报管理</dt>
          <dd> 
            <a href="sendDairyTime.jsp" class="h_hover2">发送时间</a>
           <a href="#"  >子菜单二</a> 
         </dd>
        </dl>
      </div>
    </div>