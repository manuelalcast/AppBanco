package com.glaxmac.bancoapp.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.glaxmac.bancoapp.R;

public class CuentasActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTNRETIRO, BTNDEPOSITO, BTNCERRAR;
    TextView LBLCUENTA, LBLSALDO;

    String cuenta = "";
    Double saldo = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas);

        LBLCUENTA = findViewById(R.id.lbl_cuenta);
        LBLSALDO = findViewById(R.id.lbl_saldo);

        BTNRETIRO = findViewById(R.id.btn_retiro);
        BTNDEPOSITO = findViewById(R.id.btn_deposito);
        BTNCERRAR = findViewById(R.id.btn_cerrar);

        BTNRETIRO.setOnClickListener(this);
        BTNDEPOSITO.setOnClickListener(this);
        BTNCERRAR.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        String cuenta2 = bundle.getString("identidificador");
        saldo = Double.parseDouble(bundle.getString("dataMoney"));

        String[] c = new String[4];
        c = cuenta2.split("-");

        cuenta = c[0].substring(0,3) + "-" + c[0].substring(3) + c[1]+c[2].substring(0,3) + "-" + c[2].substring(3) + "-" + c[3].substring(0,2);
        LBLCUENTA.setText(cuenta);
        LBLSALDO.setText("S/. "+saldo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_deposito:{
                Intent intent = new Intent(CuentasActivity.this, DepositoActivity.class);
                intent.putExtra("identidificador", cuenta);
                intent.putExtra("dataMoney", saldo+"");
                startActivity(intent);
            }break;
            case R.id.btn_retiro:{
                Intent intent = new Intent(CuentasActivity.this, RetiroActivity.class);
                intent.putExtra("identidificador", cuenta);
                intent.putExtra("dataMoney", saldo+"");
                startActivity(intent);
            }break;
            case R.id.btn_cerrar:{
                finish();
            }break;
        }
    }

    public void  setSaldo(Double saldo){ this.saldo = saldo;}
}
