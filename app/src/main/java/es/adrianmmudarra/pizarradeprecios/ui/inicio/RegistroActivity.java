package es.adrianmmudarra.pizarradeprecios.ui.inicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.adrianmmudarra.pizarradeprecios.R;

public class RegistroActivity extends AppCompatActivity {

    Button btn_cancelar, btn_registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inicializar();
    }

    private void inicializar() {
        btn_cancelar = findViewById(R.id.btn_registro_cancelar);
        btn_registrar = findViewById(R.id.btn_registro_registar);
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
