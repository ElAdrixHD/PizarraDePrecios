package es.adrianmmudarra.pizarradeprecios.ui.subasta;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Subasta;

public class SubastaPresenter implements SubastaContract.Presenter, SubastaInteractor.SubastaInteractorInterface {

    SubastaContract.View view;
    SubastaInteractor subastaInteractor;

    public SubastaPresenter(SubastaContract.View view) {
        this.view = view;
        subastaInteractor = new SubastaInteractor(this);
    }

    @Override
    public void loadSubastas(String fecha) {
        subastaInteractor.loadSubastas(fecha);
    }

    @Override
    public void getNameCooperativa(int id) {
        String nombre = subastaInteractor.getNameCoopByID(id);
        view.getNameCooperativa(nombre);
    }

    @Override
    public void onSuccess(ArrayList<Subasta> subastas) {
        view.updateAdapter(subastas);
    }

    @Override
    public void onError(String error) {
        view.showError(error);
    }
}
