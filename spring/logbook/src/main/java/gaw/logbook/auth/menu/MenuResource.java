package gaw.logbook.auth.menu;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuResource {
	private MenuDaoService service=new MenuDaoService();
	
//	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/menus")
	public List<Menu> retrieveAllMenu() throws SQLException {
		return service.getListMenu();
	}
}
