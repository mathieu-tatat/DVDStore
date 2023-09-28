package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VenteRepositoryInterface extends CrudRepository<VenteRepository, Long> {


    ArrayList<VenteRepository> getVenteById(Long id);


    ArrayList<VenteRepository> findAll();

    VenteRepository save(VenteRepository venteRepository);
    
}
