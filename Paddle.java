import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game paddle. It is keyboard controlled (left, right, space). It also 
 * generates a new ball when it is created itself.
 * 
 * @author mik
 * @version 1.0
 */
public class Paddle extends Actor
{
    public Ball myBall;  // used before ball gets released
    public Ball ballFoo;
    private MouseInfo minfo;
    private int xD;
    private int on;
    

    /**
     * When the paddle gets created, create a ball as well.
     */
    public void addedToWorld(World world)
    {
        newBall();
    }
    
    public void act() 
    {
        if( Greenfoot.isKeyDown( "left" ) ){
            move(-10);
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            move( 10 );   
        }
        if( Greenfoot.isKeyDown( "space" ) ){
            on++;   
        }
        if(on>=1){
        if( Greenfoot.isKeyDown( "left" ) ){
            move(-20);
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            move( 20 );   
        } 
        if( Greenfoot.isKeyDown( "space" ) ){
            on=0;   
        }
        }
        if( haveBall() && Greenfoot.isKeyDown( "space" ) || Greenfoot.mouseClicked(null) ){
            releaseBall();   
        }

    }
    
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
        if (myBall != null) {
            myBall.move (dist);
        }
    }
    
    public void newBall()
    {
        
        myBall = new Ball();
        getWorld().addObject (myBall, getX(), getY()-20);
    }
        
    public boolean haveBall()
    {
        return myBall != null;
    }
        
    public void releaseBall()
    {
        myBall.release();
        ballFoo = myBall;
        myBall = null;
        
    }       
}
