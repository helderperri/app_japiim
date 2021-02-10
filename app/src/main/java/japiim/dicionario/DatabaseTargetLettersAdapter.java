package japiim.dicionario;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DatabaseTargetLettersAdapter {
    DatabaseHelper helper;
    SQLiteDatabase db;
    List<GetTargetLettersTableValues> targetLettersList = new ArrayList<>();
    Context context;
    long glyphId;

    public DatabaseTargetLettersAdapter(Context context, long glyphId) {
        helper = new DatabaseHelper(context);
        db = helper.getReadableDatabase();
        this.context = context;
        this.glyphId = glyphId;
    }


    public List<GetTargetLettersTableValues> getTargetLetters(){
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + "", null);
        StringBuffer buffer = new StringBuffer();
        //int count = 0;

        while(cursor.moveToNext()){

            int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_GLYPYHID);
            int glyphId = cursor.getInt(index1);
            int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_GLYPHORDER);
            int glyphOrder = cursor.getInt(index2);
            int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_GLYPYH);
            String glyph = cursor.getString(index3);
            int index4 = cursor.getColumnIndex(DatabaseHelper.KEY_DISPLAYBTN);
            int displayBtn = cursor.getInt(index4);
            int index5 = cursor.getColumnIndex(DatabaseHelper.KEY_POSITIONBTN);
            int positionBtn = cursor.getInt(index5);

            GetTargetLettersTableValues getTargetLettersTableValues = new GetTargetLettersTableValues(glyphId, glyph, glyphOrder, displayBtn, positionBtn);
            targetLettersList.add(getTargetLettersTableValues);







        }
        return targetLettersList;

    }
    private static class DatabaseHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "out.db";
        private static final String TABLE_NAME = "entries_target_letters";
        //When you do change the structure of the database change the version number from 1 to 2
        private static final int DATABASE_VERSION = 16;
        private static final String KEY_GLYPYHID = "glyph_id";
        private static final String KEY_GLYPHORDER = "glyph_order";
        private static final String KEY_GLYPYH = "glyph";
        private static final String KEY_DISPLAYBTN = "display_btn";
        private static final String KEY_POSITIONBTN = "position_btn";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
                " ("+ KEY_GLYPYHID+" integer primary key autoincrement, " + KEY_GLYPYH+ " text, "+ KEY_GLYPHORDER + " integer, " + KEY_DISPLAYBTN + " integer, " + KEY_POSITIONBTN + " integer)";
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
