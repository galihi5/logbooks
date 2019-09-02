package gaw.logbook.kotaid;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import myBatis.MyBatisHelper;

@Component
public class KotaIdDaoService {
	private SqlSessionFactory myBatis;
	private SqlSession session;
	
	public KotaIdDaoService() {
		this.myBatis=MyBatisHelper.getSqlSessionFactory();
	}
	
	public List<KotaId> getListKotaIds() throws SQLException{
		session=myBatis.openSession(true);
		try {
			List<KotaId> result=session.selectList("kotaId.getListKotaIds");
			return result;
		}finally {
			session.close();
		}
	}
	
	public KotaId getKotaIdById(int id) throws SQLException{
		session=myBatis.openSession(true);
		try {
			KotaId result=session.selectOne("kotaId.getKotaIdById", id);					
			return result;
		}finally {
			session.close();
		}
	}
	
	public int saveKotaId(KotaId kotaId) throws SQLException{
		session=myBatis.openSession(true);
		try {
			int x=session.insert("kotaId.saveKotaId", kotaId);
			return x;
		}finally {
			session.close();
		}		
    }
	
	public int saveKotaIdWithReturningId(KotaId kotaId) throws SQLException{
		session=myBatis.openSession(true);
		try {
			int x=session.selectOne("kotaId.saveKotaIdWithReturningId", kotaId);
			return x;
		}finally {
			session.close();
		}		
    }
	
	public int deleteKotaIdById(int id) {				
		session=myBatis.openSession(true);
		try {
			int result=session.delete("kotaId.deleteKotaIdById", id);
			return result;
		}finally {
			session.close();
		}
	}
	
	public KotaId deleteKotaIdByIdWithReturningObject(int id) throws SQLException{
		session=myBatis.openSession(true);
		try {
			KotaId kotaId=session.selectOne("kotaId.deleteKotaIdByIdWithReturningObject", id);
			return kotaId;
		}finally {
			session.close();
		}		
    }
	
	public List<KotaId> deleteKotaIdByKotaWithReturningList(String kota) throws SQLException{
		session=myBatis.openSession(true);
		try {
			List<KotaId> result=session.selectList("kotaId.deleteKotaIdByKotaWithReturningList", kota);
			return result;
		}finally {
			session.close();
		}		
	}
}
