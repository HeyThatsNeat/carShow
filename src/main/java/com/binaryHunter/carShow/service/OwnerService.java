package com.binaryHunter.carShow.service;

import com.binaryHunter.carShow.entity.Owner;

import java.util.List;

public interface OwnerService {
  List<Owner> getOwners();

  Owner getOwnerById(Long id);

  Owner addOwner(Owner owner);

  void deleteOwner(Long id);

  Owner updateOwnerById(Long id, Owner owner);
}
