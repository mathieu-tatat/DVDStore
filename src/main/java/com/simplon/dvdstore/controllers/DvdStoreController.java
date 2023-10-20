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

/**
 * The type Dvd store controller.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("dvds")
//@PreAuthorize("isAuthenticated()" )
public class DvdStoreController {

    /**
     * The Dvd store service.
     */
    @Autowired
    DvdStoreService dvdStoreService;


    /**
     * Add boolean.
     *
     * @param dvdStoreGetDTO the dvd store get dto
     * @return the boolean
     */
    @PostMapping
    public boolean add(@RequestBody AuthRequestDto.DvdStoreGetDTO dvdStoreGetDTO) {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(dvdStoreGetDTO.getId()), dvdStoreGetDTO.getName(), dvdStoreGetDTO.getGenre(),dvdStoreGetDTO.getQuantity(),dvdStoreGetDTO.getPrix(), dvdStoreGetDTO.getPhoto(),dvdStoreGetDTO.getDescription());
        return dvdStoreService.add(dvdServiceModel);
    }


    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ArrayList<AuthRequestDto.DvdStoreGetDTO> getAll() {
        ArrayList<AuthRequestDto.DvdStoreGetDTO> dvdStoreDTOs = new ArrayList<>();
        ArrayList<DvdServiceModel> dvdServiceModelArrayList = dvdStoreService.getAll();
        for (DvdServiceModel x : dvdServiceModelArrayList) {
            dvdStoreDTOs.add(new AuthRequestDto.DvdStoreGetDTO(x.getName(), x.getGenre(),x.getQuantity(),x.getPrix(),x.getPhoto(), x.getDescription() ,x.getId().get()));
        }
        return dvdStoreDTOs;
    }

    /**
     * Gets dvd by id.
     *
     * @param id the id
     * @return the dvd by id
     */
    @GetMapping("/{id}")
    public AuthRequestDto.DvdStoreGetDTO getDvdById(@PathVariable Long id) {
        DvdServiceModel dvdServiceModel = dvdStoreService.getDvdById(id);
        return new AuthRequestDto.DvdStoreGetDTO(dvdServiceModel.getName(), dvdServiceModel.getGenre(),dvdServiceModel.getQuantity(), dvdServiceModel.getPrix(), dvdServiceModel.getPhoto(), dvdServiceModel.getDescription(), dvdServiceModel.getId().get());
    }

    /**
     * Gets dvd by name.
     *
     * @param name the name
     * @return the dvd by name
     */
    @GetMapping("name/{name}")
    public AuthRequestDto.DvdStoreGetDTO getDvdByName(@PathVariable String name) {
        DvdServiceModel dvdServiceModel = dvdStoreService.getDvdByName(name);
        return new AuthRequestDto.DvdStoreGetDTO(dvdServiceModel.getName(), dvdServiceModel.getGenre(),dvdServiceModel.getQuantity(),dvdServiceModel.getPrix(), dvdServiceModel.getPhoto(), dvdServiceModel.getDescription(), dvdServiceModel.getId().get());
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id) {
        dvdStoreService.delete(id);
    }

    /**
     * Update boolean.
     *
     * @param id          the id
     * @param dvdStoreDTO the dvd store dto
     * @return the boolean
     */
    @PutMapping("{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody DvdStoreDTO dvdStoreDTO) {
        return dvdStoreService.update(id, new DvdServiceModel(Optional.ofNullable(id),
                dvdStoreDTO.getName(), dvdStoreDTO.getGenre(),
                dvdStoreDTO.getQuantity(),dvdStoreDTO.getPrix(),
                dvdStoreDTO.getPhoto(), dvdStoreDTO.getDescription() ));
    }

}

