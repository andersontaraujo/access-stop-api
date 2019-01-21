package com.accessstop.station.rest;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import com.accessstop.station.Station;

import lombok.Setter;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Setter
@Component
public class StationResourceMapper extends CustomMapper<Station, StationResource> {

	@Override
	public void mapAtoB(Station a, StationResource b, MappingContext context) {
		b.setCreatedAt(a.getCreatedAt().toDate());
	}

	@Override
	public void mapBtoA(StationResource b, Station a, MappingContext context) {
		a.setCreatedAt(LocalDateTime.fromDateFields(b.getCreatedAt()));
	}

}
