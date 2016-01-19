package app.invoice.com.invoiceapp.fragment;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import app.invoice.com.invoiceapp.R;
import app.invoice.com.invoiceapp.SplashActivity;

/**
 * Created by Angle on 1/12/2016.
 */
public class FragmentStep3 extends Fragment
{

    public static Fragment getInstance()
    {
        Fragment fragment=new FragmentStep3();
        return  fragment;
    }

    ImageView imgLogo;
    private static int GALLERY_REQUEST=101;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_step3,container,false);
        initView(view);
        return view;
    }

    public void initView(View view)
    {
        imgLogo=(ImageView)view.findViewById(R.id.imgLogo);
        if(SplashActivity.businessModel.getLogo()!=null)
            imgLogo.setImageURI(Uri.parse(SplashActivity.businessModel.getLogo()));
        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetImageFromGalley();
            }
        });
    }

    private void GetImageFromGalley()
    {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent,GALLERY_REQUEST);
    }

    private String imgDecodableString;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==Activity.RESULT_OK && requestCode==GALLERY_REQUEST) {

            Uri selectedImageUri = data.getData();
            String[] projection = {MediaStore.MediaColumns.DATA};
            Cursor cursor = getActivity().managedQuery(selectedImageUri, projection, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            cursor.moveToFirst();
            String selectedImagePath = cursor.getString(column_index);
            Bitmap bm;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(selectedImagePath, options);
            final int REQUIRED_SIZE = 200;
            int scale = 1;
            while (options.outWidth / scale / 2 >= REQUIRED_SIZE
                    && options.outHeight / scale / 2 >= REQUIRED_SIZE)
                scale *= 2;
            options.inSampleSize = scale;
            options.inJustDecodeBounds = false;
            bm = BitmapFactory.decodeFile(selectedImagePath, options);
            imgLogo.setImageBitmap(bm);
            SplashActivity.businessModel.setLogo(selectedImageUri.toString());
        }
    }
}
