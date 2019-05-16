package es.adrianmmudarra.pizarradeprecios.ui.cooperativa;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Cooperativa;

public class CooperativaPresenter implements CooperativaContract.Presenter, CooperativaInteractor.CooperativaInterface {

    private CooperativaContract.View view;
    private CooperativaInteractor interactor;

    public CooperativaPresenter(CooperativaContract.View view) {
        this.view = view;
        interactor = new CooperativaInteractor(this);
    }

    @Override
    public void loadCooperativas() {
        interactor.loadCooperativas();
    }

    @Override
    public void onSuccess(ArrayList<Cooperativa> cooperativas) {
        view.updateAdapter(cooperativas);
    }

    @Override
    public void onError(String error) {
        view.showError(error);
    }
}
