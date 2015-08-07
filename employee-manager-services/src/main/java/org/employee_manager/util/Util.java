package org.employee_manager.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Util {

	public static JsonObject validateCaptcha(String secret, String response, String remoteip)
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
