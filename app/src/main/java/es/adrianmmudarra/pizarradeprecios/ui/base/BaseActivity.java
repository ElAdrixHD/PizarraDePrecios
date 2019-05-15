package es.adrianmmudarra.pizarradeprecios.ui.base;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.adrianmmudarra.pizarradeprecios.R;

public class BaseActivity extends AppCompatActivity{

    BottomNavigationView navigationMenu;
//    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        navigationMenu = findViewById(R.id.navigationView);
    }

    public BottomNavigationView getNavigationMenu() {
        return navigationMenu;
    }

    /*@Override
    public void setContentView(int layoutResID) {
        ConstraintLayout constraintLayout = (ConstraintLayout)getLayoutInflater().inflate(R.layout.activity_base,null);
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.container);
        navigationMenu = constraintLayout.findViewById(R.id.navigationView);
        getLayoutInflater().inflate(layoutResID,frameLayout,true);
        super.setContentView(constraintLayout);

    }*/
}
