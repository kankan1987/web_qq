package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 关系链相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class Friends_API extends RequestAPI {

	/**
	 * 我的听众列表
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            请求记录个数
	 * @param startindex
	 *            起始位置(第一页填0, 继续向下翻页填:reqnum*(page-1))
	 * @return
	 * @throws Exception
	 */
	public String fanslist(OAuth oauth, String format, String reqnum,
			String startindex) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("startindex", startindex));

		return getResource("http://open.t.qq.com/api/friends/fanslist",
				parameters, oauth);
	}

	/**
	 * 我收听的人列表
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            请求记录个数
	 * @param startindex
	 *            起始位置(第一页填0, 继续向下翻页填:reqnum*(page-1))
	 * @return
	 * @throws Exception
	 */
	public String idollist(OAuth oauth, String format, String reqnum,
			String startindex) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("startindex", startindex));

		return getResource("http://open.t.qq.com/api/friends/idollist",
				parameters, oauth);
	}

	/**
	 * 黑名单列表
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            请求记录个数
	 * @param startindex
	 *            起始位置(第一页填0, 继续向下翻页填:reqnum*(page-1))
	 * @return
	 * @throws Exception
	 */
	public String blacklist(OAuth oauth, String format, String reqnum,
			String startindex) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("startindex", startindex));

		return getResource("http://open.t.qq.com/api/friends/blacklist",
				parameters, oauth);
	}

	/**
	 * 特别收听列表
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            请求记录个数
	 * @param startindex
	 *            起始位置(第一页填0, 继续向下翻页填:reqnum*(page-1))
	 * @return
	 * @throws Exception
	 */
	public String speciallist(OAuth oauth, String format, String reqnum,
			String startindex) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("startindex", startindex));

		return getResource("http://open.t.qq.com/api/friends/speciallist",
				parameters, oauth);
	}

	/**
	 * 收听某个用户
	 * 
	 * @param oauth
	 * @param format
	 * @param name
	 *            收听的用户帐号
	 * @return
	 * @throws Exception
	 */
	public String add(OAuth oauth, String format, String name) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("name", name));

		return postContent("http://open.t.qq.com/api/friends/add", parameters,
				oauth);
	}

	/**
	 * 取消收听某个用户
	 * 
	 * @param oauth
	 * @param format
	 * @param name
	 *            取消收听的用户帐号
	 * @return
	 * @throws Exception
	 */
	public String del(OAuth oauth, String format, String name) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("name", name));

		return postContent("http://open.t.qq.com/api/friends/del", parameters,
				oauth);
	}

	/**
	 * 特别收听某个用户
	 * 
	 * @param oauth
	 * @param format
	 * @param name
	 *            特别收听的用户帐号
	 * @return
	 * @throws Exception
	 */
	public String addspecail(OAuth oauth, String format, String name)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("name", name));

		return postContent("http://open.t.qq.com/api/friends/addspecail",
				parameters, oauth);
	}

	/**
	 * 取消特别收听某个用户
	 * 
	 * @param oauth
	 * @param format
	 * @param name
	 *            取消特别收听的用户帐号
	 * @return
	 * @throws Exception
	 */
	public String delspecial(OAuth oauth, String format, String name)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("name", name));

		return postContent("http://open.t.qq.com/api/friends/delspecial",
				parameters, oauth);
	}

	/**
	 * 添加某个用户到黑名单
	 * 
	 * @param oauth
	 * @param format
	 * @param name
	 *            拉黑的用户帐号
	 * @return
	 * @throws Exception
	 */
	public String addblacklist(OAuth oauth, String format, String name)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("name", name));

		return postContent("http://open.t.qq.com/api/friends/addblacklist",
				parameters, oauth);
	}

	/**
	 * 从黑名单中删除某个用户
	 * 
	 * @param oauth
	 * @param format
	 * @param name
	 *            取消拉黑的用户帐号
	 * @return
	 * @throws Exception
	 */
	public String delblacklist(OAuth oauth, String format, String name)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("name", name));

		return postContent("http://open.t.qq.com/api/friends/delblacklist",
				parameters, oauth);
	}

	/**
	 * 检测是否我的听众或我收听的人
	 * 
	 * @param oauth
	 * @param format
	 * @param names
	 *            其他人的帐户名列表(最多30个, 用英文逗号,隔开)
	 * @param flag
	 *            0:检测听众, 1:检测收听的人,2:两种关系都检测
	 * @return
	 * @throws Exception
	 */
	public String check(OAuth oauth, String format, String names, String flag)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("names", names));
		parameters.add(new QParameter("flag", flag));

		return getResource("http://open.t.qq.com/api/friends/check",
				parameters, oauth);
	}

	/**
	 * 获取其他用户听众列表
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            请求记录个数
	 * @param startindex
	 *            起始位置(第一页填0, 继续向下翻页填:reqnum*(page-1))
	 * @param name
	 *            用户帐号
	 * @return
	 * @throws Exception
	 */
	public String user_fanslist(OAuth oauth, String format, String reqnum,
			String startindex, String name) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("startindex", startindex));
		parameters.add(new QParameter("name", name));

		return getResource("http://open.t.qq.com/api/friends/user_fanslist",
				parameters, oauth);
	}

	/**
	 * 获取其他用户收听的人列表
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            请求记录个数
	 * @param startindex
	 *            起始位置(第一页填0, 继续向下翻页填:reqnum*(page-1))
	 * @param name
	 *            用户帐号
	 * @return
	 * @throws Exception
	 */
	public String user_idollist(OAuth oauth, String format, String reqnum,
			String startindex, String name) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("startindex", startindex));
		parameters.add(new QParameter("name", name));

		return getResource("http://open.t.qq.com/api/friends/user_idollist",
				parameters, oauth);
	}

	/**
	 * 其他帐户特别收听的人列表
	 * 
	 * @param oauth
	 * @param format
	 * @param reqnum
	 *            请求记录个数
	 * @param startindex
	 *            起始位置(第一页填0, 继续向下翻页填:reqnum*(page-1))
	 * @param name
	 *            用户帐号
	 * @return
	 * @throws Exception
	 */
	public String user_speciallist(OAuth oauth, String format, String reqnum,
			String startindex, String name) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("startindex", startindex));
		parameters.add(new QParameter("name", name));

		return getResource("http://open.t.qq.com/api/friends/user_speciallist",
				parameters, oauth);
	}
}
