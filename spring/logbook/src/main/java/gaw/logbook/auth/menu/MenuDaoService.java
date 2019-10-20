package gaw.logbook.auth.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import myBatis.MyBatisHelper;

@Component
public class MenuDaoService {
	private SqlSessionFactory myBatis;
	private SqlSession session;
	
	public MenuDaoService() {
		this.myBatis=MyBatisHelper.getSqlSessionFactory();
	}
	
	private List<Menu> getListMenuParent() throws SQLException{
		session=myBatis.openSession(true);
		try {
			List<Menu> result=session.selectList("menu.getListMenuParent");
			return result;
		}finally {
			session.close();
		}
	}
	
	private List<Menu> getListMenuChild(String parentId) throws SQLException{
		session=myBatis.openSession(true);
		try {
			List<Menu> result=session.selectList("menu.getListMenuChild", parentId);
			return result;
		}finally {
			session.close();
		}
	}
	
	public List<Menu> getListMenu() throws SQLException{
		List<Menu> result=new ArrayList();
		List<Menu> parent=getListMenuParent();		
		Iterator itr=(Iterator) parent.iterator();		
		while (itr.hasNext()) {
			Menu menu=(Menu)itr.next();
			String parentId=menu.getMenuId();
			
			if (parentId!=null) {
				List views=getListMenuChild(parentId);
				
				if (views!=null)
					menu.setViews(views);
			}
			
			result.add(menu);
		}
		return result;
	}
}
