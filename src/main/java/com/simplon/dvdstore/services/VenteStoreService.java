package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class VenteStoreService {
    @Autowired
    VenteRepositoryInterface venteRepositoryInterface;

    @Autowired
    ClientRepositoryInterface clientRepositoryInterface;

    @Autowired
    DvdRepositoryInterface dvdRepositoryInterface;


    public ArrayList<VenteServiceModele> getAll() {
        ArrayList<VenteServiceModele> venteServiceModeles = new ArrayList<>();
        ArrayList<VenteRepository> venteRepositoryArrayList =  venteRepositoryInterface.findAll();
        for (VenteRepository x : venteRepositoryArrayList) {
            venteServiceModeles.add(new VenteServiceModele(x.getDate(), x.getMontant(),x.getQuantiteVendue(), Optional.ofNullable( x.getId() ) ));
        }
        return venteServiceModeles;
    }

    public boolean add(VenteServiceModele venteServiceModele) {

        ClientRepository client = clientRepositoryInterface.getClientById(venteServiceModele.getId_client().get());

        DvdRepositoryModel dvd = dvdRepositoryInterface.getDvdById(venteServiceModele.getId_dvd().get());

        VenteRepository venteRepository = new VenteRepository(venteServiceModele.getDate(), venteServiceModele.getMontant(), venteServiceModele.getQuantiteVendue(), client, dvd);

       VenteRepository venteRepositoryReturned = venteRepositoryInterface.save(venteRepository);

        return venteRepositoryReturned != null;
    }

    public VenteServiceModele getVenteById(Long id) {
        VenteRepository venteRepository = venteRepositoryInterface.findById(id).get();
        return new VenteServiceModele(venteRepository.getDate(), venteRepository.getMontant(),venteRepository.getQuantiteVendue(), Optional.ofNullable( venteRepository.getId() ) );
    }

    public boolean update(Long id, VenteServiceModele venteServiceModele) {
        try {
            VenteRepository venteRepository = venteRepositoryInterface.findById(id).get();
            venteRepository.setMontant(venteServiceModele.getMontant());
            venteRepository.setQuantiteVendue(venteServiceModele.getQuantiteVendue());
            venteRepositoryInterface.save(venteRepository);
            return venteServiceModele != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void delete(Long id) {
        venteRepositoryInterface.deleteById(id);}

}
