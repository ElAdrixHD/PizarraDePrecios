package es.adrianmmudarra.pizarradeprecios.ui.subasta;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.data.db.model.Subasta;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.CooperativaRepository;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.SubastaRepository;

public class SubastaInteractor {

    ArrayList<Subasta> subastas;
    private SubastaInteractorInterface listener;

    public SubastaInteractor(SubastaInteractorInterface listener) {
        this.listener = listener;
        subastas = new ArrayList<>();
    }

    public void loadSubastas(String date){
        subastas = SubastaRepository.getSubastaRepository().getSubastasByFecha(date);
        if (subastas.size() != 0){
            listener.onSuccess(subastas);
        }else{
            listener.onError("No hay datos");
        }
    }

    public String getNameCoopByID(int id){
        return CooperativaRepository.getCooperativaRepository().getCooperativaByID(id).getNombre_cooperativa();
    }

    interface SubastaInteractorInterface{
        void onSuccess(ArrayList<Subasta> subastas);
        void onError(String error);
    }
}
