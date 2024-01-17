package com.binaryHunter.carShow.service;

import com.binaryHunter.carShow.entity.Owner;
import com.binaryHunter.carShow.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{
  private final OwnerRepository ownerRepository;

  public OwnerServiceImpl(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public List<Owner> getOwners() {
    return ownerRepository.findAll();
  }

  @Override
  public Owner getOwnerById(Long id) {
    Optional<Owner> optionalOwner = ownerRepository.findById(id);
    if (optionalOwner.isPresent()) {
      return optionalOwner.get();
    } else {
      throw new EntityNotFoundException("owner with id " + id + " not found");
    }
  }

  public Owner addOwner(Owner owner) {
    return ownerRepository.save(owner);
  }

  @Override
  public void deleteOwner(Long id) {
    ownerRepository.deleteById(id);
  }

  @Override
  public Owner updateOwnerById(Long id, Owner owner) {
    Owner existingOwner = getOwnerById(id);
    existingOwner.setFirstName(owner.getFirstName());
    existingOwner.setLastName(owner.getLastName());
    ownerRepository.save(existingOwner);
    return existingOwner;
  }

}
