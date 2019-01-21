package com.accessstop.common.util;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

@Component
public class LocalDateTimeCustomConverter extends BidirectionalConverter<Date, LocalDateTime> {

	@Override
	public Date convertFrom(LocalDateTime arg0, Type<Date> arg1) {
		return LocalDateTimeUtil.convertLocalDateTimeToDate(arg0);
	}

	@Override
	public LocalDateTime convertTo(Date arg0, Type<LocalDateTime> arg1) {
		return LocalDateTimeUtil.convertDateToLocalDateTime(arg0);
	}

}
