package es.adrianmmudarra.pizarradeprecios.ui.inicio;

import android.content.Context;

public class RegisterContract {
    public interface View{
        void hideProgressBar();
        void showProgressBar();
        void setEmailEmptyError();
        void setPasswordEmptyError();
        void setPasswordConfirmEmptyError();
        void setNameEmptyError();
        void setLastNameEmptyError();
        void onSuccess();
        void setPasswordMatchError();
        void setEmailExistsError();
        void clearEmailError();
        void clearPasswordError();
        void clearPasswordConfirmError();
        void clearNameError();
        void clearLastNameError();
    }

    public interface Presenter{
        void registerUser(String name, String lastname, String email, String password, String passwordConfirm, Context context);
    }
}
