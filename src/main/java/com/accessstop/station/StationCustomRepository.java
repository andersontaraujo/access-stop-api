package com.accessstop.station;

import java.util.List;

public interface StationCustomRepository {
	
	List<Station> search(StationFilter filter);

}
