package net.xpadro.services.k8s.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CrudController {
    private final CountryRepository countryRepository;

    @Autowired
    public CrudController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = countryRepository.findAll();
        return ResponseEntity.ok(countries);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Country country) {
        countryRepository.save(country);
        return ResponseEntity.accepted().build();
    }
}
