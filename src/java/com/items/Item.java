/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.items;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmad
 */

@XmlRootElement(name = "item")
public class Item implements Serializable{
    
    int id,price;
    String name;

    public Item() 
    {
    }

    
    
    public Item(int id, String name,int price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    
    
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
    
    @XmlElement 
    public void setPrice(int price) {
        this.price = price;
    }
    
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
