package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Dvd store model.
 */
@Getter
@Setter
@Data
public class DvdStoreModel {
    /**
     * The Dvds.
     */
    List<DvdRepositoryModel> dvds = new ArrayList<>();
}
