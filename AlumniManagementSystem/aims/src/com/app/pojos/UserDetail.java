package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the user_details database table.
 *
 */
@Entity
@Table(name = "user_details")
@NamedQuery(name = "UserDetail.findAll", query = "SELECT u FROM UserDetail u")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userDetailId")
	private Long userId;
	
	@Column(name = "user_email", unique = true)
	private String userEmail;
	
	@Column(name = "user_addr")
	private String userAddr;
	
	@Column(name = "user_approve_status")
	private int userApproveStatus;
	
	@Column(name = "user_city")
	private String userCity;
	
	@Column(name = "user_country")
	private String userCountry;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "user_dob")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date userDob;
	
	@Column(name = "user_fname")
	private String userFname;
	
	@Column(name = "user_lname")
	private String userLname;
	
	@Column(name = "user_mobile")
	private String userMobile;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_state")
	private String userState;

	@OneToMany(cascade = CascadeType.ALL/*, mappedBy = "eventId"*/)
	private List<EventsDetail> eventsDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY/*, mappedBy = "postId"*/)
	private List<PostDetail> postDetails;

	@Column(name = "loginType")
	private String loginType;

	public boolean isApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(boolean approveStatus) {
		this.approveStatus = approveStatus;
	}

	@Column(name = "approve_status", columnDefinition = "tinyint(1) default 0")
	private boolean approveStatus;

	@OneToMany(/*mappedBy = "vacancyId", */cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<VacanciesDetail> vacanciesDetails;

	public UserDetail() {
	}

	public String getUserAddr() {
		return this.userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public int getUserApproveStatus() {
		return this.userApproveStatus;
	}

	public void setUserApproveStatus(int userApproveStatus) {
		this.userApproveStatus = userApproveStatus;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserCountry() {
		return this.userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public Date getUserDob() {
		return this.userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

	public String getUserFname() {
		return this.userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return this.userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public List<EventsDetail> getEventsDetails() {
		return this.eventsDetails;
	}

	public void setEventsDetails(List<EventsDetail> eventsDetails) {
		this.eventsDetails = eventsDetails;
	}

	public EventsDetail addEventsDetail(EventsDetail eventsDetail) {
		getEventsDetails().add(eventsDetail);
		eventsDetail.setUserDetail(this);

		return eventsDetail;
	}

	public EventsDetail removeEventsDetail(EventsDetail eventsDetail) {
		getEventsDetails().remove(eventsDetail);
		eventsDetail.setUserDetail(null);

		return eventsDetail;
	}

	public List<PostDetail> getPostDetails() {
		if (this.postDetails == null) {
			this.postDetails = new ArrayList<PostDetail>();
		}
		return this.postDetails;
	}

	public void setPostDetails(List<PostDetail> postDetails) {
		this.postDetails = postDetails;
	}

	public PostDetail addPostDetail(PostDetail postDetail) {
		getPostDetails().add(postDetail);
		postDetail.setUserDetail(this);

		return postDetail;
	}

	public PostDetail removePostDetail(PostDetail postDetail) {
		getPostDetails().remove(postDetail);
		postDetail.setUserDetail(null);

		return postDetail;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public List<VacanciesDetail> getVacanciesDetails() {
		return this.vacanciesDetails;
	}

	public void setVacanciesDetails(List<VacanciesDetail> vacanciesDetails) {
		this.vacanciesDetails = vacanciesDetails;
	}

	public VacanciesDetail addVacanciesDetail(VacanciesDetail vacanciesDetail) {
		getVacanciesDetails().add(vacanciesDetail);
		vacanciesDetail.setUserDetail(this);

		return vacanciesDetail;
	}

	public VacanciesDetail removeVacanciesDetail(VacanciesDetail vacanciesDetail) {
		getVacanciesDetails().remove(vacanciesDetail);
		vacanciesDetail.setUserDetail(null);

		return vacanciesDetail;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + userId + ", userEmail=" + userEmail + ", userAddr=" + userAddr
				+ ", userApproveStatus=" + userApproveStatus + ", userCity=" + userCity + ", userCountry=" + userCountry
				+ ", userDob=" + userDob + ", userFname=" + userFname + ", userLname=" + userLname + ", userMobile="
				+ userMobile + ", userPassword=" + userPassword + ", userState=" + userState + ", loginType="
				+ loginType + ", approveStatus=" + approveStatus + ",]";
	}
}