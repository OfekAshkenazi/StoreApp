package SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Android on 10/2/2017.
 */

public class DAL {
}
class StoreEntery{
    protected static final String PRODUCTS_TABLE_NAME=" Products ";
    protected static final String PRODUCTS_COL1=" _id ";
    protected static final String PRODUCTS_COL2=" title ";
    protected static final String PRODUCTS_COL3=" description ";
    protected static final String PRODUCTS_COL4=" price ";
    protected static final String PRODUCTS_COL5=" type ";

    protected static final String CREATE_PRODUCTS_TABLE_QUERY="CREATE TABLE"+PRODUCTS_TABLE_NAME+"("
            +PRODUCTS_COL1+"INTEGER PRIMARY KEY AUTOINCREMENT,"
            +PRODUCTS_COL2+"TEXT,"
            +PRODUCTS_COL3+"TEXT,"
            +PRODUCTS_COL4+"REAL,"
            +PRODUCTS_COL5+"INTEGER)";
}

class MySQLiteHelper extends SQLiteOpenHelper{
    Context context;
    protected static final String DB_NAME="StoreDatabase";
    protected static  final int DB_VER=1;

    public MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StoreEntery.CREATE_PRODUCTS_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+StoreEntery.PRODUCTS_TABLE_NAME);
        onCreate(db);
    }
}
