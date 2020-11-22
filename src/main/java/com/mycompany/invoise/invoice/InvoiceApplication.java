package com.mycompany.invoise.invoice;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.mycompany.invoise.core.entity.invoice")
//@EntityScan( basePackages ={"com.mycompany.invoise.core.entity.invoice","com.mycompany.invoise.invoice.service"})
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}
	@Bean
	public Hibernate5Module datHibernate5Module(){
		Hibernate5Module module = new Hibernate5Module();
		//desactive le @Trasient
		module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		module.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
		return  module;
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}
}
