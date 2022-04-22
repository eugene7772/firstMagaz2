package com.magaz2.firstMagaz2.globalData;

import com.magaz2.firstMagaz2.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalCart {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
}
