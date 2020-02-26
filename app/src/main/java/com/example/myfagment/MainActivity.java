package com.example.myfagment;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    public static String tokens = "asd";
    public static boolean admin = false;
    public static String endPoint= "http://192.168.0.11:3333/";

    AsyncHttpClient client = new AsyncHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnentrar = findViewById(R.id.btnentrar);
        btnentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    postData();
                    Context context = getApplicationContext();
                    Toast.makeText(context,"POST", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                }
            }
        });
    }

    public void postData() throws JSONException {
        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);

        JSONObject oJSONObject = new JSONObject();
        oJSONObject.put("username",editText.getText().toString());
        oJSONObject.put("password",editText2.getText().toString());
        System.out.println(editText.getText().toString());
        System.out.println(editText2.getText().toString());
        ByteArrayEntity oEntity = null;
        try {
            oEntity = new ByteArrayEntity(oJSONObject.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        oEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

        client.post(getApplicationContext(), endPoint+"api/v1/login", (HttpEntity) oEntity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                // called before request is started
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody){
                String resp = new String(responseBody);
                String res="nohaytoken";
                boolean bol = false;
                try {
                    JSONObject testV =new JSONObject(new String(responseBody));
                    res = testV.get("token").toString();
                    bol = Boolean.parseBoolean(testV.get("super").toString());
                }catch (Exception e){
                    System.out.println(e);
                }

                System.out.println("..................");
                System.out.println(resp);
                System.out.println(res);
                tokens=res;
                admin=bol;
                Intent intent = new Intent(MainActivity.this , TableF.class);
                startActivity(intent);
                System.out.println("..................");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println(error);
                System.out.println("error");
            }
        });
    }
}
