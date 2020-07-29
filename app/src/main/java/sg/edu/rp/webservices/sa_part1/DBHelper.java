package sg.edu.rp.webservices.sa_part1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "SimpleModule.db";
    private static int DATABASE_VERSION = 1;
    private static String TABLE_MODULE = "Module";
    private static String COLUMN_ID= "_id";
    private static String COLUMN_CODE = "code";
    private static String COLUMN_NAME = "name";
    private static String COLUMN_SCHOOL = "school";
    private static String COLUMN_numStudents = "numStudents";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createModuleTableSql = "CREATE TABLE"+TABLE_MODULE+"("
                +COLUMN_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_NAME+"TEXT"+COLUMN_SCHOOL+"TEXT"
                +COLUMN_numStudents + "INTEGER"
                +COLUMN_CODE+"TEXT )";
        db.execSQL(createModuleTableSql);

        //DUMMY
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,"Android Programming II");
        values.put(COLUMN_CODE,"C347");
        values.put(COLUMN_SCHOOL,"SOI");
        values.put(COLUMN_numStudents,"50");
        db.insert(TABLE_MODULE,null,values);

        //DUMMY
        ContentValues values2 = new ContentValues();
        values2.put(COLUMN_NAME,"Understanding Society");
        values2.put(COLUMN_CODE,"B103");
        values2.put(COLUMN_SCHOOL,"SMC");
        values2.put(COLUMN_numStudents,"200");
        db.insert(TABLE_MODULE,null,values2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertModules(String name, String code, String school, int numStudents){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_CODE,code);
        values.put(COLUMN_SCHOOL,school);
        values.put(COLUMN_numStudents,numStudents);
        long result = db.insert(TABLE_MODULE,null,values);
        return result;
    }

    public ArrayList<Module> getAllModules(){
        ArrayList<Module> modules = new ArrayList<Module>();
        SQLiteDatabase db = this.getReadableDatabase();
        String columns[] = {COLUMN_ID,COLUMN_NAME,COLUMN_SCHOOL,COLUMN_CODE,COLUMN_numStudents};
        String condition = COLUMN_NAME + "LIKE?";

        Cursor cursor = db.query(TABLE_MODULE,columns,condition,null,null,null,null);

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String school = cursor.getString(2);
                String code = cursor.getString(3);
                int numStudents = cursor.getInt(4);

                Module module = new Module(id,numStudents,code,name,school);
                modules.add(module);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return modules;

    }
}
