package es.adrianmmudarra.pizarradeprecios.ui.base;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.ui.cooperativa.CooperativaActivity;
import es.adrianmmudarra.pizarradeprecios.ui.dash.DashActivity;
import es.adrianmmudarra.pizarradeprecios.ui.producto.ProductoActivity;

public class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navigationMenu;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        ConstraintLayout constraintLayout = (ConstraintLayout)getLayoutInflater().inflate(R.layout.activity_base,null);
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.container);
        navigationMenu = constraintLayout.findViewById(R.id.navigationView);
        getLayoutInflater().inflate(layoutResID,frameLayout,true);
        navigationMenu.setOnNavigationItemSelectedListener(this);
        super.setContentView(constraintLayout);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (!menuItem.isChecked()){
            switch (menuItem.getItemId()){
                case R.id.navigation_inicio:
                    intent = new Intent(BaseActivity.this, DashActivity.class);
                    break;
                case R.id.navigation_cooperativas:
                    intent = new Intent(BaseActivity.this, CooperativaActivity.class);
                    break;
                case R.id.navigation_productos:
                    intent = new Intent(BaseActivity.this, ProductoActivity.class);
                    break;
            }
        }
        if (intent!= null){
            startActivity(intent);
        }
        menuItem.setChecked(true);
        intent = null;
        return true;
    }
}
