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
    protected double gravity = 0.981; 
    protected int val = 4;
    protected boolean jump;
    protected int fall;
    protected boolean firstMove;
    protected boolean veryFirst = true;
    protected int worldVel;
    protected double y;
    protected int doubleEligible = 0;
    protected int startY;
    protected SpicyWorld world;

    public Boy(){
        init(false);
    }
    public void act() 
    {
        if (veryFirst == true) {
            y = getY();
            startY = (int)y;
        }
        if (Greenfoot.isKeyDown("space")) {
            if (doubleEligible > 7) {
                init(true);
                doubleEligible = 0;
            }
        }
        if (firstMove == true) {
            world = (SpicyWorld)this.getWorld();
            worldVel = world.getVelocity();
            y = getY();
        }
        if (jump == false) {
            if (y+1!=this.getWorld().getHeight() + 10 && this.getOneIntersectingObject(Platform.class)== null) {
                fall++;
                y = y+(1*fall*gravity);
                this.setLocation(getX(), (int)y);
                try {
                    if (y >= getWorld().getHeight()) {
                        world.loose(this);
                    }
                } catch (Exception e) {}
            } else {
                if (veryFirst == true) {
                    startY = (int)y;
                    veryFirst = false;
                }
                if (startY > (y + 30)) {
                    world.scroll();
                    world.score += 30;
                    doubleEligible++;
                }
                init(true);
            }
        } else {
            if (fall<20) {
                fall++;
                y = y-(70/(1*fall*gravity));
                this.setLocation(getX(), (int)y);
                if (y >= getWorld().getHeight()) {
                    try {
                        world.loose(this);
                    } catch (Exception e) {}
                }
            } else {
                init(false);
            }
        }
        events();
    }
    protected void events(){
        if(Greenfoot.isKeyDown("right"))
        {
            run(true);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            run(false);
        }
    }
    protected void init(boolean _jump) {
        jump = _jump;
        firstMove = true;
        if (_jump == true) {
            fall = 1;
            startY = getY();
        } else {
            fall = 0;
        }
    }
    protected void run(boolean back)
    {
        int pos;
        if (back == true) {pos =  1;} else {pos = -1;}
        Platform wand = (Platform)this.getOneObjectAtOffset(pos, 0, Platform.class);
        if (wand == null) {
            if (back) {
                this.setLocation(getX()+val, getY());
            } else {
                this.setLocation(getX()-val, getY());
            }

        }
    }    
}
