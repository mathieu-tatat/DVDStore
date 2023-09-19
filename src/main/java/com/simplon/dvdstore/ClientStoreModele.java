package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.ClientRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Data
public class ClientStoreModele {
    List<ClientRepository> clients = new ArrayList<>();
}
