package br.com.lais.cinetop.model;

/**
 * Created by Lais on 02/10/2016.
 */
public class JsonResponseDetails {

    String overview;//○ sinopse ­> descrição sucinta do filme
    int runtime;//○ duração ­> x minutos ou horas
    Genre[] genres;//○ gênero ­> ação, terror etc.
    String original_language;//○ país de origem ­> EUA
    String vote_average;//○ classificação ­> as estrelas
    String poster_path;//foto em cartaz
    String original_title;

    public String getOverview() {
        return overview;
    }

    public int getRuntime() {
        return runtime;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }
}
