package es.adrianmmudarra.pizarradeprecios.ui.inicio;

import android.content.Context;

public class RegisterPresenter implements RegisterContract.Presenter, LoginRegisterInteractor.RegisterInteractor {

    private RegisterContract.View view;
    private LoginRegisterInteractor interactor;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        interactor = new LoginRegisterInteractor();
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
    public void onPasswordConfirmEmptyError() {
        view.setPasswordConfirmEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onNameEmptyError() {
        view.setNameEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onLastNameEmptyError() {
        view.setLastNameEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
        view.hideProgressBar();
    }

    @Override
    public void onPasswordMatchError() {
        view.setPasswordMatchError();
        view.hideProgressBar();
    }

    @Override
    public void onEmailExistsError() {
        view.setEmailExistsError();
        view.hideProgressBar();
    }

    @Override
    public void onClearEmailError() {
        view.clearEmailError();
    }

    @Override
    public void onClearPasswordError() {
        view.clearPasswordError();
    }

    @Override
    public void onClearPasswordConfirmError() {
        view.clearPasswordConfirmError();
    }

    @Override
    public void onClearNameError() {
        view.clearNameError();
    }

    @Override
    public void onClearLastNameError() {
        view.clearLastNameError();
    }

    @Override
    public void registerUser(String name, String lastname, String email, String password, String passwordConfirm) {
        view.showProgressBar();
        interactor.registerUser(email,password,passwordConfirm,name,lastname,this);
    }
}
