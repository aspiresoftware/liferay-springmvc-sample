package com.aspire.student.util;

import java.io.PrintWriter;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * Utility class manages uses to perform json related functionality
 * @author aspire20
 *
 */
public class JsonServiceUtil {

  public static Logger log = Logger.getLogger(JsonServiceUtil.class);

  /**
   * Write json data in the response
   * 
   * @param writer
   * @param map
   */
  public static void writeJson(PrintWriter writer, Map<String, Object> map) {
    log.debug("in writeJson method");
    Gson gson = new Gson();
    if (writer == null) {
      log.error("writer is null :");
      return;
    }
    try {
      String jsonString = gson.toJson(map);
      log.info("Gson is " + jsonString);
      writer.print(jsonString);
      writer.flush();
    } catch (Exception e) {
      log.error("Error in writeJson object :", e);
    }
  }
}
