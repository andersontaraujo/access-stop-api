package com.accessstop.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    private StationRepository repository;

    Iterable<Station> findAll() {
        return repository.findAll();
    }
}
