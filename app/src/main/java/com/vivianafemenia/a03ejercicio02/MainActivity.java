package com.vivianafemenia.a03ejercicio02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vivianafemenia.a03ejercicio02.Actividades.Activity_add_bici;
import com.vivianafemenia.a03ejercicio02.modelos.Bici;
import com.vivianafemenia.a03ejercicio02.modelos.Coche;
import com.vivianafemenia.a03ejercicio02.modelos.Moto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Atributos para vista
    private Button btnAddCoche;
    private Button btnAddBici;
    private Button btntAddMoto;
    private TextView txtCoche;
    private TextView txtBici;
    private  TextView txtMoto;
//Atributos para launchers
    private ActivityResultLauncher<Intent>launcherCoche;
    private ActivityResultLauncher<Intent>launcherMoto;
    private ActivityResultLauncher<Intent>launcherBici;
//Atributos para la lógica

    private ArrayList<Coche>listacoches;
    private ArrayList<Moto> listamotos;
    private ArrayList<Bici>listabicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();
        inicializarLauncher();
        limpiarTexto();
        btntAddMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launcherMoto.launch(new Intent(MainActivity.this, Activity_add_moto.class));
            }
        });
        btnAddBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launcherBici.launch( new Intent(MainActivity.this, Activity_add_bici.class));
            }
        });
        btnAddCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launcherCoche.launch(new Intent(MainActivity.this, Activity_add_coche.class));
            }
        });
    }

    private void limpiarTexto() {
    }

    private void inicializarLauncher() {
        launcherCoche=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK){
                            if(result.getData()!=null && result.getData().getExtras()!=null){
                            Bundle bundle= result.getData().getExtras();
                            Coche coche=(Coche) bundle.getSerializable("Coche");
                            listacoches.add(coche);
                            txtCoche.setText("Coche"+(listacoches.size()));
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Activity Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        launcherBici=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode()==RESULT_OK){
                    if(result.getData()!=null){
                        Bundle bundle= result.getData().getExtras();
                        Bici bici =(Bici) bundle.getSerializable("Bici");
                        listabicis.add(bici);
                        txtBici.setText(String.valueOf(listabicis.size()));
                    }
                }
            }
        });

        launcherMoto=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode()==RESULT_OK){
                    if(result.getData()!=null){
                        Bundle bundle= result.getData().getExtras();
                        Moto moto=(Moto) bundle.getSerializable("Coche");
                        listamotos.add(moto);
                        txtMoto.setText(String.valueOf(listamotos.size()));
                    }
                }
            }
        });

    }

    @SuppressLint("WrongViewCast")
    private void inicializarVariables() {
        btnAddCoche=findViewById(R.id.btncocheMain);
        btnAddBici=findViewById(R.id.btnBiciMain);
        btntAddMoto=findViewById(R.id.btnMotoMain);
        txtCoche=findViewById(R.id.txtcocheMain);
        txtBici=findViewById(R.id.txtBiciMain);
        txtMoto=findViewById(R.id.txtMotoMain);

        listacoches=new ArrayList<>();
        listamotos=new ArrayList<>();
        listabicis=new ArrayList<>();
    }
}