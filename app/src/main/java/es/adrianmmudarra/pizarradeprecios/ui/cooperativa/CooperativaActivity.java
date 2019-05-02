package es.adrianmmudarra.pizarradeprecios.ui.cooperativa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.CooperativaRepository;
import es.adrianmmudarra.pizarradeprecios.ui.adapter.CooperativaAdapter;
import es.adrianmmudarra.pizarradeprecios.ui.dash.DashActivity;
import es.adrianmmudarra.pizarradeprecios.ui.producto.ProductoActivity;
import es.adrianmmudarra.pizarradeprecios.ui.subasta.SubastaActivity;

public class CooperativaActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    CooperativaAdapter adapter;

    BottomNavigationView navigationMenu;
    BottomNavigationView.OnNavigationItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooperativa);
        setTitle("Cooperativas");
        recyclerView = findViewById(R.id.recycler_cooperativa);
        adapter = new CooperativaAdapter(this,this);
        adapter.addAll(CooperativaRepository.getCooperativaRepository().getAll());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        navigationMenu = findViewById(R.id.navigationViewCooperativa);
        listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_inicio:
                        finish();
                        break;
                    case R.id.navigation_cooperativas:

                        break;
                    case R.id.navigation_productos:
                        startActivity(new Intent(CooperativaActivity.this, ProductoActivity.class));
                        break;
                }
                return false;
            }
        };
        navigationMenu.setOnNavigationItemSelectedListener(listener);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(CooperativaActivity.this, SubastaActivity.class);
        i.putExtra("ID",adapter.getItem(recyclerView.getChildAdapterPosition(v)).getId());
        startActivity(i);
        //Snackbar.make(v, "Cooperativa: " + (adapter.getItem(recyclerView.getChildAdapterPosition(v)).getNombre_cooperativa()), Snackbar.LENGTH_SHORT).show();
    }
}
