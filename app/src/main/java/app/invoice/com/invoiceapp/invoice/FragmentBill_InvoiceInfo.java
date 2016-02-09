package app.invoice.com.invoiceapp.invoice;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import app.invoice.com.invoiceapp.InvoiceBillActivity;
import app.invoice.com.invoiceapp.R;
import app.invoice.com.invoiceapp.database.Database;
import app.invoice.com.invoiceapp.fragment.FragmentInvoiceBillEdit;
import app.invoice.com.invoiceapp.model.InvoiceModel;
import app.invoice.com.invoiceapp.model.InvoiceSetting;

/**
 * Created by ramanandi on 1/2/16.
 */
public class FragmentBill_InvoiceInfo extends Fragment {

    private View rootView;

    private EditText edtInvName;
    private TextView ediInvDate;
    private TextView ediInvTerms, ediInvDue;
    private EditText ediInvPo;
    private boolean isEdit;
    @Override
    public void onAttach(Activity activity) {

        if (activity instanceof InvoiceBillActivity) {

            ((InvoiceBillActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
            if(!isEdit) {
                String uuid = UUID.randomUUID().toString();
                String invoiceNo = edtInvName.getText().toString();
                String invoiceDate = ediInvDate.getText().toString();
                String invoiceDue = ediInvDue.getText().toString();
                String poNumber = ediInvPo.getText().toString();
                String termsDue = ediInvTerms.getText().toString();
                InvoiceModel model1 = new InvoiceModel();
                InvoiceSetting model2 = new InvoiceSetting();
                model1.setRemoteId(uuid);
                model1.setInvoiceDate(invoiceDate);
                model1.setDueDate(invoiceDue);
                model1.setInvoiceNo(invoiceNo);
                model1.setPoNumber(poNumber);
                model2.setTermsDay(termsDue);
            }

        }

        return super.onOptionsItemSelected(item);
    }

    Database database;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragmentbill_invoiceinfo, container, false);
        database=new Database(getActivity());
        database.openDataBase();
        initView();
        isEdit=getActivity().getIntent().getExtras().getBoolean("isEdit");
        setHasOptionsMenu(true);

        return rootView;
    }

    Calendar calendar;
    SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
    String date1,dateDue;
    int year1,year2,month1,month2,day1,day2;

    private void initView() {

        ediInvDate = (TextView) rootView.findViewById(R.id.edtInvDate);
        ediInvTerms = (TextView) rootView.findViewById(R.id.edtInvTerms);
        ediInvDue = (TextView) rootView.findViewById(R.id.edtInvDue);
        edtInvName = (EditText) rootView.findViewById(R.id.edtInvName);
        ediInvPo = (EditText) rootView.findViewById(R.id.edtInvPo);
        calendar=Calendar.getInstance();
        year1=year2=calendar.get(Calendar.YEAR);
        month1=month2=calendar.get(Calendar.MONTH);
        day1=day2=calendar.get(Calendar.DAY_OF_MONTH);

        dateDue=date1=sdf.format(calendar.getTime());
        ediInvDate.setText(date1);
        ediInvDue.setText(dateDue);


        ediInvTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTermsDialog();
            }
        });
        ediInvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog1();
            }
        });
        ediInvDue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog1();
            }
        });
    }
    DatePickerDialog.OnDateSetListener onDateSetListener1=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar cal=Calendar.getInstance();
                cal.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                cal.set(Calendar.MONTH,monthOfYear);
                cal.set(Calendar.YEAR,year);
                String strDate=sdf.format(cal.getTime());
                ediInvDate.setText(strDate);
        }
    };
    DatePickerDialog.OnDateSetListener onDateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar cal=Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            cal.set(Calendar.MONTH,monthOfYear);
            cal.set(Calendar.YEAR,year);
            String strDate=sdf.format(cal.getTime());
            ediInvDue.setText(strDate);
        }
    };
    private void showDateDialog2()
    {
        DatePickerDialog datePickerDialog1=new DatePickerDialog(getActivity(),onDateSetListener1,year2,month2,day2);
        datePickerDialog1.show();
    }
    private void showDateDialog1()
    {
        DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(),onDateSetListener,year1,month1,day1);
        datePickerDialog.show();
    }
    private void showTermsDialog()
    {
        CharSequence[] array=getActivity().getResources().getStringArray(R.array.terms);
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setItems(array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        }).setMessage("Please select terms")
                .create().show();

    }

}
