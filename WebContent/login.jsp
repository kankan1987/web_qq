<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.javawind.t_api.utils.OAuthClient" %>
<%@ page import="net.javawind.t_api.utils.QStr" %>
<%@ include file="_config.jsp" %>
<%
String ac = request.getParameter("ac");
OAuthClient auth = new OAuthClient();
if(ac==null){
	callBackURL = baseURL+"/login.jsp?ac=callback&forward="+QStr.encode(forward);
	oauth.setOauth_callback(callBackURL);
	oauth = auth.requestToken(oauth);
	session.setAttribute(sid+"oauth",oauth);
	if(oauth.getStatus()==1){
		out.println("Request Token 授权失败！"+oauth.getMsg());
		return;
	}
	else{
		response.sendRedirect("https://open.t.qq.com/cgi-bin/authorize?oauth_token="+oauth.getOauth_token());
		return;
	}
}
else if("logout".equals(ac)){
	session.removeAttribute(sid+"oauth");
	response.sendRedirect(QStr.decode(forward));
	return;
}
else if("callback".equals(ac)){
	String oauth_token = request.getParameter("oauth_token");
	String oauth_verifier = request.getParameter("oauth_verifier");
	
	if(oauth_token==null || oauth_verifier==null){
		out.println("用户拒绝授权！");
		return;
	}
	
	oauth = (OAuth)session.getAttribute(sid+"oauth");
	oauth.setOauth_verifier(oauth_verifier);
	oauth = auth.accessToken(oauth);
	session.setAttribute(sid+"oauth",oauth);
	if(oauth.getStatus()==2){
		out.println("Access Token 授权失败！"+oauth.getMsg());
		return;
	}
	else{
		response.sendRedirect(QStr.decode(forward));
		return;
	}
}
%>