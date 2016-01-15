package com.example.carlosantonio.guiaturistica;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Carlos Antonio on 14/01/2016.
 */
public class Detalle extends Activity {

    ImageView ImgCoche;
    TextView NombreCoche, ComentarioCoche;
    String Ncoche, Coment;
    Integer ImNombreCoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_layout);

        NombreCoche = (TextView) findViewById(R.id.tvnombreauto);
        ComentarioCoche = (TextView) findViewById(R.id.tvcontenido);
        ImgCoche = (ImageView) findViewById(R.id.ivcoche);

        Bundle getbundle = getIntent().getExtras();
        Ncoche = getbundle.getString("NombreCarro");
        Coment = getbundle.getString("Comentario");
        ImNombreCoche = getbundle.getInt("Imagen");

        NombreCoche.setText(Ncoche);
        ComentarioCoche.setText(Coment);
        ImgCoche.setBackgroundResource(ImNombreCoche);

    }

}
