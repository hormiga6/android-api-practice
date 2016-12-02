package com.hormiga6.androidapipractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hormiga6.androidapipractice.ActivityOverlay.BaseActivity;
import com.hormiga6.androidapipractice.ActivityResult.StartActivity;
import com.hormiga6.androidapipractice.Application.ContextCheckActivity1;
import com.hormiga6.androidapipractice.Drawable.DrawableActivity;
import com.hormiga6.androidapipractice.Layout.LinearLayoutActivity;
import com.hormiga6.androidapipractice.ListView.ListViewActivity;
import com.hormiga6.androidapipractice.MultiTypeList.MultiTypeListActivity;
import com.hormiga6.androidapipractice.NavigationDrawer.DrawerActivity;
import com.hormiga6.androidapipractice.ProgressBar.ProgressBarActivity;
import com.hormiga6.androidapipractice.Ripple.RippleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickOverlay(View view){
        Intent intent = new Intent(this, BaseActivity.class);
        startActivity(intent);
    }

    public void clickListView(View view){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    public void clickLinearLayout(View view){
        Intent intent = new Intent(this, LinearLayoutActivity.class);
        startActivity(intent);
    }

    public void clickRipple(View view){
        Intent intent = new Intent(this, RippleActivity.class);
        startActivity(intent);
    }

    public void clickMultiTypeListView(View view){
        Intent intent = new Intent(this, MultiTypeListActivity.class);
        startActivity(intent);
    }

    public void clickDrawable(View view){
        Intent intent = new Intent(this, DrawableActivity.class);
        startActivity(intent);
    }

    public void clickDrawer(View view){
        Intent intent = new Intent(this, DrawerActivity.class);
        startActivity(intent);
    }

    public void clickProgressBar(View view){
        Intent intent = new Intent(this, ProgressBarActivity.class);
        startActivity(intent);
    }

    public void clickActivityResult(View view){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    public void clickContext(View view){
        Intent intent = new Intent(this, ContextCheckActivity1.class);
        startActivity(intent);
    }
}
