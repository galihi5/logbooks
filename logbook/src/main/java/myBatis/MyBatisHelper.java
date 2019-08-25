package myBatis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHelper {
	private static final SqlSessionFactory sqlSessionFactory;
	static {
		try {
			Properties prop = new Properties();
			String sqlConfig = System.getProperty("sqlConfig");

			if (sqlConfig == null) {
				try {
					prop.load(new FileInputStream("jdbc.properties"));
				} catch (IOException ex) {
					prop.load(Resources.getResourceAsReader("myBatis/jdbc.properties"));
				}
			} else {
				prop.load(Resources.getUrlAsReader(sqlConfig));
			}

			String resource = "myBatis/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, prop);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error initializing MyBatisHelper class. Cause: " + e);
		}

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
