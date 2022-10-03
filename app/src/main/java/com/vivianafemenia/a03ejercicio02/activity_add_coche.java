package com.vivianafemenia.a03ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class activity_add_coche extends AppCompatActivity {
    private EditText txtmarcacoche;
    private EditText txtmodelocoche;
    private EditText txtcolorcoche;
    private Button btnCrearcoche;
    private Button btnCancelarcoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coche);
        inicializarVariables();

        btnCrearcoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coche coche=new Coche(txtmodelocoche.getText().toString(),txtmarcacoche.getText().toString()
                        ,txtcolorcoche.getText().toString());
                Bundle bundle=new Bundle();
                bundle.putSerializable("Coche",coche);
                Intent intent=new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        btnCancelarcoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void inicializarVariables() {
        txtcolorcoche=findViewById(R.id.txtColorCoche);
        txtmarcacoche=findViewById(R.id.txtMarcaCoche);
        txtmodelocoche=findViewById(R.id.txtModeloCoche);
        btnCancelarcoche=findViewById(R.id.btnCancelarCoche);
        btnCrearcoche=findViewById(R.id.btnCrearCoche);
    }


}