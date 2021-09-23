package com.tms.lesson10.prog05NewArrayList.myArrayList;

public interface IListOfMine<S> {

    public void addElement(S element);

    public void removeElement(int index);

    public S getElement(int index);

    public boolean elementExists(S element);

    public void clearAll();

}
