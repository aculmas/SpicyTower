import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo). ACTUALLY NOT. Just joking.

/**
 * Write a description of class Row here.
 * 
 * @author Martin Haug
 * @version 0.0.1
 *
 * Row actually acts as a collection for Brick objects. It sets them randomly, at picked difficulty or in groups.
 */
public class Row
{
	public boolean[] objects = new boolean[16];
    public Row() {
    	for (int i = 0; i < objects.length; i++) {
    		if (Math.random() > 0.5) {
    			objects[i] = true;
    		}
    	}
    }
    public Row(double diff) {
    	if (diff > 100) {
    		diff = 0.5;
    	} else {
    		diff = diff / 100;
    	}
    	for (int i = 0; i < objects.length; i++) {
    		if (Math.random() > diff) {
    			objects[i] = true;
    		}
    	}
    }


}
