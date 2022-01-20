package org.capgemini.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CateringOderingNonveg")
public class CateringOrderingNonveg {
	//CateringOrderingNonveg info- orderId,userId,type,thali,quantity,userAddress,dabbaAddress,subscription,cost
	@Id//primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Auto generating orderId
	private long orderId;
	@Column(name="userID")
	private long userId;
	@Column(name="type")
	private String type;
	@Column(name="thali")
	private String thali;
	@Column(name="quantity")
	private String quantity;
	@Column(name="useraddress")
	private String userAddress;
	@Column(name="dabbaaddress")
	private String dabbaAddress;
	@Column(name="subscription")
	private int subscription;
	@Column(name="cost")
	private double cost;
	@Column(name="time")
	Date time=new Date( );
	
	//Default Constructor
	public CateringOrderingNonveg() {
		super();
	}
	
	//Parameterized Constructor
	public CateringOrderingNonveg(long orderId, long userId, String type, String thali, String quantity, String userAddress,
			String dabbaAddress, int subscription, double cost) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.type = type;
		this.thali = thali;
		this.quantity = quantity;
		this.userAddress = userAddress;
		this.dabbaAddress = dabbaAddress;
		this.subscription = subscription;
		this.cost = cost;
	}
	
	//Getters and Setters method
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getThali() {
		return thali;
	}
	public void setThali(String thali) {
		this.thali = thali;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getDabbaAddress() {
		return dabbaAddress;
	}
	public void setDabbaAddress(String dabbaAddress) {
		this.dabbaAddress = dabbaAddress;
	}
	public int getSubscription() {
		return subscription;
	}
	public void setSubscription(int subscription) {
		this.subscription = subscription;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
