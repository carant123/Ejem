package com.example.carlosantonio.guiaturistica.Model;

import com.example.carlosantonio.guiaturistica.R;

/**
 * Created by Carlos Antonio on 13/01/2016.
 */
public class Coche {

    private int ID;
    private String nombre;
    private int idDrawable;
    private String informacion;

    public Coche(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public Coche() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId() {
        return nombre.hashCode();
    }

}
