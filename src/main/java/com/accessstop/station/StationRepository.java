package com.accessstop.station;

import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {

    Station findByNumber(Long number);
}
