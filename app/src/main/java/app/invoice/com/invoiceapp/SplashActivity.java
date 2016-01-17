package app.invoice.com.invoiceapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

import app.invoice.com.invoiceapp.fragment.FragmentStep1;
import app.invoice.com.invoiceapp.fragment.FragmentStep2;
import app.invoice.com.invoiceapp.fragment.FragmentStep3;
import app.invoice.com.invoiceapp.fragment.FragmentStep4;
import app.invoice.com.invoiceapp.fragment.FragmentStep5;

public class SplashActivity extends AppCompatActivity {

    private CirclePageIndicator indicator;
    private ViewPager pager;
    private Button btnSkip,btnNext,btnPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViews();
        Log.d("tag","this is test demo");
    }

    private void initViews()
    {
        indicator=(CirclePageIndicator)findViewById(R.id.indicator);
        pager=(ViewPager)findViewById(R.id.pager);
        btnSkip=(Button)findViewById(R.id.btnSkip);
        btnPrev=(Button)findViewById(R.id.btnNext);
        btnNext=(Button)findViewById(R.id.btnNext);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        indicator.setViewPager(pager);


        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sender = new Intent(SplashActivity.this, InvoiceActivity.class);
                startActivity(sender);
                finish();

            }
        });


        pager.setOnScrollChangeListener(new View.OnScrollChangeListener() {



            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {


                Log.d("page position" , ""+i);Log.d("page position" , ""+i1);Log.d("page position" , ""+i2);Log.d("page position" , ""+i3);


            }
        });

    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            if(position==0)
                return FragmentStep1.getInstance();
            else if(position==1)
                return FragmentStep2.getInstance();
            else if(position==2)
                return FragmentStep3.getInstance();
            else if(position==3)
                return FragmentStep4.getInstance();
            else if(position==4)
                return FragmentStep5.getInstance();
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
