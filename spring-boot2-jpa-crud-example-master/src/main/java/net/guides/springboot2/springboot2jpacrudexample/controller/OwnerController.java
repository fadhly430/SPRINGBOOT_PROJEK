package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Owner;
import net.guides.springboot2.springboot2jpacrudexample.repository.OwnerRepository;

@RestController
@RequestMapping("/api/v1")
public class OwnerController {
	@Autowired
	private OwnerRepository ownerRepository;

	@GetMapping("/owners")
	public List<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}

	@GetMapping("/owners/{id}")
	public ResponseEntity<Owner> getOwnerById(@PathVariable(value = "id") Long ownerId)
			throws ResourceNotFoundException {
		Owner owner = ownerRepository.findById(ownerId)
				.orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + ownerId));
		return ResponseEntity.ok().body(owner);
	}

	@PostMapping("/owners")
	public Owner createOwner(@Valid @RequestBody Owner owner) {
		return ownerRepository.save(owner);
	}

	@PutMapping("/owners/{id}")
	public ResponseEntity<Owner> updateOwner(@PathVariable(value = "id") Long ownerId,
			@Valid @RequestBody Owner ownerDetails) throws ResourceNotFoundException {
		Owner owner = ownerRepository.findById(ownerId)
				.orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + ownerId));

		owner.setUserName(ownerDetails.getUserName());
		owner.setEmailId(ownerDetails.getEmailId());
		owner.setPasswordUser(ownerDetails.getPasswordUser());
		
		final Owner updatedOwner = ownerRepository.save(owner);
		return ResponseEntity.ok(updatedOwner);
	}

	@DeleteMapping("/owners/{id}")
	public Map<String, Boolean> deleteOwner(@PathVariable(value = "id") Long ownerId)
			throws ResourceNotFoundException {
		Owner owner = ownerRepository.findById(ownerId)
				.orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + ownerId));

		ownerRepository.delete(owner);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
