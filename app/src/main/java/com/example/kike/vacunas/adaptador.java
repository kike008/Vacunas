package com.example.kike.vacunas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class adaptador  extends RecyclerView.Adapter<adaptador.vacunaViewHolder> {
    private List<vacunas> items;

    public static class vacunaViewHolder extends RecyclerView.ViewHolder {


        public TextView id_A;
        public TextView comunidad;
        public TextView mvz;
        public TextView telefono;
        public TextView perros;
        public TextView gatos;

        public vacunaViewHolder(View v) {
            super(v);
            id_A = (TextView) v.findViewById(R.id.id_A);
            comunidad = (TextView) v.findViewById(R.id.comunidad);
            mvz = (TextView) v.findViewById(R.id.mvz);
            telefono = (TextView) v.findViewById(R.id.telefono);
            perros = (TextView) v.findViewById(R.id.perros);
            gatos = (TextView) v.findViewById(R.id.gatos);
        }
    }

    public adaptador(List<vacunas> items) {this.items = items;}

    @Override
    public vacunaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        return new vacunaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(vacunaViewHolder ViewHolder, int i) {
        ViewHolder.id_A.setText(String.valueOf(items.get(i).getId_A()));
        ViewHolder.comunidad.setText(items.get(i).getComunidad());
        ViewHolder.mvz.setText(items.get(i).getMvz());
        ViewHolder.telefono.setText(String.valueOf(items.get(i).getTelefono()));
        ViewHolder.perros.setText(items.get(i).getPerros());
        ViewHolder.gatos.setText(items.get(i).getGatos());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
