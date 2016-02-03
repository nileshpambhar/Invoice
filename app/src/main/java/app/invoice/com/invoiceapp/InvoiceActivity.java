package app.invoice.com.invoiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import app.invoice.com.invoiceapp.adapter.DrawerListAdapter;
import app.invoice.com.invoiceapp.invoice.FragmentInvoiceMain;

public class InvoiceActivity extends AppCompatActivity
{

    DrawerLayout drawer;
    public static final int SIGNATURE_ACTIVITY = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FragmentInvoiceMain fim = new FragmentInvoiceMain();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.content_invoice_frame , fim).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent sender = new Intent(InvoiceActivity.this, InvoiceBillActivity.class);
                startActivityForResult(sender,SIGNATURE_ACTIVITY);
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        ListView navigationView = (ListView) findViewById(R.id.nav_drawer);
        navigationView.setAdapter(new DrawerListAdapter(InvoiceActivity.this));
        navigationView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawer.closeDrawer(GravityCompat.START);
                if(position==0)
                {

                }
                else if(position==1)
                {
                    Intent sender = new Intent(InvoiceActivity.this, EstimateActivity.class);
                    startActivity(sender);
                }
                else if(position==2)
                {
                    Intent sender = new Intent(InvoiceActivity.this, ItemListActivity.class);
                    startActivity(sender);
                }
                else if(position==3)
                {
                    Intent sender = new Intent(InvoiceActivity.this, ClientListActivity.class);
                    startActivity(sender);
                }
                else if(position==4)
                {
                    Intent sender = new Intent(InvoiceActivity.this, BackUpActivity.class);
                    startActivity(sender);
                }
                else if(position==5)
                {

                }
                else if(position==6)
                {
                    Intent sender = new Intent(InvoiceActivity.this, SettngActvity.class);
                    startActivity(sender);
                }
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
        getMenuInflater().inflate(R.menu.invoice_activity_main, menu);
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode) {
            case SIGNATURE_ACTIVITY:
                if (resultCode == RESULT_OK) {

                    Bundle bundle = data.getExtras();
                    String status  = bundle.getString("status");
                    if(status.equalsIgnoreCase("done")){
                        Toast toast = Toast.makeText(this, "Signature capture successful!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 105, 50);
                        toast.show();
                    }
                }
                break;
        }

    }


}
