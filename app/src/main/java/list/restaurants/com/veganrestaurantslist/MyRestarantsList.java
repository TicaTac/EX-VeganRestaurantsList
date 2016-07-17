package list.restaurants.com.veganrestaurantslist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyRestarantsList extends AppCompatActivity {

    // ArrayList
    ArrayList<Resturant> allRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_restarants_list);

        // SQL Helper

        MyDbCommandsHelper dbhelper= new MyDbCommandsHelper(this);
        allRestaurants=dbhelper.getAllResturants();


        ListView lv= (ListView) findViewById(R.id.listView);

       // ArrayAdapter<Resturant> adapter= new ArrayAdapter<Resturant>(this,android.R.layout.simple_list_item_1, allRestaurants);

        MySqlOpenHelper helper= new MySqlOpenHelper(this);
        Cursor c= helper.getWritableDatabase().rawQuery("SELECT * FROM restaurants ", null);


        String[] from= {"name" ,"address" };
        int[] to = { android.R.id.text1, android.R.id.text2 };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,c ,from, to );


        lv.setAdapter(adapter);


    }
}
