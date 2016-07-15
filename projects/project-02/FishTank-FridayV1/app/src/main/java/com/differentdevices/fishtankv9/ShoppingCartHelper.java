package com.differentdevices.fishtankv9;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by sterlinggerritz on 7/14/16.
 */
public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<ProductSingleton> catalog;
    private static List<ProductSingleton> cart;
    private int id;
    private String name;
    private String description;
    private Double price;
    private Integer rating;
    private String image;
    private String type;
    public static List<ProductSingleton> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<ProductSingleton>();
            catalog.add(new ProductSingleton(1,"Clown Fish", "juvenile fish", 12.99, 5, "http://www.wmsp.co.uk/images/speciesimages/1364921778.jpg", "Fish"));

            catalog.add(new ProductSingleton(2,"Trigger Fish", "juvenile fish", 87.00, 4,"http://www.fishkeeping.co.il/images/cache/51pQV1sGWYL._SX355_.jpg", "Fish"));

            catalog.add(new ProductSingleton(3,"Blue Tang", "juvenile fish", 12.99, 2,"http://www.reefsecrets.com.au/image/cache/data/blue%20tang-700x700.jpg", "Fish"));


            catalog.add(new ProductSingleton(4,"Frog Spawn Coral", "soft coral", 12.99, 5,"https://s-media-cache-ak0.pinimg.com/736x/db/b4/5c/dbb45cdf04bf49beb5862712bcc2da77.jpg", "Coral"));

            catalog.add(new ProductSingleton(5,"Coral Branches", "soft coral", 13.50, 1,"https://s-media-cache-ak0.pinimg.com/736x/c5/16/b8/c516b8fbad1050230782b85c3edce148.jpg", "Coral"));


            catalog.add(new ProductSingleton(6,"Zoanthid", "soft coral", 42.99, 2,"http://www.zoanthids.com/images/SuperSunflowerZoanthids.jpg", "Coral"));

            catalog.add(new ProductSingleton(7,"Sea Salt", "1 gallon", 89.99, 4,"http://petus.imageg.net/PETNA_36/pimg/pPETNA-5046564_main_t300x300.jpg", "Supply"));

            catalog.add(new ProductSingleton(8,"Fish Food", "5 ounces", 16.99, 4,"https://coastalreefaquariums.files.wordpress.com/2012/07/newlifespectrum.jpg", "Supply"));
            catalog.add(new ProductSingleton(9,"Chemical Level Test Kit", "6 tests", 99.99, 5,"http://www.fishkeeping.co.il/images/cache/51pQV1sGWYL._SX355_.jpg", "Supply"));
        }

        return catalog;
    }

    public static List<ProductSingleton> getCart() {
        if(cart == null) {
            cart = new ArrayList<ProductSingleton>() {
            };
        }

        return cart;
    }

}
