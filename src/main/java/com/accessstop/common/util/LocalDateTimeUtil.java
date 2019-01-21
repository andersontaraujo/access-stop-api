package com.accessstop.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeUtil {
	
	public static LocalDate convertDateToLocalDate(Date source) {
        return source.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertLocalDateToDate(LocalDate source) {
        return Date.from(source.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime convertDateToLocalDateTime(Date source) {
        return LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime source) {
        return Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
    }

}
