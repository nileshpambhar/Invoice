package app.invoice.com.invoiceapp;

import android.content.Intent;
import android.location.SettingInjectorService;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import app.invoice.com.invoiceapp.adapter.DrawerListAdapter;

public class SettngActvity extends AppCompatActivity
         {
    DrawerLayout drawer;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_drawer_view_setting);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getApplicationContext().getResources().getString(R.string.action_settings));
        setSupportActionBar(toolbar);
        initDrawer();
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.invoice_activity_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

             private void initDrawer()
             {
                 drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                 ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                         this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                 drawer.setDrawerListener(toggle);
                 toggle.syncState();

                 ListView navigationView = (ListView) findViewById(R.id.nav_drawer);
                 navigationView.setAdapter(new DrawerListAdapter(SettngActvity.this));
                 navigationView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         drawer.closeDrawer(GravityCompat.START);
                         if (position == 0) {
                             Intent sender = new Intent(SettngActvity.this, InvoiceActivity.class);
                             startActivity(sender);
                         } else if (position == 1) {
                             Intent sender = new Intent(SettngActvity.this, EstimateActivity.class);
                             startActivity(sender);
                         } else if (position == 2) {
                             Intent sender = new Intent(SettngActvity.this, ItemListActivity.class);
                             startActivity(sender);
                         } else if (position == 3) {

                         } else if (position == 4) {
                             Intent sender = new Intent(SettngActvity.this, BackUpActivity.class);
                             startActivity(sender);
                         } else if (position == 5) {

                         } else if (position == 6) {

                         }
                     }
                 });
             }
}
