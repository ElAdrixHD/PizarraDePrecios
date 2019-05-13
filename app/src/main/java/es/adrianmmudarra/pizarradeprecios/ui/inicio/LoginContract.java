package es.adrianmmudarra.pizarradeprecios.ui.inicio;

import android.content.Context;

public class LoginContract {
    public interface View{
        void hideProgressBar();
        void showProgressBar();
        void setEmailEmptyError();
        void setPasswordEmptyError();
        void setLoginError();
        void onSuccess();
        void clearErrorEmail();
        void clearErrorPassword();
    }

    public interface Presenter{
        void validateCredentials(String email, String password, Context context);
    }
}
