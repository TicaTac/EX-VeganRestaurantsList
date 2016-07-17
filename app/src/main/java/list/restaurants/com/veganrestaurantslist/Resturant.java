package list.restaurants.com.veganrestaurantslist;

/**
 * Created by jbt on 17/07/2016.
 */
public class Resturant {

    String name;
    String address;
    boolean isVegan;


    public Resturant(String name, String address, boolean isVegan) {
        this.name = name;
        this.address = address;
        this.isVegan = isVegan;
    }


    @Override
    public String toString() {
        return name +" "+address+" vegan: "+isVegan;
    }
}
