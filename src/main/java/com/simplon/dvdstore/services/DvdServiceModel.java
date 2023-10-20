package com.simplon.dvdstore.services;

import jakarta.persistence.Lob;
import jakarta.websocket.Decoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.util.Map;
import java.util.Optional;

/**
 * The type Dvd service model.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DvdServiceModel {
    private Optional <Long> id;
    private String name;
    private String genre;
    private Long quantity;
    /**
     * The Prix.
     */
    public Float prix;
    /**
     * The Photo.
     */
    public String photo;
    /**
     * The Description.
     */
    public String  description;

}
