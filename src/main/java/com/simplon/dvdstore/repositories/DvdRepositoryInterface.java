package com.simplon.dvdstore.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DvdRepositoryInterface extends CrudRepository<DvdRepositoryModel, Long> {
        ArrayList<DvdRepositoryModel> findAll();
       DvdRepositoryModel getDvdById(Long id);
        ArrayList<DvdRepositoryModel> findByName(String name);
        DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);
}


