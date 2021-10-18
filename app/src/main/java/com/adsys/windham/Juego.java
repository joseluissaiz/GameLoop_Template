package com.adsys.windham;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.text.DecimalFormat;

public class Juego extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder soporteDeSuperficie;
    private LoopJuego loopJuego;
    private Context contexto;

    public Juego(Context contexto) {
        super(contexto);
        this.contexto = contexto;
        //Obtenemos el soporte de la superficie y establecemos la llamada de vuelta
        soporteDeSuperficie = getHolder();
        soporteDeSuperficie.addCallback(this);
        //Creamos un nuevo loop del juego
        loopJuego = new LoopJuego(this, soporteDeSuperficie);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        loopJuego.iniciarLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    public void dibujar(Canvas lienzo) {
        super.draw(lienzo);
        dibujarUPS(lienzo);
        dibujarFPS(lienzo);
    }

    public void dibujarUPS(Canvas lienzo){
        DecimalFormat formatoDecimal = new DecimalFormat("#.##");
        String promedioUPS = formatoDecimal.format(loopJuego.obtenerPromedioUPS());Paint pincel = new Paint();
        pincel.setColor(Color.WHITE);
        pincel.setTextSize(20);
        lienzo.drawText("UPS: "+promedioUPS, 50, 50, pincel);
    }

    public void dibujarFPS(Canvas lienzo){
        DecimalFormat formatoDecimal = new DecimalFormat("#.##");
        String promedioFPS = formatoDecimal.format(loopJuego.obtenerPromedioFPS());
        Paint pincel = new Paint();
        pincel.setColor(Color.WHITE);
        pincel.setTextSize(20);
        lienzo.drawText("FPS: "+promedioFPS, 50, 80, pincel);
    }

    public void actualizar(){

    }
}
