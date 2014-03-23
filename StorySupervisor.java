import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StorySupervisor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StorySupervisor extends Actor
{
    /**
     * Act - do whatever the StorySupervisor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private SpicyWorld w;
    private int step = 0;
    private Overlay last;
    private Letter mail;
    public void act() 
    {
    	if (w.score > 450 && step == 0) {
    		mail = new Letter(0, false, false);
    		w.addObject(mail, 0, 0);
    		step++;
    	} else if (w.score > 450 && w.score < 700) {
    		try {
    			if (last.getY() < 550) {
    				last = new Overlay();
    				w.addObject(last, 0, 0);
    			}
    		} catch (Exception e) {
				last = new Overlay();
    			w.addObject(last, 0, 0);
    		}
    	} else if (w.score > 650 && step == 1) {
    		mail.dismiss();
    		step++;
    	} else if (w.score > 800 && step == 2) {
    		w.notification.setStatus(true);
    		mail = new Letter(1, true, true);
    		step++;
    	} else if (w.score > 800 && w.score < 1100 && step == 3 && Greenfoot.isKeyDown("m")) {
    		w.addObject(mail, 0, 0);
    	} else if (w.score > 1250 && step == 3) {
    		w.notification.setStatus(false);
    		mail = new Letter(2, false, false);
    		w.addObject(mail, 0, 0);
    		step++;
    	} else if (w.score > 1400 && step == 4) {
    		mail.dismiss();
    		step++;
    	} else if (w.score > 1500 && step == 5) {
    		w.notification.setStatus(true);
    		mail = new Letter(3, true, true);
    		step++;
    	} else if (w.score > 1500 && w.score < 1750 && step == 6 && Greenfoot.isKeyDown("m")) {
    		w.addObject(mail, 0, 0);
    	} else if (w.score > 1750 && step == 6) {
    		w.notification.setStatus(true);
    		mail = new Letter(4, true, true);
    		step++;
    	} else if (w.score > 1750 && w.score < 2000 && step == 7 && Greenfoot.isKeyDown("m")) {
    		w.addObject(mail, 0, 0);
    	} else if (w.score > 2000 && step == 7) {
    		w.addObject(new Grafitto(), 0, 0);
    		step++;
    	}

    } 
    protected void addedToWorld (World _w) {
    	super.addedToWorld(_w);
    	w = (SpicyWorld)_w;
    } 
}
