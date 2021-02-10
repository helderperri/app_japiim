package japiim.dicionario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import japiim.dicionario.GetExamplesVernacularTableValues;

import java.util.ArrayList;
import java.util.List;


public class DatabaseExamplesVernacularAdapter {
    DatabaseHelper helper;
    SQLiteDatabase db;
    List<GetExamplesVernacularTableValues> examplesVernacularList = new ArrayList<>();
    Context context;
    long exampleBundleId;
    long exampleId;

    public DatabaseExamplesVernacularAdapter(Context context, long exampleBundleId, long exampleId) {
        helper = new DatabaseHelper(context);
        db = helper.getReadableDatabase();
        this.context = context;
        this.exampleBundleId = exampleBundleId;
        this.exampleId = exampleId;
    }


    public List<GetExamplesVernacularTableValues> getExamplesVernacular(){
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE example_bundle_id = " + exampleBundleId + "", null);
        StringBuffer buffer = new StringBuffer();
        //int count = 0;

        while(cursor.moveToNext()){

            int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_EXAMPLEBUNDLEID);
            int exampleBundleId = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_EXAMPLEID);
            int exampleId = cursor.getInt(index2);
            int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_ENTRYREF);
            String entryRef = cursor.getString(index3);
            int index4 = cursor.getColumnIndex(DatabaseHelper.KEY_VERNACULAR);
            String vernacular = cursor.getString(index4);

            GetExamplesVernacularTableValues getExamplesVernacularTableValues = new GetExamplesVernacularTableValues(exampleBundleId, entryRef, exampleId, vernacular);
            examplesVernacularList.add(getExamplesVernacularTableValues);







        }
        return examplesVernacularList;

    }
    private static class DatabaseHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "out.db";
        private static final String TABLE_NAME = "examples";
        //When you do change the structure of the database change the version number from 1 to 2
        private static final int DATABASE_VERSION = 16;
        private static final String KEY_EXAMPLEBUNDLEID = "example_bundle_id";
        private static final String KEY_EXAMPLEID = "example_id";
        private static final String KEY_ENTRYREF = "entry_ref";
        private static final String KEY_VERNACULAR = "vernacular";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
                " ("+ KEY_EXAMPLEBUNDLEID+" integer, " + KEY_ENTRYREF+ " text, "+ KEY_EXAMPLEID + " integer primary key autoincrement, " + KEY_VERNACULAR +" text)";
        private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;
        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
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
