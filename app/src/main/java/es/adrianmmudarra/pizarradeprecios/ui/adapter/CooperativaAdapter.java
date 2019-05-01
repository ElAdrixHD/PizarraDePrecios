package es.adrianmmudarra.pizarradeprecios.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import es.adrianmmudarra.pizarradeprecios.R;
import es.adrianmmudarra.pizarradeprecios.data.db.model.Cooperativa;

public class CooperativaAdapter extends RecyclerView.Adapter<CooperativaAdapter.CooperativaViewHolder> implements View.OnClickListener{

    ArrayList<Cooperativa> cooperativas;
    Context context;
    View.OnClickListener listener;

    public CooperativaAdapter(Context context){
        this.context = context;
        this.cooperativas = new ArrayList<>();
    }

    public CooperativaAdapter(Context context, View.OnClickListener listener){
        this.context = context;
        this.listener = listener;
        this.cooperativas = new ArrayList<>();

    }

    @NonNull
    @Override
    public CooperativaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.cooperativa_view,viewGroup,false);
        CooperativaViewHolder cooperativaViewHolder = new CooperativaViewHolder(v);
        v.setOnClickListener(this);
        return cooperativaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CooperativaViewHolder cooperativaViewHolder, int i) {
        cooperativaViewHolder.nombre_coop.setText(cooperativas.get(i).getNombre_cooperativa());
    }

    @Override
    public int getItemCount() {
        return cooperativas.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public Cooperativa getItem(int posicion) {
        return cooperativas.get(posicion);
    }

    public void clear(){
        this.cooperativas.clear();
    }

    public void addAll(ArrayList<Cooperativa> cooperativas){
        this.cooperativas.addAll(cooperativas);
    }



    class CooperativaViewHolder extends RecyclerView.ViewHolder{
        TextView nombre_coop;
        public CooperativaViewHolder(View view){
            super(view);
            nombre_coop = view.findViewById(R.id.tv_nombre_cooperativa_view);
        }
    }
}
