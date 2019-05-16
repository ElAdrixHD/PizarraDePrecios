package es.adrianmmudarra.pizarradeprecios.ui.producto;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.model.Producto;
import es.adrianmmudarra.pizarradeprecios.data.db.repository.ProductoRepository;
import es.adrianmmudarra.pizarradeprecios.ui.adapter.ProductoAdapter;
import es.adrianmmudarra.pizarradeprecios.ui.dash.DashActivity;

public class ProductoFargment extends Fragment implements View.OnClickListener, ProductoContract.View{

    public static String FRAGMENT_ID = "producto_fragment";
    RecyclerView recyclerView;
    ProductoAdapter adapter;
    ProductoInterface listener;
    ProductoContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_producto,container,false);
        if (v != null){
            initialize(v);
        }
        return v;
    }

    private void initialize(View v) {
        recyclerView = v.findViewById(R.id.recycler_prod);
        adapter = new ProductoAdapter(getContext(),this);
        presenter = new ProductoPresenter(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter.loadProductos();
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.setNavegationCheck(2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (DashActivity)context;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void updateAdapter(ArrayList<Producto> productos) {
        adapter.clear();
        adapter.addAll(productos);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }

    public interface ProductoInterface{
        void setSubastaProductoFragment(int id_prod);
        void setNavegationCheck(int id);
    }
}
