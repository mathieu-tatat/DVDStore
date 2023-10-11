package com.simplon.dvdstore.dto;

import com.simplon.dvdstore.services.ClientServiceModele;
import com.simplon.dvdstore.services.DvdServiceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDate;



@Data
@NoArgsConstructor

public class VenteGetDTO {

    public LocalDate date;
    public Float montant;
    public int quantiteVendue;
    public Long id;
    public Long id_client;
    public Long id_dvd;

    public VenteGetDTO(LocalDate date, Float montant, int quantiteVendue, Long aLong, ClientServiceModele clientServiceModele, DvdServiceModel dvdServiceModel) {
        this.date = date;
        this.montant = montant;
        this.quantiteVendue = quantiteVendue;
        this.id = aLong;
        this.id_client = clientServiceModele.getId().get();
        this.id_dvd = dvdServiceModel.getId().get();
    }
}
