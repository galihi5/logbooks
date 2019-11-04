package gaw.logbook.auth.devdiaries.authentication.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import myBatis.MyBatisHelper;

@Component
public class UserDaoService {
	private SqlSessionFactory myBatis;
	private SqlSession session;
	
	public UserDaoService() {
		this.myBatis=MyBatisHelper.getSqlSessionFactory();
	}

	public User getUserRoles(String userid) {
		session=myBatis.openSession(true);
		try {
			User result=session.selectOne("authorization.getUserRoles", userid);
			return result;
		}finally {
			session.close();
		}
	}
}
