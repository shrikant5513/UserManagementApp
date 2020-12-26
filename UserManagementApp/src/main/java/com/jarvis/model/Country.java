package com.jarvis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

import lombok.Data;

@Data
@Entity
@Table(name = "COUNTRY_MASTER")
public class Country {

	@Id
	private Integer countryId;
	private String CountryName;
	
}
