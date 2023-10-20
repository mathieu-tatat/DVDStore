package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// commentaire

/**
 * The type Dvd strore application.
 */
@SpringBootApplication
public class DvdStroreApplication{
	private static final Logger log = LoggerFactory.getLogger(DvdRepositoryModel.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(DvdStroreApplication.class);
	}
}
