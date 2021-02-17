package edu.escuelaing.arep;

import static spark.Spark.*;

import java.text.ParseException;
import java.util.Scanner;

import org.eclipse.jetty.util.log.Log;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import spark.Request;
import spark.Response;
/**
 * Hello Spark!
 *
 *  web app  Heroku using SparkWeb
 *
 * @author daniel
 * modified by @author Yeisson Gualdron
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello Clima!" );
        port(getPort());
        get("/clima", (req, res) -> inputDataPage(req, res));

    }
    private static JSONObject inputDataPage(Request req, Response res) throws org.json.simple.parser.ParseException {
    	String lugar = req.queryParams("lugar");
    	System.out.println(lugar);
    	ConnectionService cs = new ConnectionService();
    	String  j =  cs.HTTPConnection(lugar);
    	System.out.println(j);
    	JSONObject json2 = new JSONObject("");

    	JSONParser parser = new JSONParser(); 
    	json2 = (JSONObject) parser.parse(j);

    	
        return json2;
    }
    
    public static  int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        
        return 4567;
    }

}
