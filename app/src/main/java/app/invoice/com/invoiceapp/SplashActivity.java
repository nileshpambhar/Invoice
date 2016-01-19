package app.invoice.com.invoiceapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import app.invoice.com.invoiceapp.fragment.FragmentStep1;
import app.invoice.com.invoiceapp.fragment.FragmentStep2;
import app.invoice.com.invoiceapp.fragment.FragmentStep3;
import app.invoice.com.invoiceapp.fragment.FragmentStep4;
import app.invoice.com.invoiceapp.fragment.FragmentStep5;
import app.invoice.com.invoiceapp.model.MyBusinessModel;

public class SplashActivity extends AppCompatActivity {

    private CirclePageIndicator indicator;
    private ViewPager pager;
    private Button btnSkip,btnNext,btnPrev;
    public static MyBusinessModel businessModel;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initViews();
    }

    private void initViews()
    {
        businessModel=new MyBusinessModel();
        indicator=(CirclePageIndicator)findViewById(R.id.indicator);
        pager=(ViewPager)findViewById(R.id.pager);
        btnSkip=(Button)findViewById(R.id.btnSkip);
        btnPrev=(Button)findViewById(R.id.btnPrev);
        btnNext=(Button)findViewById(R.id.btnNext);
        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    if (adapter.fragments.get(1) instanceof FragmentStep2) {
                        ((FragmentStep2) adapter.fragments.get(1)).saveData();
                    }
                }
                indicator.setCurrentItem(position);
                if (position == 0) {
                    btnPrev.setVisibility(View.GONE);
                    btnNext.setText("Next");
                } else if (position == 4) {
                    btnNext.setText("Finish");
                    btnPrev.setVisibility(View.VISIBLE);
                } else {
                    btnPrev.setVisibility(View.VISIBLE);
                    btnNext.setText("Next");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btnPrev.setVisibility(View.GONE);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pager.getCurrentItem() > 0)
                    pager.setCurrentItem(pager.getCurrentItem() - 1);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pager.getCurrentItem() < 4)
                    pager.setCurrentItem(pager.getCurrentItem() + 1);
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sender = new Intent(SplashActivity.this, InvoiceActivity.class);
                startActivity(sender);
                finish();

            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        List<Fragment> fragments;
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments=new ArrayList<>();
            fragments.add(FragmentStep1.getInstance());
            fragments.add(FragmentStep2.getInstance());
            fragments.add(FragmentStep3.getInstance());
            fragments.add(FragmentStep4.getInstance());
            fragments.add(FragmentStep5.getInstance());
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
