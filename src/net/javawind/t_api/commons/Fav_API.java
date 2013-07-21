package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 数据收藏相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class Fav_API extends RequestAPI {

	/**
	 * 收藏一条微博
	 * 
	 * @param oauth
	 * @param format
	 * @param id
	 *            需要收藏的微博id
	 * @return
	 * @throws Exception
	 */
	public String addt(OAuth oauth, String format, String id) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("id", id));
		
		return postContent("http://open.t.qq.com/api/fav/addt", parameters,
				oauth);
	}

	/**
	 * 取消收藏一条微博
	 * 
	 * @param oauth
	 * @param format
	 * @param id
	 *            需要取消收藏的微博id
	 * @return
	 * @throws Exception
	 */
	public String delt(OAuth oauth, String format, String id) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("id", id));
		
		return postContent("http://open.t.qq.com/api/fav/delt", parameters,
				oauth);
	}

	/**
	 * 获取收藏的微博列表
	 * 
	 * @param oauth
	 * @param format
	 * @param pageflag
	 *            分页标识(0:第一页, 1:向下翻页, 2:向上翻页)
	 * @param nexttime
	 *            向下翻页起始时间(第一页 时填0, 继续翻页:填上一次请求返回的nexttime时间)
	 * @param prevtime
	 *            向下翻
	 * @param reqnum
	 *            每次请求记录的条数
	 * @param lastid
	 *            第一页 时填0,继续向下翻页,填上一次请求返回的最后一条记录id,翻页用
	 * @return
	 * @throws Exception
	 */
	public String list_t(OAuth oauth, String format, String pageflag,
			String nexttime, String prevtime, String reqnum, String lastid)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("pageflag", pageflag));
		parameters.add(new QParameter("nexttime", nexttime));
		parameters.add(new QParameter("prevtime", prevtime));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("lastid", lastid));
		
		return getResource("http://open.t.qq.com/api/fav/list_t", parameters,
				oauth);
	}

	/**
	 * 订阅话题
	 * 
	 * @param oauth
	 * @param format
	 * @param id
	 *            需要订阅的话题id
	 * @return
	 * @throws Exception
	 */
	public String addht(OAuth oauth, String format, String id) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("id", id));
		
		return postContent("http://open.t.qq.com/api/fav/addht", parameters,
				oauth);
	}

	/**
	 * 取消订阅话题
	 * 
	 * @param oauth
	 * @param format
	 * @param id
	 *            需要取消订阅的话题id
	 * @return
	 * @throws Exception
	 */
	public String delht(OAuth oauth, String format, String id) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("id", id));
		
		return postContent("http://open.t.qq.com/api/fav/delht", parameters,
				oauth);
	}

	/**
	 * 获取用户已收藏的话题列表
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            每次请求记录的条数
	 * @param pageflag
	 *            分页标识(0:第一页,1:向下翻页,2向上翻页)
	 * @param pagetime
	 *            本页起始时间 第一页时填0,继续翻页:填上一次请求返回的最后一条记录时间
	 * @param lastid
	 *            第一页 时填0,继续向下翻页,填上一次请求返回的最后一条记录id,翻页用
	 * @return
	 * @throws Exception
	 */
	public String list_ht(OAuth oauth, String format, String reqnum,
			String pageflag, String pagetime, String lastid) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("pageflag", pageflag));
		parameters.add(new QParameter("pagetime", pagetime));
		parameters.add(new QParameter("lastid", lastid));
		
		return getResource("http://open.t.qq.com/api/fav/list_ht", parameters,
				oauth);
	}
}
