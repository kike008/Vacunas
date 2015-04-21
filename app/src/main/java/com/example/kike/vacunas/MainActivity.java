package com.example.kike.vacunas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText id_A, comunidad, mvz, telefono, perros, gatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_A = (EditText) findViewById(R.id.id_A);
        comunidad = (EditText) findViewById(R.id.comunidad);
        mvz = (EditText) findViewById(R.id.mvz);
        telefono = (EditText) findViewById(R.id.telefono);
        perros = (EditText) findViewById(R.id.perros);
        gatos = (EditText) findViewById(R.id.gatos);

    }

    public void alta (View V) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper (this, "vacunacion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String e_id_a = id_A.getText().toString();
        String e_comunidad = comunidad.getText().toString();
        String e_mvz = mvz.getText().toString();
        String e_telefono = telefono.getText().toString();
        String e_perros = perros.getText().toString();
        String e_gatos = gatos.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("id_A", e_id_a);
        registro.put("comunidad", e_comunidad);
        registro.put("mvz", e_mvz);
        registro.put("telefono", e_telefono);
        registro.put("perros", e_perros);
        registro.put("gatos", e_gatos);

        bd.insert("vacunacion", null, registro);
        bd.close();

        id_A.setText("");
        comunidad.setText("");
        mvz.setText("");
        telefono.setText("");
        perros.setText("");
        gatos.setText("");

        Toast.makeText(this, "se agrego una nueva vacunacion", Toast.LENGTH_SHORT).show();
        id_A.requestFocus();


    }

    public void consulta(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "vacunacion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String id_ve = id_A.getText().toString();
        Cursor fila = bd.rawQuery("select comunidad, mvz, telefono, perros, gatos from vacunacion where id_A=" + id_ve, null);
        if (fila.moveToFirst()) {
            comunidad.setText(fila.getString(0));
            mvz.setText(fila.getString(1));
            telefono.setText(fila.getString(2));
            perros.setText(fila.getString(3));
            gatos.setText(fila.getString(4));
            } else {
            Toast.makeText(this, "No existe la vacunacion",Toast.LENGTH_SHORT).show();
            id_A.requestFocus();
        }
        bd.close();
    }

    public void baja(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "vacunacion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String id_vet = id_A.getText().toString();
        int cant = bd.delete("vacunacion","id_A=" + id_vet, null);
        bd.close();

        id_A.setText("");
        comunidad.setText("");
        mvz.setText("");
        telefono.setText("");
        perros.setText("");
        gatos.setText("");

        if (cant == 1) {
            Toast.makeText(this, "Se borro la vacunacion",Toast.LENGTH_SHORT).show();
            id_A.requestFocus();
        } else {
            Toast.makeText(this, "No existe esta vacunacion",Toast.LENGTH_SHORT).show();
            id_A.requestFocus();
        }
    }

    public void modificacion (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "vacunacion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String e_id_a = id_A.getText().toString();
        String e_comunidad = comunidad.getText().toString();
        String e_mvz = mvz.getText().toString();
        String e_telefono = telefono.getText().toString();
        String e_perros = perros.getText().toString();
        String e_gatos = gatos.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("id_A", e_id_a);
        registro.put("comunidad", e_comunidad);
        registro.put("mvz", e_mvz);
        registro.put("telefono", e_telefono);
        registro.put("perros", e_perros);
        registro.put("gatos", e_gatos);

        int cant = bd.update("vacunacion", registro, "id_A=" + e_id_a, null);
        bd.close();

        if (cant == 1) {
            Toast.makeText(this, "se modifico la vacunacion",Toast.LENGTH_SHORT).show();
            id_A.requestFocus();
        } else {
            Toast.makeText(this, "No existe la vacunacion",Toast.LENGTH_SHORT).show();
            id_A.requestFocus();
        }
    }

    public void limpiar (View v){
        id_A.setText("");
        comunidad.setText("");
        mvz.setText("");
        telefono.setText("");
        perros.setText("");
        gatos.setText("");

        id_A.requestFocus();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
