package app.invoice.com.invoiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class SettngActvity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_drawer_view_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getApplicationContext().getResources().getString(R.string.action_settings));
        setSupportActionBar(toolbar);
//        FragmentInvoiceMain fim = new FragmentInvoiceMain();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.content_invoice_frame, fim).addToBackStack(null).commit();
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_backup:
                Intent senderBackup = new Intent(SettngActvity.this, BackUpActivity.class);
                startActivity(senderBackup);
                break;
            case R.id.nav_view:
                Intent senderMyItem = new Intent(SettngActvity.this, MyItemActivity.class);
                startActivity(senderMyItem);
                break;
            case R.id.nav_support:
               /* Intent senderSupport = new Intent(SettngActvity.this, SupportActivity.class);
                startActivity(senderSupport);*/
                break;
            case R.id.nav_est:
                Intent sender = new Intent(SettngActvity.this, EstimateActvity.class);
                startActivity(sender);
                break;
            case R.id.nav_clients:
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_cam:
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_settings:
                Intent senderSetting = new Intent(SettngActvity.this, EstimateActvity.class);
                startActivity(senderSetting);
                break;


        }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toast.makeText(SettngActvity.this, "position :: " + id, Toast.LENGTH_SHORT).show();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
