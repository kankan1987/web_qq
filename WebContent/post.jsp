<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="net.javawind.t_api.commons.T_API" %>
<%@ include file="_config.jsp" %>
<%
if("".equals(account.getName())){
	response.sendRedirect("login.jsp?forward="+forward);
	return;
}

String ac = request.getParameter("ac");

@SuppressWarnings("unchecked")
Map<String,String[]> params = (Map<String,String[]>)request.getParameterMap();

T_API tapi = new T_API();
//String[] message = {"-1","Not Action Method!"};
String result="";

if("add".equals(ac)){//发表微博
	result = tapi.add(oauth,format,params.get("content")[0],clientip);

	//format为xml时，可以调用tapi.message查看详细的状态，返回数组，message[0]为处理状态，message[1]为失败原因
	//message = tapi.message(result);	
}
else if("add_pic".equals(ac)){//发表微博,带图片，这里需要自行处理文件上传
	/*TODO：发表图片需要先把图片传到服务器，picpath填写图片在服务器的绝对路径*/
	
	//实际情况下,图片处于网站目录，所以 picpath 传值应该是  /upload/xxxx.jpg，然后转换为为绝对路径
	//String picpath = this.getServletContext().getRealPath(params.get("picpath")[0]);
	
	//这里测试的时候,JSP应用部署在本地，所以可以这样传本地文件：String picpath="D:/web/xxx.jpg";
	String picpath = params.get("picpath")[0];
	
	result = tapi.add_pic(oauth,format,params.get("content")[0],clientip,picpath);	
	//message = tapi.message(result);
}
%>
发表状态返回：<%=result%>