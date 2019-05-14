package es.adrianmmudarra.pizarradeprecios.ui.dash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.ui.base.BaseActivity;

public class DashActivity extends BaseActivity {

    FragmentManager fragmentManager;
    DashFragment dashFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        setTitle("Pantalla Principal");
        fragmentManager = getSupportFragmentManager();
        dashFragment = (DashFragment)fragmentManager.findFragmentByTag(DashFragment.FRAGMENT_ID);
        if (dashFragment == null){
            dashFragment = new DashFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.frame_dash,dashFragment,DashFragment.FRAGMENT_ID);
            transaction.commit();
        }
    }
}
