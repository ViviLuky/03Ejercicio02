package com.vivianafemenia.a03ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vivianafemenia.a03ejercicio02.modelos.Moto;

public class Activity_add_moto extends AppCompatActivity {
    private EditText txtmarcamoto;
    private EditText txtmodelomoto;
    private EditText txtcilindrada;
    private Button btnCrearmoto;
    private Button btnCancelarmoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_moto);

        inicializarVariables();
        btnCrearmoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtcilindrada.getText().toString().trim().isEmpty() &&
                txtmarcamoto.getText().toString().trim().isEmpty()
                        && txtmodelomoto.getText().toString().trim().isEmpty()) {
                    Moto moto = new Moto(txtcilindrada.getText().toString().trim(),
                            txtmarcamoto.getText().toString().trim(), txtmodelomoto.getText().toString().trim());

                Bundle bundle=new Bundle();
                bundle.putSerializable("Moto",moto);
                Intent intent=new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }}
        });
        btnCancelarmoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void inicializarVariables() {
        txtcilindrada=findViewById(R.id.txtCilindradaMoto);
        txtmarcamoto=findViewById(R.id.txtMarcaMoto);
        txtmodelomoto=findViewById(R.id.txtModeloMoto);
        btnCancelarmoto=findViewById(R.id.btnCancelarMoto);
        btnCrearmoto=findViewById(R.id.btnCrearMoto);

    }
}