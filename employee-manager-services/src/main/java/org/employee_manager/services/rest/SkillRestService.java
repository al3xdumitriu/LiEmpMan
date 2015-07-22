package org.employee_manager.services.rest;

import javax.ws.rs.Path;

@Path("skill")
public class SkillRestService {

	
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
