package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("dvds")
public class DvdStoreController {

    @Autowired
    DvdStoreService dvdStoreService;

    @GetMapping
    public ArrayList<DvdStoreGetDTO> getAll() {
        ArrayList<DvdStoreGetDTO> dvdStoreDTOs = new ArrayList<>();
        ArrayList<DvdServiceModel> dvdServiceModelArrayList = dvdStoreService.getAll();
        for (DvdServiceModel x : dvdServiceModelArrayList) {
            dvdStoreDTOs.add(new DvdStoreGetDTO(x.getName(), x.getGenre(),x.getQuantity(),x.getPrix(), x.getId().get()));
        }
        return dvdStoreDTOs;
    }

    @GetMapping("/{id}")
    public DvdStoreGetDTO getDvdById(@PathVariable Long id) {
        DvdServiceModel dvdServiceModel = dvdStoreService.getDvdById(id);
        return new DvdStoreGetDTO(dvdServiceModel.getName(), dvdServiceModel.getGenre(),dvdServiceModel.getQuantity(), dvdServiceModel.getPrix(), dvdServiceModel.getId().get());
    }

    @GetMapping("/name/{name}")
    public DvdStoreGetDTO getDvdByName(@PathVariable String name) {
        DvdServiceModel dvdServiceModel = dvdStoreService.getDvdByName(name);
        return new DvdStoreGetDTO(dvdServiceModel.getName(), dvdServiceModel.getGenre(),dvdServiceModel.getQuantity(),dvdServiceModel.getPrix(), dvdServiceModel.getId().get());
    }

    @PostMapping
    public boolean add(@RequestBody DvdStoreGetDTO dvdStoreGetDTO) {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreGetDTO.getName(), dvdStoreGetDTO.getGenre(),dvdStoreGetDTO.getQuantity(),dvdStoreGetDTO.getPrix(), Optional.ofNullable(dvdStoreGetDTO.getId()));
        return dvdStoreService.add(dvdServiceModel);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable Long id) {
        dvdStoreService.delete(id);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody DvdStoreDTO dvdStoreDTO) {
        return dvdStoreService.update(id, new DvdServiceModel(dvdStoreDTO.getName(), dvdStoreDTO.getGenre(), dvdStoreDTO.getQuantity(),dvdStoreDTO.getPrix(), Optional.ofNullable(id)));
    }

}

