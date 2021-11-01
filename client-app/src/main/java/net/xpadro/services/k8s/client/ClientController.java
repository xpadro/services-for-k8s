package net.xpadro.services.k8s.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/client/countries")
public class ClientController {
    private final RestTemplate restTemplate;

    @Value("${client.url}")
    private String endpoint;

    @Autowired
    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getCountries() {
        ResponseEntity<Country[]> response = restTemplate.getForEntity(endpoint, Country[].class);
        List<Country> countries = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return ResponseEntity.ok(countries);
    }
}
