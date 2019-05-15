package es.adrianmmudarra.pizarradeprecios.ui.dash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.R;

public class DashFragment extends Fragment {
    public static String FRAGMENT_ID = "dash_fragment";
    BarChart chart, chart2;
    ArrayList<BarEntry> NoOfEmp;
    ArrayList<String> year;
    BarDataSet bardataset;
    BarData data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dash,container,false);
        if (v != null){
            initialize(v);
        }
        return v;
    }

    private void initialize(View v) {
        chart = v.findViewById(R.id.barchart);
        chart2 = v.findViewById(R.id.barchart2);
        NoOfEmp = new ArrayList<>();
        year = new ArrayList<>();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((DashActivity)getActivity()).setNavegationCheck(0);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

        bardataset = new BarDataSet(NoOfEmp, "No Of Employee");
        chart.animateY(3000);
        chart.setHighlightFullBarEnabled(true);
        chart.setFitBars(false);

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new BarData(bardataset);

        chart.setData(data);

        chart2.animateY(3000);
        chart2.setHighlightFullBarEnabled(true);
        chart2.setFitBars(false);

        chart2.setData(data);
    }
}
