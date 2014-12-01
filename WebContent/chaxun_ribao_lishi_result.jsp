<%@ page language="java"
	import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*,cn.modernfarming.mis.*,java.util.Date"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger logger = LogManager.getLogger(request.getRequestURI());

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String openID = request.getParameter("OpenID");
	if (openID != null) {
		if (Services.CheckBind(openID).equals("")) {
			response.sendRedirect("MIS_Bind.jsp?OpenID=" + openID);
		}
	} else {
		response.sendRedirect("NotWeixin.jsp");
	}
	String ChartX = "", ChartData = "", ChartData1 = "", ChartData2 = "";
	String txt = "", dt = "";

	String Dt1 = request.getParameter("dt1");
	String Dt2 = request.getParameter("dt2");
	String farmName = request.getParameter("farmName");

	txt += "<div><table width=\"98%\" id=\"table-custom-2\" data-mode=\"columntoggle\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\" data-column-btn-theme=\"b\" data-column-btn-text=\"选择要查看的列\" data-column-popup-theme=\"a\"><tr><th colspan=\"10\">  <span style=\"font-size: 18px;\" class=\"STYLE7\">"
			+ farmName
			+ " "
			+ Dt1
			+ "~"
			+ Dt2
			+ "日数据 </span></th></tr><tr class=\"ui-bar-d\"><th>日期</th><th>总产量</th><th>成母牛单产</th><th>泌乳牛单产</th><th>蛋白质</th><th>脂肪</th><th>干物质</th><th>微生物</th><th>体细胞</th><th data-priority=\"1\">干奶牛比例</th></tr>";
	if (Dt1 != null) {

		try {
			Connection conn;
			ResultSet rsL1,rsL2;
			Statement statementL1,statementL2;
			String SSQL;
			String countSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			SSQL = "select convert(varchar,[dt],112) dt,[FARM],[TOTAL],[adult_cow],[Lactating_cow],[protein],[fat],[dry_matter],[germ],[soma],[proportion] from [REPORT_Dairy_Product_Summary] where 1=1"
					+ " and dt between '"
					+ Dt1
					+ "' and '"
					+ Dt2
					+ " 23:59:59'"
					+ " and FARM = '"
					+ farmName
					+ "'"
					+ " order by dt desc";
			logger.debug(SSQL);
			
			rsL1 = statementL1.executeQuery(SSQL);
			ResultSetMetaData rsmd1 = rsL1.getMetaData();
			int count = rsmd1.getColumnCount();
			logger.debug(count);
			
			statementL2 = conn.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			int dataCount = 0;
			countSQL = "select count(*) cnt from [REPORT_Dairy_Product_Summary] where dt between '"
					+ Dt1
					+ "' and '"
					+ Dt2
					+ " 23:59:59'"
					+ " and FARM = '"
					+ farmName
					+ "'";
					
			rsL2 = statementL2.executeQuery(countSQL);
			if(rsL2.next()){
				dataCount=rsL2.getInt("cnt");
			}
			logger.debug("dataCount is:" + dataCount);
			while (rsL1.next()) {
				if(dataCount > 18){
					dt = rsL1.getString(1).substring(4);
					int dtInt = Integer.parseInt(dt);
					if(dtInt%2==0){
						txt += "<tr>";

						for (int i = 2; i <= count; i++) {

							if (i == 11) {
								txt += "<td>" + rsL1.getString(i) + "%</td>";
							} else if (i == 3) {
								String tmpS = rsL1.getString(i);
								//logger.debug(tmpS);
								txt += "<td>" + tmpS + "</td>";
								if (!ChartData.equals("")) {
									ChartData = ","+ChartData;
								}
								ChartData = tmpS+ChartData;	
							} else if (i == 4) {
								String tmpS = rsL1.getString(i);
								
								txt += "<td>" + tmpS + "</td>";
								if (!ChartData1.equals("")) {
									ChartData1 = ","+ChartData1;
								}
								ChartData1 = tmpS+ChartData1;	
							} else if (i == 5) {
								String tmpS = rsL1.getString(i);
								
								txt += "<td>" + tmpS + "</td>";
								if (!ChartData2.equals("")) {
									ChartData2 = ","+ChartData2;
								}
								ChartData2 = tmpS+ChartData2;	
							} else if (i == 2) {
								String tmpS = rsL1.getString(i - 1).substring(4);
								//logger.debug("i=2:"+tmpS);
								txt += "<td>" + tmpS + "</td>";
								if (!ChartX.equals("")) {
									ChartX = ","+ChartX;
								}
								ChartX = "'" + tmpS + "'"+ChartX;
								//logger.debug(ChartX);
								
							} else {
								txt += "<td>" + rsL1.getString(i) + "</td>";
							}
						}
						
						txt += "</tr>";
					} else {
						
					}
					
				} else{
					dt = rsL1.getString(1).substring(4);
					//logger.debug("dt is "+dt);
					txt += "<tr>";

					for (int i = 2; i <= count; i++) {

						if (i == 11) {
							txt += "<td>" + rsL1.getString(i) + "%</td>";
						} else if (i == 3) {
							String tmpS = rsL1.getString(i);
							//logger.debug(tmpS);
							txt += "<td>" + tmpS + "</td>";
							if (!ChartData.equals("")) {
								ChartData = ","+ChartData;
							}
							ChartData = tmpS+ChartData;	
						} else if (i == 4) {
							String tmpS = rsL1.getString(i);
							
							txt += "<td>" + tmpS + "</td>";
							if (!ChartData1.equals("")) {
								ChartData1 = ","+ChartData1;
							}
							ChartData1 = tmpS+ChartData1;	
						} else if (i == 5) {
							String tmpS = rsL1.getString(i);
							
							txt += "<td>" + tmpS + "</td>";
							if (!ChartData2.equals("")) {
								ChartData2 = ","+ChartData2;
							}
							ChartData2 = tmpS+ChartData2;	
						} else if (i == 2) {
							String tmpS = rsL1.getString(i - 1).substring(4);
							//logger.debug("i=2:"+tmpS);
							txt += "<td>" + tmpS + "</td>";
							if (!ChartX.equals("")) {
								ChartX = ","+ChartX;
							}
							ChartX = "'" + tmpS + "'"+ChartX;
							//logger.debug(ChartX);
							
						} else {
							txt += "<td>" + rsL1.getString(i) + "</td>";
						}
					}
					
					txt += "</tr>";
				}
				}
				
				
			rsL1.close();
			statementL1.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}

	}
	txt += "</table></div>";
	//logger.debug("the ChartData is "+ChartData);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- meta name="viewport"
	content="device-width,device-height,initial-scale=1,user-scalable=1" / -->
<meta name="viewport" content=""/ >



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.theme-1.4.3.css"
	rel="stylesheet" type="text/css" />
<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.structure-1.4.3.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.css"
	rel="stylesheet" type="text/css" />
<link href="PlugIn/jQuery/jquery-ui-1.10.2/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
<script
	src="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.js"
	type="text/javascript"></script>

<script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery.ui.core.js"
	type="text/javascript"></script>
<script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery.ui.datepicker.js"
	type="text/javascript"></script>

<script src="PlugIn/jQuery/Highcharts-4.0.3/js/highcharts_1.js"
	type="text/javascript"></script>
<!-- <script src="PlugIn/jQuery/Highcharts-4.0.3/js/modules/exporting.js"
	type="text/javascript"></script> -->

<title>历史日报</title>
<style>
a {
	font-size: 44px;
}

td {
	text-align: right;
	font-size: 28px;
	border: 2px solid gray;
}

body {
	font-size: 30px;
}
text {
	font-size: 30px;
}

th {
	text-align: center;
	font-size: 30px;
	border: 2px solid gray;
}
</style>
<script type="text/javascript">
	function onBridgeReady() {
		WeixinJSBridge.call('hideOptionMenu');
	}

	if (typeof WeixinJSBridge == "undefined") {
		if (document.addEventListener) {
			document.addEventListener('WeixinJSBridgeReady', onBridgeReady,
					false);
		} else if (document.attachEvent) {
			document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
			document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		}
	} else {
		onBridgeReady();
	}
</script>
</head>
<body>
	<a onclick="history.back();">返回</a>
	<br />
	<br />
	<%=txt%>
	<div id="container"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	<div id="container1"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</html>
<script type="text/javascript">
	$(function() {
		$('#container').highcharts({
			title : {
				text : '',
				x : -20
			//center
			},
			subtitle : {
				text : '总产量',
				x : -20
			},
			xAxis : {
				categories : [<%=ChartX %>],
				title : {
					text : '日期'
				},
				labels : {
					 style: {
						
						fontSize: '15px'
					} 
				}
			},
			yAxis : {
				title : {
					text : ''
				},
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ]
			},
			tooltip : {
				valueSuffix : ''
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle',
				borderWidth : 0
			},
			"series" : [ {
				name : '总产量',
				data : [<%=ChartData  %>]
			} ]
		});
		
		
		$('#container1').highcharts({
			title : {
				text : '',
				x : -20
			//center
			},
			subtitle : {
				text : '单产',
				x : -20
			},
			xAxis : {
				categories : [<%=ChartX  %>],
				title : {
					text : '日期'
				},
				labels : {
					 style: {
						
						fontSize: '15px'
					} 
				}
			},
			yAxis : {
				title : {
					text : ''
				},
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ]
			},
			tooltip : {
				valueSuffix : ''
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle',
				borderWidth : 0
			},
			"series" : [ {
				name : '成母牛',
				data : [<%=ChartData1  %>]
			} ,{
				name : '泌乳牛',
				data : [<%=ChartData2  %>]
			}]
		});
	});
</script>