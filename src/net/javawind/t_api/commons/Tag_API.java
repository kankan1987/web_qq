package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 标签相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-06-04
 * @Version 1.0.1
 */

public class Tag_API extends RequestAPI {

	/**
	 * 添加标签
	 * 
	 * @param oauth
	 * @param format
	 * @param tag
	 *            标签内容
	 * @return
	 * @throws Exception
	 */
	public String addt(OAuth oauth, String format, String tag) throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("tag", tag));
		
		return postContent("http://open.t.qq.com/api/tag/add", parameters,
				oauth);
	}

	/**
	 * 删除标签
	 * 
	 * @param oauth
	 * @param format
	 * @param tagid
	 *            标签id
	 * @return
	 * @throws Exception
	 */
	public String del(OAuth oauth, String format, String tagid)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("tagid", tagid));
		
		return postContent("http://open.t.qq.com/api/tag/del", parameters,
				oauth);
	}
}
