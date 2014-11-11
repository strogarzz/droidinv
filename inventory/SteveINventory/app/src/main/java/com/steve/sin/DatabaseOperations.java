package com.steve.sin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.steve.sin.TableData.TableInfo;

/**
 * Created by steve on 2014.11.11..
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_DB_QUERY = "CREATE TABLE " + TableInfo.TABLE_NAME +
            " (" +
            "inv_id      INTEGER    PRIMARY KEY AUTOINCREMENT   NOT NULL," +
            "inv_barcode TEXT                                   NOT NULL," +
            "inv_date    DATETIME   DEFAULT CURRENT_TIMESTAMP   NOT NULL," +
            "inv_piece   INTEGER                                NOT NULL," +
            "inv_active  INTEGER                                NOT NULL " +
            " ); " +
            "CREATE INDEX barcode_index ON " + TableInfo.TABLE_NAME + " (inv_barcode); " +
            "COMMIT;";

    public DatabaseOperations(Context context) {
        super(context, TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operation:","[" + TableInfo.DATABASE_NAME + "] database created.");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_DB_QUERY);
        Log.d("Database operation:","[" + TableInfo.TABLE_NAME + "] table created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInventory(DatabaseOperations dop, String barcode, Integer piece, Integer active) {
        SQLiteDatabase SQ = dop.getWritableDatabase();

        ContentValues cv  = new ContentValues();
            cv.put(TableInfo.inv_barcode, barcode);
            cv.put(TableInfo.inv_piece, piece);
            cv.put(TableInfo.active, active);

        long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operation:","[" + barcode + "] inserted.");

    }
}
