package com.shoppingcart.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Office;
import com.shoppingcart.app.repository.OfficeRepository;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.OfficeService;
@Service
public class OfficeServiceImpl implements OfficeService{
	
	@Autowired
	private OfficeRepository officeRepository;
	

	@Override
	public List<Office> findAll() {
		
		return officeRepository.findAll();
	}

	@Override
	public MessageResponse save(Office office) {
		Office newOffice = new Office();
		newOffice.setCity(office.getCity());
		newOffice.setPhone(office.getPhone());
		newOffice.setAddressLine1(office.getAddressLine1());
		newOffice.setAddressLine2(office.getAddressLine2());
		newOffice.setState(office.getState());
		newOffice.setCountry(office.getCountry());
		newOffice.setPostalCode(office.getPostalCode());
		newOffice.setTerritory(office.getTerritory());
		officeRepository.save(newOffice);
		
		return  new MessageResponse("New Office record created successfully");

	}

	@Override
	public Optional<Office> getById(long id) {
		
		return officeRepository.findById(id);
		
		}

	@Override
	public List<Office> sortedByState(Office officedetails) {
		return officeRepository.findAllSortedByState();
	}

	@Override
	public List<Office> getByCity(String city) {
		return officeRepository.findByCity(city);
	}

	@Override
	public List<Office> paging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Office> list =officeRepository.findOffices(pageable);
		return list;
	}
	@Override
	public Iterable<Office> sorting(Office officedetails) {
		String sortBy = "Phone_no.";
		List<Office> list = (List<Office>) officeRepository.sortOffice(Sort.by(Sort.Direction.ASC,sortBy));
		return list;
	}

	@Override
	public Office update(Office office) {
		return officeRepository.save(office);
	}

	@Override
	public MessageResponse deleteById(long id) {
		officeRepository.findById(id);
		 
		officeRepository.deleteById(id);
			 
		 return new MessageResponse("Office record deleted successfully");

		 }

	
	}