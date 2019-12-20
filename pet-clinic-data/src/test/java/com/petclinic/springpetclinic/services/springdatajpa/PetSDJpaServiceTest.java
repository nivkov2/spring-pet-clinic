package com.petclinic.springpetclinic.services.springdatajpa;

import com.petclinic.springpetclinic.model.Pet;
import com.petclinic.springpetclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetSDJpaService petSDJpaService;

    Pet pet;

    @BeforeEach
    void setUp() {
        pet = Pet.builder().id(1l).build();
    }

    @Test
    void findAll() {
        Set<Pet> pets = new HashSet<>();
        pets.add(Pet.builder().build());
        pets.add(Pet.builder().build());

        when(petRepository.findAll()).thenReturn(pets);

        assertEquals(pets.size(),
                ((Set<Pet>)petRepository.findAll()).size());
    }

    @Test
    void findById() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));
        assertNotNull(petRepository.findById(anyLong()).get());
    }

    @Test
    void save() {
        petRepository.save(pet);
        verify(petRepository, times(1)).save(pet);
    }

    @Test
    void delete() {
        petRepository.delete(pet);
        verify(petRepository, times(1)).delete(pet);
    }

    @Test
    void deleteById() {
        petRepository.deleteById(anyLong());
        verify(petRepository, times(1)).deleteById(anyLong());
    }
}