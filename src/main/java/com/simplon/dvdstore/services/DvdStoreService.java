package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class DvdStoreService {
    @Autowired
    DvdRepositoryInterface dvdRepositoryInterface;




    public boolean add(DvdServiceModel dvdServiceModel) {
        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(dvdServiceModel.getName(), dvdServiceModel.getGenre(), dvdServiceModel.getQuantity(), dvdServiceModel.getPrix(),dvdServiceModel.getPhoto());
        DvdRepositoryModel dvdRepositoryModelReturned = dvdRepositoryInterface.save(dvdRepositoryModel);
        return dvdRepositoryModelReturned != null;
    }

    public boolean update(@PathVariable Long id, @RequestBody DvdServiceModel dvdServiceModel) {
        try {
            DvdRepositoryModel dvdRepositoryModel = dvdRepositoryInterface.findById(id).get();
            dvdRepositoryModel.setName(dvdServiceModel.getName());
            dvdRepositoryModel.setGenre(dvdServiceModel.getGenre());
            dvdRepositoryModel.setQuantity(dvdServiceModel.getQuantity());
            dvdRepositoryModel.setPrix(dvdServiceModel.getPrix());
            dvdRepositoryModel.setPhoto(dvdServiceModel.getPhoto());
            dvdRepositoryInterface.save(dvdRepositoryModel);
            return dvdServiceModel != null;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<DvdServiceModel> getAll() {

        ArrayList<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        ArrayList<DvdRepositoryModel> dvdRepositoryModelsArrayList = dvdRepositoryInterface.findAll();
        for (DvdRepositoryModel x : dvdRepositoryModelsArrayList) {
            dvdServiceModels.add(new DvdServiceModel(x.getName(), x.getGenre(),x.getQuantity(),x.getPrix(), x.getPhoto(),Optional.ofNullable(x.getId())));
        }
        return dvdServiceModels;
    }

    public DvdServiceModel getDvdById(Long id) {
        DvdRepositoryModel dvdRepositoryModel = dvdRepositoryInterface.findById(id).get();
        return new DvdServiceModel(dvdRepositoryModel.getName(), dvdRepositoryModel.getGenre(),dvdRepositoryModel.getQuantity(),dvdRepositoryModel.getPrix(),dvdRepositoryModel.getPhoto(), Optional.ofNullable(dvdRepositoryModel.getId()));
    }

    public DvdServiceModel getDvdByName(String name) {
        DvdRepositoryModel dvdRepositoryModel = dvdRepositoryInterface.findByName(name).get(0);
        return new DvdServiceModel(dvdRepositoryModel.getName(), dvdRepositoryModel.getGenre(),dvdRepositoryModel.getQuantity(),dvdRepositoryModel.getPrix(),dvdRepositoryModel.getPhoto(), Optional.ofNullable(dvdRepositoryModel.getId()));
    }

    public void delete(Long id) {
        dvdRepositoryInterface.deleteById(id);
    }
}
