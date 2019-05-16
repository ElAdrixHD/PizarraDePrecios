package es.adrianmmudarra.pizarradeprecios.ui.producto;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Producto;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.ProductoRepository;

public class ProductoInteractor {

    private ProductoInterface presenter;
    ArrayList<Producto> productos;

    public ProductoInteractor(ProductoInterface presenter) {
        this.presenter = presenter;
        this.productos = new ArrayList<>();
    }

    public void loadProductos(){
        productos = ProductoRepository.getProductoRepository().getAll();
        if (productos.size() != 0){
            presenter.onSuccess(productos);
        }else {
            presenter.onError("No hay datos");
        }
    }

    interface ProductoInterface{
        void onSuccess(ArrayList<Producto> productos);
        void onError(String error);
    }
}
