package com.ahead.springboot.beans;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String lastName;
	private String email;
	/**
	 * 性别 1男  0女
	 */
	private Integer gender;
	private Integer dId;
	
	

}
