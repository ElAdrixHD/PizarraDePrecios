package es.adrianmmudarra.pizarradeprecios.ui.producto;

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
import es.adrianmmudarra.pizarradeprecios.data.db.model.Producto;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.ProductoRepository;
import es.adrianmmudarra.pizarradeprecios.ui.adapter.ProductoAdapter;
import es.adrianmmudarra.pizarradeprecios.ui.cooperativa.CooperativaActivity;
import es.adrianmmudarra.pizarradeprecios.ui.subasta.SubastaActivity;

public class ProductoActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    ProductoAdapter adapter;

    BottomNavigationView navigationMenu;
    BottomNavigationView.OnNavigationItemSelectedListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        setTitle("Productos");

        navigationMenu = findViewById(R.id.navigationViewProducto);
        listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_inicio:
                        finish();
                        break;
                    case R.id.navigation_cooperativas:
                        startActivity(new Intent(ProductoActivity.this, CooperativaActivity.class));
                        break;
                    case R.id.navigation_productos:
                        break;
                }
                return false;
            }
        };
        navigationMenu.setOnNavigationItemSelectedListener(listener);

        recyclerView = findViewById(R.id.recycler_prod);
        adapter = new ProductoAdapter(this,this);
        adapter.addAll(ProductoRepository.getProductoRepository().getAll());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(ProductoActivity.this, SubastaActivity.class);
        i.putExtra("nombre",adapter.getItem(recyclerView.getChildAdapterPosition(v)).getNombre());
        startActivity(i);
    }
}
