<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/loginmenu/loginmenu.css"/>
<script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
<script src="PlugIn/jQuery/loginmenu/loginmenu.js" type="text/javascript"></script>



<title>登录界面</title>
</head>
<body> <!--  onsubmit="return checklogin(this);" -->
<form id="adminlogin"  method="post" name="adminlogin" action="check_login" >

<input value=1 type=hidden name=do_submit> 
<div>

</div>
<table style="margin: auto; width: 100%; height: 100%" border=0 cellSpacing=0 
cellPadding=0>
  <tbody>
  <tr>
    <td height=150>&nbsp;</td></tr>
  <tr style="height: 254px">
    <td>
      <div style="margin: 0px auto; width: 936px"><img style="DISPLAY: block" 
      src="image/loginmenu/body_03.jpg"> </div>
      <div style="BACKGROUND-COLOR: #278296">
      <div style="margin: 0px auto; width: 936px">
      <div 
      style="BACKGROUND: url(image/loginmenu/body_05.jpg) no-repeat; height: 155px">
      <div 
      style="TEXT-ALIGN: left; width: 265px; float: right; height: 125px; _height: 95px">
      <table border=0 cellSpacing=0 cellPadding=0 width="100%">
        <tbody>
        <tr>
          <td style="height: 43px"><input id=username class=input type=text 
            name=username>
            </td>
            </tr>
        <tr>
          <td>
          <input id=password class=input type=password name=password>
</td></tr>


            </tbody>
            
            </table>
            
            
            
            </div>
      <div style="height: 1px; clear: both"></div>
      <div style="width: 380px; float: right; clear: both">
      <table border=0 cellSpacing=0 cellPadding=0 width=300>
        <tbody>
        <tr>
          <td width=100 align=right>
          
  
          <input class=loginbtn id=btnLogin  src="image/loginmenu/btn1.jpg" type=image name=btnLogin onClick="JavaScript:checklogin(this);">
                <!-- onClick="JavaScript:adminlogin.submit();" -->

   

            </td>
          <td width=100 align=middle>
         <input class=resetbtn id=btnReset src="image/loginmenu/btn2.jpg"  type=image name=btnReset onClick="JavaScript:adminlogin.reset();" >

</td>
</tr>
</tbody>
</table>
</div>
</div>
</div
></div>
      <div style="margin: 0px auto; width: 936px"><img 
      src="image/loginmenu/body_06.jpg"> </div>
      </td>
      </tr>
  <tr style="height: 30%">
    <td>&nbsp;</td></tr>
    
    </tbody>
    
    </table>
    
    </form>
    
    
    </body>
</html>