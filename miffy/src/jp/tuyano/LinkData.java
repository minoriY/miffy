package jp.tuyano;

import java.net.URL;
import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class LinkData {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String title;

	@Persistent
	private String date;

	@Persistent
	private String place;
	
	@Persistent
	private String detail;
	
	@Persistent
	private String member;

	@Persistent
	private Date datetime;

	public LinkData(String title, String date, String place, String detail, String member, Date datetime) {
		super();
		this.title = title;
		this.date = date;
		this.place = place;
		this.detail = detail;
		this.member = member;
		this.datetime = datetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
