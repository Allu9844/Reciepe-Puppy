package codeminds.recipepuppy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import codeminds.recipepuppy.Interfaces.TodayScheduleInterface;
import codeminds.recipepuppy.models.RecipePojo;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private EditText mEditText;
    public ProgressDialog mDialog;

    public static RecipePojo mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mData = new RecipePojo();

        mEditText = (EditText)findViewById(R.id.recp);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void submitData(View view){

        mDialog = new ProgressDialog(DashboardActivity.this);
        mDialog.setMessage("Please Wait..");
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setCancelable(true);
        mDialog.show();

        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint("http://www.recipepuppy.com");

        RestAdapter restAdapter = builder.build();
        TodayScheduleInterface api = restAdapter.create(TodayScheduleInterface.class);


        api.getSchedule(mEditText.getText().toString(), new Callback<RecipePojo>() {
            @Override
            public void success(RecipePojo recipePojo, Response response) {
                mData = recipePojo;
                Log.i("hhhh","hhhhhhhhhhhhhhhhhhhhhhhhhhh"+mData.getTitle());

                for(int i=0;i<mData.getResults().size();i++){
                    Log.i("hhhh","hhhhhhhhhhhhhhhhhhhhhhhhhhh"+mData.getResults().get(i).getTitle());

                }
                mDialog.dismiss();

//                startActivity(new Intent(this,ListActivity.class));

                Intent i = new Intent(DashboardActivity.this,ListActivity.class);

                startActivity(i);

            }

            @Override
            public void failure(RetrofitError error) {

                mDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Please Try Again", Toast.LENGTH_LONG).show();

                Log.i("Falie","retrofit error---------------------------------------------------"+error.toString());
            }
        });





    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
