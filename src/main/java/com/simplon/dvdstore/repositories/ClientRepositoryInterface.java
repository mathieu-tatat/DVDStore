package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;


@Repository
public interface ClientRepositoryInterface extends CrudRepository<ClientRepository, Long> {


    ArrayList<ClientRepository> findAll();

    ClientRepository save(ClientRepository clientRepository);
    ClientRepository getClientById(Long id);
    ArrayList<ClientRepository> findByNom(String nom);
}
