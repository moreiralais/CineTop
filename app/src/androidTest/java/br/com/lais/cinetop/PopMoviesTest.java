package br.com.lais.cinetop;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.lais.cinetop.activity.*;
import br.com.lais.cinetop.model.ResultJson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class PopMoviesTest {

    private Activity activity;
    private RecyclerView recyclerView;

    @Rule
    public ActivityTestRule testRule = new ActivityTestRule(PopMoviesActivity.class);
    private TextView titulo;

    @Before
    public void setUp()throws Exception
    {
        activity = testRule.getActivity();
        recyclerView = (RecyclerView) activity.findViewById(R.id.recycler_filme);
        titulo = (TextView) activity.findViewById(R.id.titulo);
    }

    @Test
    public void activityNaoDeveSerNull()throws Exception
    {
        assertNotNull(activity);

    }

    @Test
    public void recyclerViewNaoDeveSerNull()throws Exception
    {
        assertNotNull(recyclerView);

    }

    @Test
    public void recyclerViewLayoutManagerNaoDeveSerNull () throws Exception{
        assertNotNull(recyclerView.getLayoutManager());
    }

    @Test
    public void tituloNaoDeveSerNulo() throws Exception{
        assertNotNull(titulo.getText());
    }



}