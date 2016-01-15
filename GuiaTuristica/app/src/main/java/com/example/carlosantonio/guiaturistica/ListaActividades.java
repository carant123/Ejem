package com.example.carlosantonio.guiaturistica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.carlosantonio.guiaturistica.Model.ModelImage;

import java.util.List;

/**
 * Created by Carlos Antonio on 13/01/2016.
 */
public class ListaActividades extends Activity implements View.OnClickListener {

    ImageButton b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaturistica_seccion);
        inicializar();
    }

    public void inicializar(){
        b1 = (ImageButton) findViewById(R.id.bt_imageButton1);
        b2 = (ImageButton) findViewById(R.id.bt_imageButton2);
        b3 = (ImageButton) findViewById(R.id.bt_imageButton3);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_imageButton1:
                Intent i = new Intent(this, listaGrid.class);
                startActivity(i);
                break;
            case R.id.bt_imageButton2:
                Intent i2 = new Intent(this, listaGrid.class);
                startActivity(i2);
                break;
            case R.id.bt_imageButton3:
                Intent i3 = new Intent(this, listaGrid.class);
                startActivity(i3);
                break;
        }
    }
}
