package es.adrianmmudarra.pizarradeprecios.ui.inicio;

import android.os.Handler;
import android.text.TextUtils;

import es.adrianmmudarra.pizarradeprecios.data.db.model.User;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.UserRepository;

public class LoginRegisterInteractor {

    public void loginCredentials(final String email, final String password, final LoginInteractor listener){
        if (checkLoginEmail(email,listener) & checkLoginPassword(password,listener)){
            new Handler().postDelayed(() -> {
                if (UserRepository.getInstance().validateUser(email,password)){
                    listener.onSuccess();
                }else {
                    listener.onLoginError();
                }
            },2000);
        }
    }

    public void registerUser(String email, String password, String confirm, String name, String lastname, RegisterInteractor listener){
        if ((checkRegisterEmail(email,listener) & checkRegisterPassword(password,listener) & checkRegisterPasswordConfirm(confirm,listener) & checkRegisterName(name,listener) & checkRegisterLastName(lastname,listener)) && checkRegisterMatchPassword(password,confirm,listener)){
            new Handler().postDelayed(()-> {
                if (UserRepository.getInstance().existUser(email)){
                    listener.onEmailExistsError();
                }else {
                    UserRepository.getInstance().registerUser(new User(name,lastname,email,password));
                    listener.onSuccess();
                }
            },2000);
        }
    }

    private boolean checkRegisterName(String name, RegisterInteractor listener){
        if (TextUtils.isEmpty(name)){
            listener.onNameEmptyError();
            return false;
        }
        listener.onClearNameError();
        return true;
    }

    private boolean checkRegisterEmail(String email, RegisterInteractor listener){
        if (TextUtils.isEmpty(email)){
            listener.onEmailEmptyError();
            return false;
        }
        listener.onClearEmailError();
        return true;
    }

    private boolean checkRegisterPassword(String password, RegisterInteractor listener){
        if (TextUtils.isEmpty(password)){
            listener.onPasswordEmptyError();
            return false;
        }
        listener.onClearPasswordError();
        return true;
    }

    private boolean checkRegisterPasswordConfirm(String password, RegisterInteractor listener){
        if (TextUtils.isEmpty(password)){
            listener.onPasswordConfirmEmptyError();
            return false;
        }
        listener.onClearPasswordConfirmError();
        return true;
    }

    private boolean checkRegisterMatchPassword(String password, String passwordConfirm, RegisterInteractor listener){
        if (!password.equals(passwordConfirm)){
            listener.onPasswordMatchError();
            return false;
        }
        listener.onClearPasswordError();
        listener.onClearPasswordConfirmError();
        return true;
    }

    private boolean checkRegisterLastName(String lastname, RegisterInteractor listener){
        if (TextUtils.isEmpty(lastname)){
            listener.onLastNameEmptyError();
            return false;
        }
        listener.onClearLastNameError();
        return true;
    }

    private boolean checkLoginEmail(String email, LoginInteractor listener){
        if (TextUtils.isEmpty(email)){
            listener.onEmailEmptyError();
            return false;
        }
        listener.onClearErrorEmail();
        return true;
    }

    private boolean checkLoginPassword(String password, LoginInteractor listener){
        if (TextUtils.isEmpty(password)){
            listener.onPasswordEmptyError();
            return false;
        }
        listener.onClearErrorPassword();
        return true;
    }

    interface LoginInteractor{
        void onEmailEmptyError();
        void onPasswordEmptyError();
        void onLoginError();
        void onSuccess();
        void onClearErrorEmail();
        void onClearErrorPassword();
    }

    interface RegisterInteractor{
        void onEmailEmptyError();
        void onPasswordEmptyError();
        void onPasswordConfirmEmptyError();
        void onNameEmptyError();
        void onLastNameEmptyError();
        void onSuccess();
        void onPasswordMatchError();
        void onEmailExistsError();
        void onClearEmailError();
        void onClearPasswordError();
        void onClearPasswordConfirmError();
        void onClearNameError();
        void onClearLastNameError();
    }
}
