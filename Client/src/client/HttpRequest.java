package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpRequest {

    private final String USER_AGENT = "";

    private String formatStringg(String string)
    {
        String finalString = "";
        boolean insideQuotes = false;
        for (int i =0; i< string.length(); i++)
        {
            if (string.charAt(i)=='#' && !insideQuotes)
                insideQuotes = true;
            else if (string.charAt(i)=='#' && insideQuotes)
                insideQuotes = false;
            else if (insideQuotes)
                finalString = finalString.concat(string.charAt(i)+ "");
        }
        return finalString;
    }

    // HTTP GET request
        public String sendGet() throws Exception {

        String url = "http://indyvision-storage.appspot.com/phrase_classic?action=get&target=excuse_generator&filter=abc&format=text";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        //  System.out.println("\nSending 'GET' request to URL : " + url);
        //  System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
        response.append((String)inputLine);
        }
        in.close();
            String response1 = response.toString();
            response1 = response1.replace('"','#');
        System.out.println(response1);
        return formatStringg(response1);

    }

}