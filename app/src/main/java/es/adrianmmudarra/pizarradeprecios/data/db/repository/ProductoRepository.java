package es.adrianmmudarra.pizarradeprecios.data.db.repository;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Producto;

public class ProductoRepository {
    private ArrayList<Producto> productos;
    private static ProductoRepository productoRepository;

    //INICIALIZACIÓN ESTÁTICA DE CLASE
    static {
        productoRepository = new ProductoRepository();
    }

    private ProductoRepository() {
        this.productos = new ArrayList<>();
        initialice();
    }

    private void initialice() {
        add(new Producto(1,"Berenjenas"));
        add(new Producto(2, "Pimientos"));
        add(new Producto(3, "Tomates"));
        add(new Producto(4,"Fresas"));
        add(new Producto(5,"Tomates 2"));
        add(new Producto(6, "Pimientos"));
        add(new Producto(7, "Berenjenas"));
        add(new Producto(8,"Verduras"));
    }

    private void add(Producto dependency) {
        productos.add(dependency);
    }

    public ArrayList<Producto> getAll() {
        return this.productos;
    }


    public static ProductoRepository getProductoRepository() {
        return  productoRepository;
    }

}
