package es.adrianmmudarra.pizarradeprecios.ui.cooperativa;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.CooperativaRepository;
import es.adrianmmudarra.pizarradeprecios.ui.adapter.CooperativaAdapter;

public class CooperativaActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    CooperativaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooperativa);

        recyclerView = findViewById(R.id.recycler_cooperativa);
        adapter = new CooperativaAdapter(this,this);
        adapter.addAll(CooperativaRepository.getDependencyRepository().getAll());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Cooperativa: " + (adapter.getItem(recyclerView.getChildAdapterPosition(v)).getNombre_cooperativa()), Snackbar.LENGTH_SHORT).show();
    }
}
