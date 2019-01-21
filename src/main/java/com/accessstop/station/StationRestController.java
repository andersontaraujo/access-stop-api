package com.accessstop.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
