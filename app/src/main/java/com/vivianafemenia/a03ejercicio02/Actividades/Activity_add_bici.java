package com.vivianafemenia.a03ejercicio02.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vivianafemenia.a03ejercicio02.R;
import com.vivianafemenia.a03ejercicio02.modelos.Bici;

public class Activity_add_bici extends AppCompatActivity {
    private EditText txtmarcabici;
    private EditText txtpulgadas;
    private Button btnCrearbici;
    private Button btnCancelarbici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bici);

        inicializarVariables();
        btnCrearbici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtmarcabici.getText().toString().trim().isEmpty() && txtpulgadas.getText().toString().trim().isEmpty()){

                Bici bici=new Bici(txtmarcabici.getText().toString().trim(),txtpulgadas.getText().toString().trim());
                Bundle bundle=new Bundle();
                bundle.putSerializable("Bici",bici);
                Intent intent=new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
            }
        });
        btnCancelarbici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void inicializarVariables() {
        txtmarcabici=findViewById(R.id.txtMarcaBici);
        txtpulgadas=findViewById(R.id.txtPulgadasBici);
        btnCancelarbici=findViewById(R.id.btnCancelarBici);
        btnCrearbici=findViewById(R.id.btnCrearBici);
    }
}