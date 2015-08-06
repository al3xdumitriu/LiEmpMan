package org.employee_manager.services.rest;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.employee_manager.model.Achievement;
import org.employee_manager.model.Employee;
import org.employee_manager.model.EmployeeProject;
import org.employee_manager.model.Evaluation;
import org.employee_manager.model.Project;
import org.employee_manager.model.Skill;
import org.employee_manager.model.SkillEvaluation;
import org.employee_manager.services.EmployeeService;
import org.employee_manager.services.SkillService;
import org.employee_manager.services.repositories.EmployeeRepository;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.ServiceException;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;
import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

@Path("employee")
public class EmployeeRestService {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SkillService skillService;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@POST
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response saveEmployee(Employee emp) {
		int status = 200;
		try {
			employeeService.save(emp);
			status = 200;
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(emp).build();
		return res;
	}

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllEmployees(@QueryParam("name") String name) {
		List<Employee> allEmployees = new ArrayList<Employee>();
		Response res = null;
		int status = 200;
		try {
			if (name == null) {
				allEmployees = employeeService.findAll();
				res = Response.status(status).entity(allEmployees).build();
			} else {
				allEmployees = employeeService.findByName(name);
			}

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		for (Employee employeeFound : allEmployees) {
			employeeFound.setEmployeeProjects(null);
			employeeFound.setAchievements(null);
			employeeFound.setEvaluations(null);
			employeeFound.setSkills(null);
		}
		res = Response.status(status).entity(allEmployees).build();
		return res;
	}

	@GET
	@Path("{id}/skill")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeSkills(@PathParam("id") String id) throws FileNotFoundException {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();

		List<Skill> skills = new ArrayList<Skill>();

		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				skills.addAll(employeeFound.getSkills());

			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(skills).build();
		return res;
	}

	@GET
	@Path("{id}/project")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeProjects(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();

		List<EmployeeProject> employeeProjects = new ArrayList<EmployeeProject>();
		List<Project> project = new ArrayList<Project>();

		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				employeeProjects.addAll(employeeFound.getEmployeeProjects());

			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(employeeProjects).build();
		return res;
	}

	@GET
	@Path("{id}/evaluation")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeEvaluations(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();

		List<Evaluation> employeeEvaluations = new ArrayList<Evaluation>();

		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				employeeEvaluations.addAll(employeeFound.getEvaluations());

			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(employeeEvaluations).build();
		return res;
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployee(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();
		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {

				employeeFound = employeeService.findById(idParse);
				serialize(employeeFound);
			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(employeeFound).build();
		return res;
	}

	@GET
	@Path("{employeeId}/skills")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getSkillForEmployee(@PathParam("employeeId") String employeeId) {
		Status status = Response.Status.OK;
		Long id = Long.parseLong(employeeId);
		List<Skill> skills = null;

		try {
			skills = skillService.findAllSkillsForEmployee(id);
			for (Skill skill : skills) {
				skill.setEmployeeId(null);
				List<SkillEvaluation> se = skill.getSkillEvaluations();

				for (SkillEvaluation s : se) {
					s.setSkillId(null);
					Evaluation eval = s.getEvaluationId();
					eval.setEmployeeId(null);
				}

			}
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(skills).build();
		return res;
	}

	@POST
	@Path("{employeeId}/skill")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response saveSkill2(@PathParam("employeeId") Long employeeId, Skill skill) {
		Status status = null;
		try {
			skillService.createSkill(employeeId, skill);
			// skill = skillService.saveSkill(skill);
			status = Response.Status.CREATED;
		} catch (Exception e) {
			status = Response.Status.INTERNAL_SERVER_ERROR;
			e.getStackTrace();
		}

		Response res = Response.status(status).entity(skill).build();
		return res;

	}

	@GET
	@Path("{id}/achievement")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeAchievements(@PathParam("id") String id) {
		Long idParse = Long.parseLong(id);
		Employee employeeFound = new Employee();

		List<Achievement> achievements = new ArrayList<Achievement>();

		Response res = null;
		int status = 200;
		try {
			if (id == null) {
				status = 404;
				res = Response.status(status).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				achievements.addAll(employeeFound.getAchievements());

			}
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		res = Response.status(status).entity(achievements).build();
		return res;
	}

	@PUT
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response update(Employee emp) {

		Long idParse = emp.getId();
		Employee employeeFound = new Employee();
		Response res = null;

		try {
			if (idParse == null) {
				res = Response.status(Response.Status.NOT_FOUND).entity(employeeFound).build();
			} else {
				employeeFound = employeeService.findById(idParse);
				employeeService.updateById(emp.getName(), emp.getCnp(), emp.getPhone(), emp.getEmail(),
						emp.getExperienceLevel(), emp.getJobTitle(), emp.getId());
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		res = Response.status(Response.Status.OK).entity(employeeFound).build();
		return res;

	}

	public void serialize(Employee emp) throws IOException, URISyntaxException, ServiceException {

		FileOutputStream fileOut = new FileOutputStream("E://fis.xml");
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("employee", Employee.class);
		xstream.alias("achievements", Achievement.class);

		String xml = xstream.toXML(emp);

		// Object to XML Conversion
		xstream.toXML(emp, fileOut);
		System.out.println("SerializedCountry XML:" + xml);

		// XML to Object Conversion
		System.out.println("Desiarilization");
		Employee deSerializedCountry = (Employee) xstream.fromXML(xml);
		System.out.println(deSerializedCountry.toString());

		String inFile = "E://fis.xml";
		String outFile = "E://fisXSL.xml";
		// File xslFile = new
		// File(getClass().getClassLoader().getResource("cvXML/template.xsl").getFile());
		String xslFile = "E://template.xsl";
		System.out.println(xslFile.toString());
		// apply XSL template to XML file
		applyTemplateXSL(inFile, outFile, xslFile);
		upToAmazon(outFile);

	}

	public void applyTemplateXSL(String inFilename, String outFilename, String xslFilename) {
		try {
			// Create transformer factory
			TransformerFactory factory = TransformerFactory.newInstance();

			// Use the factory to create a template containing the XSL file
			Templates template = factory.newTemplates(new StreamSource(new FileInputStream(xslFilename)));

			// Use the template to create a transformer
			Transformer xformer = template.newTransformer();

			// Prepare the input and output files
			Source source = new StreamSource(new FileInputStream(inFilename));
			Result result = new StreamResult(new FileOutputStream(outFilename));

			// Apply the XSL file to the source file and write the result to the
			// output file
			xformer.transform(source, result);
		} catch (FileNotFoundException e) {
		} catch (TransformerConfigurationException e) {
			// An error occurred in the XSL file
		} catch (TransformerException e) {
			// An error occurred while applying the XSL file
			// Get location of error in input file
			SourceLocator locator = e.getLocator();
			int col = locator.getColumnNumber();
			int line = locator.getLineNumber();
			String publicId = locator.getPublicId();
			String systemId = locator.getSystemId();
		}

	}

	public void upToAmazon(String uploadFile) throws ServiceException, IOException {
		String awsAccessKey = "AKIAJT7FQSI4MYQAXNBQ";
		String awsSecretKey = "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";
		AWSCredentials awsCredentials = new AWSCredentials(awsAccessKey, awsSecretKey);
		S3Service s3Service = new RestS3Service(awsCredentials);
		FileInputStream fis = new FileInputStream(uploadFile);
		ByteArrayOutputStream ous = new ByteArrayOutputStream();

		try {
			byte[] buffer = new byte[4096];
			int read = 0;
			while ((read = fis.read(buffer)) != -1) {
				ous.write(buffer, 0, read);
				S3Object fileToBeImported = new S3Object("key1.xml", ous.toByteArray());
				s3Service.putObject("levi9isintern", fileToBeImported);
			}
		} catch (Exception e) {

			e.getMessage();
		}

		S3Object objectComplete = s3Service.getObject("levi9isintern", "key1.xml");
		System.out.println("S3Object, complete: " + objectComplete.toString());
		System.out.println("Greeting:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(objectComplete.getDataInputStream()));
		String data = null;
		while ((data = reader.readLine()) != null) {
			System.out.println(data);
		}

		// S3Bucket testBucket = s3Service.getOrCreateBucket("levi9isintern");
		// System.out.println("Created test bucket: " + testBucket.getName());
		// S3Bucket[] myBuckets = s3Service.listAllBuckets();
		// System.out.println("How many buckets to I have in S3? " +
		// myBuckets.length);
	}
}
