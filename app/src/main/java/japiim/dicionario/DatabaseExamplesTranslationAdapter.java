package japiim.dicionario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import japiim.dicionario.GetExamplesTranslationTableValues;

import java.util.ArrayList;
import java.util.List;


public class DatabaseExamplesTranslationAdapter {
    DatabaseHelper helper;
    SQLiteDatabase db;
    List<GetExamplesTranslationTableValues> examplesTranslationList = new ArrayList<>();
    Context context;
    long exampleBundleId;
    long translationId;

    public DatabaseExamplesTranslationAdapter(Context context, long exampleBundleId, long translationId) {
        helper = new DatabaseHelper(context);
        db = helper.getReadableDatabase();
        this.context = context;
        this.exampleBundleId = exampleBundleId;
        this.translationId = translationId;
    }


    public List<GetExamplesTranslationTableValues> getExamplesTranslation(){
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE example_bundle_id = " + exampleBundleId + "", null);
        StringBuffer buffer = new StringBuffer();
        //int count = 0;

        while(cursor.moveToNext()){

            int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_EXAMPLEBUNDLEID);
            int exampleBundleId = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_TRANSLATIONID);
            int translationId = cursor.getInt(index2);
            int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_ENTRYREF);
            String entryRef = cursor.getString(index3);
            int index4 = cursor.getColumnIndex(DatabaseHelper.KEY_TRANSLATION);
            String translation = cursor.getString(index4);

            GetExamplesTranslationTableValues getExamplesTranslationTableValues = new GetExamplesTranslationTableValues(exampleBundleId, entryRef, translationId, translation);
            examplesTranslationList.add(getExamplesTranslationTableValues);







        }
        return examplesTranslationList;

    }
    private static class DatabaseHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "out.db";
        private static final String TABLE_NAME = "translations";
        //When you do change the structure of the database change the version number from 1 to 2
        private static final int DATABASE_VERSION = 16;
        private static final String KEY_EXAMPLEBUNDLEID = "example_bundle_id";
        private static final String KEY_TRANSLATIONID = "translation_id";
        private static final String KEY_ENTRYREF = "entry_ref";
        private static final String KEY_TRANSLATION = "translation";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
                " ("+ KEY_EXAMPLEBUNDLEID+" integer, " + KEY_ENTRYREF+ " text, "+ KEY_TRANSLATIONID + " integer primary key autoincrement, " + KEY_TRANSLATION +" text)";
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
