package com.jbarragan.jcastro.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("route")
@Scope("request")
public class RouteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3672625811832786351L;

	private Date today;

	@PostConstruct
	private void initialize() {
		today = new Date();
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

}
