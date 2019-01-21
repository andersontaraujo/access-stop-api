package com.accessstop.station;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
