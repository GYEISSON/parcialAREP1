package edu.escuelaing.arep;

import java.util.concurrent.ConcurrentHashMap;

/** @author yeiso */
public class Cache {
  /** */
  private ConcurrentHashMap<String, String> dic = new ConcurrentHashMap<String, String>();
  /** */
  private ConnectionService cs;

  Cache() {
    cs = new ConnectionService();
  }

  /**
   * @param lugar
   * @return
   */
  public String inCache(String lugar) {

    if (!dic.containsKey(lugar)) {
      dic.put(lugar, cs.HTTPConnection(lugar));
    }

    return dic.get(lugar);
  }
}
