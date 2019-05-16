package es.adrianmmudarra.pizarradeprecios.ui.cooperativa;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Cooperativa;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.CooperativaRepository;

public class CooperativaInteractor {

    private CooperativaInterface presenter;
    ArrayList<Cooperativa> cooperativas;

    public CooperativaInteractor(CooperativaInterface presenter) {
        this.presenter = presenter;
        cooperativas = new ArrayList<>();
    }

    public void loadCooperativas(){
        cooperativas = CooperativaRepository.getCooperativaRepository().getAll();
        if (cooperativas.size() != 0){
            presenter.onSuccess(cooperativas);
        }
        else {
            presenter.onError("No hay datos");
        }
    }

    interface CooperativaInterface{
        void onSuccess(ArrayList<Cooperativa> cooperativas);
        void onError(String error);
    }
}
