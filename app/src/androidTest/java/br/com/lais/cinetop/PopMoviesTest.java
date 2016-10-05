package br.com.lais.cinetop;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.lais.cinetop.activity.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class PopMoviesTest {

    private Activity activity;

    @Rule
    public ActivityTestRule testRule = new ActivityTestRule(PopMoviesActivity.class);

    @Before
    public void setUp()throws Exception
    {
        activity = testRule.getActivity();
    }

    @Test
    public void shouldNotBeNull()throws Exception
    {
        assertNotNull(activity);

    }

    
}