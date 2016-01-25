package app.invoice.com.invoiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import app.invoice.com.invoiceapp.database.Database;
import app.invoice.com.invoiceapp.model.ClientModel;

public class ClientAddActivity extends AppCompatActivity {


    EditText editName,editEmail,editMobile,editPhone,editFax,editContact,editLine1,editLine2,
    editLine3,editShipName,editShip_Addr1,editShip_Addr2,editShip_Addr3;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("New Client");
        db=new Database(ClientAddActivity.this);
        db.openDataBase();
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_client_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        if(item.getItemId()==R.id.action_save)
        {
            saveDataToDB();
        }
        return super.onOptionsItemSelected(item);
    }

    private  void initViews()
    {
        editName=(EditText)findViewById(R.id.editName);
        editEmail=(EditText)findViewById(R.id.editEmail);
        editMobile=(EditText)findViewById(R.id.editMobile);
        editPhone=(EditText)findViewById(R.id.editPhone);
        editFax=(EditText)findViewById(R.id.editFax);
        editContact=(EditText)findViewById(R.id.editContact);
        editLine1=(EditText)findViewById(R.id.editAddress1);
        editLine2=(EditText)findViewById(R.id.editAddress2);
        editLine3=(EditText)findViewById(R.id.editAddress3);
        editShipName=(EditText)findViewById(R.id.editShippingName);
        editShip_Addr1=(EditText)findViewById(R.id.editShipLine1);
        editShip_Addr2=(EditText)findViewById(R.id.editShipLine2);
        editShip_Addr3=(EditText)findViewById(R.id.editShipLine3);

    }

    private void saveDataToDB()
    {
        ClientModel model=new ClientModel();
        model.setName(editName.getText().toString());
        model.setEmail(editEmail.getText().toString());
        model.setMobile(editMobile.getText().toString());
        model.setPhone(editPhone.getText().toString());
        model.setFax(editFax.getText().toString());
        model.setContact(editContact.getText().toString());
        model.setLine1(editLine1.getText().toString());
        model.setLine2(editLine2.getText().toString());
        model.setLine3(editLine3.getText().toString());
        model.setShipping_name(editShipName.getText().toString());
        model.setShip_addr1(editShip_Addr1.getText().toString());
        model.setShip_addr2(editShip_Addr2.getText().toString());
        model.setShip_addr3(editShip_Addr3.getText().toString());
        db.saveClient(model);

    }
}
