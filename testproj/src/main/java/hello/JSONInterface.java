package hello;
import java.io.*;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

import com.google.maps.model.DistanceMatrix;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.json.*;
import com.google.maps.*;
/**
 * Created by 803100 on 03.05.2017.
 */
public class JSONInterface {
    Integer tem;
    Float dist;

    private static String readAll(Reader rd) throws IOException{
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1){
            sb.append((char) cp);
        }
        return  sb.toString();
    }

    public static JSONObject readJsonFromUrl (String url) throws IOException, JSONException{
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsontext = readAll(rd);
            JSONObject json = new JSONObject(jsontext);
            return json;
        }
        finally {
            is.close();
        }
    }

    public float calcDistance (StringBuffer beg, StringBuffer end){
        JSONObject json = null;
        StringBuffer start = new StringBuffer(), stop = new StringBuffer();
        float totDistance;
        try{
            json = readJsonFromUrl("https://maps.googleapis" +
                    ".com/maps/api/distancematrix/json?origins="+beg+"&destinations="+end+"&mode=driving&sensor=false");
            json.get("rows");
            JSONArray arr = null;
            arr = json.getJSONArray("rows");
            tem = (Integer)arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance")
                    .getInt("value");
            dist=(float)tem/1000;
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return  dist;
    }
}
