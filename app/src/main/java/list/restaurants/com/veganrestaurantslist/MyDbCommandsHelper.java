package list.restaurants.com.veganrestaurantslist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jbt on 17/07/2016.
 */
public class MyDbCommandsHelper {



    Context c;
    MySqlOpenHelper helper;



    public MyDbCommandsHelper(Context c)
    {
        this.c=c;
        helper=  new MySqlOpenHelper(c);
    }


    public void  addRestraunt(Resturant resturant)
    {
        int isVegan=0;
        if(resturant.isVegan)
            isVegan=1;

        /// safe SQL query to add to database
        ContentValues contentValues= new ContentValues();

        contentValues.put(DBConstants.restaurantName, resturant.name);
        contentValues.put(DBConstants.restaurantAdress, resturant.address);
        contentValues.put(DBConstants.isVegan, isVegan);

        helper.getWritableDatabase().insert("restaurants", null,contentValues );

/*
//not a safe command
        String sqlCommand= "INSERT INTO restaurants ("+ DBConstants.restaurantName+", "+ DBConstants.restaurantAdress+", "+ DBConstants.isVegan+") " +
                " VALUES ('"+resturant.name+"' ,'"+resturant.address+"'  , "+isVegan+");";

                     helper.getWritableDatabase().execSQL(sqlCommand);
                */

        Toast.makeText(c, "added "+resturant.name ,Toast.LENGTH_SHORT).show();
    }




    public ArrayList<Resturant> getAllResturants()
    {
        ArrayList<Resturant> allrests= new ArrayList<Resturant>();


        //  Cursor cursor= helper.getReadableDatabase().rawQuery("SELECT *  FROM  restaurants ", null);

        //best practice
        Cursor cursor= helper.getReadableDatabase().query("restaurants",null,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            int nameColumn= cursor.getColumnIndex(DBConstants.restaurantName);
            String restName= cursor.getString(nameColumn);

            int addressColumn= cursor.getColumnIndexOrThrow(DBConstants.restaurantAdress);
            String restaddress= cursor.getString(addressColumn);

            int isVeganInt= cursor.getColumnIndexOrThrow(DBConstants.isVegan);
            int  tempVegan= cursor.getInt(isVeganInt);

            boolean isVegan = false;
            if(tempVegan==1)
                isVegan=true;

            Resturant restTemp= new Resturant(restName,restaddress,isVegan);

            allrests.add(restTemp);

        }
        return allrests;
    }






}
