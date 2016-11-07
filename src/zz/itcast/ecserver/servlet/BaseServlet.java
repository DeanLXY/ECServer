package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseServlet extends HttpServlet {

	protected SqlSessionFactory sqlSessionFactory;

	public BaseServlet() {
		super();
		try {
			// 1 .创建SqlSessionFactoryBuilder对象
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// 2. 加载配置文件
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			// 3. 获取sqlSessionFactory对象
			
			sqlSessionFactory = builder.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
