package net.javawind.t_api.commons;

import java.util.ArrayList;
import java.util.List;

import net.javawind.t_api.beans.OAuth;
import net.javawind.t_api.beans.QParameter;

/**
 * 数据更新相关API
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a>
 * @Data 2011-01-21
 * @Version 1.0.0
 */

public class Info_API extends RequestAPI {

	/**
	 * 查看数据更新条数
	 * 
	 * @param oauth
	 * @param format
	 * @param op
	 *            请求类型 0:只请求更新数,不清除更新数 1:请求更新数,并对更新数清零
	 * @param type
	 *            5:首页未读消息记数,6:提及我消息记数,7:私信页消息计数,8:新增听众数,9:首页广播数(原创的)
	 * @return
	 * @throws Exception
	 */
	public String update(OAuth oauth, String format, String op, String type)
			throws Exception {
		List<QParameter> parameters = new ArrayList<QParameter>();
		parameters.add(new QParameter("format", format));
		parameters.add(new QParameter("op", op));
		parameters.add(new QParameter("type", type));
		
		return getResource("http://open.t.qq.com/api/info/update", parameters,
				oauth);
	}
}
