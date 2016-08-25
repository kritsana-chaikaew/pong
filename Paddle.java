import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Paddle extends Actor
{
    private int paddleSize;
    
    private int worldWidth;
    
    private int speed = 10;
    private int positionX;
    private int positionY;
    public int direction = 0;
    
    public void act()
    {
        worldWidth = getWorld().getWidth();
        paddleSize = getImage().getWidth() / 2;
        move();
    }
    
    private void move()
    {
        if(Greenfoot.isKeyDown("right") && getX() + paddleSize <= worldWidth)
        {
            direction = 1;
            setLocation(getX() + speed, getY());
        }
        else if(Greenfoot.isKeyDown("left") && getX() - paddleSize >= 0)
        {
            direction = -1;
            setLocation(getX() - speed, getY());
        }
        else
        {    
            direction = 0;
        }
    }
    
    
}
