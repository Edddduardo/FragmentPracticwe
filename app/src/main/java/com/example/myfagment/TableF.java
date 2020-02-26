package com.example.myfagment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TableF extends AppCompatActivity {
    TextView esadmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_f);
        esadmin = (TextView) findViewById(R.id.tvadmin);
        esAdmi();
    }

    public void esAdmi(){
        if (MainActivity.admin == true){
            esadmin.setText("Si es admin");
        }else{
            esadmin.setText("No era admin");
        }
    }
}
