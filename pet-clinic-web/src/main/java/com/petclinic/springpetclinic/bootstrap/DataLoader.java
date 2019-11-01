package com.petclinic.springpetclinic.bootstrap;

import com.petclinic.springpetclinic.model.Owner;
import com.petclinic.springpetclinic.model.Pet;
import com.petclinic.springpetclinic.model.PetType;
import com.petclinic.springpetclinic.model.Vet;
import com.petclinic.springpetclinic.services.OwnerService;
import com.petclinic.springpetclinic.services.PetTypeService;
import com.petclinic.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Dog");
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("address bla bla");
        owner1.setCity("sity bla bla");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDog);
        mikesPet.setOwner(owner1);
        mikesPet.setLocaleDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenane");
        owner1.setAddress("address bla bla");
        owner1.setCity("sity bla bla");
        owner1.setTelephone("123123123");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCat);
        fionasCat.setOwner(owner2);
        fionasCat.setLocaleDate(LocalDate.now());
        fionasCat.setName("Cotsco ");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded owners.....");

        Vet vet = new Vet();
        vet.setFirstName("Fiona");
        vet.setLastName("Glenane");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets.....");

    }
}
