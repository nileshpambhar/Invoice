package app.invoice.com.invoiceapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import app.invoice.com.invoiceapp.InvoiceBillEditActivity;
import app.invoice.com.invoiceapp.R;
import app.invoice.com.invoiceapp.Utill.Constant;

/**
 * Created by ramanandi on 17/1/16.
 */
public class FragmentInvoiceBillEdit extends Fragment implements View.OnClickListener {


    private View rootView;
    private EditText editNotes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_invoice_bill_edit, container, false);


        Log.d("welcome to all", "all fragment");

        initView();
        return rootView;
    }

    private void initView() {

        rootView.findViewById(R.id.btnProjectName).setOnClickListener(this);
        rootView.findViewById(R.id.btnAddClient).setOnClickListener(this);
        rootView.findViewById(R.id.btnBillAddress).setOnClickListener(this);
        rootView.findViewById(R.id.btnAddItem).setOnClickListener(this);

        rootView.findViewById(R.id.btnDiscount).setOnClickListener(this);
        rootView.findViewById(R.id.btnShipping).setOnClickListener(this);
        rootView.findViewById(R.id.btnTax).setOnClickListener(this);
        rootView.findViewById(R.id.btnAddphoto).setOnClickListener(this);
        rootView.findViewById(R.id.btnPayment).setOnClickListener(this);
        rootView.findViewById(R.id.btnSignature).setOnClickListener(this);
        editNotes = (EditText) rootView.findViewById(R.id.editNotes);


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.btnProjectName:
                Goto_Fragment(Constant.FragmentInfo);
                break;
            case R.id.btnAddClient:
                // Goto_Fragment(Constant.FragmentAddClient);
                break;
            case R.id.btnBillAddress:
                Goto_Fragment(Constant.FragmentBillAddress);
                break;
            case R.id.btnAddItem:
                Goto_Fragment(Constant.FragmentAddItem);
                break;
            case R.id.btnDiscount:
                Goto_Fragment(Constant.FragmentDiscount);
                break;
            case R.id.btnShipping:
                Goto_Fragment(Constant.FragmentShipping);
                break;
            case R.id.btnTax:
                Goto_Fragment(Constant.FragmentTax);
                break;
            case R.id.btnAddphoto:
                Goto_Fragment(Constant.FragmentAddPhoto);
                break;
            case R.id.btnPayment:
                Goto_Fragment(Constant.FragmentPayment);
                break;
            case R.id.btnSignature:
              //  Goto_Fragment(Constant.FragmentSignature);
                break;

        }

    }


    private void Goto_Fragment(String FragmentName) {

        Intent sender = new Intent(getActivity(), InvoiceBillEditActivity.class);
        sender.putExtra("Fragment", FragmentName);
        startActivity(sender);

    }
}
