package es.adrianmmudarra.pizarradeprecios.data.db.repository;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.User;

public class UserRepository {

    ArrayList<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        add(new User("Adrián","Muñoz Mudarra", "correo@adrianmmudarra.es","123"));
    }

    private  void add(User user){
        users.add(user);
    }

    public boolean validateUser(String email, String password){
        for(User user : users){
            if ((user.getEmail().equals(email)) && (user.getPassword().equals(password)))
                return true;
        }
        return false;
    }

    public boolean existUser(String email){
        for(User user : users){
            if ((user.getEmail().equals(email)))
                return true;
        }
        return false;
    }

    public void registerUser(User user){
        add(user);
    }
}
