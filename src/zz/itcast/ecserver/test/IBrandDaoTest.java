package zz.itcast.ecserver.test;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import zz.itcast.ecserver.dao.IBrandDao;
import zz.itcast.ecserver.po.Brand;

public class IBrandDaoTest {
	private SqlSessionFactory sessionFactory;

	@Before
	public void init() throws IOException {
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 3. 创建sqlsessionFactory对象

		sessionFactory = sessionFactoryBuilder.build(inputStream);
	}

	@Test
	public void testAddNewBrand() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(
					"D:\\Android\\workspace-j2ee\\itcast16\\ECServerz19\\src\\zz\\itcast\\ecserver\\test\\jd_brand.config");
			br = new BufferedReader(fr);
			String line = null;
			Brand brand;
			SqlSession sqlSession = sessionFactory.openSession();
			IBrandDao brandDao = sqlSession.getMapper(IBrandDao.class);
			while ((line = br.readLine()) != null) {
				String[] infos = line.split("#");
				String a_href = infos[0];
				String img_src = infos[1];
				String brand_id = infos[2];
				brand = new Brand();
				brand.setName("");
				brand.setPic(img_src);
				brand.setBrandId(brand_id);
				brand.setKey("国际品牌");
				brand.setHref(a_href);
				brandDao.addNewBrand(brand);
				sqlSession.commit();
			}
			sqlSession.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(br);
			close(fr);
		}
	}

	public void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
