package es.adrianmmudarra.pizarradeprecios.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.model.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> implements View.OnClickListener{

    ArrayList<Producto> productos;
    Context context;
    View.OnClickListener listener;

    public ProductoAdapter(Context context){
        this.context = context;
        this.productos = new ArrayList<>();
    }

    public ProductoAdapter(Context context, View.OnClickListener listener){
        this.context = context;
        this.listener = listener;
        this.productos = new ArrayList<>();

    }

    @NonNull
    @Override
    public ProductoAdapter.ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.producto_view,viewGroup,false);
        ProductoViewHolder productoViewHolder = new es.adrianmmudarra.pizarradeprecios.ui.adapter.ProductoAdapter.ProductoViewHolder(v);
        v.setOnClickListener(this);
        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre_prod.setText(productos.get(i).getNombre());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public Producto getItem(int posicion) {
        return productos.get(posicion);
    }

    public void clear(){
        this.productos.clear();
    }

    public void addAll(ArrayList<Producto> productos){
        this.productos.addAll(productos);
    }



    class ProductoViewHolder extends RecyclerView.ViewHolder{
        TextView nombre_prod;
        public ProductoViewHolder(View view){
            super(view);
            nombre_prod = view.findViewById(R.id.tv_producto_nombre);
        }
    }
}
