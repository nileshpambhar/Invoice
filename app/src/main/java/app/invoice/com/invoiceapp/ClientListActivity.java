package app.invoice.com.invoiceapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import app.invoice.com.invoiceapp.adapter.DrawerListAdapter;
import app.invoice.com.invoiceapp.database.Database;
import app.invoice.com.invoiceapp.model.ClientModel;

public class ClientListActivity extends AppCompatActivity {

    ListView listClients;
    List<ClientModel> clientModels;
    Database db;
    ClientListAdapter adapter;
    Toolbar toolbar;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);
         toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Clients");
        listClients=(ListView)findViewById(R.id.listClients);
        db=new Database(ClientListActivity.this);
        db.openDataBase();
        clientModels=db.getAllClients();
        Log.d("tag","==> total records:"+clientModels.size());
        adapter=new ClientListAdapter();
        listClients.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ClientListActivity.this,ClientAddActivity.class);
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
        navigationView.setAdapter(new DrawerListAdapter(ClientListActivity.this));
        navigationView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawer.closeDrawer(GravityCompat.START);
                if (position == 0) {
                    Intent sender = new Intent(ClientListActivity.this, InvoiceActivity.class);
                    startActivity(sender);
                } else if (position == 1) {
                    Intent sender = new Intent(ClientListActivity.this, EstimateActivity.class);
                    startActivity(sender);
                } else if (position == 2) {
                    Intent sender = new Intent(ClientListActivity.this, ItemListActivity.class);
                    startActivity(sender);
                } else if (position == 3) {

                } else if (position == 4) {
                    Intent sender = new Intent(ClientListActivity.this, BackUpActivity.class);
                    startActivity(sender);
                } else if (position == 5) {

                } else if (position == 6) {
                    Intent sender = new Intent(ClientListActivity.this, SettngActvity.class);
                    startActivity(sender);
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(listClients!=null)
        {
            db=new Database(ClientListActivity.this);
            db.openDataBase();
            clientModels=db.getAllClients();
            Log.d("tag","==> total records:"+clientModels.size());
            adapter=new ClientListAdapter();
            listClients.setAdapter(adapter);
        }
    }

    class ClientListAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return clientModels.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if(convertView==null)
            {
                convertView=getLayoutInflater().inflate(R.layout.list_client_row,null);
                holder=new Holder();
                holder.txtName=(TextView)convertView.findViewById(R.id.txtName);
                holder.txtPriceRight=(TextView)convertView.findViewById(R.id.txtPriceRight);
                holder.txtPriceLeft=(TextView)convertView.findViewById(R.id.txtPriceLeft);
                holder.txtDate=(TextView)convertView.findViewById(R.id.txtDate);
                convertView.setTag(holder);
            }
            else
            {
                holder=(Holder)convertView.getTag();
            }
            ClientModel model=clientModels.get(position);
            holder.txtName.setText(model.getName());
            return convertView;
        }

        class Holder
        {
            TextView txtName,txtPriceRight,txtPriceLeft,txtDate;
        }
    }
}
