package com.example.dario.supermarketapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ProductActivity extends AppCompatActivity {

    List<DataAdapter> ListOfdataAdapter;
    RecyclerView recyclerView;
    String PRODUCT_HTTP_JSON_URL = "https://appventasweb.000webhostapp.com/ProductsJsonData.php";

    String Id_Product_JSON = "id_product";
    String Id_Super_JSON = "id_super"; //Foreing Key
    String Image_Name_JSON = "image_title";
    String Image_URL_JSON = "image_url";

    JsonArrayRequest RequestOfJSonArray ;
    RequestQueue requestQueue ;
    View view ;
    int RecyclerViewItemPosition ;
    RecyclerView.LayoutManager layoutManagerOfrecyclerView;
    RecyclerView.Adapter recyclerViewadapter;
    ArrayList<String> ImageTitleNameArrayListForClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_3);

        ImageTitleNameArrayListForClick = new ArrayList<>();

        ListOfdataAdapter = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview2);

        recyclerView.setHasFixedSize(true);

        layoutManagerOfrecyclerView = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManagerOfrecyclerView);

        JSON_HTTP_CALL();

        // Implementing Click Listener on RecyclerView.
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(ProductActivity.this, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

                view = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(view != null && gestureDetector.onTouchEvent(motionEvent)) {
                    //Getting RecyclerView Clicked Item value.
                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(view);
                    // Showing RecyclerView Clicked Item value using Toast.
                    Toast.makeText(ProductActivity.this, ImageTitleNameArrayListForClick.get(RecyclerViewItemPosition), Toast.LENGTH_LONG).show();

                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });

    }

    public void JSON_HTTP_CALL(){
        RequestOfJSonArray = new JsonArrayRequest(PRODUCT_HTTP_JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ParseJSonResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue = Volley.newRequestQueue(ProductActivity.this);
        requestQueue.add(RequestOfJSonArray);
    }

    public void ParseJSonResponse(JSONArray array) {

        Bundle bundle = getIntent().getExtras();
        int dato = bundle.getInt("id_super");

        for(int i = 0; i<array.length(); i++) {
            DataAdapter GetDataAdapter2 = new DataAdapter();
            JSONObject json = null;
            try {

                json = array.getJSONObject(i);
                if(json.getInt("id_super") == dato){
                    Toast.makeText(ProductActivity.this, "la concha de la lora!!!", Toast.LENGTH_LONG).show();
                    GetDataAdapter2.setImageTitle(json.getString(Image_Name_JSON));
                    // Adding image title name in array to display on RecyclerView click event.
                    ImageTitleNameArrayListForClick.add(json.getString(Image_Name_JSON));
                    GetDataAdapter2.setImageUrl(json.getString(Image_URL_JSON));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            ListOfdataAdapter.add(GetDataAdapter2);
        }
        recyclerViewadapter = new RecyclerViewAdapter(ListOfdataAdapter, this);
        recyclerView.setAdapter(recyclerViewadapter);
    }


}
