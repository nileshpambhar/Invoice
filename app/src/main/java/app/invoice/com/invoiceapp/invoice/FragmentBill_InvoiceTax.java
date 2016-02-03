package app.invoice.com.invoiceapp.invoice;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import app.invoice.com.invoiceapp.InvoiceBillActivity;
import app.invoice.com.invoiceapp.InvoiceBillEditActivity;
import app.invoice.com.invoiceapp.R;

/**
 * Created by ramanandi on 1/2/16.
 */
public class FragmentBill_InvoiceTax extends Fragment {

    private View rootView;

    private EditText edtInvName, ediInvDate, ediInvTerms, ediInvDue, ediInvPo;

    @Override
    public void onAttach(Activity activity) {

        if (activity instanceof InvoiceBillActivity) {

            ((InvoiceBillEditActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        super.onAttach(activity);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == android.R.id.home) {

//            Log.i("home click ", "count");
//
//            FragmentInvoiceBillEdit fibe = new FragmentInvoiceBillEdit();
//            FragmentManager fm = getFragmentManager();
//            fm.beginTransaction().replace(R.id.invoice_bill_frame, fibe).commit();

        }

        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_tax, container, false);

        // initView();

        setHasOptionsMenu(true);

        return rootView;
    }


    private void initView() {

        ediInvDate = (EditText) rootView.findViewById(R.id.edtInvDate);
        edtInvName = (EditText) rootView.findViewById(R.id.edtInvName);
        ediInvTerms = (EditText) rootView.findViewById(R.id.edtInvTerms);
        ediInvDue = (EditText) rootView.findViewById(R.id.edtInvDue);
        ediInvPo = (EditText) rootView.findViewById(R.id.edtInvPo);

    }


}
