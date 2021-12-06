package aquarium.shop.basket;

import aquarium.shop.product.Product;
import java.util.HashMap;


public class Basket {

    private static HashMap<Product,Integer> content = new HashMap<>();

    public HashMap<Product, Integer> getContent() {
        return content;
    }

    public void addProduct(Product product){
        if(content.containsKey(product)){
            content.put(product, content.get(product)+1);
        }
        else{
            content.put(product,1);
        }

    }

    public void addProduct(Product product, int quantity){
        if(content.containsKey(product)){
            content.put(product, content.get(product)+1);
        }
        else{
            content.put(product,quantity);
        }
    }

    public void removeProduct(Product product){
        content.remove(product);
    }

    public void increaseNumberOfProducts(Product product, int quantity){
        content.replace(product,content.get(product) + quantity);
    }

    public void decreaseNumberOfProducts(Product product, int quantity){
        content.replace(product,content.get(product) - quantity);
    }

    public void clearBasket(){
        content.clear();
    }

//    public void PaymentInfo(){
//        content.forEach((key, value) -> System.out.println(key + ":" + value + key.getPrice()));
//    }








}
