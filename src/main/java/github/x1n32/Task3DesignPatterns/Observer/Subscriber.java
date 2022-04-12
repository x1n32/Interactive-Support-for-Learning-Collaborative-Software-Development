package github.x1n32.Task3DesignPatterns.Observer;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;

/**
 * Subscriber is a class that 'listens' to updates from a object it wants to listen to (in this case, something from a channel class.)
 * It has a name and a channel variable. The channel it subscibes to will call an update when it releases a new video.
 * 
 */
public class Subscriber {     
    private String name;
    private Channel channel = new Channel();


    public Subscriber(String name) {
        this.name = name;
    }

    //Every time Channel does something, it will invoke update for every object of this class
    public void update(){
        System.out.println("Hi " + name + ", a video has been uploaded: " + channel.titlename);
    }
    public void subscribeChannel(Channel ch){
        channel = ch;
    }


    /* This is another way of implementing an observer, using property change listener: 
    
    implements PropertyChangeListener 
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Hello " + name + ", a video has been uploaded: " + channel.titlename);
        
    }*/

}
