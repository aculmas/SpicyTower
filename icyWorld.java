import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class icyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class icyWorld extends World
{

    /**
     * Constructor for objects of class icyWorld.
     * 
     */
    public int score;
    public icyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        score = 501;
    }
    public void loose(Actor a) {
    	if (score > 500) {
    		int h = (int)getHeight() / 2;
    		addObject(new goodThing(), 50, h);
    		addObject(new goodThing(), 200, h);
    		addObject(new goodThing(), 350, h);
    	}
    	if (score < 500 && score > 250) {
    		int h = (int)getHeight() / 2;
    		addObject(new goodThing(), 50, h);
    		addObject(new goodThing(), 200, h);
    	} else {
    	    int h = (int)getHeight() / 2;
    		addObject(new goodThing(), 50, h);
    	}
    	removeObject(a);
    }
}
