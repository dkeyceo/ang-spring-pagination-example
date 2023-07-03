package com.dkey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dkey.entity.Country;
import com.dkey.service.CountryService;

@RestController
@CrossOrigin(origins = "*")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/pages")
	public ResponseEntity<Page<Country>> getPagedResult(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String order,
			@RequestParam(defaultValue = "true") boolean asc) {
		Page<Country> pagedCountries = countryService.getPagedResult(PageRequest.of(page, size, Sort.by(order)));
		if (!asc) {
			pagedCountries = countryService.getPagedResult(PageRequest.of(page, size, Sort.by(order).descending()));
		}
		return new ResponseEntity<Page<Country>>(pagedCountries, HttpStatus.OK);
	}

}
