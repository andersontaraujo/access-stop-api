package com.accessstop.config;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class OrikaMapperConfig extends ConfigurableMapper implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	private MapperFactory mapperFactory;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		init();
		configBeans();
	}
	
	@Override
	protected void configure(MapperFactory factory) {
		this.mapperFactory = factory;
	}
	
	@SuppressWarnings("rawtypes")
	private void configBeans() {
		Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
		for (Mapper mapper : mappers.values()) {
			addMappers(mapper);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addMappers(Mapper<?, ?> mapper) {
		this.mapperFactory.classMap(mapper.getAType(), mapper.getBType()).customize((Mapper) mapper).byDefault().register();
	}	

}
