package com.example.bgera.cuotaprestamos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Locale;

import static com.example.bgera.cuotaprestamos.R.id.txtMonto;

public class InformationActivity extends AppCompatActivity {
    String btnPresionado;
    TextView monto1,años1, finpago,tipo,montoA,montoI,montoT,cm;
     double monto;
    double años;
    Calendar date = Calendar.getInstance();
    double montoa=0;
    double montoi =0;
    double montot =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        monto1 = (TextView) findViewById(R.id.txtMonto);
        Intent i = getIntent();
        monto= i.getDoubleExtra(MainActivity.MONTO_PRESSED,0);
        monto1.setText("L" + monto);

        años1 = (TextView) findViewById(R.id.txtContAños);
        Intent in =getIntent();
        años= in.getDoubleExtra(MainActivity.AÑOS_PRESSED,0);
        años1.setText(""+ años);

        Intent inte = getIntent();
        btnPresionado = inte.getStringExtra(MainActivity.BUTTON_PRESSED);

        Toast e = Toast.makeText(this, "Prestamo "+btnPresionado+"calculado en "+años, Toast.LENGTH_LONG);
        e.show();

        finpago = (TextView) findViewById(R.id.txtFinPago);
        finpago.setText(""+(Calendar.DAY_OF_WEEK_IN_MONTH)+"/"+(date.get(Calendar.YEAR)+años));

        tipo=(TextView) findViewById(R.id.txtTipoPrestamo);
        tipo.setText(btnPresionado);

        montoA=(TextView) findViewById(R.id.txtMontoAjustado);
        switch (btnPresionado){
            case("casa"):
            montoA.setText("L"+(30000+monto));
            break;
            case("carro"):
            montoA.setText(""+((0.3*monto)+monto));
                break;
            case("user"):
                montoA.setText(""+0);
                break;



        //btnPresionado=inte.getStringExtra(MainActivity.BUTTON_PRESSED);

    }
        montoI = (TextView) findViewById(R.id.txtMontoIntereses);
        switch (btnPresionado) {
            case ("casa"):
                montoI.setText("" +(((0.1*monto)*monto)*años));
                break;
            case ("carro"):
                montoI.setText("" +(((0.25*monto)*monto)*años));
                break;
            case ("user"):
                montoI.setText("" +(((0.35*monto)*monto)*años));
                break;
        }


        montoT =(TextView) findViewById(R.id.txtMontoTotal);
        switch (btnPresionado) {
            case ("casa"):
                montoi=((0.1*monto)*monto)*años;
                montoa = (30000+monto);
                montoT.setText(""+(monto+montoa+montoi));
                break;
            case ("carro"):

                montoi=((0.25*monto)*monto)*años;
                montoa = (0.3*monto)+monto;
                montoT.setText(""+(monto+montoa+montoi));
                break;
            case ("user"):
                montoi=((0.35*monto)*monto)*años;
                montoT.setText(""+(monto+montoa+montoi));
                break;

    }
        cm =(TextView) findViewById(R.id.txtCuotaMensual);
        switch (btnPresionado) {
            case ("casa"):
                montoi=((0.1*monto)*monto)*años;
                montoa = (30000+monto);
                montot =(monto+montoa+montoi);
                cm.setText(""+(montot/(años*12)));
                break;
            case ("carro"):

                montoi=((0.25*monto)*monto)*años;
                montoa = (0.3*monto)+monto;
                montot =(monto+montoa+montoi);
                cm.setText(""+(montot/(años*12)));
                break;
            case ("user"):
                montoi=((0.35*monto)*monto)*años;
                montot =(monto+montoa+montoi);
                cm.setText(""+(montot/(años*12)));
                break;

        }



}
    public void cotizar (View view) {
        Intent iweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baccredomatic.com/es-sv"));
        startActivity(iweb);

    }
}