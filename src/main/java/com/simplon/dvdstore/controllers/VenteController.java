package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.VenteServiceModele;
import com.simplon.dvdstore.services.VenteStoreService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("ventes")
public class VenteController {
   @Autowired
   VenteStoreService venteStoreService;


   @GetMapping
   public ArrayList<VenteGetDTO> getAll() {
       ArrayList<VenteGetDTO> venteGetDTOs = new ArrayList<>();
       ArrayList<VenteServiceModele> venteServiceModeleArrayList = venteStoreService.getAll();
       for (VenteServiceModele x : venteServiceModeleArrayList) {
           venteGetDTOs.add(new VenteGetDTO(x.getDate(), x.getMontant(),x.getQuantiteVendue(), x.getId().get() ,  x.getClient().get(),x.getDvd().get()));
       }
       return venteGetDTOs;
   }

   @PostMapping
   public  boolean add(@RequestBody VenteGetDTO venteGetDTO) {
       VenteServiceModele venteServiceModel = new VenteServiceModele(venteGetDTO.getDate(), venteGetDTO.getMontant(),venteGetDTO.getQuantiteVendue(), Optional.ofNullable(venteGetDTO.getId()), Optional.ofNullable( venteGetDTO.getId_client() ), Optional.ofNullable(  venteGetDTO.getId_dvd()));
       System.out.println(venteGetDTO);
       return venteStoreService.add(venteServiceModel);
   }

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


}
