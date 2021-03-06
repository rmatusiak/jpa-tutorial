package com.acme.order.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document
@Table(name = "customer_t")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private CustomerType customerType;

}
