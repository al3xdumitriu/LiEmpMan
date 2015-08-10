package org.employee_manager.services.rest;



import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.employee_manager.model.Account;
import org.employee_manager.services.AccountService;
import org.employee_manager.services.EmployeeService;
import org.employee_manager.util.Const;
import org.employee_manager.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/account")
public class AccountRestService {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private EmployeeService employeeService;

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAccounts(@QueryParam("username") String username, @QueryParam("password") String password) {

		List<Account> accountsList = null;
		Account account = null;
		Response resultResponse = null;

		// the login method
		if (username != null && password != null) {
			try {
				account = accountService.findAccountByNameAndPassword(username, password);
				if (account == null)
					return Response.status(Response.Status.NO_CONTENT).build();
				account.setRoles(null);
				account.setEmployeeIdJson(account.getEmployeeId().getId());
				resultResponse = Response.status(Response.Status.OK).entity(account).build();
				//JsonObject jsonObject=this.validateCaptcha(secret, account.getCapchaAnswer(), "user_ip_address");
			} catch (Exception e) {
				resultResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
			return resultResponse;

		}

		try {
			accountsList = accountService.findAll();
			for (Account accountIterate : accountsList) {
				accountIterate.setRoles(null);
			}
			resultResponse = Response.status(Response.Status.OK).entity(accountsList).build();
		} catch (Exception e) {
			resultResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

		return resultResponse;
	}

	@POST
	@Path("")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
	public Response saveAccount(Account account) {

		Response resultResponse = null;
		String secret = Const.CAPCHA_PRIVATE_KEY;
		try {
			JsonObject jsonObject=Util.validateCaptcha(secret, account.getCapchaAnswer(), "user_ip_address");
			if(jsonObject.getBoolean("success") ==equals(true) );
			accountService.save(account);
			employeeService.save(account.getEmployeeId());
			resultResponse = Response.status(Response.Status.CREATED).entity(jsonObject).build();
		} catch (Exception e) {
			resultResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return resultResponse;
	}

	@GET
	@Path("{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccount(@PathParam("accountId") String accountId) {

		Account account = null;
		Response resultResponse = null;

		try {
			account = accountService.findById(Long.parseLong(accountId));
			account.setRoles(null);
			resultResponse = Response.status(Response.Status.OK).entity(account).build();
		} catch (Exception e) {
			resultResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return resultResponse;
	}
	
	
}
