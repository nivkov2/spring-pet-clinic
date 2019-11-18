package com.petclinic.springpetclinic.services.map;

import com.petclinic.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long id = 1l;
    final String lastName = "Rathesh";


    @BeforeEach
    public void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void delete() {
        Owner owner2 = Owner.builder().build();
        ownerServiceMap.save(owner2);
        assertEquals(2, ownerServiceMap.findAll().size());
        ownerServiceMap.delete(owner2);
        assertEquals(1, ownerServiceMap.findAll().size());

    }

    @Test
    void save() {
        Owner owner2 = Owner.builder().build();
        ownerServiceMap.save(owner2);
        assertEquals(2, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        assertEquals(1, ownerServiceMap.findAll().size());
        Set<Owner> all = ownerServiceMap.findAll();
        ownerServiceMap.deleteById(all.iterator().next().getId());
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(id);
        assertEquals(id, owner.getId());
    }


    @Test
    void findByLastName() {
        Owner owner = Owner.builder().build();
        owner.setLastName(lastName);
        ownerServiceMap.save(owner);
        assertNotNull(ownerServiceMap.findByLastName(lastName));
        assertEquals(lastName, ownerServiceMap.findByLastName(lastName).getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        assertNull(ownerServiceMap.findByLastName("foo"));
    }

}