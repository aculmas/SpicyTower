import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Notification here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Notification extends Ui
{
    /**
     * Act - do whatever the Notification wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage unr = new GreenfootImage("images/notification.png");
    private GreenfootImage rea = new GreenfootImage("images/noNotification.png");
    public Notification() {}
    public Notification(String _unr, String _rea) {
        unr = new GreenfootImage(_unr);
        rea = new GreenfootImage(_rea);
        setImage(rea);
    }
    public void setStatus(boolean _new)
    {
    	if (_new) {
    		setImage(unr);
    	} else {
    		setImage(rea);
    	}
    }
}
