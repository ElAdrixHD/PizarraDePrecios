package es.adrianmmudarra.pizarradeprecios.ui.dash;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.ui.cooperativa.CooperativaActivity;
import es.adrianmmudarra.pizarradeprecios.ui.producto.ProductoActivity;

public class DashActivity extends AppCompatActivity {

    BottomNavigationView navigationMenu;
    BottomNavigationView.OnNavigationItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        setTitle("Pantalla Principal");
        BarChart chart = findViewById(R.id.barchart);
        BarChart chart2 = findViewById(R.id.barchart2);
        navigationMenu = findViewById(R.id.navigationViewDash);
        listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_inicio:
                        break;
                    case R.id.navigation_cooperativas:
                        startActivity(new Intent(DashActivity.this, CooperativaActivity.class));
                        break;
                    case R.id.navigation_productos:
                        startActivity(new Intent(DashActivity.this, ProductoActivity.class));
                        break;
                }
                return false;
            }
        };
        navigationMenu.setOnNavigationItemSelectedListener(listener);

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(945f, 0));
        NoOfEmp.add(new BarEntry(1040f, 1));
        NoOfEmp.add(new BarEntry(1133f, 2));
        NoOfEmp.add(new BarEntry(1240f, 3));
        NoOfEmp.add(new BarEntry(1369f, 4));
        NoOfEmp.add(new BarEntry(1487f, 5));
        NoOfEmp.add(new BarEntry(1501f, 6));
        NoOfEmp.add(new BarEntry(1645f, 7));
        NoOfEmp.add(new BarEntry(1578f, 8));
        NoOfEmp.add(new BarEntry(1695f, 9));

        ArrayList year = new ArrayList();

        year.add("2008");
        year.add("2009");
        year.add("2010");
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "No Of Employee");
        chart.animateY(5000);
        chart.setHighlightFullBarEnabled(true);
        chart.setFitBars(false);

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(bardataset);

        chart.setData(data);

        chart2.animateY(5000);
        chart2.setHighlightFullBarEnabled(true);
        chart2.setFitBars(false);

        chart2.setData(data);
    }
}
