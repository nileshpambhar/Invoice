package app.invoice.com.invoiceapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import app.invoice.com.invoiceapp.R;

/**
 * Created by Angle on 1/12/2016.
 */
public class FragmentStep1 extends Fragment
{

    //private List<String> currencies;
    private Spinner spinner;
    public static Fragment getInstance()
    {
        Fragment fragment=new FragmentStep1();
        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_step1,container,false);
        initView(view);
        return view;
    }

    private void initView(View view)
    {
      //  currencies=new ArrayList<>();
        spinner=(Spinner)view.findViewById(R.id.spinnerCurrency);
        Log.d("tag", "Total currency" + Locale.getAvailableLocales().length);

        /*for (Locale ll: Locale.getAvailableLocales()){
            try {
                Currency a = Currency.getInstance(ll);
                String str=a.getCurrencyCode()+"("+a.getSymbol()+")";
                currencies.add(str);
                Log.v("MyCurrency", a.getCurrencyCode() + "#" + a.getSymbol());
            }catch (Exception e){
                // when the locale is not supported
            }
        }*/
        String[] currencies=getActivity().getResources().getStringArray(R.array.currency);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,currencies);

        spinner.setPrompt("Select Currency");
        spinner.setAdapter(adapter);
    }
}
