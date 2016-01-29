package app.invoice.com.invoiceapp;

import android.content.ClipData;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import app.invoice.com.invoiceapp.adapter.DrawerListAdapter;

public class ItemListActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Items");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemListActivity.this, AddItemActivity.class);
                startActivity(intent);
            }
        });

        initDrawer();
    }
    private void initDrawer()
    {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        ListView navigationView = (ListView) findViewById(R.id.nav_drawer);
        navigationView.setAdapter(new DrawerListAdapter(ItemListActivity.this));
        navigationView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawer.closeDrawer(GravityCompat.START);
                if (position == 0) {
                    Intent sender = new Intent(ItemListActivity.this, InvoiceActivity.class);
                    startActivity(sender);
                } else if (position == 1) {
                    Intent sender = new Intent(ItemListActivity.this, EstimateActivity.class);
                    startActivity(sender);
                } else if (position == 2) {

                } else if (position == 3) {
                    Intent sender = new Intent(ItemListActivity.this, ClientListActivity.class);
                    startActivity(sender);
                } else if (position == 4) {
                    Intent sender = new Intent(ItemListActivity.this, BackUpActivity.class);
                    startActivity(sender);
                } else if (position == 5) {

                } else if (position == 6) {
                    Intent sender = new Intent(ItemListActivity.this, SettngActvity.class);
                    startActivity(sender);
                }
            }
        });
    }
}
