package com.example.myfagment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class TableF extends AppCompatActivity implements GreenFrag.OnFragmentInteractionListener,RedFrag.OnFragmentInteractionListener,
        BlankFrag.OnFragmentInteractionListener{
    TextView esadmin;
    GreenFrag GreenFrag;
    RedFrag RedFrag;
    BlankFrag BlankFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_f);
        esadmin = (TextView) findViewById(R.id.tvadmin);
        RedFrag = new RedFrag();
        GreenFrag = new GreenFrag();
        BlankFrag = new BlankFrag();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentcont,BlankFrag).commit();
        esAdmi();
    }

    public void esAdmi(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (MainActivity.admin == true){
            esadmin.setText("Si es admin");
            transaction.replace(R.id.fragmentcont,GreenFrag);
        }else{
            esadmin.setText("No era admin");
            transaction.replace(R.id.fragmentcont,RedFrag);
        }
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
