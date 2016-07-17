package list.restaurants.com.veganrestaurantslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addBtn= (Button) findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameET= (EditText) findViewById(R.id.restNameET);
                EditText address= (EditText) findViewById(R.id.restAdressET);

                CheckBox cb= (CheckBox) findViewById(R.id.isVeganCB);


                Resturant restToAdd= new Resturant(nameET.getText().toString(), address.getText().toString(), cb.isChecked());

                MyDbCommandsHelper dbhelper= new MyDbCommandsHelper(MainActivity.this);
                dbhelper.addRestaurant(restToAdd);


            }
        });


        Button gotolist= (Button) findViewById(R.id.gotoListBtn);

        gotolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, MyRestarantsList.class);
                startActivity(intent);
            }
        });


    }
}
