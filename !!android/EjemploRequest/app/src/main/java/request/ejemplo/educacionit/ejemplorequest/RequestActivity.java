package request.ejemplo.educacionit.ejemplorequest;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONObject;

import request.ejemplo.educacionit.ejemplorequest.model.Producto;

public class RequestActivity extends AppCompatActivity {

    private TextView id;
    private TextView description;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
        .build();
        ImageLoader.getInstance().init(config);


        id= (TextView) findViewById(R.id.product_id);
        description= (TextView) findViewById(R.id.description);
        image= (ImageView) findViewById(R.id.image);

        GsonRequest gsonRequest=new GsonRequest<Producto>("http://www.webkathon.com/pruebasit/products.php?id=1",
                Producto.class, null, new Response.Listener<Producto>() {
            @Override
            public void onResponse(Producto response) {
                id.setText(response.getId());
                description.setText(response.getDescription());
                ImageLoader.getInstance().displayImage(response.getImage(),image);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RequestActivity.this,"error",Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(this).add(gsonRequest);

    }
}
