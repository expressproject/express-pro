package com.weatherexpress.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {

	@Column(name = "cart_id")
	private int cartId;
}
