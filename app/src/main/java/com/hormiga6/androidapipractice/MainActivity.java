package com.hormiga6.androidapipractice;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hormiga6.androidapipractice.ActivityOverlay.BaseActivity;
import com.hormiga6.androidapipractice.ActivityResult.StartActivity;
import com.hormiga6.androidapipractice.Application.ContextCheckActivity1;
import com.hormiga6.androidapipractice.Background.AsyncTaskActivity;
import com.hormiga6.androidapipractice.Background.BackgroundActivity;
import com.hormiga6.androidapipractice.Drawable.DrawableActivity;
import com.hormiga6.androidapipractice.Layout.ProgrammaticaLayoutlActivity;
import com.hormiga6.androidapipractice.Layout.ViewAspectRatioActivity;
import com.hormiga6.androidapipractice.ListView.ListViewActivity;
import com.hormiga6.androidapipractice.MemoryLeak.ParentActivity;
import com.hormiga6.androidapipractice.MultiTypeList.MultiTypeListActivity;
import com.hormiga6.androidapipractice.NavigationDrawer.DrawerActivity;
import com.hormiga6.androidapipractice.ProgressBar.ProgressBarActivity;
import com.hormiga6.androidapipractice.Ripple.RippleActivity;
import com.hormiga6.androidapipractice.SQLite.SQLiteActivity;
import com.hormiga6.androidapipractice.Service.ServiceActivity;
import com.hormiga6.androidapipractice.Surface.GameActivity;
import com.hormiga6.androidapipractice.UncaughtException.UncaughtExceptionActivity;
import com.hormiga6.androidapipractice.WebView.WebViewActivity;
import com.hormiga6.androidapipractice.audio.AudioFocusActivity;
import com.hormiga6.androidapipractice.bitmap.BitmapActivity;
import com.hormiga6.androidapipractice.build.BuildActivity;
import com.hormiga6.androidapipractice.connectivity.ConnectivityActivity;
import com.hormiga6.androidapipractice.disklrucache.DiskLruCacheActivity;
import com.hormiga6.androidapipractice.localbroadcast.LocalBroadcastActivity;
import com.hormiga6.androidapipractice.looper.MyLooperActivity;
import com.hormiga6.androidapipractice.scale.ScaleImageActivity;
import com.hormiga6.androidapipractice.view.GlobalVisibleRectActivity;
import com.hormiga6.androidapipractice.window.WindowActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.activityList);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        List<DataSet> list = new ArrayList<DataSet>(){{
            add(new DataSet("WebView", WebViewActivity.class));
            add(new DataSet("AsyncTask WorkQueue", AsyncTaskActivity.class));
            add(new DataSet("Aspect Ratio", ViewAspectRatioActivity.class));
            add(new DataSet("DiskLruCache", DiskLruCacheActivity.class));
            add(new DataSet("Build", BuildActivity.class));
            add(new DataSet("LocalBroadCaster", LocalBroadcastActivity.class));
            add(new DataSet("ConnectivityActivity", ConnectivityActivity.class));
            add(new DataSet("WindowManager", WindowActivity.class));
            add(new DataSet("GlobalVisibleRectActivity", GlobalVisibleRectActivity.class));
            add(new DataSet("AudioFocusActivity", AudioFocusActivity.class));
            add(new DataSet("ScaleImageActivity", ScaleImageActivity.class));
            add(new DataSet("BitmapActivity", BitmapActivity.class));
            add(new DataSet("BaseActivity", BaseActivity.class));
            add(new DataSet("DrawableActivity", DrawableActivity.class));
            add(new DataSet("ProgressBarActivity", ProgressBarActivity.class));
            add(new DataSet("ContextCheckActivity1", ContextCheckActivity1.class));
            add(new DataSet("ListViewActivity", ListViewActivity.class));
            add(new DataSet("RippleActivity", RippleActivity.class));
            add(new DataSet("MultiTypeListActivity", MultiTypeListActivity.class));
            add(new DataSet("DrawerActivity", DrawerActivity.class));
            add(new DataSet("StartActivity", StartActivity.class));
            add(new DataSet("MyLooperActivity", MyLooperActivity.class));
            add(new DataSet("ServiceActivity", ServiceActivity.class));
            add(new DataSet("UncaughtExceptionActivity", UncaughtExceptionActivity.class));
            add(new DataSet("ParentActivity", ParentActivity.class));
            add(new DataSet("SQLiteActivity", SQLiteActivity.class));
            add(new DataSet("ProgrammaticalLayoutActivity", ProgrammaticaLayoutlActivity.class));
            add(new DataSet("GameActivity", GameActivity.class));
            add(new DataSet("BackgroundActivity", BackgroundActivity.class));
        }};

        mAdapter = new MyAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
    }

    static class DataSet {
        private String label;
        private Class activityClass;

        public DataSet(String label, Class activityClass) {
            this.label = label;
            this.activityClass = activityClass;
        }

        public String getLabel() {
            return label;
        }

        public Class getActivityClass() {
            return activityClass;
        }
    }

    public void dispatchActivity(View view) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.hormiga6.androidapipractice." + view.getTag().toString());
        Intent intent = new Intent(this,aClass);
        startActivity(intent);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout constraint;
        public ViewHolder(ConstraintLayout itemView) {
            super(itemView);
            constraint = itemView;
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MainActivity.ViewHolder> {
        List<DataSet> list;

        MyAdapter(List<DataSet> list){
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
            ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_activity, parent, false);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = mRecyclerView.getChildLayoutPosition(view);
                    Intent intent = new Intent(parent.getContext(),
                            list.get(position).getActivityClass());
                    startActivity(intent);
                }
            });
            ViewHolder vh = new ViewHolder(v);

            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ((TextView)holder.constraint.findViewById(R.id.textViewName)).setText(list.get(position).label);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

}
