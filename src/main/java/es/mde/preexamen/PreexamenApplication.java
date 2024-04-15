package es.mde.preexamen;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class PreexamenApplication {

  private static final Logger log = (Logger) LoggerFactory.getLogger(PreexamenApplication.class);
  
	public static void main(String[] args) {
		SpringApplication.run(PreexamenApplication.class, args);
	}

}
