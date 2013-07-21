package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 帐户相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class User_API extends RequestAPI {

	/**
	 * 获取自己的资料
	 * 
	 * @param oauth
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public String info(OAuth oauth, String format) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		
		return getResource("http://open.t.qq.com/api/user/info", parameters,
				oauth);
	}

	/**
	 * 修改/更新用户本人信息
	 * 
	 * @param oauth
	 * @param format
	 * @param nick
	 *            昵称
	 * @param sex
	 *            性别,1:男, 2:女
	 * @param year
	 *            出生年
	 * @param month
	 *            出生月
	 * @param day
	 *            出生日
	 * @param countrycode
	 *            国家码
	 * @param provincecode
	 *            省份码
	 * @param citycode
	 *            城市码
	 * @param introduction
	 *            个人简介
	 * @return
	 * @throws Exception
	 */
	public String update(OAuth oauth, String format, String nick, String sex,
			String year, String month, String day, String countrycode,
			String provincecode, String citycode, String introduction)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("nick", nick));
		parameters.add(new QParameter("sex", sex));
		parameters.add(new QParameter("year", year));
		parameters.add(new QParameter("month", month));
		parameters.add(new QParameter("day", day));
		parameters.add(new QParameter("countrycode", countrycode));
		parameters.add(new QParameter("provincecode", provincecode));
		parameters.add(new QParameter("citycode", citycode));
		parameters.add(new QParameter("introduction", introduction));
		
		return postContent("http://open.t.qq.com/api/user/update", parameters,
				oauth);
	}

	/**
	 * 修改/更新用户本人头像
	 * 
	 * @param oauth
	 * @param format
	 * @param picpath
	 *            图片路径(在服务器上的绝对路径)
	 * @return
	 * @throws Exception
	 */
	public String update_head(OAuth oauth, String format, String picpath)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));

		List<QParameter> pic = new ArrayList<QParameter>();
		pic.add(new QParameter("pic", picpath));
		
		return postFile("http://open.t.qq.com/api/user/update_head",
				parameters, pic, oauth);
	}

	/**
	 * 获取其他用户个人资料
	 * 
	 * @param oauth
	 * @param format
	 * @param name
	 *            他人的帐号
	 * @return
	 * @throws Exception
	 */
	public String other_info(OAuth oauth, String format, String name)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("name", name));
		
		return getResource("http://open.t.qq.com/api/user/other_info",
				parameters, oauth);
	}
}
