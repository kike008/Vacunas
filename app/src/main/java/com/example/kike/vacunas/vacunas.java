package com.example.kike.vacunas;

/**
 * Created by KIKE on 27/05/2015.
 */
public class vacunas {
    private String id_A, comunidad, mvz, telefono, perros, gatos;

    public vacunas(String id_A, String comunidad, String mvz, String telefono, String perros, String gatos) {
        this.id_A = id_A;
        this.comunidad = comunidad;
        this.mvz = mvz;
        this.telefono = telefono;
        this.perros = perros;
        this.gatos = gatos;
    }

    public String getId_A() { return id_A; }

    public String getComunidad() { return comunidad; }

    public String getMvz() { return mvz; }

    public String getTelefono() { return telefono; }

    public String getPerros() { return perros; }

    public String getGatos() { return gatos; }

}
