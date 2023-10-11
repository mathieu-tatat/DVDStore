package com.simplon.dvdstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class AuthRequestDto {
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Data
    @AllArgsConstructor
    public static class DvdStoreGetDTO {
        public String name;
        public String genre;
        public Long quantity;
        public Float prix;
        public String photo;
        public String description;
        public Long id;

    }
}
