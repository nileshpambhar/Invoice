package app.invoice.com.invoiceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import app.invoice.com.invoiceapp.R;

public class DrawerListAdapter extends BaseAdapter {
    String[] menuItems = {"Invoices", "Estimates", "My Items", "Clients", "Backup", "Support", "Settings"};
    LayoutInflater inflater;

    public DrawerListAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return menuItems.length;
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
        if (convertView == null) {
            holder = new Holder();
            convertView = (View) inflater.inflate(R.layout.lay_drawer_list_row, null);
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            holder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.textView.setText(menuItems[position]);
        return convertView;
    }

    class Holder {
        TextView textView;
        ImageView imgIcon;
    }
}