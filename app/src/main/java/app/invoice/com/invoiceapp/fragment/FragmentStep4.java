package app.invoice.com.invoiceapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import app.invoice.com.invoiceapp.R;

/**
 * Created by Angle on 1/12/2016.
 */
public class FragmentStep4 extends Fragment
{

    public static Fragment getInstance()
    {
        Fragment fragment=new FragmentStep4();
        return  fragment;
    }
    View view;
    Spinner sp_WhatInvoiceFor,sp_WhoDo_U_Invoice,sp_RepeatBusiness,sp_Exp_per_job,
            sp_Inv_per_month,sp_year_in_business,sp_business_revenue,sp_prefer_inv_design;
    EditText editComment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_step4,container,false);
        initView(view);

        return view;
    }

    private void initView(View view)
    {
        sp_WhatInvoiceFor=(Spinner)view.findViewById(R.id.spinWhatInvoiceFor);
        sp_WhoDo_U_Invoice=(Spinner)view.findViewById(R.id.spinWhoDo_U_Invoice);
        sp_RepeatBusiness=(Spinner)view.findViewById(R.id.spinRepeatBuz);
        sp_Exp_per_job=(Spinner)view.findViewById(R.id.spinExp_Per_Job);
        sp_Inv_per_month=(Spinner)view.findViewById(R.id.spinInvoicePerMonth);
        sp_year_in_business=(Spinner)view.findViewById(R.id.spinYearsInBuz);
        sp_business_revenue=(Spinner)view.findViewById(R.id.spinBuz_revenue);
        sp_prefer_inv_design=(Spinner)view.findViewById(R.id.spinPreferInvoice);
        editComment=(EditText)view.findViewById(R.id.editComment);

    }
}
