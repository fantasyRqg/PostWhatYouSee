package com.ranqingguo.postwhatyousee;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends Activity {

    @Bind(R.id.navdrawer)
    RecyclerView mFontList;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawer;

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

    private DrawerArrowDrawable mDrawerArrow;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActionBar ab = getActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeButtonEnabled(true);
        }


        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFontList.setAdapter(new FontAdapter(fonts));
        mFontList.setLayoutManager(new LinearLayoutManager(this));
        mFontList.setHasFixedSize(true);

        mDrawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mDrawerArrow, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back_ground:
                return true;
            case R.id.action_photo:
                return true;
            case R.id.action_font:
                return true;
            case android.R.id.home:
                if (mDrawer.isDrawerOpen(mFontList)) {
                    mDrawer.closeDrawer(mFontList);
                } else {
                    mDrawer.openDrawer(mFontList);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
