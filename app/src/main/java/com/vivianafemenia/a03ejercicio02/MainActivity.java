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
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnAddCoche;
    private Button btnAddBici;
    private Button btntAddMoto;
    private TextView txtCoche;
    private TextView txtBici;
    private  TextView txtMoto;

    private ActivityResultLauncher<Intent>launcherCoche;
    private ActivityResultLauncher<Intent>launcherMoto;
    private ActivityResultLauncher<Intent>launcherBici;

    private ArrayList<Coche>coches=new ArrayList<>();
    private ArrayList<Moto> motos=new ArrayList<>();
    private ArrayList<Bici>bicis=new ArrayList<>();

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
               Intent intent= new Intent(MainActivity.this,activity_add_moto.class);
               launcherMoto.launch(intent);
            }
        });
        btnAddBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity_add_bici.class);
                launcherBici.launch(intent);
            }
        });
        btnAddCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity_add_coche.class);
                launcherCoche.launch(intent);
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
                            if(result.getData()!=null){
                            Bundle bundle= result.getData().getExtras();
                            Coche coche=(Coche) bundle.getSerializable("Coche");
                            coches.add(coche);
                            txtCoche.setText(String.valueOf(coches.size()));
                            }
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
                        bicis.add(bici);
                        txtBici.setText(String.valueOf(bicis.size()));
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
                        motos.add(moto);
                        txtMoto.setText(String.valueOf(motos.size()));
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
    }
}