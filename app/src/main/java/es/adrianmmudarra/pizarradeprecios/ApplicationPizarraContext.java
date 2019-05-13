package es.adrianmmudarra.pizarradeprecios;

import android.app.Application;

import es.adrianmmudarra.pizarradeprecios.data.db.repository.UserRepository;

public class ApplicationPizarraContext extends Application {
    private UserRepository userRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        userRepository = new UserRepository();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}

