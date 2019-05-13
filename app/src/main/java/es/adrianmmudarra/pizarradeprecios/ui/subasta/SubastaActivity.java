package es.adrianmmudarra.pizarradeprecios.ui.subasta;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.model.Cooperativa;
import es.adrianmmudarra.pizarradeprecios.data.db.model.Producto;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.CooperativaRepository;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.ProductoRepository;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.SubastaRepository;
import es.adrianmmudarra.pizarradeprecios.ui.adapter.SubastaAdapter;
import es.adrianmmudarra.pizarradeprecios.ui.cooperativa.CooperativaActivity;
import es.adrianmmudarra.pizarradeprecios.ui.dash.DashActivity;
import es.adrianmmudarra.pizarradeprecios.ui.producto.ProductoActivity;

public class SubastaActivity extends AppCompatActivity implements View.OnClickListener {
    int id;
    String producto;
    TextView t;
    EditText etPlannedDate;
    RecyclerView recyclerView;
    SubastaAdapter adapter;

    BottomNavigationView navigationMenu;
    BottomNavigationView.OnNavigationItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subasta);
        setTitle("Subasta");
        id = getIntent().getIntExtra("ID",0);
        producto = getIntent().getStringExtra("nombre");
        etPlannedDate = findViewById(R.id.etPlannedDate);
        t = findViewById(R.id.tv_subasta_nombreCoop);

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd / MM / yyyy");
        String formattedDate = df.format(c);

        if (id != 0){
            t.setText(CooperativaRepository.getCooperativaRepository().getCooperativaByID(id).getNombre_cooperativa());
            etPlannedDate.setOnClickListener(this);
            etPlannedDate.setText(formattedDate);
        }else {
            t.setText(producto);
        }



        recyclerView = findViewById(R.id.recycler_subasta);
        adapter = new SubastaAdapter(this);
        if (id != 0){
            adapter.addAll(SubastaRepository.getSubastaRepository().getSubastasByFecha(formattedDate));
        }else{
            adapter.addAll(SubastaRepository.getSubastaRepository().getSubastasByProducto(producto));
        }

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        navigationMenu = findViewById(R.id.navigationViewSubasta);
        listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_inicio:
                        startActivity(new Intent(SubastaActivity.this,DashActivity.class));
                        break;
                    case R.id.navigation_cooperativas:
                        startActivity(new Intent(SubastaActivity.this, CooperativaActivity.class));
                        break;
                    case R.id.navigation_productos:
                        startActivity(new Intent(SubastaActivity.this, ProductoActivity.class));
                        break;
                }
                return false;
            }
        };
        navigationMenu.setOnNavigationItemSelectedListener(listener);
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
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
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
                adapter.clear();
                adapter.addAll(SubastaRepository.getSubastaRepository().getSubastasByFecha(text));
                adapter.notifyDataSetChanged();
            }
        });
        newFragment.show(this.getSupportFragmentManager(), "datePicker");
    }
}
