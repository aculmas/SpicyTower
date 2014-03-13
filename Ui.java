import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ui here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Ui extends Actor
{
    /**
     * Act - do whatever the Ui wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected SpicyWorld w;
    protected void addedToWorld (World _w) {
    	super.addedToWorld(_w);
    	w = (SpicyWorld)_w;
    }
    public int[] getCenter () {
    	try {
    		int [] _cntr = {(int)(w.getWidth() / 2), (int)(w.getHeight() / 2)};
    		return _cntr;
    	} catch (Exception e) {
    		int [] _cntr = {0, 0};
    		return _cntr;
    	}
    }
    protected void setCenter() {
    	int [] cntr = getCenter();
    	setLocation(cntr[0], cntr[1]);
    }
    protected void scroll(boolean up, int velocity) {
    	if (!up) {
    		setLocation(getX(), getY() + velocity);
    		if (getY() >= 599) {
    			w.removeObject(this);
    		}
    	} else {
    		setLocation(getX(), getY() - velocity);
    		if (getY() <= 1) {
    			w.removeObject(this);
    		}
    	}
    }
}
