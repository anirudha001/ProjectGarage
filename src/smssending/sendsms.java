/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smssending;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import UserInfo.Userinfo;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author acme
 */
public class sendsms {
    
    
    static public boolean   sendMessage(String msg,String mobileNumber)
    {
      try
     {
    mobileNumber = "91"+mobileNumber;        
    URL url;
    HttpURLConnection connection = null;  
    String targetURL="http://smslane.com/vendorsms/pushsms.aspx";
     String urlParameters =
        "user=" + URLEncoder.encode(Userinfo.getUDetails(), "UTF-8") +
        "&password=" + URLEncoder.encode(Userinfo.getPDetails(), "UTF-8")+
        "&msisdn=" + URLEncoder.encode(mobileNumber, "UTF-8")+
        "&msg=" + URLEncoder.encode(msg, "UTF-8")+
        "&sid=" + URLEncoder.encode("WebSMS", "UTF-8")+
        "&fl=" + URLEncoder.encode("0", "UTF-8");
    try {
      //Create connection
      url = new URL(targetURL);
      connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", 
           "application/x-www-form-urlencoded");
			
      connection.setRequestProperty("Content-Length", "" + 
               Integer.toString(urlParameters.getBytes().length));
      connection.setRequestProperty("Content-Language", "en-US");  
			
      connection.setUseCaches (false);
      connection.setDoInput(true);
      connection.setDoOutput(true);

      //Send request
      DataOutputStream wr = new DataOutputStream (
                  connection.getOutputStream ());
      wr.writeBytes (urlParameters);
      wr.flush ();
      wr.close ();
      
      //InputStreamReader is = ;
      BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      StringBuffer res = new StringBuffer(); 
      while((line = rd.readLine()) != null) {
       System.out.println(line);
      }
      rd.close();


    } catch (Exception e) {

      e.printStackTrace();
            return true;  
    } finally {

      if(connection != null) {
        connection.disconnect(); 
      }
    }
     } 
    catch(Exception e)
     {
        System.out.println(e);
        return false;     
     }                             
          return true;   
    }     
    
      
}
