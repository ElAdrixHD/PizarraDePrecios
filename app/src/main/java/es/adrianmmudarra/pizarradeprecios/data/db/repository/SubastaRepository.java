package es.adrianmmudarra.pizarradeprecios.data.db.repository;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Subasta;

public class SubastaRepository {
    private ArrayList<Subasta> subastas;
    private static SubastaRepository subastaRepository;

    //INICIALIZACIÓN ESTÁTICA DE CLASE
    static {
        subastaRepository = new SubastaRepository();
    }

    private SubastaRepository() {
        this.subastas = new ArrayList<>();
        initialice();
    }

    private void initialice() {
        add(new Subasta("02 / 05 / 2019", "AgrupaAdra", "Berenjenas", "1.16,1.14,1.12,1.10"));
        add(new Subasta("02 / 05 / 2019", "AgrupaAdra", "Pimientos", "1.16,1.14,1.12,1.10"));
        add(new Subasta("02 / 05 / 2019", "AgrupaAdra", "Tomates", "1.16,1.14,1.12,1.10"));
        add(new Subasta("02 / 05 / 2019", "AgrupaAdra", "Fresas", "1.16,1.14,1.12,1.10"));
        add(new Subasta("02 / 05 / 2019", "AgrupaAdra", "Tomates 2", "1.16,1.14,1.12,1.10"));
        add(new Subasta("01 / 05 / 2019", "AgrupaAdra", "Pimientos", "1.16,1.14,1.12,1.10"));
        add(new Subasta("01 / 05 / 2019", "AgrupaAdra", "Berenjenas", "1.16,1.14,1.12,1.10"));
        add(new Subasta("01 / 05 / 2019", "AgrupaAdra", "Verduras", "1.16,1.14,1.12,1.10"));

    }

    private void add(Subasta dependency) {
        subastas.add(dependency);
    }

    public ArrayList<Subasta> getAll() {
        return this.subastas;
    }

    public ArrayList<Subasta> getSubastasByFecha(String fecha) {
        ArrayList<Subasta> tmp = new ArrayList<>();
        for (Subasta s : subastas){
            if (s.getFecha_subasta().equals(fecha)){
                tmp.add(s);
            }
        }
        return tmp;
    }

    public ArrayList<Subasta> getSubastasByProducto(String producto) {
        ArrayList<Subasta> tmp = new ArrayList<>();
        for (Subasta s : subastas){
            if (s.getProducto().equals(producto)){
                tmp.add(s);
            }
        }
        return tmp;
    }


    public static SubastaRepository getSubastaRepository() {
        return  subastaRepository;
    }

}
