package japiim.dicionario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import japiim.dicionario.GetSensesTableValues;

import java.util.ArrayList;
import java.util.List;


public class DatabaseSensesAdapter {
    DatabaseHelper helper;
    SQLiteDatabase db;
    DatabaseSenseBundlesAdapter databaseSenseBundlesAdapter;
    DatabaseFormBundlesAdapter databaseFormBundlesAdapter;

    List<GetSensesTableValues> sensesList = new ArrayList<>();
    Context context;
    long senseBundleId;
    long senseId;
    String def;


    public DatabaseSensesAdapter(Context context, long senseBundleIid, long senseIid) {
        helper = new DatabaseHelper(context);
        db = helper.getReadableDatabase();
        this.context = context;
        this.senseBundleId = senseBundleIid;
        this.senseId = senseIid;


    }


    public long getSenseBundleId(long entry_id){

        databaseSenseBundlesAdapter = new DatabaseSenseBundlesAdapter(context, entry_id, 0);

        senseBundleId = databaseSenseBundlesAdapter.getSenseBundleId(entry_id);


        return senseBundleId;
    }

    public String getDef(long senseBundleId ){


        Cursor cursor = db.rawQuery("SELECT def FROM senses WHERE sense_bundle_id = " + senseBundleId + " AND lang_code = 'por'", null);
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(DatabaseHelper.KEY_DEF);
            def = cursor.getString(index);

            /*

            while(cursor2.moveToNext()) {
                int index2 = cursor.getColumnIndex("entry_bundle_id");
                parentEntryBundleId = cursor.getInt(index2);


            }

            */

        }



        return def;

    }

    public List<GetSensesTableValues> getSenses(){
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE sense_bundle_id = " + senseBundleId + "", null);
        StringBuffer buffer = new StringBuffer();
        //int count = 0;

        while(cursor.moveToNext()){

            int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_SENSEBUNDLEID);
            int senseBundleId = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_SENSEID);
            int senseId = cursor.getInt(index2);
            int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_ENTRYREF);
            String entryRef = cursor.getString(index3);
            int index4 = cursor.getColumnIndex(DatabaseHelper.KEY_DEF);
            String def = cursor.getString(index4);

            GetSensesTableValues getSensesTableValues = new GetSensesTableValues(senseBundleId, entryRef, senseId, def);
            sensesList.add(getSensesTableValues);







        }
        return sensesList;

    }
    private static class DatabaseHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "out.db";
        private static final String TABLE_NAME = "senses";
        //When you do change the structure of the database change the version number from 1 to 2
        private static final int DATABASE_VERSION = 16;
        private static final String KEY_SENSEBUNDLEID = "sense_bundle_id";
        private static final String KEY_SENSEID = "sense_id";
        private static final String KEY_ENTRYREF = "entry_ref";
        private static final String KEY_DEF = "def";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
                " ("+ KEY_SENSEBUNDLEID+" integer, " + KEY_ENTRYREF+ " text, "+ KEY_SENSEID + " integer primary key autoincrement)";
        private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;
        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            //Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try{
                //db.execSQL(CREATE_TABLE);
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try{
                Toast.makeText(context, "onUpgrade called", Toast.LENGTH_SHORT).show();
                //db.execSQL(DROP_TABLE);
                //onCreate(db);
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
