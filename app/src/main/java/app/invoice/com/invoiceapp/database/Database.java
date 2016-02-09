package app.invoice.com.invoiceapp.database;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import app.invoice.com.invoiceapp.model.ClientModel;
import app.invoice.com.invoiceapp.model.InvoiceModel;
import app.invoice.com.invoiceapp.model.InvoiceSetting;

public class Database extends SQLiteOpenHelper {

    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 25;
    // Database Name
    private static final String DATABASE_NAME = "invoice.db";
    private static final String DB_PATH_SUFFIX = "/databases/";

    private static String C_BILL_NAME="billingName";
    private static String C_EMAIL="email";
    private static String C_BILL_ADDRESSS1="billingAddress1";
    private static String C_BILL_ADDRESSS2="billingAddress2";
    private static String C_BILL_ADDRESSS3="billingAddress3";
    private static String C_CONTACT="contact";
    private static String C_PHONE="phone";
    private static String C_MOBILE="mobile";
    private static String C_FAX="fax";
    private static String C_WEBSITE="website";
    private static String C_SHIPPING_NAME="shippingName";
    private static String C_SHIP_ADDRESS1="shippingAddress1";
    private static String C_SHIP_ADDRESS2="shippingAddress2";
    private static String C_SHIP_ADDRESS3="shippingAddress3";
    private static String C_REMOTE_ID="remoteId";
    private static String C_UPDATED="updated";
    private static String C_DELETED="deleted";

    private static String TABLE_CLIENT="client";

    static Context ctx;
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx = context;
    }

    // Getting single contact


    public void CopyDataBaseFromAsset() throws IOException{

        InputStream myInput = ctx.getAssets().open(DATABASE_NAME);

// Path to the just created empty db
        String outFileName = getDatabasePath();

// if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

// Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

// transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

// Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }
    private static String getDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX
                + DATABASE_NAME;
    }

    public SQLiteDatabase openDataBase() throws SQLException{
        File dbFile = ctx.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()) {
            try {
                CopyDataBaseFromAsset();
                System.out.println("Copying sucess from Assets folder");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub


    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void saveClient(ClientModel clientModel)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(C_BILL_NAME, clientModel.getName());
        cv.put(C_EMAIL,clientModel.getEmail());
        cv.put(C_BILL_ADDRESSS1,clientModel.getLine1());
        cv.put(C_BILL_ADDRESSS2,clientModel.getLine2());
        cv.put(C_BILL_ADDRESSS3, clientModel.getLine3());
        cv.put(C_CONTACT,clientModel.getContact());
        cv.put(C_PHONE,clientModel.getPhone());
        cv.put(C_MOBILE,clientModel.getMobile());
        cv.put(C_FAX,clientModel.getFax());
        cv.put(C_WEBSITE,clientModel.getWebsite());
        cv.put(C_SHIPPING_NAME,clientModel.getShipping_name());
        cv.put(C_SHIP_ADDRESS1,clientModel.getShip_addr1());
        cv.put(C_SHIP_ADDRESS2,clientModel.getShip_addr2());
        cv.put(C_SHIP_ADDRESS3, clientModel.getShip_addr3());
        long record_id=db.insert(TABLE_CLIENT, null, cv);
        Log.d("tag","Client record saved :"+record_id);
    }

    public List<ClientModel> getAllClients()
    {
        String qry="SELECT * FROM "+TABLE_CLIENT;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(qry, null);
        List<ClientModel> clientList=new ArrayList<>();

        if(cursor.moveToFirst())
        {
            do {
                ClientModel model=new ClientModel();
                model.setId(cursor.getInt(0));
                model.setName(cursor.getString(1));

                model.setEmail(cursor.getString(2));
                model.setLine1(cursor.getString(3));
                model.setLine2(cursor.getString(4));
                model.setLine3(cursor.getString(5));
                model.setContact(cursor.getString(6));
                model.setPhone(cursor.getString(7));
                model.setMobile(cursor.getString(8));

                model.setFax(cursor.getString(9));
                model.setWebsite(cursor.getString(10));

                model.setShipping_name(cursor.getString(11));
                model.setShip_addr1(cursor.getString(12));
                model.setShip_addr2(cursor.getString(13));
                model.setShip_addr3(cursor.getString(14));
                clientList.add(model);
            }while (cursor.moveToNext());
        }
        return clientList;
    }

    private void saveInvoiceInfo(InvoiceModel model1,InvoiceSetting invoiceSetting)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("invoiceNo",model1.getInvoiceNo());
        cv.put("invoiceDate",model1.getDueDate());
        cv.put("dueDate",model1.getDueDate());
    }
}

