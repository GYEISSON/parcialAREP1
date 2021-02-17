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
	private static Cache cache = new Cache();
	
    public static void main( String[] args )
    {

        System.out.println( "Hello Clima!" );
        port(getPort());
        get("/clima", (req, res) -> inputDataPage(req, res));
        

    }
    private static String inputDataPage(Request req, Response res) throws org.json.simple.parser.ParseException {
    	String lugar = req.queryParams("lugar");
    	String json = cache.inCache(lugar);
        return json;
    }
    
    public static  int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        
        return 4567;
    }

}
