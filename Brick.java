import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Brick  extends Actor
{
    private  GreenfootImage brick1 = new GreenfootImage("Brick1.png");
    private  GreenfootImage brick2 = new GreenfootImage("Brick2.png");
    private  GreenfootImage brick3 = new GreenfootImage("Brick3.png");
    private int thend = 0;
    private int hit = 0;
    private int cnt =0;

    /*public void act()
    {
    
        effect();
        thend();
        checkHit();
        
    
    }*/
    
        
    public Brick(int foo)
    {
        if (foo >= 1)
        {
            setImage(brick1);
            hit = 1;
        } 
    }
    
    public void effect()
    {
        if (hit >= 1)
                {
                    hit--;
                    getWorld().removeObject(this);
                    cnt++;
                }
      }
    public boolean checkHit()
    {
        Actor a = getOneIntersectingObject(null);
        if ( a != null )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
