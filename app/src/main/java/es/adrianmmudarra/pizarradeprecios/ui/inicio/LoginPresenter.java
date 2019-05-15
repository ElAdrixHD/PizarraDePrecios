package es.adrianmmudarra.pizarradeprecios.ui.inicio;

import android.content.Context;

public class LoginPresenter implements LoginContract.Presenter, LoginRegisterInteractor.LoginInteractor {

    LoginContract.View view;
    LoginRegisterInteractor interactor;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        interactor = new LoginRegisterInteractor();
    }

    @Override
    public void validateCredentials(String email, String password) {
        view.showProgressBar();
        interactor.loginCredentials(email,password,this);
    }

    @Override
    public void onEmailEmptyError() {
        view.setEmailEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onPasswordEmptyError() {
        view.setPasswordEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onLoginError() {
        view.setLoginError();
        view.hideProgressBar();
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
        view.hideProgressBar();
    }

    @Override
    public void onClearErrorEmail() {
        view.clearErrorEmail();
    }

    @Override
    public void onClearErrorPassword() {
        view.clearErrorPassword();
    }
}
