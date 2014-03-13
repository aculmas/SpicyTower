import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grafitto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grafitto extends Ui
{
    /**
     * Act - do whatever the Grafitto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scroll(false, 1);
    }  
    protected void addedToWorld (World _w) {
        super.addedToWorld(_w);
        w = (SpicyWorld)_w;
        setLocation(getCenter()[0], 0);
    }
}
