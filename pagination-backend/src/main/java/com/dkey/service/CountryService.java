package com.dkey.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dkey.entity.Country;
import com.dkey.repository.CountryRepository;

@Service
@Transactional
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	
	public Page<Country> getPagedResult(Pageable pageable){
		return countryRepository.findAll(pageable);
	}
}
