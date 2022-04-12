package github.x1n32.Task3DesignPatterns.Observer;
//import java.beans.PropertyChangeListener;
//import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * Subject of interest. 
 * Subscriber class is an observer
 */
public class Channel {

    private ArrayList<Subscriber> subs = new ArrayList<>();   
    String titlename;


    /**
     * Method to add to the array list
     * @param sub
     */
    public void subscribe(Subscriber sub){
        subs.add(sub);
    }

    /**
     * Method to leave to array list
     * @param sub
     */
    public void unsubscribe(Subscriber sub){
        subs.remove(sub);
    }

    
    /**
     * Method to call/notify all objects of this class when called
     */
    public void notifySubscibers(){
        for (Subscriber sub: subs){
            sub.update();
        }
    }

    /**
     * 'uploading' a video; calls notiffySubscribers
     * @param title
     */
    public void upload(String title ){
        this.titlename = title;
        notifySubscibers();
    }



    
    /* 
    Another way of implementing this is to use PropertyChangeSupport, to notify a PropertyChangeListener when 
    something is changed. Similar to the code above. Where addPropertyChangeListener is equivalent to subscribe.

    private PropertyChangeSupport notify;
    public Channel() {
        notify = new PropertyChangeSupport(this);
    } 
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        notify.addPropertyChangeListener(pcl);
    }
    public void upload(String title ){
        notify.firePropertyChange(titlename, this.titlename, title);
    }
    */


}
