package es.adrianmmudarra.pizarradeprecios.data.db.repository;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Cooperativa;

public class CooperativaRepository {
    private ArrayList<Cooperativa> cooperativas;
    private static  CooperativaRepository cooperativaRepository;

    //INICIALIZACIÓN ESTÁTICA DE CLASE
    static {
        cooperativaRepository = new CooperativaRepository();
    }

    private CooperativaRepository(){
        this.cooperativas = new ArrayList<>();
        initialice();
    }

    private void initialice() {
        add(new Cooperativa("AgrupaAdra","Calle X, Nº Y", "999999999", "asd@asd.com","null"));
        add(new Cooperativa("AgrupaEjido","Calle X, Nº Y", "999999999", "asd@asd.com","null"));
        add(new Cooperativa("Casi","Calle X, Nº Y", "999999999", "asd@asd.com","null"));
        add(new Cooperativa("Agroponiente","Calle X, Nº Y", "999999999", "asd@asd.com","null"));
        add(new Cooperativa("Otra cooperativa","Calle X, Nº Y", "999999999", "asd@asd.com","null"));
        add(new Cooperativa("Prueba mas","Calle X, Nº Y", "999999999", "asd@asd.com","null"));
        add(new Cooperativa("Aun mas","Calle X, Nº Y", "999999999", "asd@asd.com","null"));

    }

    /**
     *  Método que añade una dependencia al repositorio
     */
    private void add(Cooperativa dependency) {
        cooperativas.add(dependency);
    }

    public ArrayList<Cooperativa> getAll(){
        return this.cooperativas;
    }

    public static CooperativaRepository getDependencyRepository() {
        return  cooperativaRepository;
    }

}
