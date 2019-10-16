package com.petclinic.springpetclinic.bootstrap;

import com.petclinic.springpetclinic.model.Owner;
import com.petclinic.springpetclinic.model.Vet;
import com.petclinic.springpetclinic.services.OwnerService;
import com.petclinic.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  @Autowired
  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Glenane");

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
