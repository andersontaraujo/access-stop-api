package com.accessstop.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accessstop.common.exception.ConflictException;
import com.accessstop.common.exception.PreconditionFailedException;

@Component
public class StationValidator {
	
	private static final String MANDATORY_FIELD_MESSAGE = "O campo {0} é de preenchimento obrigatório";
	
	@Autowired
	private StationRepository repository;
	
	public void validateCreation(Station station) {
		validateNumber(station);
		validateUniqueNumber(station);
		validateName(station);
		validateAddress(station);
	}
	
	public void validateModification(Station station) {
		validateNumber(station);
		validateName(station);
		validateAddress(station);
	}
	
	private void validateNumber(Station station) {
		if (station.getNumber() == null) {
			throw new PreconditionFailedException(MANDATORY_FIELD_MESSAGE, "Número");
		}
	}
	
	private void validateUniqueNumber(Station station) {
		Station entity = repository.findByNumber(station.getNumber());
		if (entity != null) {
			throw new ConflictException("Registro de Estação com Número {0} encontrado.", station.getNumber());
		}
	}
	
	private void validateName(Station station) {
		if (station.getName() == null || station.getName().equals("")) {
			throw new PreconditionFailedException(MANDATORY_FIELD_MESSAGE, "Nome");
		}
	}
	
	private void validateAddress(Station station) {
		if (station.getAddress() == null || station.getAddress().equals("")) {
			throw new PreconditionFailedException(MANDATORY_FIELD_MESSAGE, "Endereço");
		}
	}

}
