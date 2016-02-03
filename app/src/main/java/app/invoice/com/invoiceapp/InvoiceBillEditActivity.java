package app.invoice.com.invoiceapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import app.invoice.com.invoiceapp.Utill.Constant;
import app.invoice.com.invoiceapp.fragment.FragmentInvoiceBillEdit;
import app.invoice.com.invoiceapp.fragment.FragmentInvoiceBillMain;
import app.invoice.com.invoiceapp.invoice.FragmentBill_InvoiceAddItem;
import app.invoice.com.invoiceapp.invoice.FragmentBill_InvoiceAddPhoto;
import app.invoice.com.invoiceapp.invoice.FragmentBill_InvoiceDiscount;
import app.invoice.com.invoiceapp.invoice.FragmentBill_InvoiceInfo;
import app.invoice.com.invoiceapp.invoice.FragmentBill_InvoicePayment;
import app.invoice.com.invoiceapp.invoice.FragmentBill_InvoiceShipping;
import app.invoice.com.invoiceapp.invoice.FragmentBill_InvoiceTax;


public class InvoiceBillEditActivity extends AppCompatActivity {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_toobar_invoicebill);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        FragmentInvoiceBillMain fim = new FragmentInvoiceBillMain();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.invoice_bill_frame, fim).commit();


        String FragmentName = getIntent().getStringExtra("Fragment");

        Log.d("tag", FragmentName);
        GotoFragment(FragmentName);
    }


    private void GotoFragment(String Name) {

        Fragment fragment = null;


        if (Name.equalsIgnoreCase(Constant.FragmentInfo)) {
            fragment = new FragmentBill_InvoiceInfo();
            getSupportActionBar().setTitle("Invoice");
        } else if (Name.equalsIgnoreCase(Constant.FragmentAddPhoto)) {
            fragment = new FragmentBill_InvoiceAddPhoto();
            getSupportActionBar().setTitle("Photo");
        } else if (Name.equalsIgnoreCase(Constant.FragmentDiscount)) {
            fragment = new FragmentBill_InvoiceDiscount();
            getSupportActionBar().setTitle("Discount");
        } else if (Name.equalsIgnoreCase(Constant.FragmentShipping)) {
            fragment = new FragmentBill_InvoiceShipping();
            getSupportActionBar().setTitle("Shipping Info");
        } else if (Name.equalsIgnoreCase(Constant.FragmentPayment)) {
            fragment = new FragmentBill_InvoicePayment();
            getSupportActionBar().setTitle("Payment option");
        } else if (Name.equalsIgnoreCase(Constant.FragmentAddItem)) {
            fragment = new FragmentBill_InvoiceAddItem();
            getSupportActionBar().setTitle("Add Item");
        } else if (Name.equalsIgnoreCase(Constant.FragmentTax)) {
            fragment = new FragmentBill_InvoiceTax();
            getSupportActionBar().setTitle("Taxes");
        }

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.invoice_bill_frame, fragment).commit();

    }


    @Override
    public void onBackPressed() {

        finish();
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
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
