package com.example.bgera.cuotaprestamos;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String btnPresionado=null;
    TextView monto,años;
    EditText editMonto,editAños;
    final static String BUTTON_PRESSED="logged";
   final static String MONTO_PRESSED="Monto";
    final static String AÑOS_PRESSED="Años";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMonto=(EditText) findViewById(R.id.editMonto);
        editAños=(EditText) findViewById(R.id.editAños);


    }

    public void casa(View view) {
        btnPresionado="casa";
        validar();
    }

    public void carro(View view) {
        btnPresionado="carro";
        validar();
    }

    public void user(View view) {
        btnPresionado="user";
        validar();
    }

    public void validar(){


        double monto = Double.parseDouble(editMonto.getText().toString());
        double años = Double.parseDouble(editAños.getText().toString());

        if(monto>5000 && años > 0){
            Intent inte = new Intent(this, InformationActivity.class);


            inte.putExtra(AÑOS_PRESSED, años);
            startActivity(inte);

            inte.putExtra(MONTO_PRESSED,monto);
            startActivity(inte);

            inte.putExtra(BUTTON_PRESSED, btnPresionado);
            startActivity(inte);



        }else {
            Toast error = Toast.makeText(this, "Monto o Años incorrectos", Toast.LENGTH_LONG);
            error.show();
        }
    }
}
