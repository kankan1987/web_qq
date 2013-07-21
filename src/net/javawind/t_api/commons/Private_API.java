package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 私信相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class Private_API extends RequestAPI {

	/**
	 * 发一条私信
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            私信内容
	 * @param clientip
	 *            用户IP地址
	 * @param name
	 *            对方用户名
	 * @return
	 * @throws Exception
	 */
	public String add(OAuth oauth, String format, String content,
			String clientip, String name) throws Exception {
		return this.add(oauth, format, content, clientip, "", "", name);
	}

	/**
	 * 发一条私信
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            私信内容
	 * @param clientip
	 *            用户IP地址
	 * @param jing
	 *            经度(可以为空)
	 * @param wei
	 *            纬度(可以为空)
	 * @param name
	 *            对方用户名
	 * @return
	 * @throws Exception
	 */
	public String add(OAuth oauth, String format, String content,
			String clientip, String jing, String wei, String name)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("content", content));
		parameters.add(new QParameter("clientip", clientip));
		parameters.add(new QParameter("jing", jing));
		parameters.add(new QParameter("wei", wei));
		parameters.add(new QParameter("name", name));

		return postContent("http://open.t.qq.com/api/private/add", parameters,
				oauth);
	}

	/**
	 * 删除一条私信
	 * 
	 * @param oauth
	 * @param format
	 * @param id
	 *            私信id
	 * @return
	 * @throws Exception
	 */
	public String del(OAuth oauth, String format, String id) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("id", id));

		return postContent("http://open.t.qq.com/api/private/del", parameters,
				oauth);
	}

	/**
	 * 获取私信收件箱列表
	 * 
	 * @param oauth
	 * @param format
	 * @param pageflag
	 *            分页标识(0:第一页,1:向下翻页,2向上翻页)
	 * @param pagetime
	 *            本页起始时间 第一页时填0,继续翻页:填上一次请求返回的最后一条记录时间
	 * @param reqnum
	 *            每次请求记录的条数
	 * @param lastid
	 *            第一页 时填0,继续向下翻页,填上一次请求返回的最后一条记录id,翻页用
	 * @return
	 * @throws Exception
	 */
	public String recv(OAuth oauth, String format, String pageflag,
			String pagetime, String reqnum, String lastid) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("pageflag", pageflag));
		parameters.add(new QParameter("pagetime", pagetime));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("lastid", lastid));

		return getResource("http://open.t.qq.com/api/private/recv", parameters,
				oauth);
	}

	/**
	 * 获取私信发件箱列表
	 * 
	 * @param oauth
	 * @param format
	 * @param pageflag
	 *            分页标识(0:第一页,1:向下翻页,2向上翻页)
	 * @param pagetime
	 *            本页起始时间 第一页时填0,继续翻页:填上一次请求返回的最后一条记录时间
	 * @param reqnum
	 *            每次请求记录的条数
	 * @param lastid
	 *            第一页 时填0,继续向下翻页,填上一次请求返回的最后一条记录id,翻页用
	 * @return
	 * @throws Exception
	 */
	public String send(OAuth oauth, String format, String pageflag,
			String pagetime, String reqnum, String lastid) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("pageflag", pageflag));
		parameters.add(new QParameter("pagetime", pagetime));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("lastid", lastid));

		return getResource("http://open.t.qq.com/api/private/send", parameters,
				oauth);
	}
}
