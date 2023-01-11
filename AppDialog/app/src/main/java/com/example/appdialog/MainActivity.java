package com.example.appdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

        ArrayList itemsSeleccionados = new ArrayList();

        CharSequence[] elementos={"CASO 0","CASO 1","CASO 2","CASO 3","CASO 4","CASO 5"};

        dialogo.setTitle("TÍTULO DEL DIÁLOGO")
             //   .setMessage("EJEMPLO DE DIÁLOGO")
                .setIcon(R.mipmap.ic_launcher)
                /*
                       .setItems(elementos, new DialogInterface.OnClickListener() {
                             public void onClick(DialogInterface dialog, int id) {
                                 // Código para realizar
                                 Toast.makeText(
                                         MainActivity.this,
                                         "Seleccionaste:" + elementos[id],
                                         Toast.LENGTH_SHORT)
                                         .show();
                             } })

                 */
       /*         .setSingleChoiceItems(elementos,0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Código para realizar
                        Toast.makeText(
                                MainActivity.this,
                                "Seleccionaste:" + elementos[id],
                                Toast.LENGTH_SHORT)
                                .show();
                    } })*/
                .setPositiveButton("PRIMERO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Código para realizar

                    } })

                .setMultiChoiceItems(elementos, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    // Guardar indice seleccionado
                                    itemsSeleccionados.add(which);
                                    Toast.makeText(
                                            MainActivity.this,
                                            "Checks seleccionados:(" + itemsSeleccionados.size() + ")",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                } else  {
                                    // Remover indice sin selección
                                    itemsSeleccionados.remove(which);
                                    Toast.makeText(
                                            MainActivity.this,
                                            "Checks seleccionados:(" + itemsSeleccionados.size() + ")",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            } })


                .setNegativeButton("SEGUNDO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Código para realizar
                    } })
                .setNeutralButton("TERCERO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Código para realizar
                    } })
        ;
                dialogo.show();
    }

 }
