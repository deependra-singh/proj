package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * The persistent class for the admin_details database table.
 *
 */
@Entity
@Table(name = "admin_details")
@NamedQuery(name = "AdminDetail.findAll", query = "SELECT f FROM AdminDetail f")
public class AdminDetail extends UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "admin_email", unique = true)
	private String adminEmail;
	@Column(name = "admin_designation")
	private String adminDesignation;
	@Column(name = "admin_emp_code")
	private String adminEmpCode;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "admin_year_of_appointment")
	private Date adminYearOfAppointment;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "admin_year_of_release")
	private Date adminYearOfRelease;
	// bi-directional many-to-one association to ApprovalDetail
	// bi-directional one-to-one association to UserDetail

	public AdminDetail() {
	}

	public String getAdminEmail() {
		return this.adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminDesignation() {
		return this.adminDesignation;
	}

	public void setAdminDesignation(String adminDesignation) {
		this.adminDesignation = adminDesignation;
	}

	public String getAdminEmpCode() {
		return this.adminEmpCode;
	}

	public void setAdminEmpCode(String adminEmpCode) {
		this.adminEmpCode = adminEmpCode;
	}

	public Date getAdminYearOfAppointment() {
		return this.adminYearOfAppointment;
	}

	public void setAdminYearOfAppointment(Date adminYearOfAppointment) {
		this.adminYearOfAppointment = adminYearOfAppointment;
	}

	public Date getAdminYearOfRelease() {
		return this.adminYearOfRelease;
	}

	public void setAdminYearOfRelease(Date adminYearOfRelease) {
		this.adminYearOfRelease = adminYearOfRelease;
	}
}