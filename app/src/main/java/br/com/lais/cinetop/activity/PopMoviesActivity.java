package br.com.lais.cinetop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.lais.cinetop.R;
import br.com.lais.cinetop.adapter.ListaAdapter;
import br.com.lais.cinetop.listener.RecyclerViewOnClickListener;
import br.com.lais.cinetop.model.JsonResponse;
import br.com.lais.cinetop.model.ResultJson;
import br.com.lais.cinetop.service.MovieAPI;
import br.com.lais.cinetop.service.MovieAPIInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopMoviesActivity extends AppCompatActivity implements RecyclerViewOnClickListener{

    private ListaAdapter listaAdapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private List<ResultJson> listaFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layoutManager = new LinearLayoutManager(PopMoviesActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_filme);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        MovieAPI movieAPI = MovieAPIInstance.getMovieAPI();
        String api_key = PopMoviesActivity.this.getResources().getString(R.string.api_key);

        Call<JsonResponse> call = movieAPI.getLista(api_key);

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                JsonResponse jsonResponse = response.body();
                listaFilmes = new ArrayList<>(Arrays.asList(jsonResponse.getResults()));
                listaAdapter = new ListaAdapter(getApplicationContext(),listaFilmes);
                listaAdapter.setRecyclerViewOnClickListener(PopMoviesActivity.this);
                recyclerView.setAdapter(listaAdapter);
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Toast.makeText(PopMoviesActivity.this,"Erro interno. Por favor tente mais tarde.",Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickListener(View view, int posicao) {
        int itemPosition = recyclerView.getChildLayoutPosition(view);
        ResultJson filme = listaFilmes.get(itemPosition);

        Intent intent = new Intent(PopMoviesActivity.this,DetailsActivity.class);
        intent.putExtra("filme", filme);
        startActivity(intent);
    }
}
