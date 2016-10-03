package br.com.lais.cinetop.service;

import br.com.lais.cinetop.model.JsonResponse;
import br.com.lais.cinetop.model.JsonResponseDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Lais on 02/10/2016.
 */
public interface MovieAPI {

    String ENDPOINT = "http://api.themoviedb.org";

    @GET("/3/movie/popular")
    Call<JsonResponse> getLista(@Query("api_key") String api_key);


    @GET("/3/movie/{id}")
    Call<JsonResponseDetails> getDetails(@Path("id") int id,@Query("api_key") String api_key);


}
