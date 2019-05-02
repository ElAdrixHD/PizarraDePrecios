package es.adrianmmudarra.pizarradeprecios.data.db.repository;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Cooperativa;

public class CooperativaRepository {
    private ArrayList<Cooperativa> cooperativas;
    private static CooperativaRepository cooperativaRepository;

    //INICIALIZACIÓN ESTÁTICA DE CLASE
    static {
        cooperativaRepository = new CooperativaRepository();
    }

    private CooperativaRepository() {
        this.cooperativas = new ArrayList<>();
        initialice();
    }

    private void initialice() {
        add(new Cooperativa(1, "AgrupaAdra", "Calle X, Nº Y", "999999999", "asd@asd.com", "null"));
        add(new Cooperativa(2, "AgrupaEjido", "Calle X, Nº Y", "999999999", "asd@asd.com", "null"));
        add(new Cooperativa(3, "Casi", "Calle X, Nº Y", "999999999", "asd@asd.com", "null"));
        add(new Cooperativa(4, "Agroponiente", "Calle X, Nº Y", "999999999", "asd@asd.com", "null"));
        add(new Cooperativa(5, "Otra cooperativa", "Calle X, Nº Y", "999999999", "asd@asd.com", "null"));
        add(new Cooperativa(6, "Prueba mas", "Calle X, Nº Y", "999999999", "asd@asd.com", "null"));
        add(new Cooperativa(7, "Aun mas", "Calle X, Nº Y", "999999999", "asd@asd.com", "null"));

    }

    private void add(Cooperativa dependency) {
        cooperativas.add(dependency);
    }

    public ArrayList<Cooperativa> getAll() {
        return this.cooperativas;
    }

    public Cooperativa getCooperativaByID(int id) {
        for (Cooperativa c : cooperativas) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }


    public static CooperativaRepository getCooperativaRepository() {
        return  cooperativaRepository;
    }

}
