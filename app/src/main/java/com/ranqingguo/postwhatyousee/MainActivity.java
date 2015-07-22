package com.ranqingguo.postwhatyousee;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;
import com.ranqingguo.postwhatyousee.common.ClassHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends Activity {

    @Bind(R.id.navdrawer)
    RecyclerView mFontList;

    @Bind(R.id.scrollView)
    ScrollView mScrollView;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @Bind(R.id.time_text)
    TextView timeText;

    @Bind(R.id.content_editor)
    EditText mContentEditor;

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
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy,HH:mm", Locale.ENGLISH);
        timeText.setText(sdf.format(new Date()));


        DrawerArrowDrawable mDrawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mDrawerArrow, R.string.drawer_open, R.string.drawer_close) {
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
            case R.id.action_to_image:
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                ClassHolder.bitmap = convertToBitmap();
                startActivity(intent);

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

    private Bitmap convertToBitmap() {
        int lineNum = mContentEditor.getLineCount() + 1;
        int lineHeight = mContentEditor.getLineHeight();
        DisplayMetrics dm = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = (lineNum + 2) * lineHeight;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        mContentEditor.setCursorVisible(false);
        mScrollView.draw(canvas);
        mContentEditor.setCursorVisible(true);
//        Rect rect = new Rect();
//        int padding = DisplayUtils.dip2px(this, 10);
//        rect.top = padding;
//        rect.bottom = bitmap.getHeight() - padding;
//        rect.left = padding;
//        rect.right = bitmap.getWidth() - padding;
//
//        // center
//        Paint mPaint = new Paint();
//        mPaint.setColor(Color.BLACK);
//        mPaint.setAntiAlias(true);
//
//        //background
//        canvas.drawColor(Color.WHITE);
//
//        //draw date
//        int x = timeText.getLeft() + timeText.getPaddingLeft();
//        int y = timeText.getTop() + timeText.getPaddingTop() + timeText.getBaseline();
//        System.out.println("date x:" + x + " y:" + y + " content:" + timeText.getText());
//        mPaint.setTextSize(timeText.getTextSize());
//        mPaint.setStyle(Paint.Style.STROKE);
//
//
//        timeText.getHitRect(rect);
//        System.out.println("date rect:" + rect.toShortString());
//        canvas.drawRect(rect, mPaint);
//        canvas.drawText(timeText.getText(), 0, timeText.getText().length(), x, y, mPaint);
//        //draw content
//        x = mContentEditor.getLeft() + mContentEditor.getPaddingLeft();
//        y = mContentEditor.getTop() + mContentEditor.getPaddingTop() + mContentEditor.getBaseline();
//        System.out.println("content x:" + x + " y:" + y + " content:" + mContentEditor.getText());
//        mContentEditor.getHitRect(rect);
//        canvas.drawRect(rect, mPaint);
//        mPaint.setTextSize(mContentEditor.getTextSize());
//        String content = mContentEditor.getText().toString();
//        canvas.drawText(content, x, y, mPaint);


        return bitmap;
    }

}
