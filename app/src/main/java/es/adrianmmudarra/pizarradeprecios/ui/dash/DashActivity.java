package es.adrianmmudarra.pizarradeprecios.ui.dash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.model.Cooperativa;
import es.adrianmmudarra.pizarradeprecios.ui.base.BaseActivity;
import es.adrianmmudarra.pizarradeprecios.ui.cooperativa.CooperativaFragment;
import es.adrianmmudarra.pizarradeprecios.ui.subasta.SubastaFragment;

public class DashActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, CooperativaFragment.CooperativaInterface {

    FragmentManager fragmentManager;
    DashFragment dashFragment;
    CooperativaFragment cooperativaFragment;
    SubastaFragment subastaFragment;
    boolean firstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dash);
        setTitle("Pantalla Principal");
        firstFragment = true;
        getNavigationMenu().setOnNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        setInicioFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (!menuItem.isChecked()){
            switch (menuItem.getItemId()){
                case R.id.navigation_inicio:
                    Toast.makeText(this,"Menu Inicio",Toast.LENGTH_SHORT).show();
                    setInicioFragment();
                    break;
                case R.id.navigation_cooperativas:
                    Toast.makeText(this,"Menu Coop",Toast.LENGTH_SHORT).show();
                    setCooperativaFragment();
                    break;
                case R.id.navigation_productos:
                    Toast.makeText(this,"Menu Prod",Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        menuItem.setChecked(true);
        return true;
    }

    private void setInicioFragment() {
        dashFragment = (DashFragment)fragmentManager.findFragmentByTag(DashFragment.FRAGMENT_ID);
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        if (dashFragment == null) {
            dashFragment = new DashFragment();
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!firstFragment){
            transaction.replace(R.id.container,dashFragment,DashFragment.FRAGMENT_ID);
            transaction.addToBackStack(null);
        }else {
            transaction.add(R.id.container,dashFragment,DashFragment.FRAGMENT_ID);
            firstFragment= false;
        }
        transaction.commit();
    }

    private void setCooperativaFragment() {
        cooperativaFragment = (CooperativaFragment)fragmentManager.findFragmentByTag(CooperativaFragment.FRAGMENT_ID);
        fragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        if (cooperativaFragment == null) {
            cooperativaFragment = new CooperativaFragment();
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
           transaction.replace(R.id.container,cooperativaFragment,CooperativaFragment.FRAGMENT_ID);
           transaction.addToBackStack(null);
           transaction.commit();

    }

    public void setNavegationCheck(int id){
        Menu m=getNavigationMenu().getMenu();
        MenuItem mi=m.getItem(id);
        mi.setChecked(true);
    }

    @Override
    public void setSubastaFragment(int id_coop) {
        Bundle bundle = new Bundle();
        bundle.putInt("ID", id_coop);
        subastaFragment = (SubastaFragment) fragmentManager.findFragmentByTag(SubastaFragment.FRAGMENT_ID);
        if (subastaFragment == null) {
            subastaFragment = new SubastaFragment();
        }
        subastaFragment.setArguments(bundle);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,subastaFragment,SubastaFragment.FRAGMENT_ID);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
