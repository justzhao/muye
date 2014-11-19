<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>Page Title</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- JQuery Mobile加载部分 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.0/jquery.mobile-1.4.0.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.0/jquery.mobile-1.4.0.min.js"></script>
</head>

<body>
	<div data-role="page">
		<div data-role="header">
			<h1>依托世界马术运动 发过旅游进军中国</h1>
		</div>
		<div role="main" class="ui-content">
			<p>
				日前，一年一度的“相约法兰西”法国旅游年度路演在北京、上海、广州举办。明年迎来中法建交50周年，刚好是中国的马年，法国诺曼底也迎来世界马术运动会。法国旅游发展署表示，希望通过简化签证等一系列措施，吸引中国游客前往。</br>
			<div>
				<img
					src="http://horse.org.cn/uploadfile/2013/1225/20131225125038689.jpg"
					alt="" border="0" />
			</div>
			<h2>法国将推近百名胜古迹</h2>
			</br> 法国旅游发展署表示，明年贯穿中法建交50周年的主题，将展开四个主题的宣传活动，包括购物、葡萄酒、文化遗产和浪漫。</br>
			其中，法国文化遗产是许多中国游客感到陌生的，如由法国国家古迹中心保存、修缮、管理及对外开放参观近100座以“历史古迹”名义受到保护的国家级名胜古迹，如昂热城堡、阿泽勒里多城堡、卡尔卡松古城等等，通过它们的多样性展示了各个时期、各种风格的法国丰富文化遗产，值得观赏。</br>
			<div>
				<img
					src="http://horse.org.cn/uploadfile/2013/1225/20131225125039865.jpg"
					alt="" border="0" />
			</div>
			<h2>赴法签证有望两日搞定</h2>
			</br>
			值得一提的是，2014年即中国马年，法国诺曼底也将迎来世界马术运动会，届时游客可以有机会看到世界顶级的马术比赛。而2014年6月26日至29
			日举行的“波尔多葡萄酒节”，预计也将会吸引大量的游客到访。</br>
			为吸引中国游客前往法国旅游，法国旅游发展署表示将力争在2014年把中国公民短期赴法签证办理时间缩短至两日，以简化签证程序。</br>
			据悉，2012年抵达法国的中国游客数量增加了23.3%，达140万人次，今年中国游客数量仍持续增加。
			</p>
		</div>
		<div data-role="footer">
			<p>
				------------------------------</br> 谢谢关注！
			</p>
		</div>
	</div>
</body>
</html>
