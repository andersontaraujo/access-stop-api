package com.accessstop.station.rest;

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
public class StationResource {
	private Long number;
	private String name;
	private String address;
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;
}
