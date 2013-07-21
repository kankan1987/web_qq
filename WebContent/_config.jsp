<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@ page import="net.javawind.t_api.beans.OAuth" %>
<%@ page import="net.javawind.t_api.beans.Account" %>
<%@ include file="_global.jsp" %>
<%
final String sid = "javawind_";
final String appKey = "8d7615cbd7f844db97f09a0469eb4896";
final String appSecret = "bcba59c6f5ab67100e0bdce37bf31098";
String callBackURL = baseURL+"/login.jsp?ac=callback";
String format = "json";

OAuth oauth = new OAuth(appKey,appSecret,callBackURL);
if(session.getAttribute(sid+"oauth")!=null){
	oauth = (OAuth)session.getAttribute(sid+"oauth");
}

Account account = oauth.getAccount();
%>