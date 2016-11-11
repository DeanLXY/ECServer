package zz.itcast.ecserver.test;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import zz.itcast.ecserver.dao.IProductDao;
import zz.itcast.ecserver.po.Product;

public class IProductDaoTest {
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
	public void testInsertNewProduct() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(
					"D:\\Android\\workspace-j2ee\\itcast16\\ECServerz19\\src\\zz\\itcast\\ecserver\\test\\jd.config");
			br = new BufferedReader(fr);
			String line = null;
			Product product;
			Random random = new Random();
			SqlSession sqlSession = sessionFactory.openSession();
			IProductDao productDao = sqlSession.getMapper(IProductDao.class);
			while ((line = br.readLine()) != null) {
				String[] infos = line.split("#");
				String alt = infos[0];
				String src = infos[1];
				System.out.println(alt);
				System.out.println(src);
				product = new Product();
				product.setName(alt);
				product.setPic(src);
				int price = random.nextInt(399);
				product.setPrice(price);
				product.setMarketprice(price + random.nextInt(48));
				product.setIsgift(false);
				int commentcount = random.nextInt(66534);
				product.setCommentcount(commentcount);
				product.setSales(commentcount + random.nextInt(1889));
				product.setCid(1001 + random.nextInt(7));
				productDao.insertNewProduct(product);
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

	@Test
	public void testInsertNewProductNews() {

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(
					"D:\\Android\\workspace-j2ee\\itcast16\\ECServerz19\\src\\zz\\itcast\\ecserver\\test\\jd_new.config");
			br = new BufferedReader(fr);
			String line = null;
			Product product;
			Random random = new Random();
			SqlSession sqlSession = sessionFactory.openSession();
			IProductDao productDao = sqlSession.getMapper(IProductDao.class);
			while ((line = br.readLine()) != null) {
				String[] infos = line.split("#");
				String a_title = infos[0];
				String a_href = infos[1];
				String img_src = infos[2];
				System.out.println(a_title);
				System.out.println(a_href);
				System.out.println(img_src);
				product = new Product();
				product.setName(a_title);
				product.setPic(img_src);
				product.setHref(a_href);
				product.setOutoftime(System.currentTimeMillis()+1000*60*60*12*random.nextInt(30));
				int price = random.nextInt(399);
				product.setPrice(price);
				product.setMarketprice(price + random.nextInt(48));
				product.setIsgift(false);
				int commentcount = random.nextInt(66534);
				product.setCommentcount(commentcount);
				product.setSales(commentcount + random.nextInt(1889));
				product.setCid(1001 + random.nextInt(7));
				productDao.insertNewProductNews(product);
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
	@Test
	public void testInsertNewBrandProduct() {
		
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try {
			fr = new FileReader(
					"D:\\Android\\workspace-j2ee\\itcast16\\ECServerz19\\src\\zz\\itcast\\ecserver\\test\\jd_brand_list.config");
			br = new BufferedReader(fr);
			Product product;
			Random random = new Random();
			SqlSession sqlSession = sessionFactory.openSession();
			IProductDao productDao = sqlSession.getMapper(IProductDao.class);
			while ((line = br.readLine()) != null) {
				String[] infos = line.split("#");
				String a_href = infos[0];
				String img_src = infos[1];
				String a_title = infos[2];
				String brand_id = infos[3];
				String product_id = infos[4];
				System.out.println(a_title);
				System.out.println(a_href);
				System.out.println(img_src);
				System.out.println(product_id);
				product = new Product();
				product.setProductId(product_id);
				product.setName(a_title);
				product.setBrandId(Integer.parseInt(brand_id));
				product.setPic(img_src);
				product.setHref(a_href);
				product.setOutoftime(System.currentTimeMillis()+1000*60*60*12*random.nextInt(30));
				int price = random.nextInt(399);
				product.setPrice(price);
				product.setMarketprice(price + random.nextInt(48));
				product.setIsgift(false);
				int commentcount = random.nextInt(66534);
				product.setCommentcount(commentcount);
				product.setSales(commentcount + random.nextInt(1889));
				product.setCid(1001 + random.nextInt(7));
				productDao.insertNewProductNews(product);
				sqlSession.commit();
			}
			sqlSession.close();
			
		} catch (Exception e) {
			System.err.println("line = "+line);
		} finally {
			close(br);
			close(fr);
		}
	}
	@Test
	public void testInsertNewProductDetailPicAndBigPic() {
		
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try {
			fr = new FileReader(
					"D:\\Android\\workspace-j2ee\\itcast16\\ECServerz19\\src\\zz\\itcast\\ecserver\\test\\jd_brand_detail.config");
			br = new BufferedReader(fr);
			SqlSession sqlSession = sessionFactory.openSession();
			IProductDao productDao = sqlSession.getMapper(IProductDao.class);
			while ((line = br.readLine()) != null) {
				String[] infos = line.split("#");
				String img_alt = infos[0];
				String img_src = infos[1];
				String img_big_src = infos[2];
				String product_id = infos[3];
				System.out.println(img_alt);
				System.out.println(img_src);
				System.out.println(img_big_src);
				System.out.println(product_id);
				productDao.insertNewProductDetailImgs(product_id, img_alt,img_src);
				productDao.insertNewProductDetailBigImgs(product_id, img_alt,img_big_src);
				sqlSession.commit();
			}
			sqlSession.close();
			
		} catch (Exception e) {
			System.err.println(e+"line = "+line);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
