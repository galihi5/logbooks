package gaw.logbook.kotaid;

import java.net.URI;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gaw.logbook.exception.NotFoundException;

@RestController
public class KotaIdResource {
	private KotaIdDaoService service = new KotaIdDaoService();

	@GetMapping("/kotaids")
	public List<KotaId> retrieveAllKotaId() throws SQLException {
		return service.getListKotaIds();
	}

	@GetMapping("/kotaids/{id}")
	public KotaId retrieveKotaId(@PathVariable int id) throws SQLException {
		KotaId kotaId = service.getKotaIdById(id);
		if (kotaId == null)
			throw new NotFoundException("id-" + id);
		return kotaId;
	}

	/* Dynamic Filtering
	 * @GetMapping("/kotaids/{id}") public MappingJacksonValue
	 * retrieveKotaId(@PathVariable int id) throws SQLException { KotaId kotaId =
	 * service.getKotaIdById(id); if (kotaId == null) throw new
	 * NotFoundException("id-" + id);
	 * 
	 * SimpleBeanPropertyFilter
	 * filter=SimpleBeanPropertyFilter.filterOutAllExcept("ID", "Kota", "Provinsi");
	 * FilterProvider filters = new SimpleFilterProvider().addFilter("KotaIdFilter",
	 * filter); MappingJacksonValue mapping = new MappingJacksonValue(kotaId);
	 * mapping.setFilters(filters);
	 * 
	 * return mapping; }
	 */

	/*
	 * @PostMapping(path = "/kotaids") public void createKotaId(@RequestBody KotaId
	 * kotaId) throws SQLException { int x = service.saveKotaId(kotaId); }
	 * 
	 * @PostMapping(path = "/kotaidsreturningid") public void
	 * createKotaIdReturningId(@RequestBody KotaId kotaId) throws SQLException { int
	 * id = service.saveKotaIdWithReturningId(kotaId);
	 * 
	 * URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (id).toUri(); }
	 */

	@PostMapping("/kotaids")
	public ResponseEntity<Object> createKotaIdReturningId(@Valid @RequestBody KotaId kotaId) throws SQLException {
		int id = service.saveKotaIdWithReturningId(kotaId);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/kotaids/{id}")
	public void deleteKotaId(@PathVariable int id) {
		int x = service.deleteKotaIdById(id);
		System.out.println("deleteKotaIdById ==> " + x);
		if (x == 0)
			throw new NotFoundException("id-" + id);
	}

	@DeleteMapping("/kotaids2/{id}")
	public void deleteKotaIdByIdWithReturningObject(@PathVariable int id) throws SQLException {
		KotaId kotaId = service.deleteKotaIdByIdWithReturningObject(id);
		if (kotaId != null)
			System.out.println("deleteKotaIdByIdWithReturningObject ==> " + kotaId.getId() + " | " + kotaId.getKota()
					+ " | " + kotaId.getProvinsi());
		if (kotaId == null)
			throw new NotFoundException("id-" + id);
	}

	@DeleteMapping("/kotaids3/{kota}")
	public void deleteKotaIdByKotaWithReturningList(@PathVariable String kota) throws SQLException {
		List<KotaId> result = service.deleteKotaIdByKotaWithReturningList(kota);
		if (result != null && result.size() > 0) {
			System.out.println("deleteKotaIdByKotaWithReturningList :");
			Iterator<KotaId> iterator = result.iterator();
			while (iterator.hasNext()) {
				KotaId kotaId = iterator.next();
				System.out.println(kotaId.getId() + " | " + kotaId.getKota() + " | " + kotaId.getProvinsi());
			}
		}
		if (result == null || result.size() == 0)
			throw new NotFoundException("kota-" + kota);
	}

}
