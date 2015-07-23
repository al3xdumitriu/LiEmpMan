package org.employee_manager.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Account;
import org.employee_manager.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("account")
public class AccountRestService {

	@Autowired
	private AccountService accountService;

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllAccounts() {

		List<Account> accountList = accountService.findAll();

		return Response.ok(accountList).build();
	}
}
