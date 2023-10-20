package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * The interface Vente repository interface.
 */
@Repository
public interface VenteRepositoryInterface extends CrudRepository<VenteRepository, Long> {


    /**
     * Gets vente by id.
     *
     * @param id the id
     * @return the vente by id
     */
    ArrayList<VenteRepository> getVenteById(Long id);


    ArrayList<VenteRepository> findAll();

    VenteRepository save(VenteRepository venteRepository);
    
}
