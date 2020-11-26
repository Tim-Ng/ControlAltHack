package p4_group_8_repo.Object_Controlers;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import p4_group_8_repo.World;

import java.util.ArrayList;

/***
 * This class is to set Actors that controls movement and interaction
 */
public abstract class Actor extends ImageView{
    /***
     * move the Actor
     * @param dx move in X axis by how much either -ve or +ve
     * @param dy move in Y axis by how much either -ve or +ve
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /***
     * get current world
     * @return current World
     */
    public World getWorld() {
        return (World) getParent();
    }

    /***
     * @return Local width
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
    /***
     * @return Local height
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /***
     * Check if the Actor is interacting with any other with a certain class
     * @param cls What type is the object
     * @param <A> Which object name
     * @return Return all the objects that intersect this object.
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    /***
     * Check if the Actor is interacting with any other with a certain class
     * @param cls What type is the object
     * @param <A> Which object name
     * @return Return an object that intersects this object.
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    /***
     * So that all that extends this class can override this
     * @param now current time
     */
    public abstract void act(long now);

}
