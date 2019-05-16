package es.adrianmmudarra.pizarradeprecios.ui.producto;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Producto;

public class ProductoContract {
    public interface View{
        void updateAdapter(ArrayList<Producto> productos);
        void showError(String error);
    }
    public interface Presenter{
        void loadProductos();
    }
}
