package es.adrianmmudarra.pizarradeprecios.ui.inicio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.adrianmmudarra.pizarradeprecios.R;

public class RegisterView extends AppCompatActivity implements RegisterContract.View, View.OnClickListener {

    ProgressDialog progressDialog;
    RegisterContract.Presenter presenter;

    TextInputLayout til_name, til_lastname, til_password, til_passwordconfirm, til_email;
    TextInputEditText tiled_name, tiled_lastname, tiled_password, tiled_passwordconfirm, tiled_email;
    Button btn_cancel, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
    }

    private void initialize() {
        btn_cancel = findViewById(R.id.btn_register_cancel);
        btn_register = findViewById(R.id.btn_register_register);
        til_email = findViewById(R.id.til_register_email);
        tiled_email = findViewById(R.id.tiled_register_email);
        til_lastname = findViewById(R.id.till_register_lastname);
        tiled_lastname = findViewById(R.id.tiled_register_lastname);
        til_name = findViewById(R.id.til_register_name);
        tiled_name = findViewById(R.id.tiled_register_name);
        til_password = findViewById(R.id.til_register_password);
        tiled_password = findViewById(R.id.tiled_register_password);
        til_passwordconfirm = findViewById(R.id.til_register_confirm);
        tiled_passwordconfirm = findViewById(R.id.tiled_register_confirm);
        btn_register.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

        presenter = new RegisterPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register_cancel:
                finish();
                break;
            case R.id.btn_register_register:
                presenter.registerUser(tiled_name.getText().toString(),tiled_lastname.getText().toString(),tiled_email.getText().toString(),tiled_password.getText().toString(),tiled_passwordconfirm.getText().toString());
                break;
        }
    }

    @Override
    public void hideProgressBar() {
        if (progressDialog != null){
            progressDialog.dismiss();
        }
    }

    @Override
    public void showProgressBar() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Registrando...");
        progressDialog.setTitle(R.string.app_name);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    public void setEmailEmptyError() {
        til_email.setError("El campo del correo no puede estar vacio");
    }

    @Override
    public void setPasswordEmptyError() {
        til_password.setError("El campo no debe estar vacio");
    }

    @Override
    public void setPasswordConfirmEmptyError() {
        til_passwordconfirm.setError("El campo no debe estar vacio");
    }

    @Override
    public void setNameEmptyError() {
        til_name.setError("El campo del nombre no puede estar vacio");
    }

    @Override
    public void setLastNameEmptyError() {
        til_lastname.setError("El campo de los apellidos no puede estar vacio");
    }

    @Override
    public void onSuccess() {
        finish();
    }

    @Override
    public void setPasswordMatchError() {
        til_password.setError("Las contraseñas");
        til_passwordconfirm.setError("no coinciden");
    }

    @Override
    public void setEmailExistsError() {
        til_email.setError("Este email ya existe");
    }

    @Override
    public void clearEmailError() {
        til_email.setError("");
    }

    @Override
    public void clearPasswordError() {
        til_password.setError("");
    }

    @Override
    public void clearPasswordConfirmError() {
        til_passwordconfirm.setError("");
    }

    @Override
    public void clearNameError() {
        til_name.setError("");
    }

    @Override
    public void clearLastNameError() {
        til_lastname.setError("");
    }
}
