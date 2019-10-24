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
import net.guides.springboot2.springboot2jpacrudexample.model.Admin;
import net.guides.springboot2.springboot2jpacrudexample.repository.AdminRepository;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/admins")
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Long adminId)
			throws ResourceNotFoundException {
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
		return ResponseEntity.ok().body(admin);
	}

	@PostMapping("/admins")
	public Admin createAdmin(@Valid @RequestBody Admin admin) {
		return adminRepository.save(admin);
	}

	@PutMapping("/admins/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "id") Long adminId,
			@Valid @RequestBody Admin adminDetails) throws ResourceNotFoundException {
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));

		
		admin.setUserName(adminDetails.getUserName());
		admin.setEmailId(adminDetails.getEmailId());
		admin.setPasswordUser(adminDetails.getPasswordUser());
		
		final Admin updatedAdmin = adminRepository.save(admin);
		return ResponseEntity.ok(updatedAdmin);
	}

	@DeleteMapping("/admins/{id}")
	public Map<String, Boolean> deleteAdmin(@PathVariable(value = "id") Long adminId)
			throws ResourceNotFoundException {
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("admin not found for this id :: " + adminId));

		adminRepository.delete(admin);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
