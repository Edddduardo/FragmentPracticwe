package com.example.myfagment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MosFrag extends AppCompatActivity implements GreenFrag.OnFragmentInteractionListener, RedFrag.OnFragmentInteractionListener,
TablitaFrag.OnFragmentInteractionListener{

    GreenFrag GreenFrag;
    RedFrag RedFrag;
    TablitaFrag TablitaFrag;
    public static Context MosContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mos_frag);
        GreenFrag = new GreenFrag();
        RedFrag = new RedFrag();
        TablitaFrag = new TablitaFrag();
        //getSupportFragmentManager().beginTransaction().add(R.id.contentFrag,GreenFrag).commit();
        MosContext =  MosFrag.this;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btnRojo:
                transaction.replace(R.id.contentFrag,RedFrag);
                break;
            case R.id.btnverde:
                transaction.replace(R.id.contentFrag,GreenFrag);
                break;
            case R.id.btntablita:
                transaction.replace(R.id.contentFrag,TablitaFrag);
                break;
        }

        transaction.commit();
    }
}
