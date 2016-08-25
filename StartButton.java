import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setImage("start_button1.png");
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), StartButton.class);
            for (Object object : objects)
            {
                if (object == this)
                {
                    setImage("start_button2.png");
                }
            }
        }
        if (Greenfoot.mouseClicked(this))
        {  
            Greenfoot.setWorld(new PongWorld());
        }  
        
        
    }    
}
