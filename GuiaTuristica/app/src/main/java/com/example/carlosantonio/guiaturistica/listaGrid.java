package com.example.carlosantonio.guiaturistica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosantonio.guiaturistica.Model.Coche;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Antonio on 13/01/2016.
 */
public class listaGrid extends Activity {

    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vistagridview);

        gridview = (GridView) findViewById(R.id.GridOpciones);

        //registro();
        Lista();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(listaGrid.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void registro(){

        try {

            String nombre = "Jaguar";
            int drawable = 1;
            String informacion = "Informacion del jaguar_xe";
            DatosEncuesta entry = new DatosEncuesta(listaGrid.this);
            entry.open();
            entry.createEntry(nombre, drawable, informacion);
            entry.close();

        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }finally {
            Toast.makeText(getApplicationContext(), "Registro Completo", Toast.LENGTH_SHORT).show();
        }

    }



    public void Lista(){



        try {

            DatosEncuesta db = new DatosEncuesta(listaGrid.this);
            db.open();
            Cursor cur = db.getData();

            List<Coche> ListaCoche = new ArrayList<Coche>();
            Coche ModelCoche;


            String classes2[];


            while(cur.moveToNext()){

                ModelCoche = new Coche();

                int id = cur.getInt(cur.getColumnIndex("_id"));

                String nombre = cur.getString(cur.getColumnIndex("Nombre_data"));

                int drawable = cur.getInt(cur.getColumnIndex("drawable_data"));

                String contenido = cur.getString(cur.getColumnIndex("contenido_data"));

                //int check = cursor.getInt(cursor.getColumnIndex("estado"));

                ModelCoche.setID(id);
                ModelCoche.setNombre(nombre);
                ModelCoche.setIdDrawable(drawable);
                ModelCoche.setInformacion(contenido);
                //pedido.estado = check;
                //pedido.estado = check;
                ListaCoche.add(ModelCoche);

            }

            cur.close();
            db.close();

            //lvEncuesta.setAdapter(new ArrayAdapter(Encuesta_Tab.this, android.R.layout.simple_list_item_1, ListaEncuesta));

            AdaptadorCoches adapter = new AdaptadorCoches(listaGrid.this, R.layout.vistagridview_item, ListaCoche);
            gridview.setAdapter(adapter);

            Toast.makeText(getApplicationContext(), "Adaptado", Toast.LENGTH_SHORT).show();

        } catch (SQLException e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), "Adaptado Error", Toast.LENGTH_SHORT).show();
        }


    }


    public class AdaptadorCoches extends ArrayAdapter<Coche> {

        private List<Coche> listaEncuesta;
        private int resource;
        private LayoutInflater inflator;

        public AdaptadorCoches(Context context, int resource, List<Coche> objects) {
            super(context, resource, objects);
            //el layout
            this.resource = resource;
            listaEncuesta = objects;
            inflator = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if(convertView == null) {
                holder = new ViewHolder();
                convertView = inflator.inflate(resource, null);

                holder.nombreImagen = (TextView) convertView.findViewById(R.id.nombre_coche);
                holder.idDrawable = (ImageView) convertView.findViewById(R.id.imagen_coche);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.nombreImagen.setText(listaEncuesta.get(position).getNombre());

            holder.idDrawable.setImageResource(Imagenes[position]);
            holder.idDrawable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombre = listaEncuesta.get(position).getNombre();
                    String comentario = listaEncuesta.get(position).getInformacion();
                    Integer imagen = Imagenes[position];
                    Bundle basket = new Bundle();
                    basket.putString("NombreCarro",nombre);
                    basket.putString("Comentario",comentario);
                    basket.putInt("Imagen",imagen);
                    Intent a = new Intent(listaGrid.this,Detalle.class);
                    a.putExtras(basket);
                    startActivity(a);
                }
            });


            return convertView;
        }

        private Integer[] Imagenes = {
                R.drawable.jaguar_f_type_2015,
                R.drawable.mercedes_benz_amg_gt,
                R.drawable.mazda_mx5_2015,
                R.drawable.porsche_911_gts,
                R.drawable.bmw_serie6_cabrio_2015,
                R.drawable.ford_mondeo,
                R.drawable.volvo_v60_crosscountry,
                R.drawable.jaguar_xe,
                R.drawable.volkswagen_golf_r_variant_2015,
                R.drawable.seat_leon_st_cupra
        };


        class ViewHolder{

            private ImageView idDrawable;
            private TextView nombreImagen ;

        }
    }

}
