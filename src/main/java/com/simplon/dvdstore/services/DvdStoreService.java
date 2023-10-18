package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Dvd store service.
 */
@Service
public class DvdStoreService {
    /**
     * The Dvd repository interface.
     */
    @Autowired
    DvdRepositoryInterface dvdRepositoryInterface;


    /**
     * Add boolean.
     *
     * @param dvdServiceModel the dvd service model
     * @return the boolean
     */
    public boolean add(DvdServiceModel dvdServiceModel) {
        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(dvdServiceModel.getName(), dvdServiceModel.getGenre(), dvdServiceModel.getQuantity(), dvdServiceModel.getPrix(),  dvdServiceModel.getPhoto(),dvdServiceModel.getDescription());
        DvdRepositoryModel dvdRepositoryModelReturned = dvdRepositoryInterface.save(dvdRepositoryModel);
        return dvdRepositoryModelReturned != null;
    }

    /**
     * Update boolean.
     *
     * @param id              the id
     * @param dvdServiceModel the dvd service model
     * @return the boolean
     */
    public boolean update(@PathVariable Long id, @RequestBody DvdServiceModel dvdServiceModel) {
        try {
            DvdRepositoryModel dvdRepositoryModel = dvdRepositoryInterface.findById(id).get();
            dvdRepositoryModel.setName(dvdServiceModel.getName());
            dvdRepositoryModel.setGenre(dvdServiceModel.getGenre());
            dvdRepositoryModel.setQuantity(dvdServiceModel.getQuantity());
            dvdRepositoryModel.setPrix(dvdServiceModel.getPrix());
            dvdRepositoryModel.setPhoto(dvdServiceModel.getPhoto());
            dvdRepositoryModel.setDescription(dvdServiceModel.getDescription());
            dvdRepositoryInterface.save(dvdRepositoryModel);
            return dvdServiceModel != null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public ArrayList<DvdServiceModel> getAll() {

        ArrayList<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        ArrayList<DvdRepositoryModel> dvdRepositoryModelsArrayList = dvdRepositoryInterface.findAll();
        for (DvdRepositoryModel x : dvdRepositoryModelsArrayList) {
            dvdServiceModels.add(new DvdServiceModel(Optional.ofNullable(x.getId()),x.getName(), x.getGenre(),x.getQuantity(), x.getPrix(), x.getPhoto(), x.getDescription()));
        }
        return dvdServiceModels;
    }

    /**
     * Gets dvd by id.
     *
     * @param id the id
     * @return the dvd by id
     */
    public DvdServiceModel getDvdById(Long id) {
        DvdRepositoryModel dvdRepositoryModel = dvdRepositoryInterface.findById(id).get();
        return new DvdServiceModel(Optional.ofNullable(dvdRepositoryModel.getId()),dvdRepositoryModel.getName(), dvdRepositoryModel.getGenre(),dvdRepositoryModel.getQuantity(),dvdRepositoryModel.getPrix(),dvdRepositoryModel.getPhoto(),dvdRepositoryModel.getDescription());
    }

    /**
     * Gets dvd by name.
     *
     * @param name the name
     * @return the dvd by name
     */
    public DvdServiceModel getDvdByName(String name) {
        DvdRepositoryModel dvdRepositoryModel = dvdRepositoryInterface.findByName(name).get(0);
        return new DvdServiceModel(Optional.ofNullable(dvdRepositoryModel.getId()),dvdRepositoryModel.getName(), dvdRepositoryModel.getGenre(),dvdRepositoryModel.getQuantity(),dvdRepositoryModel.getPrix(), dvdRepositoryModel.getPhoto(),dvdRepositoryModel.getDescription());
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Long id) {
        dvdRepositoryInterface.deleteById(id);
    }
}
