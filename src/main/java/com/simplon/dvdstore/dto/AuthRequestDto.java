package com.simplon.dvdstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Auth request dto.
 */
public class AuthRequestDto {
    private String username;
    private String password;


    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The type Dvd store get dto.
     */
    @Data
    @AllArgsConstructor
    public static class DvdStoreGetDTO {
        /**
         * The Name.
         */
        public String name;
        /**
         * The Genre.
         */
        public String genre;
        /**
         * The Quantity.
         */
        public Long quantity;
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
        /**
         * The Id.
         */
        public Long id;

    }
}
