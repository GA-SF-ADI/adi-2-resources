package ly.generalassemb.project2;

import java.util.ArrayList;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/21/16.
 */
public class ShoppingCart {
    private static ShoppingCart ourInstance = new ShoppingCart();

    ArrayList<Long> mProducts;

    public static ShoppingCart getInstance() {
        return ourInstance;
    }

    private ShoppingCart() {
        mProducts = new ArrayList<>();
    }

    public void addProduct(long productId){
        if (!mProducts.contains(productId)){
            mProducts.add(productId);
        }
    }

    public void removeProduct(int productId){
        mProducts.remove(Long.valueOf(productId));
    }
}
