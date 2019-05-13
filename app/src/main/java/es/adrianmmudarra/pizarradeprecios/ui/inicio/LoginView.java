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
import es.adrianmmudarra.pizarradeprecios.ui.dash.DashActivity;

public class LoginView extends AppCompatActivity implements LoginContract.View, View.OnClickListener {
    Button btn_register, btn_login;
    TextInputEditText tiled_email, tiled_password;
    TextInputLayout til_email, til_password;
    ProgressDialog progressDialog;
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize() {
        btn_register = findViewById(R.id.btn_login_register);
        btn_login = findViewById(R.id.btn_login_login);
        tiled_email = findViewById(R.id.tiled_login_email);
        tiled_password = findViewById(R.id.tiled_login_password);
        til_email = findViewById(R.id.til_login_email);
        til_password = findViewById(R.id.til_login_password);
        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        presenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_login:
                presenter.validateCredentials(tiled_email.getText().toString(),tiled_password.getText().toString(),this);
                break;
            case R.id.btn_login_register:
                startActivity(new Intent(LoginView.this, RegisterView.class));
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
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Iniciando Sesion");
        progressDialog.setTitle(R.string.app_name);
        progressDialog.show();
    }

    @Override
    public void setEmailEmptyError() {
        til_email.setError("El campo del correo no puede estar vacio");
    }

    @Override
    public void setPasswordEmptyError() {
        til_password.setError("El campo de la contraseña no puede estar vacio");
    }

    @Override
    public void setLoginError() {
        Toast.makeText(this,"Credenciales invalidas",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(LoginView.this, DashActivity.class));
    }

    @Override
    public void clearErrorEmail() {
        til_email.setError("");
    }

    @Override
    public void clearErrorPassword() {
        til_password.setError("");

    }
}
