package com.ahead.springboot.beans;

import lombok.Data;

import java.io.Serializable;

@Data
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String departmentName;
}
