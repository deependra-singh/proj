package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the post_details database table.
 * 
 */
@Entity
@Table(name = "post_details")
@NamedQuery(name = "PostDetail.findAll", query = "SELECT p FROM PostDetail p")
public class PostDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	@Column(name = "post_from_name")
	private String postFromName;

	@Column(name = "post_message")
	private String postMessage;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "post_send_date")
	private Date postSendDate;

	// bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name = "userDetailId")
	private UserDetail userDetail;

	

	@Column(name = "approve_status",columnDefinition="bit(1) default 0")
    private boolean approveStatus;
	
	public PostDetail() {
	}

	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostFromName() {
		return this.postFromName;
	}

	public void setPostFromName(String postFromName) {
		this.postFromName = postFromName;
	}

	public String getPostMessage() {
		return this.postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public Date getPostSendDate() {
		return this.postSendDate;
	}

	public void setPostSendDate(Date postSendDate) {
		this.postSendDate = postSendDate;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	

	public boolean isApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(boolean approveStatus) {
		this.approveStatus = approveStatus;
	}

	@Override
	public String toString() {
		return "PostDetail [postId=" + postId + ", postFromName=" + postFromName + ", postMessage=" + postMessage
				+ ", postSendDate=" + postSendDate + ", approveStatus=" + approveStatus + "]";
	}

	
	
}