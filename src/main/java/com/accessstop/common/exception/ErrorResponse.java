package com.accessstop.common.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
	private Date occurredAt;
	private Integer httpStatusCode;
	private String httpError;
	private String message;
	private String method;
	private String path;
}
