package com.simplon.dvdstore.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * The interface Dvd repository interface.
 */
@Repository
public interface DvdRepositoryInterface extends CrudRepository<DvdRepositoryModel, Long> {

    ArrayList<DvdRepositoryModel> findAll();

    /**
     * Gets dvd by id.
     *
     * @param id the id
     * @return the dvd by id
     */
    DvdRepositoryModel getDvdById(Long id);


    /**
     * Find by name array list.
     *
     * @param name the name
     * @return the array list
     */
    ArrayList<DvdRepositoryModel> findByName(String name);
    DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);
}


