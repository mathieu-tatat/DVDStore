package com.simplon.dvdstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.w3c.dom.Text;

/**
 * The type Dvd store dto.
 */
@Data
@Value
@AllArgsConstructor
public class DvdStoreDTO {

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
    public String description;
}

