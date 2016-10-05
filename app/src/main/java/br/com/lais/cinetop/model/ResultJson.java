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

    public ResultJson(String poster_path,String original_title,String vote_average,int id){
        setPoster_path(poster_path);
        setOriginal_title(original_title);
        setVote_average(vote_average);
        setId(id);
    }

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

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setId(int id) {
        this.id = id;
    }
}
