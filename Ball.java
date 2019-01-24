import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Ball extends Actor
{
    private int deltaX;        
    private int deltaY;         
    private int count = 2;
    private Brick brick;

    private boolean stuck = true;   

    public void act() 
    {
        if (!stuck) 
        {
            move();
            checkOut();
        }     
    }

    public void move()
    {
        setLocation (getX() + deltaX, getY() + deltaY);
        checkPaddle();
        checkWalls();
        checkBrick();
    }
    
    private void checkWalls()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            deltaX = -deltaX;
        }
        if (getY() == 0) {
            deltaY = -deltaY;
        }
    }
  
    private void checkOut()
    {
        if (getY() == getWorld().getHeight()-1) {
            ((Board) getWorld()).ballIsOut();
            getWorld().removeObject(this);
        }
    }
    
    private void checkPaddle()
    {
        Actor paddle = getOneIntersectingObject(Paddle.class);
        if (paddle != null) {
            deltaY = -deltaY;
            int offset = getX() - paddle.getX();
            deltaX = deltaX + (offset/10);
            if (deltaX > 7) {
                deltaX = 7;
            }
            if (deltaX < -7) {
                deltaX = -7;
            }
        }            
    }
    
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
    }
    public void release()
    {
        deltaX = Greenfoot.getRandomNumber(11) - 7;
        deltaY = -7;
        stuck = false;
    }
    
    public void checkBrick()
    { 
        brick  = (Brick)getOneIntersectingObject(Brick.class);
        if ( brick != null )
        {
            if (getY() > brick.getY() || getY() < brick.getY())
            {
                deltaY = -deltaY;
            }
            else
            {   
                deltaX = -deltaX;
            }
            brick.effect();
        }
}
}
