package app.invoice.com.invoiceapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import app.invoice.com.invoiceapp.R;
import app.invoice.com.invoiceapp.SplashActivity;

/**
 * Created by Angle on 1/12/2016.
 */
public class FragmentStep2 extends Fragment
{

    public static Fragment getInstance()
    {
        Fragment fragment=new FragmentStep2();
        return  fragment;
    }

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_step2,container,false);
        initView(view);
        return view;
    }

    EditText editName,editWebsite,editPhone,editEmail,editAddr1,editAddr2,editAddr3;
    private void initView(View view)
    {
        editName=(EditText)view.findViewById(R.id.editName);
        editWebsite=(EditText)view.findViewById(R.id.editWebsite);
        editPhone=(EditText)view.findViewById(R.id.editPhone);
        editEmail=(EditText)view.findViewById(R.id.editEmail);
        editAddr1=(EditText)view.findViewById(R.id.editAddress1);
        editAddr2=(EditText)view.findViewById(R.id.editAddress2);
        editAddr3=(EditText)view.findViewById(R.id.editAddress3);
        editName.setText(SplashActivity.businessModel.getName());
        editWebsite.setText(SplashActivity.businessModel.getWebsite());
        editPhone.setText(SplashActivity.businessModel.getPhone());
        editEmail.setText(SplashActivity.businessModel.getEmail());
        editAddr1.setText(SplashActivity.businessModel.getAddress1());
        editAddr2.setText(SplashActivity.businessModel.getAddress2());
        editAddr3.setText(SplashActivity.businessModel.getAddress3());
    }
    public void saveData()
    {
        SplashActivity.businessModel.setName(editName.getText().toString());
        SplashActivity.businessModel.setWebsite(editWebsite.getText().toString());
        SplashActivity.businessModel.setPhone(editPhone.getText().toString());
        SplashActivity.businessModel.setEmail(editEmail.getText().toString());
        SplashActivity.businessModel.setAddress1(editAddr1.getText().toString());
        SplashActivity.businessModel.setAddress2(editAddr2.getText().toString());
        SplashActivity.businessModel.setAddress3(editAddr3.getText().toString());
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("tag", "on Pause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("tag","on Destroy");

    }
}
