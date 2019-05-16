package es.adrianmmudarra.pizarradeprecios.ui.subasta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.model.Subasta;
import es.adrianmmudarra.pizarradeprecios.ui.adapter.SubastaAdapter;

public class SubastaFragment extends Fragment implements View.OnClickListener, SubastaContract.View {

    public static String FRAGMENT_ID ="subasta_fragment";

    int id_cooperativa;
    String producto;
    TextView tv_name_coop;
    EditText etPlannedDate;
    RecyclerView recyclerView;
    SubastaAdapter adapter;
    Date today;
    SimpleDateFormat df = new SimpleDateFormat("dd / MM / yyyy");
    String formattedDate;
    SubastaContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_subasta,container,false);
        if (v != null){
            initialize(v);
        }
        return v;
    }

    private void initialize(View v) {
        id_cooperativa = getArguments().getInt("ID",0);
        producto = getArguments().getString("nombre");
        etPlannedDate = v.findViewById(R.id.etPlannedDate);
        tv_name_coop = v.findViewById(R.id.tv_subasta_nombreCoop);
        today = Calendar.getInstance().getTime();
        formattedDate = df.format(today);
        recyclerView = v.findViewById(R.id.recycler_subasta);
        adapter = new SubastaAdapter(getContext());
        presenter = new SubastaPresenter(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getNameCooperativa(id_cooperativa);
        etPlannedDate.setOnClickListener(this);
        etPlannedDate.setText(formattedDate);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        presenter.loadSubastas(formattedDate);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etPlannedDate:
                showDatePickerDialog();
                break;
        }
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance((datePicker, year, month, day) -> {
            String text = "";
            final String selectedDate = day + " / " + (month+1) + " / " + year;
            SimpleDateFormat sdf = new SimpleDateFormat("dd / MM / yyyy");
            try {
                Date d = sdf.parse(selectedDate);
                text = sdf.format(d);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            etPlannedDate.setText(text);
            presenter.loadSubastas(text);
        });
        newFragment.show(getFragmentManager(), "datePicker");
    }

    @Override
    public void updateAdapter(ArrayList<Subasta> subastas) {
        adapter.clear();
        adapter.addAll(subastas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
        adapter.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getNameCooperativa(String cooperativa) {
        tv_name_coop.setText(cooperativa);
    }
}
