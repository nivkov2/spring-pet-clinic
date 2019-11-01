package com.petclinic.springpetclinic.services.map;

import com.petclinic.springpetclinic.model.Specialty;
import com.petclinic.springpetclinic.model.Vet;
import com.petclinic.springpetclinic.services.SpecialtyService;
import com.petclinic.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapServices<Vet, Long> implements VetService {

  private final SpecialtyService specialtyService;

  public VetServiceMap(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Vet object) {
    super.delete(object);
  }

  @Override
  public Vet save(Vet object) {
    if(object.getSpecialties().size() > 0){
      object.getSpecialties().forEach( specialty -> {
        if(specialty.getId() == null){
          Specialty savedSpecialty = specialtyService.save(specialty);
          specialty.setId(savedSpecialty.getId());
        }
      });

    }
    return super.save(object);
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
