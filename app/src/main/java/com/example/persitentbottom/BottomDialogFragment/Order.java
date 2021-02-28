package com.example.persitentbottom.BottomDialogFragment;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private String price;
    private List<Product> listProduct;
    private String address;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order(String price, List<Product> listProduct, String address) {
        this.price = price;
        this.listProduct = listProduct;
        this.address = address;
    }

    public String getListProductName() {
        if (listProduct == null || listProduct.isEmpty()) {
            return "";

        }
        StringBuilder stringBuilder = new StringBuilder();//nối chuỗi sp (dùng StringBulder)
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);

            if (stringBuilder.length() > 0) {//neu co san pham
                stringBuilder.append("\n");//xuong dong
            }
            stringBuilder.append(product.getName());
        }
        return stringBuilder.toString();
    }

}
