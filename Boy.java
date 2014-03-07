import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Write a description of class Boy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boy extends Actor
{
    /**
     * Act - do whatever the Boy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private double gravity = 0.981; 
    public void act() 
    {
        fall();
        //jump();
		events();
    }
    public void events(){
    	if(Greenfoot.isKeyDown("right"))
        {
            run(true);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            run(false);
        }
    }
    public void run(boolean back)
    {
        int pos;
        if (back == true) {pos =  1;} else {pos = -1;}
        Platform wand = (Platform)this.getOneObjectAtOffset(pos, 0, Platform.class);
        if (wand == null) {
            if (back) {
                this.setLocation(getX()+1, getY());
            } else {
                this.setLocation(getX()-1, getY());
            }
            
        }
    }    
    public void fall()
    {
        int fall = 0;
        double y = getY();
        while(y+1!=this.getWorld().getHeight() + 10 && this.getOneIntersectingObject(Platform.class)== null)
        {
        	events();
        	fall++;
            y = y+(1*fall*gravity);
            this.setLocation(getX(), (int)y);
            Greenfoot.delay(1);
            if (y >= getWorld().getHeight()) {
                icyWorld w = (icyWorld)this.getWorld();
                w.loose(this);
                break;
            }
        }
    }
    /*public void jump()
    {
        int fall = 1;
        int power = 10;
        while(fall < 200)
        {
        	events();
        	int multi = Math.round((float)(-1*(fall*fall)));
            this.setLocation(getX(), getY()-multi);
            Greenfoot.delay(1);
            fall++;
        }
    }*/
}
