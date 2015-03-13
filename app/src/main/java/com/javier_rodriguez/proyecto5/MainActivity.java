/*******************************************
 * MainActivity
 * Autor: Javier Rodríguez Soler.
 * Dom: com.javier_rodriguez
 * Version : 1
 *******************************************/


package com.javier_rodriguez.proyecto5;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {

    public static final long Retardo= 5000; //Tiempo de retardo que se define en el splash screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Establecemos portarit orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Ocultamos title bar.
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        TimerTask task = new TimerTask(){
            @Override
        public void run (){

                //Inicio de la siguiente actividad mediate un intent.
                Intent mainIntent = new Intent().setClass(
                     MainActivity.this, MainActivity2.class);
                startActivity(mainIntent);
                finish();
            }
        };

        //Establecemos el timer.
        Timer timer = new Timer();
        timer.schedule(task, Retardo);

        //SpinerBar.
        final ProgressBar spinner;
        spinner =(ProgressBar)findViewById(R.id.spinner);
        spinner.setVisibility(View.VISIBLE);// Lo hacemos visible.

       }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
