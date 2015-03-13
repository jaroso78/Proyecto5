/*******************************************
 * MainActivity2
 * Autor: Javier Rodríguez Soler.
 * Dom: com.javier_rodriguez
 * Version : 1
 *******************************************/

package com.javier_rodriguez.proyecto5;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity2 extends Activity {

    //Control de volumen
    private int mVolume = 6, mVolumeMax = 10, mVolumeMin = 0;
    //Control para saber si suena.
    private int sonando = 0;
    private MediaPlayer mPlayer;
    private boolean mCanPlayAudio;
    private AudioManager mAudioManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        //Capturamos el servicio que nos proporciona manejar sonidos.
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        //Capturamos las preferencias de Usuario.
         SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity2.this);


        //Obtenemos valor
        if (pref.getBoolean("audio_activo",true)==true){ //Si es true
            sonando =1; //Suena.
        }

         //Obtenemos el mediaplayer y cargasmo la canción.
        mPlayer = MediaPlayer.create(this, R.raw.cancion01);
        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                if (sonando == 1) {  //Si sonando esta activo.
                    mPlayer.start(); //Inicia la música.
                }
            }
        });


        //Control de boton de opciones.
        Button btnOpciones = (Button)findViewById(R.id.button);

        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class)); //Carga las opciones.
            }
        });



    }


    //Método onResume para cuando vuelve a tomar el control el MainActivity.
    @Override
    protected void onResume(){
        super.onResume();
        //Obtenemos las preferencias almacenadas por si han vuelto ha cambiar.
        SharedPreferences pref1 = PreferenceManager.getDefaultSharedPreferences(MainActivity2.this);
        if (pref1.getBoolean("audio_activo",true)==true){ //Si la preferencia audio_Activo es tru
            mPlayer.start(); //Inicia la música.
        } else {
            mPlayer.pause(); //En caso contrario la pausa.
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
