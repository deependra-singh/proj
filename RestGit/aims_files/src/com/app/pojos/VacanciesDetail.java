package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the vacancies_details database table.
 *
 */
@Entity
@Table(name = "vacancies_details")
@NamedQueries({
		@NamedQuery(name = "VacanciesDetail.findAll", query = "SELECT v FROM VacanciesDetail v WHERE v.approveStatus=true ORDER BY v.vacancyCreateDate DESC"),
		@NamedQuery(name = "listVacanciesDetailByUser", query = "select v from VacanciesDetail v where v.userDetail=:userDetail") })
public class VacanciesDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	public VacanciesDetail() {
	}

	@Column(name = "approve_status", columnDefinition = "bit(1) default 0")
	private boolean approveStatus;
	@Id
	@Column(name = "vacancy_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vacancyId;
	@Column(name = "vacancy_category")
	private String vacancyCategory;
	@Column(name = "vacancy_company")
	private String vacancyCompany;
	@Column(name = "vacancy_contact")
	private String vacancyContact;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vacancy_create_date")
	private Date vacancyCreateDate;
	@Column(name = "vacancy_description")
	private String vacancyDescription;
	@Column(name = "vacancy_designation")
	private String vacancyDesignation;
	@Column(name = "vacancy_email")
	private String vacancyEmail;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "vacancy_expiry_date")
	private Date vacancyExpiryDate;
	@Column(name = "vacancy_location")
	private String vacancyLocation;
	@Column(name = "vacancy_phone")
	private String vacancyPhone;
	@Column(name = "vacancy_position")
	private String vacancyPosition;
	@Column(name = "vacancy_reqexp")
	private String vacancyReqexp;
	@Column(name = "vacancy_requirements")
	private String vacancyRequirements;

	public boolean isApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(boolean approveStatus) {
		this.approveStatus = approveStatus;
	}

	// bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name = "userDetailId")
	private UserDetail userDetail;

	public int getVacancyId() {
		return this.vacancyId;
	}

	public void setVacancyId(int vacancyId) {
		this.vacancyId = vacancyId;
	}

	public String getVacancyCategory() {
		return this.vacancyCategory;
	}

	public void setVacancyCategory(String vacancyCategory) {
		this.vacancyCategory = vacancyCategory;
	}

	public String getVacancyCompany() {
		return this.vacancyCompany;
	}

	public void setVacancyCompany(String vacancyCompany) {
		this.vacancyCompany = vacancyCompany;
	}

	public String getVacancyContact() {
		return this.vacancyContact;
	}

	public void setVacancyContact(String vacancyContact) {
		this.vacancyContact = vacancyContact;
	}

	public Date getVacancyCreateDate() {
		return this.vacancyCreateDate;
	}

	public void setVacancyCreateDate(Date vacancyCreateDate) {
		this.vacancyCreateDate = vacancyCreateDate;
	}

	public String getVacancyDescription() {
		return this.vacancyDescription;
	}

	public void setVacancyDescription(String vacancyDescription) {
		this.vacancyDescription = vacancyDescription;
	}

	public String getVacancyDesignation() {
		return this.vacancyDesignation;
	}

	public void setVacancyDesignation(String vacancyDesignation) {
		this.vacancyDesignation = vacancyDesignation;
	}

	public String getVacancyEmail() {
		return this.vacancyEmail;
	}

	public void setVacancyEmail(String vacancyEmail) {
		this.vacancyEmail = vacancyEmail;
	}

	public Date getVacancyExpiryDate() {
		return this.vacancyExpiryDate;
	}

	public void setVacancyExpiryDate(Date vacancyExpiryDate) {
		this.vacancyExpiryDate = vacancyExpiryDate;
	}

	public String getVacancyLocation() {
		return this.vacancyLocation;
	}

	public void setVacancyLocation(String vacancyLocation) {
		this.vacancyLocation = vacancyLocation;
	}

	public String getVacancyPhone() {
		return this.vacancyPhone;
	}

	public void setVacancyPhone(String vacancyPhone) {
		this.vacancyPhone = vacancyPhone;
	}

	public String getVacancyPosition() {
		return this.vacancyPosition;
	}

	public void setVacancyPosition(String vacancyPosition) {
		this.vacancyPosition = vacancyPosition;
	}

	public String getVacancyReqexp() {
		return this.vacancyReqexp;
	}

	public void setVacancyReqexp(String vacancyReqexp) {
		this.vacancyReqexp = vacancyReqexp;
	}

	public String getVacancyRequirements() {
		return this.vacancyRequirements;
	}

	public void setVacancyRequirements(String vacancyRequirements) {
		this.vacancyRequirements = vacancyRequirements;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public String toString() {
		return "VacanciesDetail [approveStatus=" + approveStatus + ", vacancyId=" + vacancyId + ", vacancyCategory="
				+ vacancyCategory + ", vacancyCompany=" + vacancyCompany + ", vacancyContact=" + vacancyContact
				+ ", vacancyCreateDate=" + vacancyCreateDate + ", vacancyDescription=" + vacancyDescription
				+ ", vacancyDesignation=" + vacancyDesignation + ", vacancyEmail=" + vacancyEmail
				+ ", vacancyExpiryDate=" + vacancyExpiryDate + ", vacancyLocation=" + vacancyLocation
				+ ", vacancyPhone=" + vacancyPhone + ", vacancyPosition=" + vacancyPosition + ", vacancyReqexp="
				+ vacancyReqexp + ", vacancyRequirements=" + vacancyRequirements + "]";
	}

}