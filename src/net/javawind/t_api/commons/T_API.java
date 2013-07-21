package net.javawind.t_api.commons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 微博相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class T_API extends RequestAPI {

	/**
	 * 获取一条微博数据
	 * 
	 * @param oauth
	 * @param format
	 * @param id
	 *            微博id
	 * @return
	 * @throws Exception
	 */
	public String show(OAuth oauth, String format, String id) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("id", id));

		return getResource("http://open.t.qq.com/api/t/show", parameters, oauth);
	}

	/**
	 * 发表一条微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @return
	 * @throws Exception
	 */
	public String add(OAuth oauth, String format, String content,
			String clientip) throws Exception {
		return this.add(oauth, format, content, clientip, "", "");
	}

	/**
	 * 发表一条微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param jing
	 *            经度(可以为空)
	 * @param wei
	 *            纬度(可以为空)
	 * @return
	 * @throws Exception
	 */
	public String add(OAuth oauth, String format, String content,
			String clientip, String jing, String wei) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("content", content));
		parameters.add(new QParameter("clientip", clientip));
		parameters.add(new QParameter("jing", jing));
		parameters.add(new QParameter("wei", wei));

		return postContent("http://open.t.qq.com/api/t/add", parameters, oauth);
	}

	/**
	 * 删除一条微博数据
	 * 
	 * @param oauth
	 * @param format
	 * @param id
	 *            微博id
	 * @return
	 * @throws Exception
	 */
	public String del(OAuth oauth, String format, String id) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("id", id));

		return postContent("http://open.t.qq.com/api/t/del", parameters, oauth);
	}

	/**
	 * 转播一条微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param reid
	 *            转播的微博id
	 * @return
	 * @throws Exception
	 */
	public String re_add(OAuth oauth, String format, String content,
			String clientip, String reid) throws Exception {
		return this.re_add(oauth, format, content, clientip, "", "", reid);
	}

	/**
	 * 转播一条微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param jing
	 *            经度(可以为空)
	 * @param wei
	 *            纬度(可以为空)
	 * @param reid
	 *            转播的微博id
	 * @return
	 * @throws Exception
	 */
	public String re_add(OAuth oauth, String format, String content,
			String clientip, String jing, String wei, String reid)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("content", content));
		parameters.add(new QParameter("clientip", clientip));
		parameters.add(new QParameter("jing", jing));
		parameters.add(new QParameter("wei", wei));
		parameters.add(new QParameter("reid", reid));

		return postContent("http://open.t.qq.com/api/t/re_add", parameters,
				oauth);
	}

	/**
	 * 评论一条微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param reid
	 *            评论的微博id
	 * @return
	 * @throws Exception
	 */
	public String comment(OAuth oauth, String format, String content,
			String clientip, String reid) throws Exception {
		return this.comment(oauth, format, content, clientip, "", "", reid);
	}

	/**
	 * 评论一条微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param jing
	 *            经度(可以为空)
	 * @param wei
	 *            纬度(可以为空)
	 * @param reid
	 *            评论的微博id
	 * @return
	 * @throws Exception
	 */
	public String comment(OAuth oauth, String format, String content,
			String clientip, String jing, String wei, String reid)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("content", content));
		parameters.add(new QParameter("clientip", clientip));
		parameters.add(new QParameter("jing", jing));
		parameters.add(new QParameter("wei", wei));
		parameters.add(new QParameter("reid", reid));

		return postContent("http://open.t.qq.com/api/t/comment", parameters,
				oauth);
	}

	/**
	 * 回复一条微博(对话)
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param reid
	 *            回复的微博id
	 * @return
	 * @throws Exception
	 */
	public String reply(OAuth oauth, String format, String content,
			String clientip, String reid) throws Exception {
		return this.reply(oauth, format, content, clientip, "", "", reid);
	}

	/**
	 * 回复一条微博(对话)
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param jing
	 *            经度(可以为空)
	 * @param wei
	 *            纬度(可以为空)
	 * @param reid
	 *            回复的微博id
	 * @return
	 * @throws Exception
	 */
	public String reply(OAuth oauth, String format, String content,
			String clientip, String jing, String wei, String reid)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("content", content));
		parameters.add(new QParameter("clientip", clientip));
		parameters.add(new QParameter("jing", jing));
		parameters.add(new QParameter("wei", wei));
		parameters.add(new QParameter("reid", reid));

		return postContent("http://open.t.qq.com/api/t/reply", parameters,
				oauth);
	}

	/**
	 * 发表一条带图片的微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户的IP地址
	 * @param picpath
	 *            图片路径(在服务器上的绝对路径)
	 * @return
	 * @throws Exception
	 */
	public String add_pic(OAuth oauth, String format, String content,
			String clientip, String picpath) throws Exception {
		return this.add_pic(oauth, format, content, clientip, "", "", picpath);
	}

	/**
	 * 发表一条带图片的微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户的IP地址
	 * @param jing
	 *            经度(可以为空)
	 * @param wei
	 *            纬度(可以为空)
	 * @param picpath
	 *            图片路径(在服务器上的绝对路径)
	 * @return
	 * @throws Exception
	 */
	public String add_pic(OAuth oauth, String format, String content,
			String clientip, String jing, String wei, String picpath)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("content", content));
		parameters.add(new QParameter("clientip", clientip));
		parameters.add(new QParameter("jing", jing));
		parameters.add(new QParameter("wei", wei));

		if (!(new File(picpath)).exists()) {// 图片不存在
			return this.add(oauth, format, content, clientip, jing, wei);
		}

		List<QParameter> pic = new ArrayList<QParameter>();
		pic.add(new QParameter("pic", picpath));

		return postFile("http://open.t.qq.com/api/t/add_pic", parameters, pic,
				oauth);
	}

	/**
	 * 获取微博当前已被转播次数
	 * 
	 * @param oauth
	 * @param format
	 * @param ids
	 *            微博id列表,多个id用英文逗号隔开
	 * @param flag
	 *            0:转发计数, 1:点评计数, 2:两者都取
	 * 
	 * @return
	 * @throws Exception
	 */
	public String re_count(OAuth oauth, String format, String ids, String flag)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("ids", ids));
		parameters.add(new QParameter("flag", flag));

		return getResource("http://open.t.qq.com/api/t/re_count", parameters,
				oauth);
	}

	/**
	 * 获取单条微博的转播理由/评论列表
	 * 
	 * @param oauth
	 * @param format
	 * @param flag
	 *            0:转播列表, 1:点评列表, 2:点评与转播列表
	 * @param rootid
	 *            转发或者回复的父微博id
	 * @param pageflag
	 *            0:第一页, 1:向下翻页, 2:向上翻页；
	 * @param pagetime
	 *            本页起始时间(第一页时填0, 继续向下翻页:填上一次请求返回的最后一条记录时间)
	 * @param reqnum
	 *            请求记录数量
	 * @param twitterid
	 *            第一页时填0, 继续向下翻页:填上一次请求返回的最后一条记录id, 翻页用
	 * @return
	 * @throws Exception
	 */
	public String re_list(OAuth oauth, String format, String flag,
			String rootid, String pageflag, String pagetime, String reqnum,
			String twitterid) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("flag", flag));
		parameters.add(new QParameter("rootid", rootid));
		parameters.add(new QParameter("pageflag", pageflag));
		parameters.add(new QParameter("pagetime", pagetime));
		parameters.add(new QParameter("reqnum", reqnum));
		parameters.add(new QParameter("twitterid", twitterid));

		return getResource("http://open.t.qq.com/api/t/re_list", parameters,
				oauth);
	}

	/**
	 * 发表音乐微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param url
	 *            音乐的歌曲文件地址
	 * @param title
	 *            音乐标题
	 * @param author
	 *            音乐演唱者
	 * @return
	 * @throws Exception
	 */
	public String add_music(OAuth oauth, String format, String content,
			String clientip, String url, String title, String author)
			throws Exception {
		return this.add_music(oauth, format, content, clientip, url, title,
				author, "", "");
	}

	/**
	 * 发表音乐微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param url
	 *            音乐的歌曲文件地址
	 * @param title
	 *            音乐标题
	 * @param author
	 *            音乐演唱者
	 * @param jing
	 *            经度(可以为空)
	 * @param wei
	 *            纬度(可以为空)
	 * @return
	 * @throws Exception
	 */
	public String add_music(OAuth oauth, String format, String content,
			String clientip, String url, String title, String author,
			String jing, String wei) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("content", content));
		parameters.add(new QParameter("clientip", clientip));
		parameters.add(new QParameter("url", url));
		parameters.add(new QParameter("title", title));
		parameters.add(new QParameter("author", author));
		parameters.add(new QParameter("jing", jing));
		parameters.add(new QParameter("wei", wei));

		return postContent("http://open.t.qq.com/api/t/add_music", parameters,
				oauth);
	}

	/**
	 * 发表视频微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param url
	 *            视频地址, 后台自动分析视频信息, 支持youku,tudou,ku6
	 * @return
	 * @throws Exception
	 */
	public String add_video(OAuth oauth, String format, String content,
			String clientip, String url) throws Exception {
		return this.add_video(oauth, format, content, clientip, url, "", "");
	}

	/**
	 * 发表视频微博
	 * 
	 * @param oauth
	 * @param format
	 * @param content
	 *            发表内容
	 * @param clientip
	 *            用户IP地址
	 * @param url
	 *            视频地址, 后台自动分析视频信息, 支持youku,tudou,ku6
	 * @param jing
	 *            经度(可以为空)
	 * @param wei
	 *            纬度(可以为空)
	 * @return
	 * @throws Exception
	 */
	public String add_video(OAuth oauth, String format, String content,
			String clientip, String url, String jing, String wei)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("content", content));
		parameters.add(new QParameter("clientip", clientip));
		parameters.add(new QParameter("url", url));
		parameters.add(new QParameter("jing", jing));
		parameters.add(new QParameter("wei", wei));

		return postContent("http://open.t.qq.com/api/t/add_video", parameters,
				oauth);
	}

	/**
	 * 获取视频信息
	 * 
	 * @param oauth
	 * @param format
	 * @param url
	 *            视频地址, 后台自动分析视频信息, 支持youku,tudou,ku6
	 * @return
	 * @throws Exception
	 */
	public String getvideoinfo(OAuth oauth, String format, String url)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("url", url));

		return postContent("http://open.t.qq.com/api/t/getvideoinfo",
				parameters, oauth);
	}

	/**
	 * 根据微博id批量获取微博内容(与索引合起来用)
	 * 
	 * @param oauth
	 * @param format
	 * @param ids
	 *            微博id列表,多个id用英文逗号隔开
	 * @return
	 * @throws Exception
	 */
	public String list(OAuth oauth, String format, String ids) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("ids", ids));

		return getResource("http://open.t.qq.com/api/t/list", parameters, oauth);
	}
}
