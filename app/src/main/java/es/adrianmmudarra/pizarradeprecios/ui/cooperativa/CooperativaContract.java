package es.adrianmmudarra.pizarradeprecios.ui.cooperativa;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Cooperativa;

public class CooperativaContract {
    public interface View{
        void updateAdapter(ArrayList<Cooperativa> cooperativas);
        void showError(String error);
    }

    public interface Presenter{
        void loadCooperativas();
    }
}
