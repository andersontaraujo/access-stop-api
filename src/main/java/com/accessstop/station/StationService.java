package com.accessstop.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    private StationRepository repository;

    public Iterable<Station> findAll() {
        return repository.findAll();
    }
    
    public Station create(Station station) {
    		return repository.save(station);
    }
    
    public Station findByNumber(Long number) {
    		return repository.findByNumber(number);
    }
    
    public Station update(Station station) {
    		return repository.save(station);
    }
    
    public void delete(Long number) {
    		repository.deleteById(number);
    }
    
}
