package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * The persistent class for the events_details database table.
 * 
 */
@Entity
@Table(name = "events_details")

@NamedQueries({
	@NamedQuery(name = "EventsDetail.findAll", query = "SELECT v FROM EventsDetail v ORDER BY v.eventDate DESC"),
    @NamedQuery(name = "listEventsDetailByUser", query = "select v from EventsDetail v where v.userDetail=:userDetail")
})

public class EventsDetail implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name = "approve_status",columnDefinition="bit(1) default 0")
    private boolean approveStatus;
	
	public boolean isApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(boolean approveStatus) {
		this.approveStatus = approveStatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private int eventId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date eventDate;

	@Column(name = "event_description")
	private String eventDescription;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_time")
	private String eventTime;

	@Column(name = "event_venue")
	private String eventVenue;

	// bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name = "userDetailId")
	private UserDetail userDetail;

	public EventsDetail() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventDescription() {
		return this.eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventTime() {
		return this.eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventVenue() {
		return this.eventVenue;
	}

	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}