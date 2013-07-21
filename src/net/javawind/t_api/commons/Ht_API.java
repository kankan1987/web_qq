package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 话题相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class Ht_API extends RequestAPI {

	/**
	 * 根据话题名称查话题id
	 * 
	 * @param oauth
	 * @param format
	 * @param httexts	话题名称列表,多个话题用英文逗号,隔开
	 * @return
	 * @throws Exception
	 */
	public String ids(OAuth oauth, String format, String httexts)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("httexts", httexts));
		
		return getResource("http://open.t.qq.com/api/ht/ids", parameters, oauth);
	}

	/**
	 * 根据话题id获取话题相关信息
	 * 
	 * @param oauth
	 * @param format
	 * @param ids	话题id列表,多个话题用英文逗号,隔开
	 * @return
	 * @throws Exception
	 */
	public String info(OAuth oauth, String format, String ids)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("ids", ids));
		
		return getResource("http://open.t.qq.com/api/ht/info", parameters, oauth);
	}
}
