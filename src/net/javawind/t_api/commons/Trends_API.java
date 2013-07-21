package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 热度，趋势相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class Trends_API extends RequestAPI {

	/**
	 * 话题热榜
	 * 
	 * @param oauth
	 * @param format
	 * @param type
	 *            请求类型 1:话题名, 2:搜索关键字, 3:两种类型都有
	 * @param reqnum
	 *            每次请求记录的条数
	 * @param pos
	 *            翻页标识
	 * @return
	 * @throws Exception
	 */
	public String ht(OAuth oauth, String format, String type, String reqnum,
			String pos) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("type", type));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("pos", pos));
		
		return getResource("http://open.t.qq.com/api/trends/ht", parameters,
				oauth);
	}

	/**
	 * 转播热榜
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            每次请求记录的条数
	 * @param pos
	 *            翻页标识
	 * @return
	 * @throws Exception
	 */
	public String t(OAuth oauth, String format, String reqnum, String pos)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("pos", pos));
		
		return getResource("http://open.t.qq.com/api/trends/t", parameters,
				oauth);
	}
}
