package com.dkey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dkey.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
