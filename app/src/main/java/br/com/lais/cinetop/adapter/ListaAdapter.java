package br.com.lais.cinetop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.List;

import br.com.lais.cinetop.R;
import br.com.lais.cinetop.listener.RecyclerViewOnClickListener;
import br.com.lais.cinetop.model.ResultJson;

/**
 * Created by Lais on 02/10/2016.
 */
public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

    private List<ResultJson> resultJsons;
    private Context contexto;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public ListaAdapter(Context contexto,List<ResultJson> resultJsons) {
        this.resultJsons = resultJsons;
        this.contexto = contexto;
        layoutInflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.card_filme, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        holder.titulo.setText(resultJsons.get(i).getOriginal_title());

        String foto = resultJsons.get(i).getPoster_path();

        Picasso.with(contexto)
                .load("http://image.tmdb.org/t/p/w185/"+foto)
                .placeholder(R.mipmap.ic_account)
                .error(R.mipmap.ic_account)
                .into(holder.foto);

        holder.nota.setRating(Float.parseFloat(resultJsons.get(i).getVote_average()));


    }

    @Override
    public int getItemCount() {
        return resultJsons.size();
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener r){
        recyclerViewOnClickListener = r;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView titulo;
        private RatingBar nota;
        private ImageView foto;

        public ViewHolder(View view) {
            super(view);

            titulo = (TextView)view.findViewById(R.id.titulo);
            foto = (ImageView)view.findViewById(R.id.foto);
            nota = (RatingBar)view.findViewById(R.id.nota);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(recyclerViewOnClickListener!=null){
                recyclerViewOnClickListener.onClickListener(v,getAdapterPosition());
            }
        }
    }
}
