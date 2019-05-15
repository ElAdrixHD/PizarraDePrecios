package es.adrianmmudarra.pizarradeprecios.ui.subasta;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Subasta;

public class SubastaContract {
    public interface View{
        void updateAdapter(ArrayList<Subasta> subastas);
        void showError(String error);
        void getNameCooperativa(String cooperativa);
    }

    public interface Presenter{
        void loadSubastas(String fecha);
        void getNameCooperativa(int id);
    }
}
