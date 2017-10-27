package codeminds.recipepuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import codeminds.recipepuppy.Adapter.RecyclerAdapter;

public class ListActivity extends AppCompatActivity {

    public RecyclerView mScheduleRecyclerView;
    private RecyclerAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        callAdapter();
    }

    public void callAdapter(){



        mScheduleRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        madapter = new RecyclerAdapter(getApplicationContext());
        madapter.setSchedule(DashboardActivity.mData.getResults());
        mScheduleRecyclerView.setAdapter(madapter);
        mScheduleRecyclerView.setHasFixedSize(true);
        mScheduleRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mScheduleRecyclerView.setNestedScrollingEnabled(false);



    }
}
