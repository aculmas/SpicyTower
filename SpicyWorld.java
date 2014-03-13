import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.Math;

/**
 * Write a description of class icyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpicyWorld extends World
{

    /**
     * Constructor for objects of class SpicyWorld.
     * 
     */
    public int score;
    public int dest;
    public Notification notification;
    public boolean pause;
    protected int didScroll;
    protected StorySupervisor supervisor;
    protected int velocity = 2;
    protected boolean scroll;
    protected int rowSpacing = 100;
    protected int firstSpacing = 50;
    protected int highest;
    protected int crow = 0;
    protected boolean first;
    protected List<Actor> aList = new ArrayList<Actor>();

    public SpicyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        score = 0;
        first = true;
        setPaintOrder(GoodThing.class, Letter.class, Overlay.class, Notification.class, Boy.class, Platform.class, Grafitto.class);
        // Populate world
        int currentSpacing = firstSpacing;
        int place = 600;
        Actor bo = new Boy();
        aList.add(bo);
        addObject(bo, 10, 550);
        while (place - (currentSpacing) >= 0) {
            Row r;
            if (crow == 0) {
                r = new Row(0);
            } else {
                r  = new Row(getDiff(crow));
            }
            crow++;
            int xPlace = 25;
            for ( boolean b : r.objects ) {
                if (b) {
                    Platform p = new Platform();
                    addObject(p, xPlace, place);
                    aList.add(p);
                    highest = place;
                }
                xPlace += 50;
            }
            currentSpacing = rowSpacing;
            place = place - (rowSpacing + 50);
        }
        notification = new Notification();
        addObject(notification, 755, 550);
        supervisor = new StorySupervisor();
        addObject(supervisor, 0, 0);
    }
    protected void makeRow() {
        crow++;
        Row r = new Row(getDiff(crow));
        int xPlace = 25;
        for ( boolean b : r.objects ) {
            if (b) {
                Platform p = new Platform();
                addObject(p, xPlace, 0);
                aList.add(p);
            }
            xPlace += 50;
        }
    }
    public void loose(Actor a) {
        int h = (int)getHeight() / 2;
        if (score > 2000) {
            addObject(new GoodThing(), 50, h);
            addObject(new GoodThing(), 200, h);
            addObject(new GoodThing(), 350, h);
            addObject(new GoodThing(), 500, h);
            addObject(new GoodThing(), 650, h);
        } 
        else if (score > 1750) {
            addObject(new GoodThing(), 50, h);
            addObject(new GoodThing(), 200, h);
            addObject(new GoodThing(), 350, h);
            addObject(new GoodThing(), 500, h);
        } 
        else if (score > 1200) {
            addObject(new GoodThing(), 50, h);
            addObject(new GoodThing(), 200, h);
            addObject(new GoodThing(), 350, h);
        }
        else if (score > 700) {
            addObject(new GoodThing(), 50, h);
            addObject(new GoodThing(), 200, h);
        } else {
            addObject(new GoodThing(), 50, h);
        }
        try {
            removeObject(a);
        } catch (Exception e) {}
    }
    public int getVelocity () {
        return velocity;
    }
    public boolean willScroll () {
        return scroll;
    }
    protected double getDiff(int x) {
        return Math.abs(Math.sin(0.7*Math.sqrt(x))*70-20);
    }
    public void act() {
        if (!pause) {
            boolean removedOne = false;
            if (scroll = true && didScroll < dest) {

                List<Actor> removedList = new ArrayList<Actor>();
                for ( Actor a : aList ) {
                    a.setLocation(a.getX(), a.getY()+velocity);
                    if (a.getY() == 599) {
                        removeObject(a);
                        removedList.add(a);
                        removedOne = true;
                    }
                }
                aList.removeAll(removedList);
            } else {
                scroll = false;
            }
            if (removedOne) {
                makeRow();
            }
        }
    }
    public void scroll() {
        scroll = true;
        didScroll = 0;
        dest = 50;
    }
}
