package gaw.logbook.geographic;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import gaw.logbook.exception.NotFoundException;

@RestController
public class CountryResource {
	private CountryDaoService service = new CountryDaoService();
	
	@GetMapping("/countries")
	public List<Country> retrieveAllCountries() throws SQLException {
		return service.getListCountries();
	}
	
	@GetMapping("/countries/page/{page}")
	public List<Country> retrieveCountriesPerPage(@PathVariable int page) throws SQLException {
		List<Country> countries = service.getListCountriesPerPage(page);
		if (countries == null)
			throw new NotFoundException("page-" + page);
		return countries;
	}
}
