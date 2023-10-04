package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.ClientServiceModele;
import com.simplon.dvdstore.services.ClientStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientStoreService clientStoreService;

    @GetMapping
    public ArrayList<ClientGetDTO> getAll() {
        ArrayList<ClientGetDTO> clientGetDTOs = new ArrayList<>();
        ArrayList<ClientServiceModele> clientServiceModeleArrayList = clientStoreService.getAll();
        for (ClientServiceModele x : clientServiceModeleArrayList) {
            clientGetDTOs.add(new ClientGetDTO(x.getNom(), x.getPrenom(),x.getTelephone(), x.getId().get()));
        }
        return clientGetDTOs;
    }


    @PostMapping
    public  boolean add(@RequestBody ClientGetDTO clientGetDTO) {
        ClientServiceModele clientServiceModel = new ClientServiceModele(clientGetDTO.getNom(), clientGetDTO.getPrenom(),clientGetDTO.getTelephone(), Optional.ofNullable(clientGetDTO.getId()));
        return clientStoreService.add(clientServiceModel);
    }
    @GetMapping("/{id}")
    public ClientGetDTO getClientById(@PathVariable Long id) {
        ClientServiceModele clientServiceModele = clientStoreService.getClientById(id);
        return new ClientGetDTO(clientServiceModele.getNom(), clientServiceModele.getPrenom(),clientServiceModele.getTelephone(), clientServiceModele.getId().get());
    }

    @GetMapping("/nom/{nom}")
    public ClientGetDTO getClientByName(@PathVariable String nom) {
        ClientServiceModele clientServiceModele = clientStoreService.getClientByName(nom);
        return new ClientGetDTO(clientServiceModele.getNom(), clientServiceModele.getPrenom(),clientServiceModele.getTelephone(), clientServiceModele.getId().get());
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO) {
        return clientStoreService.update(id, new ClientServiceModele(clientDTO.getNom(), clientDTO.getPrenom(), clientDTO.getTelephone(), Optional.ofNullable(id)));
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable Long id) {
        clientStoreService.delete(id);
    }
}
