import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ball extends Actor
{
    private boolean startGame = false;
    
    private int ballSize;
    private int positionX;
    private int positionY;
    private int speed = 4;
    private int speedX = speed;
    private int speedY = speed;
    private int ballDirectionX = 1;
    private int ballDirectionY = 1;
    public int radius;
    private int score;
    private boolean touchedDiamond = false;
    
    private int worldHeight;
    private int worldWidth;
    private boolean touchedPaddle = false;
    
    private Paddle paddle;
    private int paddleDirection;
    
    private PongWorld pongWorld;
    
    public void act() 
    {
        pongWorld = (PongWorld) getWorld();
        worldHeight = pongWorld.getHeight();
        worldWidth = pongWorld.getWidth();
        
        paddle = pongWorld.getPaddle();
        paddleDirection = paddle.direction;
        
        ballSize = getImage().getHeight();
        radius = ballSize / 2;
        positionX = getX();
        positionY = getY();
        
        if(!startGame)
        {
            setLocation(positionX, positionY + speedY * ballDirectionY);
        }
        
        checkTouchingEdge();
        if(startGame)
        {
            move();
        }
        bounce();
        scoring();
    }
    
    private void move()
    {
        setLocation(positionX + speedX * ballDirectionX, positionY + speedY * ballDirectionY);
    }
    private void setSpeed()
    {
        
    }
    
    private void bounce()
    {
        if(isTouching(Paddle.class))
        {
            startGame = true;
            if(paddleDirection == 0)
            {
                speedX = speed;
                speedY = speed;
            }
            else if(paddleDirection == ballDirectionX)
            {
                speedY = speed;
                speedX = speed * 4;
            }
            else if(paddleDirection != ballDirectionX)
            {
                speedX = speed;
                speedY = speed * 4;
            }
            if(!touchedPaddle)
            {
                ballDirectionY = -ballDirectionY;
                touchedPaddle = true;
                Greenfoot.playSound("noid.wav");
            }
            touchedDiamond = false;
        }
    }
    
    private void scoring()
    {
        if(isTouching(Diamond.class))
        {
            if(!touchedDiamond)
            {
                removeTouching(Diamond.class);
                touchedDiamond = true;
            
                ballDirectionY = -ballDirectionY;
                speedX = speed;
                speedY = speed;
                score = score + 1;
                Greenfoot.playSound("diamond.wav");
                touchedPaddle = false;
            }
        }
    }
    
    private void checkTouchingEdge()
    {
        if(positionX + radius >= worldWidth)
        {
            ballDirectionX = -ballDirectionX;
            Greenfoot.playSound("bounce.wav");
            touchedPaddle = false;
            touchedDiamond = false;
        }
        if(positionX - radius <= 0)
        {
            ballDirectionX = -ballDirectionX;
            Greenfoot.playSound("bounce.wav");
            touchedPaddle = false;
            touchedDiamond = false;

        }
        if(positionY + radius >= worldHeight)
        {
            speedX = 0;
            speedY = 0;
            Greenfoot.playSound("game_over.wav");
            Greenfoot.stop();
        }
        if(positionY - radius <= 0)
        {
            ballDirectionY = -ballDirectionY;
            Greenfoot.playSound("bounce.wav");
            touchedPaddle = false;
            touchedDiamond = false;
        }
    }

}
