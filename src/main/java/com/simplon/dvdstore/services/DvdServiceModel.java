package com.simplon.dvdstore.services;

import jakarta.persistence.Lob;
import jakarta.websocket.Decoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.util.Map;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DvdServiceModel {
    private String name;
    private String genre;
    private Long quantity;
    public Float prix;
    public String photo;
    public String  description;
    private Optional <Long> id;
}
