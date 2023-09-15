package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Data
public class DvdStoreModel {

    List<DvdRepositoryModel> dvds = new ArrayList<>();
}
