package deloitte.sanli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import deloitte.sanli.domain.dto.Category;
import deloitte.sanli.service.WalmartService;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hasan.sanli
 *
 *         Feb 27, 2020
 */
@SpringBootApplication
public class SanliApplication {

	@Autowired
	WalmartService walmartService;
	public static Category[] movieCategories;
	private final Logger log = LoggerFactory.getLogger(SanliApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SanliApplication.class, args);
	}

	@PostConstruct
	private void PostConstruct() {
		log.info("init start");
		movieCategories = walmartService.getCategoriesById("4096");
		log.info("init finish");
	}
}
