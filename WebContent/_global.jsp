<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//全局变量
String baseURL = "http://"+request.getServerName();
if(request.getServerPort()!=80){
	baseURL += ":"+request.getServerPort();
}
if(!"/".equals(request.getContextPath())){
	baseURL += request.getContextPath();
}
System.out.println("baseURL="+baseURL);
%>
<%
String clientip = request.getHeader("x-forwarded-for");
System.out.println("x-forwarded-for="+clientip);
if (clientip == null || clientip.length() == 0 || "unknown".equalsIgnoreCase(clientip)) {
	clientip = request.getHeader("Proxy-Client-IP");
	System.out.println("Proxy-Client-IP="+clientip);
}
if (clientip == null || clientip.length() == 0 || "unknown".equalsIgnoreCase(clientip)) {
	clientip = request.getHeader("WL-Proxy-Client-IP");
	System.out.println("WL-Proxy-Client-IP="+clientip);
}
if (clientip == null || clientip.length() == 0 || "unknown".equalsIgnoreCase(clientip)) {
	clientip = request.getRemoteAddr();
	System.out.println("RemoteAddr="+clientip);
}
System.out.println("clientip="+clientip);
%>
<%
String forward = request.getParameter("forward");
if(forward==null || "".equals(forward)){
	String referer = request.getHeader("referer");
	if(referer!=null){
		forward = referer;//.replace(baseURL,"");
	}
	else{
		forward = "/";
	}
}
System.out.println("forward="+forward);
%>