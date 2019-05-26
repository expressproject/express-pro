package com.weatherexpress.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_intraction_channel",schema = "whether_express")
public class InteractionChannel {
	
	public InteractionChannel() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uic_id")
	private int userInteractionChannelId;
	
	//@Column(name = "user_id")
	//private String usrId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private long phoneNumber;
	
	@Column(name = "website")
	private String website;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "user_id")
	private Users users = new Users();
	
	
	

	public int getUserInteractionChannelId() {
		return userInteractionChannelId;
	}

	public void setUserInteractionChannelId(int userInteractionChannelId) {
		this.userInteractionChannelId = userInteractionChannelId;
	}

	//public String getUsrId() {
	//	return usrId;
	//}

	//public void setUsrId(String usrId) {
	//	this.usrId = usrId;
	//}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "InteractionChannel [userInteractionChannelId=" + userInteractionChannelId + ", usrId=" 
				+ ", email=" + email + ", phoneNumber=" + phoneNumber  + ", website="
				+ website + "]";
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
	
	
	

}
