package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.ClientServiceModele;
import com.simplon.dvdstore.services.DvdServiceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;


@Data
@NoArgsConstructor

public class VenteGetDTO {

    public LocalDate date;
    public Float montant;
    public int quantiteVendue;
    public Long id;

    public Long id_client;

    public Long  id_dvd;


    public VenteGetDTO(LocalDate date, Float montant, int quantiteVendue, Long id, ClientServiceModele clientServiceModele, DvdServiceModel dvdServiceModel) {
    }

public VenteGetDTO(LocalDate date, Float montant, int quantiteVendue, Long id, ClientGetDTO clientGetDTO, DvdStoreGetDTO dvdStoreGetDTO) {
    }

    public VenteGetDTO(LocalDate date, Float montant, int quantiteVendue, Long id) {
    }
}
