import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Letter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letter extends Ui
{
    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int story;
    private boolean dismissable;
    private boolean right;
    private boolean pause;
    public GreenfootImage[] images = {
    	new GreenfootImage("images/licenseWarn.png"),
    	new GreenfootImage("images/clLetter1.png"),
    	new GreenfootImage("images/signalDetected.png"),
    	new GreenfootImage("images/clLetter2.png"),
    	new GreenfootImage("images/signalDecrypt.png")
    };
    public Letter() {
    	right = false;
    }
    protected void addedToWorld (World _w) {
    	super.addedToWorld(_w);
    	w = (SpicyWorld)_w;
    	setCenter();
    	if (pause) {
    		w.pause = true;
    	}
    	if (right) {
    		setImage(images[story]);
    	}

    } 
    public Letter(int _story, boolean _dismissable, boolean _pause) {
    	story = _story;
    	dismissable = _dismissable;
    	pause = _pause;
    	right = true;
    }
    public void dismiss() {
    	w.removeObject(this);
    	w.pause = false;
        w.notification.setStatus(false);
    }
    public void act() 
    {
        if (Greenfoot.isKeyDown("q") && dismissable) {
        	dismiss();
        }
    }    
}
