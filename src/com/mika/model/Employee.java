package com.mika.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idUtilisateur")
	private Integer empId;
	
	@Column(name="nomUtilisateur")
	private String empNom;
	
	@Column(name="emailUtilisateur")
	private String empEmail;
	
	@Column(name="passwordUtilisateur")
	private String empPassword;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpNom() {
		return empNom;
	}

	public void setEmpNom(String empNom) {
		this.empNom = empNom;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	

}
