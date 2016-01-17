package app.invoice.com.invoiceapp.invoice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.invoice.com.invoiceapp.R;
import app.invoice.com.invoiceapp.invoicetab.SlidingTabLayout;

/**
 * Created by ramanandi on 17/1/16.
 */
public class FragmentInvoiceMain extends Fragment
{


    private View rootView;
    SectionPagerAdapter pagerAdapter;
    ViewPager pager;
    SlidingTabLayout mSlidingTabLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_invoice_main , container , false);
        init_view();
        return rootView;
    }

    private void init_view(){
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        // db=new DatabaseHandler(AppsListActivity.this);
        mSlidingTabLayout = (SlidingTabLayout) rootView
                .findViewById(R.id.sliding_tabs);
        pagerAdapter = new SectionPagerAdapter(getFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(0);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(pager);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                super.onPageSelected(position);

            }
        });
    }

    class SectionPagerAdapter extends FragmentPagerAdapter{

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int position) {


            if(position ==0)
            {
                return  new FragmentInvoiceAll();
            }else if (position ==1)
            {
                return  new FragmentInvoiceOutStanding();
            }else
            {
                return  new FragmentInvoicePaid();
            }


        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            if (position == 0) {
                return "ALL";
            } else if (position == 1) {
                return "OUTSTANDING";
            } else
                return "PAID";
        }
    }
}
