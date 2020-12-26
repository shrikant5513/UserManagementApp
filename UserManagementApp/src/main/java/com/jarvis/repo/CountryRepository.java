package com.jarvis.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.model.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable> {

}
