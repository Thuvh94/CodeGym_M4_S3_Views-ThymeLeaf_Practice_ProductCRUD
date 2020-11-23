package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IProductServiceImpl implements  IProductService{
    private static Map<Integer,Product> products;
    static{
        products = new HashMap<>();
        products.put(1,new Product(1,"LG",8000000));
        products.put(2,new Product(2,"LH",8200000));
        products.put(3,new Product(3,"LI",8400000));
        products.put(4,new Product(4,"LK",8600000));
        products.put(5,new Product(5,"LL",8800000));
        products.put(6,new Product(6,"LM",9000000));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
