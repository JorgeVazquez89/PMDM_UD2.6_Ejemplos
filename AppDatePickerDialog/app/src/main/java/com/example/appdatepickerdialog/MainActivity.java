package com.example.appdatepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edt1 = (EditText) findViewById(R.id.edtDate);
        Button btn =(Button) findViewById(R.id.btn);

   /*     final Calendar calen = Calendar.getInstance();
        int hour = calen.get(Calendar.HOUR_OF_DAY);
        int minute = calen.get(Calendar.MINUTE);



        TimePickerDialog hora = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int
                            minute) {
                        // Código para realizar
                    }
                }, hour, minute,true);
        hora.show();
    /*
      final Calendar calen = Calendar.getInstance(); */
 /*         int anio = calen.get(Calendar.YEAR);
        int mes = calen.get(Calendar.MONTH);
        int dia = calen.get(Calendar.DAY_OF_MONTH);

  */

/*
        DatePickerDialog fecha = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int
                            monthOfYear, int dayOfMonth) {
                            // Código para realizar
                    }
                }, anio, mes, dia);

        fecha.show();
*/

        final Calendar calen = Calendar.getInstance();
        int anio = calen.get(Calendar.YEAR);
        int mes = calen.get(Calendar.MONTH);
        int dia = calen.get(Calendar.DAY_OF_MONTH);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog fecha = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int
                                    monthOfYear, int dayOfMonth) {
                                edt1.setText(dayOfMonth + "/"+ monthOfYear + "/" + year);
                            }
                        }, anio, mes, dia);

                fecha.show();

            }
        });


    }


}