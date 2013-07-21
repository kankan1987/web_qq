package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 搜索相关API(仅对腾讯合作方开放,需要申请)
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class Search_API extends RequestAPI {

	/**
	 * 搜索用户
	 * 
	 * @param oauth
	 * @param format
	 * @param keyword
	 *            搜索关键字
	 * @param pagesize
	 *            每页记录数量
	 * @param page
	 *            页码
	 * @return
	 * @throws Exception
	 */
	public String user(OAuth oauth, String format, String keyword,
			String pagesize, String page) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("keyword", keyword));
		parameters.add(new QParameter("pagesize", pagesize));
		parameters.add(new QParameter("page", page));
		
		return getResource("http://open.t.qq.com/api/search/user", parameters,
				oauth);
	}

	/**
	 * 搜索广播
	 * 
	 * @param oauth
	 * @param format
	 * @param keyword
	 *            搜索关键字
	 * @param pagesize
	 *            每页记录数量
	 * @param page
	 *            页码
	 * @return
	 * @throws Exception
	 */
	public String t(OAuth oauth, String format, String keyword,
			String pagesize, String page) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("keyword", keyword));
		parameters.add(new QParameter("pagesize", pagesize));
		parameters.add(new QParameter("page", page));
		
		return getResource("http://open.t.qq.com/api/search/t", parameters,
				oauth);
	}

	/**
	 * 通过标签搜索用户
	 * 
	 * @param oauth
	 * @param format
	 * @param keyword
	 *            搜索关键字
	 * @param pagesize
	 *            每页记录数量
	 * @param page
	 *            页码
	 * @return
	 * @throws Exception
	 */
	public String userbytag(OAuth oauth, String format, String keyword,
			String pagesize, String page) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("keyword", keyword));
		parameters.add(new QParameter("pagesize", pagesize));
		parameters.add(new QParameter("page", page));
		
		return getResource("http://open.t.qq.com/api/search/userbytag",
				parameters, oauth);
	}
}
