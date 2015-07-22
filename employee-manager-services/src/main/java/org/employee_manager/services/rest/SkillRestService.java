package org.employee_manager.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.employee_manager.model.Skill;
import org.employee_manager.services.RoleService;
import org.employee_manager.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/skill")
public class SkillRestService {

	@Autowired
	private SkillService skillService;
	
	@Autowired
	private RoleService roleService;
	
	@GET
	@Path("")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Skill> getAllSkills()
	{
		return skillService.findAllSkills();
		
	}
	
	/*@GET
	@Path("{}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SolrDocumentList querySolr() throws SolrServerException, IOException
	{
		SolrClient solr=SolrClientApp.instantiateSolr();
		
		
		SolrQuery parameters = new SolrQuery();
		
		String mQueryString="last_name:Wixon";
		parameters.set("q", mQueryString);
		parameters.set("wt", "json");
		
		QueryResponse response = solr.query(parameters);
	
		List<Person> beans =  (List<Person>)response.getBeans(Person.class);
		
		System.out.println(beans.size());
		SolrDocumentList list = response.getResults();
		
		return list;
		
	}*/
	
	
}
