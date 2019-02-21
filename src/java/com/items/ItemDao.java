/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmad
 */
public class ItemDao {

    public List<Item> getAllItemsList() {

        List<Item> itemList = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/items", "root", "CodeForIraq");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id,name,price from item_card");
            itemList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                

                itemList.add(new Item(id,name,price));
            }
            rs.close();
            stmt.close();
            con.close();

            return itemList;
        } catch (Exception e) {
            System.out.println(e);
        }

        return itemList;

    }

    public String addItem(int id, String name, int price) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/items", "root", "CodeForIraq");
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate("insert into item_card values (" + id + ",'" + name + "'," +  price + ")");

            if (result == 1) {
                return "Success";
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return "fail";
    }

   
}

