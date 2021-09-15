package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/** @author yeison */
public class ConnectionService {

  /**
   * @param lugar
   * @return
   */
  public String HTTPConnection(String as_lugar) {
    StringBuilder lsb_rta;

    lsb_rta = new StringBuilder();
    try {
      StringBuilder lsb_urlString;
      String ls_urlApi;
      String ls_idApi;

      lsb_urlString = new StringBuilder();
      ls_urlApi = "https://api.openweathermap.org/data/2.5/weather?q=";
      ls_idApi = "&appid=58d751474603bff74ebd559023792d9f";

      if (as_lugar != null && !as_lugar.isEmpty()) {

        lsb_urlString.append(ls_urlApi);
        lsb_urlString.append(as_lugar);
        lsb_urlString.append(ls_idApi);

        URL lurl_url = new URL(lsb_urlString.toString());
        if (lurl_url != null) {
          HttpURLConnection lhuc_connection = (HttpURLConnection) lurl_url.openConnection();
          if (lhuc_connection != null) {

            lhuc_connection.setRequestMethod("GET");
            InputStreamReader lisr_isr;
            lisr_isr = new InputStreamReader(lhuc_connection.getInputStream());
            if (lisr_isr != null) {

              BufferedReader lbr_bufferedReader;
              lbr_bufferedReader = new BufferedReader(lisr_isr);
              if (lbr_bufferedReader != null) {

                String line;
                while ((line = lbr_bufferedReader.readLine()) != null) {
                  lsb_rta.append(line);
                }
                lbr_bufferedReader.close();
              }
            }
          }
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    return lsb_rta.toString();
  }
}
