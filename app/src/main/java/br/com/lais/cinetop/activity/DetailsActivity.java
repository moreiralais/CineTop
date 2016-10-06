package br.com.lais.cinetop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.lais.cinetop.R;
import br.com.lais.cinetop.adapter.DetailsAdapter;
import br.com.lais.cinetop.adapter.ListaAdapter;
import br.com.lais.cinetop.model.JsonResponse;
import br.com.lais.cinetop.model.JsonResponseDetails;
import br.com.lais.cinetop.model.ResultJson;
import br.com.lais.cinetop.service.MovieAPI;
import br.com.lais.cinetop.service.MovieAPIInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    private DetailsAdapter detailsAdapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ResultJson filme = (ResultJson) getIntent().getSerializableExtra("filme");

        if (filme!=null){

            Log.i("LOG-CINE","filme id === "+filme.getId());

            MovieAPI movieAPI = MovieAPIInstance.getMovieAPI();
            String api_key = DetailsActivity.this.getResources().getString(R.string.api_key);

            layoutManager = new LinearLayoutManager(DetailsActivity.this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            recyclerView = (RecyclerView) findViewById(R.id.recycler_details);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);

            Call<JsonResponseDetails> call = movieAPI.getDetails(filme.getId(),api_key);

            call.enqueue(new Callback<JsonResponseDetails>() {
                @Override
                public void onResponse(Call<JsonResponseDetails> call, Response<JsonResponseDetails> response) {
                    JsonResponseDetails jsonResponse = response.body();
                    tratarRetornoCallback(jsonResponse);
                }

                @Override
                public void onFailure(Call<JsonResponseDetails> call, Throwable t) {

                }
            });



        }
    }

    private void tratarRetornoCallback(JsonResponseDetails jsonResponse) {

        List<JsonResponseDetails> lista = new ArrayList<>();
        lista.add(jsonResponse);

        detailsAdapter = new DetailsAdapter(getApplicationContext(), lista);
        recyclerView.setAdapter(detailsAdapter);
    }
}
