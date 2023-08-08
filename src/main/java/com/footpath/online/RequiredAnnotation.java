package com.footpath.online;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
@Component
public class RequiredAnnotation {
	@Autowired
	public MessageSource messageSource;
	@Autowired
	public Environment environment;

}
