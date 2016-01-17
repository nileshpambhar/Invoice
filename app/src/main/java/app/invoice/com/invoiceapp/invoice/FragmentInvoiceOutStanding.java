package app.invoice.com.invoiceapp.invoice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.invoice.com.invoiceapp.R;

/**
 * Created by ramanandi on 17/1/16.
 */
public class FragmentInvoiceOutStanding extends Fragment
{


    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_invoice_all , container , false);


        return rootView;
    }
}
