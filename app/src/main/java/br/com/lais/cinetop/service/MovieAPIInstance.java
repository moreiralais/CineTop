package br.com.lais.cinetop.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lais on 02/10/2016.
 */
public class MovieAPIInstance {

    public static MovieAPI getMovieAPI() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(MovieAPI.ENDPOINT).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(MovieAPI.class);
    }
}
