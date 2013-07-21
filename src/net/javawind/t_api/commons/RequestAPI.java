package net.javawind.t_api.commons;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;
import net.javawind.t_api.utils.OAuthClient;
import net.javawind.t_api.utils.QHttpClient;

import org.w3c.dom.Document;

/**
 * Request Remote Server API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.1
 */

public class RequestAPI {
	
	QHttpClient http = new QHttpClient();

	/**
	 * get json or xml resource from remote api
	 * 
	 * @param url
	 * @param params
	 * @param oauth
	 * @return
	 * @throws Exception
	 */
	public String getResource(String url, List<QParameter> parameters,
			OAuth oauth) throws Exception {
		parameters.addAll(oauth.getTokenParams());

		OAuthClient oac = new OAuthClient();
		String queryString = oac.getOauthParams(url, "GET", oauth
				.getOauth_consumer_secret(), oauth.getOauth_token_secret(),
				parameters);
		
		return http.get(url.trim(), queryString.trim());
	}

	/**
	 * submit a post request to remote api
	 * 
	 * @param url
	 * @param parameters
	 * @param oauth
	 * @return
	 * @throws Exception
	 */
	public String postContent(String url, List<QParameter> parameters,
			OAuth oauth) throws Exception {
		parameters.addAll(oauth.getTokenParams());

		OAuthClient oac = new OAuthClient();
		String queryString = oac.getOauthParams(url, "POST", oauth
				.getOauth_consumer_secret(), oauth.getOauth_token_secret(),
				parameters);
		
		return http.post(url.trim(), queryString.trim());
	}

	/**
	 * submit a post request with some files to remote api
	 * 
	 * @param url
	 * @param parameters
	 * @param filePath
	 * @param oauth
	 * @return
	 * @throws Exception
	 */
	public String postFile(String url, List<QParameter> parameters,
			List<QParameter> files, OAuth oauth) throws Exception {
		parameters.addAll(oauth.getTokenParams());

		OAuthClient oac = new OAuthClient();
		String queryString = oac.getOauthParams(url, "POST", oauth
				.getOauth_consumer_secret(), oauth.getOauth_token_secret(),
				parameters);

		return http.postWithFile(url.trim(), queryString.trim(), files);
	}

	/**
	 * display the response result
	 * 
	 * @param result
	 * @return
	 */
	public String[] message(String result) {
		String[] arr = new String[2];

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbd = dbf.newDocumentBuilder();
			Document doc = dbd.parse(new ByteArrayInputStream(result
					.getBytes("UTF-8")));
			XPathFactory f = XPathFactory.newInstance();
			XPath path = f.newXPath();

			arr[0] = path.evaluate("root/ret", doc);
			// arr[1] = path.evaluate("root/msg", doc);
			switch (Integer.parseInt(arr[0])) {
			case 0:
				arr[1] = "操作成功";
				break;
			case 1:
				arr[1] = "参数错误";
				break;
			case 2:
				arr[1] = "频率受限";
				break;
			case 3:
				arr[1] = "鉴权失败";
				break;
			case 4:
				arr[1] = "服务器内部错误";
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			arr[0] = "4";
			arr[1] = e.toString();
		}

		return arr;
	}
}
