package com.accessstop.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    private StationRepository repository;
    
    @Autowired
    private StationValidator validator;

    public List<Station> search(StationFilter filter) {
        return repository.search(filter);
    }
    
    public Station create(Station station) {
    		validator.validateCreation(station);
    		return repository.save(station);
    }
    
    public Station findByNumber(Long number) {
    		return repository.findByNumber(number);
    }
    
    public Station update(Station station) {
    		validator.validateModification(station);
    		return repository.save(station);
    }
    
    public void delete(Long number) {
    		repository.deleteById(number);
    }
    
}
