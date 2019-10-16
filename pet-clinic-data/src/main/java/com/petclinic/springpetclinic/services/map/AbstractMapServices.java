package com.petclinic.springpetclinic.services.map;

import com.petclinic.springpetclinic.model.BaseEntity;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractMapServices<T extends BaseEntity, ID extends Long> {

  protected Map<Long, T> map = new HashMap<>();

  Set<T> findAll() {
    return new HashSet<>(map.values());
  }

  T findById(ID id) {
    return map.get(id);
  }

  T save(T object) {
    if (object != null) {
      if (object.getId() == null) {
        object.setId(getNextInt());
      }

      map.put(object.getId(), object);
    } else {
      throw new RuntimeException("Object cannot to be null");
    }

    return object;
  }

  void deleteById(ID id) {
    map.remove(id);
  }

  void delete(T object) {
    map.entrySet().removeIf(entry -> entry.getValue().equals(object));
  }

  private Long getNextInt() {

    Long nextId = null;

    try {
      nextId = Collections.max(map.keySet()) + 1;
    } catch (NoSuchElementException e) {
      nextId = 1L;
    }
    return nextId;
  }

}