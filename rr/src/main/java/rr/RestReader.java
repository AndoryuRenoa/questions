package rr;
/*
* next step make class to overload with json
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

            URL url = new URL("http://mochijump.com/test/returnAll");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
		  // this is strange this while statement:
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
	/*
	     try {
		RectangleClass rC = mapper.readValue(output, RectangleClass.class);
		RectangleClass.save(i);
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (JsonGenerationException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	* ^ If we're accepting all input here we need to start with an array of JSON, then convert the array into individual instances
	* overloading a class which contains the internal values startX, startY, width, height...
	* let's try to get a single rectange first, and print to console the characteristics for that rectangle
	*/
	
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
  }
}