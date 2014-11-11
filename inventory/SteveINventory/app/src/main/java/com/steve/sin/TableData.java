package com.steve.sin;

import android.provider.BaseColumns;

import java.sql.Timestamp;


/**
 * Created by steve on 2014.11.11..
 */
public class TableData {

    public TableData() {

    }

    public static abstract class TableInfo implements BaseColumns {

        public static final String DATABASE_NAME    = "sin";
        public static final String TABLE_NAME       = "inventory";
        public static final String inv_barcode      = "inv_barcode";
        public static final String inv_piece        = "inv_piece";
        public static final String active           = "inv_active";
    }
}
