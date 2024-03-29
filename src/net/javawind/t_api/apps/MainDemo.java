package net.javawind.t_api.apps;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.commons.Statuses_API;
import net.javawind.t_api.commons.T_API;
import net.javawind.t_api.utils.OAuthClient;

/**
 * 测试类
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class MainDemo {

	static final String appKey = "8d7615cbd7f844db97f09a0469eb4896";
	static final String appSecret = "bcba59c6f5ab67100e0bdce37bf31098";
	static String callBackURL = "null";
	static String format = "xml";
	static boolean skipLogin = true;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// 测试网络连通状态
		// QHttpClient http = new QHttpClient();
		// System.out.println(http.get("http://www.baidu.com", ""));

		if (skipLogin) {
			skipLogin();
			return;
		}

		// TODO Auto-generated method stub
		OAuth oauth = new OAuth(appKey, appSecret, callBackURL); // 初始化OAuth请求令牌
		OAuthClient auth = new OAuthClient();// OAuth 认证对象

		oauth = auth.requestToken(oauth);
		if (oauth.getStatus() == 1) {
			System.out.println("Request Token 授权失败！");
			return;
		} else {
			String url = "http://open.t.qq.com/cgi-bin/authorize?oauth_token="
					+ oauth.getOauth_token();
			URI uri = new URI(url);
			if (!Desktop.isDesktopSupported()) {
				System.err.println("浏览器启动出错，请手动访问：" + url + "，并获取授权码");
			} else {
				Desktop desktop = Desktop.getDesktop();
				if (desktop == null
						|| !desktop.isSupported(Desktop.Action.BROWSE)) {
					System.err.println("浏览器启动出错，请手动访问：" + url + "，并获取授权码");
				}
				try {
					desktop.browse(uri);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}

			Scanner in = new Scanner(System.in);
			System.out.println("请输入你的授权码：");
			String oauth_verifier = in.nextLine().trim();

			oauth.setOauth_verifier(oauth_verifier);
			oauth = auth.accessToken(oauth);

			if (oauth.getStatus() == 2) {
				System.out.println("Access Token 授权失败！");
				return;
			} else {
				System.out.println("Oauth_token : " + oauth.getOauth_token());
				System.out.println("Oauth_token_secret : "
						+ oauth.getOauth_token_secret());

				// 这里你就可以使用 oauth 对象自由访问API了
				// 比如,获取 主页时间线:
				Statuses_API sapi = new Statuses_API();
				String result = sapi.home_timeline(oauth, "json", "0", "",
						"20", "", "", "");
				System.out.println(result);
			}
		}
	}

	/**
	 * 第一次授权通过后，可以通过打印oauth对象的oauth_token和oauth_token_secret
	 * 填到这里测试使用，可以免除重复登陆和授权
	 * 
	 * @throws Exception
	 */
	private static void skipLogin() throws Exception {
		OAuth oauth = new OAuth(appKey, appSecret, callBackURL); // 初始化OAuth请求令牌
		oauth.setOauth_token("xxxxx"); // 这里填入Oauth_token
		oauth.setOauth_token_secret("yyyyy"); // 这里填入oauth_token_secret

		// 比如,获取 主页时间线:
		Statuses_API sapi = new Statuses_API();
		String result = sapi.home_timeline(oauth, "json", "0", "", "20", "",
				"", "");
		System.out.println(result);

		T_API tapi = new T_API();
		result = tapi.add(oauth, format, "我不是你的小浣熊，玩不出你的其乐无穷", "12.34.56.78");
		// result = tapi.add_pic(oauth, "json", "测试发图片",
		// "12.34.56.78","D:/qubo/0034.jpg");
		System.out.println(result);
	}
}
