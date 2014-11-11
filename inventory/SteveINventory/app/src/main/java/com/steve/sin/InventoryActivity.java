package com.steve.sin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class InventoryActivity extends Activity {
    Button leker;
    TextView text1;
    String barcode;
    Integer piece, active;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        text1 = (TextView) findViewById(R.id.textView);
        barcode = "1234567890";
        piece   = 1;
        active  = 1;

        leker = (Button) findViewById(R.id.button1);
        leker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                DatabaseOperations DB = new DatabaseOperations(ctx);
                try {
                    DB.putInventory(DB, barcode, piece, active);
                    text1.setText(barcode);
                    Toast.makeText(getBaseContext(), barcode + " rögzítve.", Toast.LENGTH_LONG).show();
                }catch(Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                    finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inventory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
