package org.employee_manager.services.rest;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.employee_manager.model.Account;
import org.employee_manager.model.Employee;
import org.employee_manager.services.AccountService;
import org.employee_manager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

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
		String secret = "6LdjuAoTAAAAAKZVEikePF0gpEuabkaal0gGIkZ2";
		try {
			JsonObject jsonObject=this.validateCaptcha(secret, account.getCapchaAnswer(), "user_ip_address");
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
	
	private JsonObject validateCaptcha(String secret, String response, String remoteip)
	{
	    JsonObject jsonObject = null;
	    URLConnection connection = null;
	    InputStream is = null;
	    String charset = java.nio.charset.StandardCharsets.UTF_8.name();

	    String url = "https://www.google.com/recaptcha/api/siteverify";
	    try {            
	        String query = String.format("secret=%s&response=%s&remoteip=%s", 
	        URLEncoder.encode(secret, charset), 
	        URLEncoder.encode(response, charset),
	        URLEncoder.encode(remoteip, charset));

	        connection = new URL(url + "?" + query).openConnection();
	        is = connection.getInputStream();
	        JsonReader rdr = Json.createReader(is);
	        jsonObject = rdr.readObject();

	    } catch (IOException ex) {
	    	System.out.println(ex.getStackTrace());
	        //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally {
	        if (is != null) {
	            try {
	                is.close();
	            } catch (IOException e) {
	            }

	        }
	    }
	    return jsonObject;
	}
	
}
