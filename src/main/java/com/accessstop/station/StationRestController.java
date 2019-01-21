package com.accessstop.station;

import java.net.URI;
import java.util.List;

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

import com.accessstop.station.rest.StationResource;
import com.accessstop.station.rest.StationsResource;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping("/stations")
public class StationRestController {

    @Autowired
    private StationService service;
    
    @Autowired
    private MapperFacade mapper;

    @GetMapping
    public ResponseEntity<StationsResource> listAll() {
        Iterable<Station> entities = service.findAll();
        List<StationResource> resources = mapper.mapAsList(entities, StationResource.class);
        return ResponseEntity.ok().body(StationsResource.builder().stations(resources).build());
    }
    
    @PostMapping
    public ResponseEntity<StationResource> create(@RequestBody Station station) {
    		Station entity = service.create(station);
    		StationResource resource = mapper.map(entity, StationResource.class);
    		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{number}").buildAndExpand(entity.getNumber()).toUri();
    		return ResponseEntity.created(location).body(resource);
    }
    
    @GetMapping("/{number}")
    public ResponseEntity<StationResource> findByNumber(@PathVariable("number") Long number) {
    		Station entity = service.findByNumber(number);
    		if (entity == null) {
    			return ResponseEntity.notFound().build();
    		}
    		StationResource resource = mapper.map(entity, StationResource.class);
    		return ResponseEntity.ok(resource);
    }
    
    @PutMapping("/{number}")
    public ResponseEntity<StationResource> update(@PathVariable("number") Long number, @RequestBody Station station) {
    		if (!number.equals(station.getNumber())) {
    			return ResponseEntity.badRequest().build();
    		}
    		Station entity = service.findByNumber(number);
		if (entity == null) {
			return ResponseEntity.notFound().build();
		}
		entity = service.update(station);
		StationResource resource = mapper.map(entity, StationResource.class);
		return ResponseEntity.ok().body(resource);
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
