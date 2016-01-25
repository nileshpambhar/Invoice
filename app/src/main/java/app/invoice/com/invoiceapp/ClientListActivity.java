package app.invoice.com.invoiceapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import app.invoice.com.invoiceapp.database.Database;
import app.invoice.com.invoiceapp.model.ClientModel;

public class ClientListActivity extends AppCompatActivity {

    ListView listClients;
    List<ClientModel> clientModels;
    Database db;
    ClientListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);
        getSupportActionBar().setTitle("Clients");
        listClients=(ListView)findViewById(R.id.listClients);
        db=new Database(ClientListActivity.this);

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
