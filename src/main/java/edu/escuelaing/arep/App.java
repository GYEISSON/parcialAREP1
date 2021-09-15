package edu.escuelaing.arep;

import static spark.Spark.get;
import static spark.Spark.port;

import org.json.simple.parser.ParseException;

import spark.Request;
import spark.Response;
/**
 * Hello Spark!
 *
 * <p>web app Heroku using SparkWeb
 *
 * @author daniel modified by @author Yeisson Gualdron
 */
public class App {

  /** */
  private static Cache cache = new Cache();

  /** @param args */
  public static void main(String[] args) {
    try {
      Integer li_port;

      li_port = getPort();
      System.out.println("Hello Clima!");
      if (li_port != null) {
        String ls_path;

        ls_path = "/clima";
        port(li_port.intValue());
        get(ls_path, (req, res) -> inputDataPage(req, res));
      } else {
        throw new ParseException(1, "El puerto debe tener un valor valido.");
      }
    } catch (ParseException ape_e) {
      System.out.println(ape_e.getMessage());
    }
  }

  /**
   * @param req
   * @param res
   * @return
   * @throws ParseException
   */
  private static String inputDataPage(Request req, Response res) throws ParseException {
    String lugar = req.queryParams("lugar");
    String json = cache.inCache(lugar);
    return json;
  }

  /** @return */
  public static int getPort() {
    if (System.getenv("PORT") != null) {
      return Integer.parseInt(System.getenv("PORT"));
    }

    return 4567;
  }
}
