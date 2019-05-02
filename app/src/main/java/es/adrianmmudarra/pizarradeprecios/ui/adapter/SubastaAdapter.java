package es.adrianmmudarra.pizarradeprecios.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.model.Subasta;

public class SubastaAdapter extends RecyclerView.Adapter<SubastaAdapter.SubastaViewHolder> implements View.OnClickListener{

        ArrayList<Subasta> subastas;
        Context context;
        View.OnClickListener listener;

        public SubastaAdapter(Context context){
            this.context = context;
            this.subastas = new ArrayList<>();
        }

        public SubastaAdapter(Context context, View.OnClickListener listener){
            this.context = context;
            this.listener = listener;
            this.subastas = new ArrayList<>();

        }

        @NonNull
        @Override
        public SubastaAdapter.SubastaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.subasta_view,viewGroup,false);
            SubastaViewHolder subastaViewHolder = new es.adrianmmudarra.pizarradeprecios.ui.adapter.SubastaAdapter.SubastaViewHolder(v);
            v.setOnClickListener(this);
            return subastaViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull SubastaViewHolder subastaViewHolder, int i) {
            subastaViewHolder.nombre_prod.setText(subastas.get(i).getProducto());
            subastaViewHolder.precios.setText(subastas.get(i).getPrecios());
        }

        @Override
        public int getItemCount() {
            return subastas.size();
        }

        @Override
        public void onClick(View v) {
            if (listener != null)
                listener.onClick(v);
        }

        public Subasta getItem(int posicion) {
            return subastas.get(posicion);
        }

        public void clear(){
            this.subastas.clear();
        }

        public void addAll(ArrayList<Subasta> subastas){
            this.subastas.addAll(subastas);
        }



        class SubastaViewHolder extends RecyclerView.ViewHolder{
            TextView nombre_prod, precios;
            public SubastaViewHolder(View view){
                super(view);
                nombre_prod = view.findViewById(R.id.tv_subasta_nombreProd_view);
                precios = view.findViewById(R.id.tv_subasta_precios_view);
            }
        }
    }
