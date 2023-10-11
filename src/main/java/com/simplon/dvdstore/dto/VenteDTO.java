package com.simplon.dvdstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.sql.Date;
import java.time.LocalDate;


@Data
@Value
@AllArgsConstructor

public class VenteDTO {
    public LocalDate date;
    public Float montant;
    public int quantiteVendue;
}
