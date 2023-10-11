package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.dto.AuthRequestDto;
import com.simplon.dvdstore.dto.DvdStoreDTO;
import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("dvds")
//@PreAuthorize("isAuthenticated()" )
public class DvdStoreController {

    @Autowired
    DvdStoreService dvdStoreService;


    @PostMapping
    public boolean add(@RequestBody AuthRequestDto.DvdStoreGetDTO dvdStoreGetDTO) {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreGetDTO.getName(), dvdStoreGetDTO.getGenre(),dvdStoreGetDTO.getQuantity(),dvdStoreGetDTO.getPrix(), dvdStoreGetDTO.getPhoto(),dvdStoreGetDTO.getDescription(), Optional.ofNullable(dvdStoreGetDTO.getId()));
        return dvdStoreService.add(dvdServiceModel);
    }


    @GetMapping
    public ArrayList<AuthRequestDto.DvdStoreGetDTO> getAll() {
        ArrayList<AuthRequestDto.DvdStoreGetDTO> dvdStoreDTOs = new ArrayList<>();
        ArrayList<DvdServiceModel> dvdServiceModelArrayList = dvdStoreService.getAll();
        for (DvdServiceModel x : dvdServiceModelArrayList) {
            dvdStoreDTOs.add(new AuthRequestDto.DvdStoreGetDTO(x.getName(), x.getGenre(),x.getQuantity(),x.getPrix(),x.getPhoto(), x.getDescription() ,x.getId().get()));
        }
        return dvdStoreDTOs;
    }

    @GetMapping("/{id}")
    public AuthRequestDto.DvdStoreGetDTO getDvdById(@PathVariable Long id) {
        DvdServiceModel dvdServiceModel = dvdStoreService.getDvdById(id);
        return new AuthRequestDto.DvdStoreGetDTO(dvdServiceModel.getName(), dvdServiceModel.getGenre(),dvdServiceModel.getQuantity(), dvdServiceModel.getPrix(), dvdServiceModel.getPhoto(), dvdServiceModel.getDescription(), dvdServiceModel.getId().get());
    }

    @GetMapping("name/{name}")
    public AuthRequestDto.DvdStoreGetDTO getDvdByName(@PathVariable String name) {
        DvdServiceModel dvdServiceModel = dvdStoreService.getDvdByName(name);
        return new AuthRequestDto.DvdStoreGetDTO(dvdServiceModel.getName(), dvdServiceModel.getGenre(),dvdServiceModel.getQuantity(),dvdServiceModel.getPrix(), dvdServiceModel.getPhoto(), dvdServiceModel.getDescription(), dvdServiceModel.getId().get());
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id) {
        dvdStoreService.delete(id);
    }

    @PutMapping("{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody DvdStoreDTO dvdStoreDTO) {
        return dvdStoreService.update(id, new DvdServiceModel(dvdStoreDTO.getName(), dvdStoreDTO.getGenre(), dvdStoreDTO.getQuantity(),dvdStoreDTO.getPrix(),dvdStoreDTO.getPhoto(), dvdStoreDTO.getDescription(), Optional.ofNullable(id)));
    }

}

