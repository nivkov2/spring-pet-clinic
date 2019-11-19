package com.petclinic.springpetclinic.services.springdatajpa;

import com.petclinic.springpetclinic.model.Owner;
import com.petclinic.springpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner owner;

    @BeforeEach
    public void setup(){
        owner = Owner.builder().build();
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().build();
        String lastName = "Smith";
        returnOwner.setLastName(lastName);

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner foundOwner = ownerRepository.findByLastName(lastName);
        assertEquals(lastName, foundOwner.getLastName());

        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> set = new HashSet<>();
        set.add(Owner.builder().build());
        set.add(Owner.builder().build());

        when(ownerRepository.findAll()).thenReturn(set);


        Set<Owner> all = (Set<Owner>) ownerRepository.findAll();

        assertEquals(2, all.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));

        assertNotNull(ownerRepository.findById(any()));
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
        ownerRepository.delete(owner);
       verify(ownerRepository, times(1)).delete(owner);
    }

    @Test
    void deleteById() {
        ownerRepository.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(1L);
    }
}