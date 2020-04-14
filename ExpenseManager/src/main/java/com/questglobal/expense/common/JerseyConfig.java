package com.questglobal.expense.common;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.questglobal.expense.controllers.ExpenseController;
@Component
@ApplicationPath("/boot-jersey")
public class JerseyConfig  extends ResourceConfig{

	public JerseyConfig() {
		 register(ExpenseController.class);
	}

}
