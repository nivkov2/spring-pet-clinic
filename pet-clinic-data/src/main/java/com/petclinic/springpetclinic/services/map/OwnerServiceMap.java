package com.petclinic.springpetclinic.services.map;

import com.petclinic.springpetclinic.model.Owner;
import com.petclinic.springpetclinic.services.OwnerService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapServices<Owner, Long> implements OwnerService {

  @Override
  public Owner findByLastName(String lastName) {
    return null;
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public void delete(Owner object) {
    super.delete(object);
  }

  @Override
  public Owner save(Owner object) {
    return super.save(object.getId(), object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }
}
