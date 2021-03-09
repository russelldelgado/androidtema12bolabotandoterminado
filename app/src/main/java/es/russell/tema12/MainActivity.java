package es.russell.tema12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private  boolean continuar  = true ;
    private float velocidad  = 0.5f;
    private int dt  = 10;
    private int tiempo = 0;
    private  Thread hilo = null;
    private GraficoView dinamica ;
    private float aceleracion = 0.01f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dinamica = new GraficoView(this  , continuar , tiempo , dt , velocidad , aceleracion);
        setContentView(dinamica);
        hilo = new Thread(dinamica);
        hilo.start();
    }
}