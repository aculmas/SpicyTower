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
    	if (w.score > 500 && step == 0) {
    		mail = new Letter(0, false, false);
    		w.addObject(mail, 0, 0);
    		step++;
    	} else if (w.score > 500 && w.score < 700) {
    		try {
    			if (last.getY() < 550) {
    				last = new Overlay();
    				w.addObject(last, 0, 0);
    			}
    		} catch (Exception e) {
				last = new Overlay();
    			w.addObject(last, 0, 0);
    		}
    	} else if (w.score > 700 && step == 1) {
    		mail.dismiss();
    		step++;
    	} else if (w.score > 1200 && step == 2) {
    		w.notification.setStatus(true);
    		mail = new Letter(1, true, true);
    		step++;
    	} else if (w.score > 1200 && step == 3 && Greenfoot.isKeyDown("m")) {
    		w.addObject(mail, 0, 0);
    		step++;
    	} else if (w.score > 1500 && step == 4) {
    		mail = new Letter(2, false, false);
    		w.addObject(mail, 0, 0);
    		step++;
    	}
    } 
    protected void addedToWorld (World _w) {
    	super.addedToWorld(_w);
    	w = (SpicyWorld)_w;
    } 
}
