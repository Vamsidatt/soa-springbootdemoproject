package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Doctor;
import com.klef.soa.repository.DoctorRepository;
@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository repo;
	
	

	@Override
	public Doctor addDoctor(Doctor d) 	{
		// TODO Auto-generated method stub
		return repo.save(d);
		
	}

	@Override
	public Doctor updatDoctor(Doctor d) {
		// TODO Auto-generated method stub
		Optional<Doctor> optional = repo.findById(d.getId());
		if(optional.isPresent()) {
			Doctor doctor=optional.get();
			doctor.setName(d.getName());
			doctor.setSalary(d.getSalary());
			doctor.setExprience(d.getExprience());
			doctor.setContact(d.getContact());
			return repo.save(doctor);
		}else {
			return null;
		}
	}

	@Override
	public List<Doctor> DisplayAllDoctors() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Doctor diaplayDoctorById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteDoctorById(Long id) {
		// TODO Auto-generated method stub
		boolean flag = repo.existsById(id);
		if(flag) {
			repo.deleteById(id);
			return "Doctor Deleted Successfully";
		}else {
			return  "Doctor ID Not Found";
		}
	}

	@Override
	public List<Doctor> DisplayDoctorByGender(String gender) {
		// TODO Auto-generated method stub
		return repo.findByGender(gender);
	}

	@Override
	public Long doctorCount() {
		// TODO Auto-generated method stub
		return repo.count();
	}
	
}
