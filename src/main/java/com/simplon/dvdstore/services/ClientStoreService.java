package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.ClientRepository;
import com.simplon.dvdstore.repositories.ClientRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientStoreService {
    @Autowired
    ClientRepositoryInterface clientRepositoryInterface;

    public ArrayList<ClientServiceModele> getAll() {
        ArrayList<ClientServiceModele> clientServiceModeles = new ArrayList<>();
        ArrayList<ClientRepository> clientRepositoryArrayList =  clientRepositoryInterface.findAll();
        for (ClientRepository x : clientRepositoryArrayList) {
            clientServiceModeles.add(new ClientServiceModele(x.getNom(), x.getPrenom(),x.getTelephone(), Optional.ofNullable(x.getId())));
        }
        return clientServiceModeles;
    }


    public boolean add(ClientServiceModele clientServiceModele) {
        ClientRepository clientRepository = new ClientRepository(clientServiceModele.getNom(), clientServiceModele.getPrenom(), clientServiceModele.getTelephone());
       ClientRepository clientRepositoryReturned = clientRepositoryInterface.save(clientRepository);

        return clientRepositoryReturned != null;
    }

    public ClientServiceModele getClientById(Long id) {
        ClientRepository clientRepository = clientRepositoryInterface.findById(id).get();
        return new ClientServiceModele(clientRepository.getNom(), clientRepository.getPrenom(),clientRepository.getTelephone(), Optional.ofNullable(clientRepository.getId()));
    }

    public ClientServiceModele getClientByName(String nom) {
        ClientRepository clientRepository = clientRepositoryInterface.findByNom(nom).get(0);
        return new ClientServiceModele(clientRepository.getNom(), clientRepository.getPrenom(),clientRepository.getTelephone(), Optional.ofNullable(clientRepository.getId()));
    }

    public boolean update(@PathVariable Long id, @RequestBody ClientServiceModele clientServiceModele) {
        try {
            ClientRepository clientRepository = clientRepositoryInterface.findById(id).get();
            clientRepository.setNom(clientServiceModele.getNom());
            clientRepository.setPrenom(clientServiceModele.getPrenom());
            clientRepository.setTelephone(clientServiceModele.getTelephone());
            clientRepositoryInterface.save(clientRepository);
            return clientServiceModele != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void delete(Long id) {
        clientRepositoryInterface.deleteById(id);}

}
