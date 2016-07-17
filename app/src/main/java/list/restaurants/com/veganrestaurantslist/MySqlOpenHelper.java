package list.restaurants.com.veganrestaurantslist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jbt on 17/07/2016.
 */
public class MySqlOpenHelper  extends SQLiteOpenHelper {


    public MySqlOpenHelper(Context context) {
        super(context, "rest_database.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {


        String command="CREATE TABLE restaurants( _id    INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+ DBConstants.restaurantName +" TEXT," +
                " "+ DBConstants.restaurantAdress+" TEXT, " +
                " "+ DBConstants.isVegan+" INTEGER)";

        db.execSQL(command);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
