package gcmsender;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GcmSender {
    //Es la key de google pero del servidor.
    public static final String API_KEY = "AIzaSyAM73oJepdhnfY9fjDTNwx0Y882QlcAmss";

    public static void main(String[] args) {
        try {
            JSONObject jGcmData = new JSONObject();
            JSONObject jData = new JSONObject();
            jData.put("message", "holi");
            jGcmData.put("to", "/topics/educacionit");
            jGcmData.put("data", jData);

            // Conexión con Google.
            URL url = new URL("https://android.googleapis.com/gcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "key=" + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Envía el contenido
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jGcmData.toString().getBytes());

            // Lee la respuesta
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            System.out.println(resp);
            System.out.println("La push notification fue enviada con éxito.");
        } catch (IOException e) {
            System.out.println("No se pudo mandar la push notification");
            e.printStackTrace();
        }
    }

}
