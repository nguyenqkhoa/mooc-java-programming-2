public class Hideout<T> {
    private T hide;

    public Hideout(){
    }

    public Hideout(T hide){
        this.hide = hide;
    }

    public void putIntoHideout(T toHide){
        hide = toHide;
    }

    public T takeFromHideout(){
        if(hide != null){
            T toReturn = hide;
            hide = null;
            return toReturn;
        }
        else {
            return null;
        }
    }

    public boolean isInHideout(){
        if(hide != null){
            return true;
        }
        else {
            return false;
        }
    }

}
