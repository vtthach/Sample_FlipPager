package dmt.hephaestus.linkedlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import dmt.hephaestus.adapter.DynamicFragmentModel;

/**
 * Project:  hephaestus
 * Author:   Khuong Vo
 * Since:    5/19/2016
 * Time:     1:16 PM
 */
public class LinkedListDynamicFragmentModel extends DynamicFragmentModel {

    private LinkedListDynamicFragmentModel next;
    private LinkedListDynamicFragmentModel previous;
    private static int centerPosition;

    public LinkedListDynamicFragmentModel(Class<?> cls, Fragment fragment, Bundle bundle) {
        super(cls, fragment, bundle);
    }

    public LinkedListDynamicFragmentModel getNext() {
        return next;
    }

    public void setNext(LinkedListDynamicFragmentModel next) {
        this.next = next;
    }

    public LinkedListDynamicFragmentModel getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListDynamicFragmentModel previous) {
        this.previous = previous;
    }

    public void setCenterPosition(int centerPosition) {
        this.centerPosition = centerPosition;
    }

    public int getCenterPosition() {
        return centerPosition;
    }
}
