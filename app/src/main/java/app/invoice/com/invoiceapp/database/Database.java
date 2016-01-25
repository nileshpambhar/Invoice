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

public class Database extends SQLiteOpenHelper {

    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "invoice.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
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

    public void saveClient(ClientModel clientModel)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name", clientModel.getName());
        cv.put("email",clientModel.getEmail());
        cv.put("mobile",clientModel.getMobile());
        cv.put("phone",clientModel.getPhone());
        cv.put("fax",clientModel.getFax());
        cv.put("contact",clientModel.getContact());
        cv.put("line1",clientModel.getLine1());
        cv.put("line2",clientModel.getLine2());
        cv.put("line3",clientModel.getLine3());
        cv.put("shipping_name",clientModel.getShipping_name());
        cv.put("ship_addr1",clientModel.getShip_addr1());
        cv.put("ship_addr2",clientModel.getShip_addr2());
        cv.put("ship_addr3", clientModel.getShip_addr3());
        long record_id=db.insert("client", null, cv);
        Log.d("tag","Client record saved :"+record_id);
    }

    public List<ClientModel> getAllClients()
    {
        String qry="SELECT * FROM client";
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
                model.setMobile(cursor.getString(3));
                model.setPhone(cursor.getString(4));
                model.setFax(cursor.getString(5));
                model.setContact(cursor.getString(6));
                model.setLine1(cursor.getString(7));
                model.setLine2(cursor.getString(8));
                model.setLine3(cursor.getString(9));
                model.setShipping_name(cursor.getString(10));
                model.setShip_addr1(cursor.getString(11));
                model.setShip_addr2(cursor.getString(12));
                model.setShip_addr3(cursor.getString(13));
                clientList.add(model);
            }while (cursor.moveToNext());
        }
        return clientList;
    }
}

