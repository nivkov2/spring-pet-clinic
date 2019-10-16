package com.petclinic.springpetclinic.services.map;

import com.petclinic.springpetclinic.model.Pet;
import com.petclinic.springpetclinic.services.PetService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapServices<Pet, Long> implements PetService {

  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Pet object) {
    super.delete(object);
  }

  @Override
  public Pet save(Pet object) {
    return super.save( object);
  }

  @Override
  public Pet findById(Long id) {
    return findById(id);
  }
}
