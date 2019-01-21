package com.accessstop.station;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/stations")
public class StationRestController {

    @Autowired
    private StationService service;

    @GetMapping
    public ResponseEntity<Iterable<Station>> listAll() {
        Iterable<Station> stations = service.findAll();
        return ResponseEntity.ok().body(stations);
    }
    
    @PostMapping
    public ResponseEntity<Station> create(@RequestBody Station station) {
    		Station entity = service.create(station);
    		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{number}").buildAndExpand(entity.getNumber()).toUri();
    		return ResponseEntity.created(location).body(entity);
    }
    
    @GetMapping("/{number}")
    public ResponseEntity<Station> findByNumber(@PathVariable("number") Long number) {
    		Station station = service.findByNumber(number);
    		if (station == null) {
    			return ResponseEntity.notFound().build();
    		}
    		return ResponseEntity.ok(station);
    }
    
    @PutMapping("/{number}")
    public ResponseEntity<Station> update(@PathVariable("number") Long number, @RequestBody Station station) {
    		if (!number.equals(station.getNumber())) {
    			return ResponseEntity.badRequest().build();
    		}
    		Station entity = service.findByNumber(number);
		if (entity == null) {
			return ResponseEntity.notFound().build();
		}
		entity = service.update(station);
		return ResponseEntity.ok().body(entity);
    }
    
    @DeleteMapping("/{number}")
    public ResponseEntity<?> delete(@PathVariable("number") Long number) {
    		Station entity = service.findByNumber(number);
		if (entity == null) {
			return ResponseEntity.notFound().build();
		}
		service.delete(number);
    		return ResponseEntity.noContent().build();
    }
}
