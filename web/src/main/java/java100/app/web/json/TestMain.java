package java100.app.web.json;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.json.XML;


public class TestMain {
    public static int INDENT_FACTOR = 4;
    public static void main(String args[]) throws MalformedURLException,
            IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL("http://14.49.41.130:8880/saramin/job-search").openConnection();
        conn.connect();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("x-waple-authorization", "NDgyLTE1MjAyMzYyODg0MzItNjg3NDZlYWEtN2ZmMi00ODcyLWI0NmUtYWE3ZmYyZTg3MmIw");
        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis));
        StringBuffer st = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            st.append(line);
        }
 
        JSONObject xmlJSONObj = XML.toJSONObject(st.toString());
        String jsonPrettyPrintString = xmlJSONObj.toString(INDENT_FACTOR);
        System.out.println(jsonPrettyPrintString);
 
    }
}
 