package es.adrianmmudarra.pizarradeprecios.ui.producto;


import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Producto;

public class ProductoPresenter implements ProductoContract.Presenter, ProductoInteractor.ProductoInterface {

    private ProductoContract.View view;
    private ProductoInteractor interactor;

    public ProductoPresenter(ProductoContract.View view) {
        this.view = view;
        interactor = new ProductoInteractor(this);
    }

    @Override
    public void loadProductos() {
        interactor.loadProductos();
    }

    @Override
    public void onSuccess(ArrayList<Producto> productos) {
        view.updateAdapter(productos);
    }

    @Override
    public void onError(String error) {
        view.showError(error);
    }
}
