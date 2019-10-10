package com.petclinic.springpetclinic.model;


import java.time.LocalDate;

public class Pet extends BaseEntity {
    private Owner owner;
    private PetType petType;
    private LocalDate localeDate;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getLocaleDate() {
        return localeDate;
    }

    public void setLocaleDate(LocalDate localeDate) {
        this.localeDate = localeDate;
    }
}
