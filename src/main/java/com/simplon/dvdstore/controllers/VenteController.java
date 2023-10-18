package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.dto.AuthRequestDto;
import com.simplon.dvdstore.dto.ClientGetDTO;
import com.simplon.dvdstore.dto.VenteGetAllDTO;
import com.simplon.dvdstore.dto.VenteGetDTO;
import com.simplon.dvdstore.services.VenteServiceModele;
import com.simplon.dvdstore.services.VenteStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Vente controller.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("ventes")
public class VenteController {
    /**
     * The Vente store service.
     */
    @Autowired
    VenteStoreService venteStoreService;


    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ArrayList<VenteGetAllDTO> getAll() {

        ArrayList<VenteGetAllDTO> venteGetAllDTOs = new ArrayList<>();
        ArrayList<VenteServiceModele> venteServiceModeleArrayList = venteStoreService.getAll();

        for (VenteServiceModele x : venteServiceModeleArrayList) {

            AuthRequestDto.DvdStoreGetDTO dvdStoreGetDTO = new AuthRequestDto.DvdStoreGetDTO(x.getDvd().get().getName(), x.getDvd().get().getGenre(), x.getDvd().get().getQuantity(), x.getDvd().get().getPrix(), x.getDvd().get().getPhoto(), x.getDvd().get().getDescription(),x.getDvd().get().getId().get());

                ClientGetDTO clientGetDTO = new ClientGetDTO(x.getClient().get().getNom(), x.getClient().get().getPrenom(), x.getClient().get().getTelephone(), x.getClient().get().getId());

                venteGetAllDTOs.add(new VenteGetAllDTO(x.getDate(), x.getMontant(),x.getQuantiteVendue(), x.getId().get(), clientGetDTO, dvdStoreGetDTO));
        }
        return venteGetAllDTOs;
    }

    /**
     * Add boolean.
     *
     * @param venteGetDTO the vente get dto
     * @return the boolean
     */
    @PostMapping
    public  boolean add(@RequestBody VenteGetDTO venteGetDTO) {
        VenteServiceModele venteServiceModel = new VenteServiceModele(venteGetDTO.getDate(), venteGetDTO.getMontant(),venteGetDTO.getQuantiteVendue(),Optional.ofNullable(venteGetDTO.getId()), Optional.ofNullable( venteGetDTO.getId_client() ), Optional.ofNullable(  venteGetDTO.getId_dvd()));
        System.out.println(venteGetDTO);
        return venteStoreService.add(venteServiceModel);
    }
    /*
    @GetMapping("/{id}")
    public VenteGetDTO getVenteById(@PathVariable Long id) {
        VenteServiceModele venteServiceModele = venteStoreService.getVenteById(id);
        return new VenteGetDTO(venteServiceModele.getDate(), venteServiceModele.getMontant(),venteServiceModele.getQuantiteVendue(), venteServiceModele.getId().get(),venteServiceModele.getClient().get(),venteServiceModele.getDvd().get());
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody VenteDTO venteDTO) {
        return venteStoreService.update(id, new VenteServiceModele(venteDTO.getDate(), venteDTO.getMontant(), venteDTO.getQuantiteVendue(),Optional.ofNullable(id)));
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable Long id) {
        venteStoreService.delete(id);
    }
*/

}
