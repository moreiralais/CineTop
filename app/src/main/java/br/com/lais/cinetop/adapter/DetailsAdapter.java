package br.com.lais.cinetop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import br.com.lais.cinetop.model.Genre;
import br.com.lais.cinetop.model.JsonResponseDetails;
import br.com.lais.cinetop.model.ResultJson;

/**
 * Created by Lais on 02/10/2016.
 */
public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder>{

    private List<JsonResponseDetails> resultJsons;
    private Context contexto;
    private LayoutInflater layoutInflater;

    public DetailsAdapter(Context contexto,List<JsonResponseDetails> filme) {
        this.resultJsons = filme;
        this.contexto = contexto;
        layoutInflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.card_details, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        holder.titulo.setText(resultJsons.get(i).getOriginal_title());
        holder.overview.setText(resultJsons.get(i).getOverview());
        holder.duracao.setText(String.valueOf(resultJsons.get(i).getRuntime())+" min");
        StringBuilder genero = new StringBuilder();
        for(Genre r :resultJsons.get(i).getGenres()){

            Log.i("LOG-CINE", "====== "+r.getName());
            genero.append(r.getName());
            genero.append(" ");
        }
        holder.genero.setText(genero.toString());
        holder.origem.setText(resultJsons.get(i).getOriginal_language());

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


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo,overview,duracao,genero,origem;
        private RatingBar nota;
        private ImageView foto;

        public ViewHolder(View view) {
            super(view);

            titulo = (TextView)view.findViewById(R.id.titulo);
            overview = (TextView)view.findViewById(R.id.overview);
            duracao = (TextView)view.findViewById(R.id.duracao);
            genero = (TextView)view.findViewById(R.id.genero);
            origem = (TextView)view.findViewById(R.id.origem);
            foto = (ImageView)view.findViewById(R.id.foto);
            nota = (RatingBar)view.findViewById(R.id.nota);


        }

    }
}
