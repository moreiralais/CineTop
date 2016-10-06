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

import java.io.Serializable;

import br.com.lais.cinetop.activity.DetailsActivity;
import br.com.lais.cinetop.model.ResultJson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class DetailsTest {


    private RecyclerView recyclerView;
    private Activity launchActivity;

    @Rule
    public ActivityTestRule testRule = new ActivityTestRule(DetailsActivity.class);
    private TextView duracao;
    private TextView origem;


    @Before
    public void setUp()throws Exception
    {
        launchActivity = testRule.launchActivity(new Intent().putExtra("filme", new ResultJson("poster_path","original_title","vote_average",550)));
        recyclerView = (RecyclerView) launchActivity.findViewById(R.id.recycler_details);
        duracao = (TextView)launchActivity.findViewById(R.id.duracao);
        origem = (TextView) launchActivity.findViewById(R.id.origem);

    }

    @Test
    public void activityNaoDeveSerNull()throws Exception
    {
        assertNotNull(launchActivity);

    }

    @Test
    public void recyclerViewNaoDeveSerNull()throws Exception
    {
        assertNotNull(recyclerView);

    }

    @Test
    public void deveTerIntent() throws Exception{
        Serializable filme = launchActivity.getIntent().getSerializableExtra("filme");
        assertNotNull(filme);

    }

    @Test
    public void recyclerViewLayoutManagerNaoDeveSerNull () throws Exception{
        assertNotNull(recyclerView.getLayoutManager());
    }

    @Test
    public void recyclerViewHasFixedSize() throws Exception{
        assertTrue(recyclerView.hasFixedSize());
    }

}