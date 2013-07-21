package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 其他相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class Other_API extends RequestAPI {

	/**
	 * 我可能认识的人
	 * 
	 * @param oauth
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public String kownperson(OAuth oauth, String format) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		
		return getResource("http://open.t.qq.com/api/other/kownperson",
				parameters, oauth);
	}

	/**
	 * 短URL变长URL
	 * 
	 * @param oauth
	 * @param format
	 * @param url
	 *            url后缀(比如要还原http://url.cn/3pHX33的原网址,则填:3pHX33)
	 * @return
	 * @throws Exception
	 */
	public String shorturl(OAuth oauth, String format, String url)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("url", url));
		
		return getResource("http://open.t.qq.com/api/other/shorturl",
				parameters, oauth);
	}

	/**
	 * 获取视频上传的key(24小时内有效,期间会返回同一个key)
	 * 
	 * @param oauth
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public String videokey(OAuth oauth, String format) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		
		return getResource("http://open.t.qq.com/api/other/videokey",
				parameters, oauth);
	}
}
