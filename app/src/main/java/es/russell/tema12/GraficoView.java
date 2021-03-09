package es.russell.tema12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GraficoView extends View implements Runnable {

    int x ,  y , ymax;
    Paint paintFondo , paintParticula , paint;
    Boolean continuar = false;


    private float velocidad ;
    private int dt  ;
    private int tiempo ;
    private float aceleracion;
    private  float energia ;


    public GraficoView(Context context , boolean continar , int tiempo , int dt , float velocidad , float aceleracion) {
        super(context);
        paintFondo = new Paint();
        paintParticula = new Paint();
        paint = new Paint();
        paintFondo.setColor(Color.WHITE);
        paintParticula.setColor(Color.RED);
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        this.continuar = continar;
        this.velocidad = velocidad;
        this.dt = dt;
        this.tiempo = tiempo;
        this.aceleracion = aceleracion;


    }

    @Override
    public void run() {

            while (continuar){
                tiempo = tiempo+dt;
                y = y+(int)(velocidad*dt);
                if (y>ymax)velocidad = -velocidad;
                if (y<0) velocidad = -velocidad;
                postInvalidate();
                try {
                    Thread.sleep(dt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        x=w/2;
        y = 0;
        ymax = h;

        energia = 0.5f * velocidad -aceleracion * y;


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(paintFondo);
        canvas.drawCircle(x + 150 ,  y , 30 , paintParticula);
        canvas.drawText("altura  : " +y  ,50 , 150 , paint);
        canvas.drawText("tiempo : " + tiempo, 50 , 190 , paint);


    }
}
