package net.javawind.t_api.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

import net.javawind.t_api.beans.QParameter;

/**
 * Http请求接口
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-06-04
 * @Version 1.0.1
 */

public class QHttpClient {

	private static final String chartSet = "UTF-8";
	private static boolean debug = false;

	public String get(String httpUrl, String queryString) throws Exception {
		print("GET:" + (httpUrl + "?" + queryString));

		URL url = new URL(httpUrl + "?" + queryString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setRequestProperty("Charset", chartSet);

		// conn.connect();
		StringBuffer strbuff = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn
				.getInputStream(), chartSet));
		String line;
		while ((line = in.readLine()) != null) {
			if (!"".equals(strbuff.toString())) {
				strbuff.append("\r\n");
			}
			strbuff.append(line);
		}
		in.close();
		conn.disconnect();
		return strbuff.toString();
	}

	public String post(String httpUrl, String queryString) throws Exception {
		print("POST:" + (httpUrl + "?" + queryString));

		URL url = new URL(httpUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setRequestProperty("Charset", chartSet);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);

		// conn.connect();
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		out.write(queryString.getBytes(chartSet));
		out.flush();

		StringBuffer strbuff = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn
				.getInputStream(), chartSet));
		String line;
		while ((line = in.readLine()) != null) {
			if (!"".equals(strbuff.toString())) {
				strbuff.append("\r\n");
			}
			strbuff.append(line);
		}
		in.close();
		out.close();
		conn.disconnect();
		return strbuff.toString();
	}

	public String postWithFile(String httpUrl, String queryString,
			List<QParameter> files) throws Exception {
		print("POST:" + (httpUrl + "?" + queryString));

		URL url = new URL(httpUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setRequestProperty("Charset", chartSet);
		// conn.setChunkedStreamingMode(8192);

		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);

		Random random = new Random();
		String _r = "\r\n";
		String _c = "--";
		String _s = "***javawind_"
				+ String.valueOf(random.nextInt(9876599) + 123400) + "***";

		// conn.connect();
		conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="
				+ _s);
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());

		if (queryString != null && !queryString.equals("")) {// add parameters
			String[] p = queryString.split("&");
			for (String s : p) {
				if (s != null && !s.equals("")) {
					if (s.indexOf("=") > -1) {
						String[] param = s.split("=");
						String value = (param.length == 2 ? QStr
								.decode(param[1]) : "");
						out.writeBytes(_c + _s + _r);
						out
								.writeBytes("Content-Disposition: form-data; name=\""
										+ param[0] + "\"" + _r);
						out.writeBytes(_r);
						out.write(value.getBytes(chartSet));
						out.writeBytes(_r);
					}
				}
			}
		}
		for (QParameter file : files) {// add file
			String fileName = file.getValue().substring(
					file.getValue().lastIndexOf("/") + 1);
			out.writeBytes(_c + _s + _r);
			out
					.writeBytes("Content-Disposition: form-data; name=\""
							+ file.getName() + "\"; filename=\"" + fileName
							+ "\"" + _r);
			out.writeBytes(_r);

			FileInputStream fis = new FileInputStream(file.getValue());
			byte[] buffer = new byte[8192]; // 8k
			int count = 0;
			while ((count = fis.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
			fis.close();
			out.writeBytes(_r);
		}
		out.writeBytes(_c + _s + _c + _r);
		out.flush();

		StringBuffer strbuff = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn
				.getInputStream(), chartSet));
		String line;
		while ((line = in.readLine()) != null) {
			if (!"".equals(strbuff.toString())) {
				strbuff.append("\r\n");
			}
			strbuff.append(line);
		}
		in.close();
		out.close();
		conn.disconnect();
		return strbuff.toString();
	}

	private void print(Object obj) {
		if (debug) {
			System.out.print(obj);
		}
	}
}
