package gaw.logbook.geographic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import myBatis.MyBatisHelper;

@Component
public class CountryDaoService {
	private SqlSessionFactory myBatis;
	private SqlSession session;
	
	public CountryDaoService() {
		this.myBatis=MyBatisHelper.getSqlSessionFactory();
	}

	public List<Country> getListCountries() {
		session=myBatis.openSession(true);
		try {
			List<Country> result=session.selectList("geographic.getListCountries");
			return result;
		}finally {
			session.close();
		}
	}
	
	public List<Country> getListCountriesPerPage(int page) {
		session=myBatis.openSession(true);
		try {
			List<Country> result=session.selectList("geographic.getListCountriesPerPage", page);
			return result;
		}finally {
			session.close();
		}
	}
}
