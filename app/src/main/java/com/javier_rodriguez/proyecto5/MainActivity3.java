package com.javier_rodriguez.proyecto5;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity3 extends PreferenceActivity {

    @Override
    public void  onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        //Cargamos el Layout de las opciones que se han definido almacenada en el res-> xml.
       addPreferencesFromResource(R.xml.preferences);
        //Obtenemos las preferencias.
       SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity3.this);




    }
}
