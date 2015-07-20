package com.ranqingguo.postwhatyousee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    String[] fonts = new String[]{
            "black",
            "Han yi xing kai ",
            "finally",
            "could you test", "black",
            "Han yi xing kai ",
            "finally",
            "could you test", "black",
            "Han yi xing kai ",
            "finally",
            "could you test", "black",
            "Han yi xing kai ",
            "finally",
            "could you test", "black",
            "Han yi xing kai ",
            "finally",
            "could you test", "black",
            "Han yi xing kai ",
            "finally",
            "could you test"
    };

    @Bind(R.id.navdrawer)
    RecyclerView fontList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fontList.setAdapter(new FontAdapter(fonts));
        fontList.setLayoutManager(new LinearLayoutManager(this));
        fontList.setHasFixedSize(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back_ground:
                return true;
            case R.id.action_photo:
                return true;
            case R.id.action_font:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
