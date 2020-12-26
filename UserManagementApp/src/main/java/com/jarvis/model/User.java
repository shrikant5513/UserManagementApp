package com.jarvis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_MASTER")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name ="EMAIL_ID", unique = true )
	private String emailId;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PHONE_NO")
	private String PhoneNo;
	
	@Column(name = "DATE_OF_BIRTH")
	private Integer dob;
	
	@Column(name = "ACCOUNT_STATUS")
	private String accountStatus;
	
	@Column(name ="COUNTRY")
	private Integer country;
	
	@Column(name ="STATE")
	private Integer state;
	
	@Column(name ="CITY")
	private Integer city;
	
}
