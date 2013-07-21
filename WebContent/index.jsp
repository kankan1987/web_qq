<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.javawind.t_api.commons.Statuses_API" %>
<%@ include file="_config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>JavaWind QWeibo SDK</title>
<style type="text/css">
body{font: 12px tahoma,"宋体",Arial, Geneva, Verdana, sans-serif;}
</style>
</head>
<body>

<%if("".equals(account.getName())){%>
	<a href="login.jsp" title="我要登录"><font color="red">点击这里登录</font></a>
<%}else{%>	
	<img alt="" src="<%=account.getHead()%>/20" />
	<a href="http://t.qq.com/<%=account.getName()%>" target="_blank" title="转到我的腾讯微博"><font color="blue">@<%=account.getNick()%></font></a>
	<a href="login.jsp?ac=logout" title="退出登录">退出</a>
	<br/><br/>
	
	<form action="post.jsp?ac=add" method="post" target="_blank">
	<b>测试发表微博：</b>
	<input type="text" name="content" size="35" value="通过javawind_API测试发表微博" />
	<input type="submit" value="发表" />
	</form>
	<hr/>
	
	<form action="post.jsp?ac=add_pic" method="post" target="_blank">
	<b>测试发表图片：</b>
	<input type="text" name="content" size="35" value="通过javawind_API测试发表图片" />
	<input type="text" name="picpath" value="D:/qubo/0030.jpg" />
	<input type="submit" value="发表" />
	</form>
	
	<hr/><b>我的微博主页时间线：</b>(请自行选择xml或者json解析组件处理)<br/>
	<%
	// 比如,获取 主页时间线:
	Statuses_API sapi = new Statuses_API();
	String result = sapi.home_timeline(oauth, format, "0", "", "20","0","0","0");
	out.println(result);
	%>
	<hr/>
	&copy;&nbsp;&nbsp;2011&nbsp;&nbsp;<a href="http://t.javawind.net" target="_blank">JavaWind Inc.</a>&nbsp;&nbsp;All Rights Reserved
<%}%>
	

</body>
</html>