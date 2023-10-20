package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The interface Client repository interface.
 */
@Repository
public interface ClientRepositoryInterface extends CrudRepository<ClientRepository, Long> {

    ArrayList<ClientRepository> findAll();

    ClientRepository save(ClientRepository clientRepository);

    /**
     * Gets client by id.
     *
     * @param id the id
     * @return the client by id
     */
    ClientRepository getClientById(Long id);

    /**
     * Find by nom array list.
     *
     * @param nom the nom
     * @return the array list
     */
    ArrayList<ClientRepository> findByNom(String nom);
}
