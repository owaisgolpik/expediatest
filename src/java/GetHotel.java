/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.JsonStreamParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author golpik
 */
@WebServlet(urlPatterns = {"/GetHotel"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetHotel extends HttpServlet {

    public static String service = "http://api.ean.com/ean-services/rs/hotel/";
    public static String version = "v3/";
    public static String method = "list";
    public static String hotelId = "201252";
    public static String otherElementsStr = "&cid=504144&minorRev=[currentMinorRev]" + "&customerUserAgent=Mozilla/4.0&customerIpAddress=172.16.82.13&locale=en_US&currencyCode=USD";
    public static String apikey = "7aeagb128o84ui6nou3u7ael16";
    public static String secret = "fq3h1urvh9eag";
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        hotelId = request.getParameter("hotelId");
        JSONObject jObj = null;
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            long timeInSeconds = (System.currentTimeMillis() / 1000);
            String input = apikey + secret + timeInSeconds;
            md.update(input.getBytes());
            String sig = String.format("%032x", new BigInteger(1, md.digest()));
            String url = service + version + method + "?apikey=" + apikey + "&sig=" + sig + otherElementsStr + "&hotelIdList=" + hotelId;
            DefaultHttpClient httpclient = new DefaultHttpClient();

            HttpGet httpget = new HttpGet(url);
            httpget.getRequestLine();
            HttpResponse res = null;

            try {
                res = httpclient.execute(httpget);

            } catch (IOException e) {
                e.getMessage();
                return;
            }

            HttpEntity entity = res.getEntity();

            if (entity != null) {

                try {
                    InputStream inputStream = entity.getContent();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;

                    line = bufferedReader.readLine();
                     out.println(line);
                    jObj = new JSONObject(line);

                    ObjectMapper mapper = new ObjectMapper();
                    HotelListResponse map = mapper.readValue(line, HotelListResponse.class);
                    
                   
                    
                    Gson gson = new Gson(); // Or use new GsonBuilder().create();
                    HotelListResponse map1 = gson.fromJson(line, HotelListResponse.class);
                    out.println(map1.getHotelListResponse());
                    
                    bufferedReader.close();
                } catch (IOException e) {
                    e.getMessage();
                    return;
                } catch (JSONException ex) {
                    Logger.getLogger(GetHotel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
            return;
        }

    }

    public static String addSlashes(String s) {
        s = s.replaceAll("\\\\", "\\\\\\\\");
        s = s.replaceAll("\\n", "\\\\n");
        s = s.replaceAll("\\r", "\\\\r");
        s = s.replaceAll("\\00", "\\\\0");
        s = s.replaceAll("'", "\\\\'");
        return s;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
