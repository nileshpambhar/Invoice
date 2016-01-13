package app.invoice.com.invoiceapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.invoice.com.invoiceapp.R;

/**
 * Created by Angle on 1/12/2016.
 */
public class FragmentStep1 extends Fragment
{

    public static Fragment getInstance()
    {
        Fragment fragment=new FragmentStep1();
        return  fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_step1,container,false);
    }
}
