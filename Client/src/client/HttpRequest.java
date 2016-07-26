package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpRequest {

    private final String USER_AGENT = "";

//    public static void main(String[] args) throws Exception {
//
//        HttpRequest http = new HttpRequest();
//
//        //System.out.println("Testing 1 - Send Http GET request");
//        http.sendGet();
//
//        //      System.out.println("\nTesting 2 - Send Http POST request");
//        //      http.sendPost();
//
//    }

    // HTTP GET request
        public String sendGet() throws Exception {

        String url = "http://indyvision-storage.appspot.com/phrase_classic?action=get&target=excuse_generator&filter=abc&format=text";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        //  System.out.println("\nSending 'GET' request to URL : " + url);
        //  System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            //System.out.println(inputLine);
//            boolean insideQuotes = false;
//            for (int i =0 ; i < inputLine.length(); i++)
//            {
//                if(inputLine.charAt(i)== '"' && !insideQuotes)
//                {
//                    insideQuotes = true;
//                }
//                if(inputLine.charAt(i)== '"' && insideQuotes)
//                {
//                    insideQuotes = false;
//                }
//                if (insideQuotes)
//                    response.append(inputLine.charAt(i));
//            }
//
        response.append((String)inputLine);
        }
        in.close();

        //print result
        // System.out.println(response.toString());
        return response.toString();

    }

}