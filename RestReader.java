package rr;
/*
* prior to incorporating this function in my mochijump app I will test it out standing alone first
* could test below first, but I want to use the Jackson API to unmarshal the JSON received, that will need to be included as a dependancy
* Eclipse is very difficult to work with regarding imporing fasterxml you can add the .jar external it's found in user/xxx/.m2/com/etcetc
*
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RestReader {
	
	public static void main(String[] args) {
          try {

            URL url = new URL("http://mochijump.com/test/returnAll");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
  }
}
