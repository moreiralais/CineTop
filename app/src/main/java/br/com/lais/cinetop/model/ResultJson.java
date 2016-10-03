package br.com.lais.cinetop.model;

import java.io.Serializable;

/**
 * Created by Lais on 02/10/2016.
 */
public class ResultJson implements Serializable{

    String poster_path;//foto em cartaz
    String original_title;//título do filme
    String vote_average;// nota
    int id;

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public int getId() {
        return id;
    }
}
