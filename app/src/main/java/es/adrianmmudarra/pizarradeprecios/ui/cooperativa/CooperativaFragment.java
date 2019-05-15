package es.adrianmmudarra.pizarradeprecios.ui.cooperativa;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.CooperativaRepository;
import es.adrianmmudarra.pizarradeprecios.ui.adapter.CooperativaAdapter;
import es.adrianmmudarra.pizarradeprecios.ui.dash.DashActivity;

public class CooperativaFragment extends Fragment implements View.OnClickListener {

    public static String FRAGMENT_ID = "COOPERATIVA_FRAGMENT";
    RecyclerView recyclerView;
    CooperativaAdapter adapter;
    CooperativaInterface cooperativaInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cooperativa,container,false);
        if (v != null){
            initialize(v);
        }
        return v;
    }

    private void initialize(View v) {
        recyclerView = v.findViewById(R.id.recycler_cooperativa);
        adapter = new CooperativaAdapter(getActivity(),this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.addAll(CooperativaRepository.getCooperativaRepository().getAll());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onResume() {
        super.onResume();
        cooperativaInterface.setNavegationCheck(1);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        cooperativaInterface = (DashActivity)activity;
    }

    @Override
    public void onClick(View v) {
        int id_coop = adapter.getItem(recyclerView.getChildAdapterPosition(v)).getId();
        cooperativaInterface.setSubastaFragment(id_coop);
    }


    public interface CooperativaInterface{
        void setSubastaFragment(int id_coop);
        void setNavegationCheck(int id);
    }
}
