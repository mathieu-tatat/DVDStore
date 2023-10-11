package com.simplon.dvdstore.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteGetAllDTO {
    public LocalDate date ;
    public Float montant;
    public int quantiteVendue;
    public Long id;
    public Long id_client;
    public Long id_dvd;
    public String name;
    public String nom;


    public VenteGetAllDTO(LocalDate date, Float montant, int quantiteVendue, Long id, ClientGetDTO clientGetDTO, AuthRequestDto.DvdStoreGetDTO dvdStoreGetDTO) {

        this.date = date;
        this.montant = montant;
        this.quantiteVendue = quantiteVendue;
        this.id = id;
        this.id_client = clientGetDTO.getId();
        this.id_dvd = dvdStoreGetDTO.getId();
        this.name = dvdStoreGetDTO.getName();
        this.nom = clientGetDTO.getNom();

    }
}
