/**
 * 
 */
package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * this is the ArrayQueue class
 * 
 * @author linda
 * @version 2024.03.30
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    /**
     * this is a field
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    // front
    private int size;
    private int enqueueIndex;
    // back

    /**
     * this is the ArrayQueue constructor
     * 
     * @param initialCapacity
     *            is an int
     */
    public ArrayQueue(int initialCapacity) {

        queue = (T[])new Object[initialCapacity + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;

    }


    /**
     * this the constructor
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * this the clear()
     */
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }


    /**
     * this the incrementIndex()
     * 
     * @param index
     *            is an int
     * 
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * this the toString()
     * 
     * @return the toString
     */
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        if (!isEmpty()) {
            int index = dequeueIndex;
            for (int i = 0; i < size - 1; i++) {
                s.append(queue[index]).append(", ");
                index = incrementIndex(index);
            }
            s.append(queue[index]);
        }
        s.append("]");
        return s.toString();
    }


    /**
     * this the equals()
     * 
     * @param obj is the object
     * @return true
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ArrayQueue)) {
            return false;
        }
        @SuppressWarnings("unchecked")
        ArrayQueue<T> other = (ArrayQueue<T>)obj;
        if (other.getSize() != getSize()) {
            return false;
        }
        if (isEmpty()) { 
            return true;
        }
        int index1 = dequeueIndex;
        int index2 = other.dequeueIndex;
        for (int i = 0; i < size; i++) {
            if (!queue[index1].equals(other.queue[index2])) {
                return false;
            }
            index1 = incrementIndex(index1);
            index2 = other.incrementIndex(index2);
        }
        return true;
    }


    /**
     * this the isEmpty()
     * 
     * @return size to be 0
     */
    public boolean isEmpty() {
        return (((enqueueIndex + 1) % queue.length) == dequeueIndex);
    }


    /**
     * this the dequeue()
     * 
     * @return front
     */
    public T dequeue() {
       
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        
        T front = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        //dequeueIndex = (dequeueIndex + 1) % queue.length;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return front;
       
        
    }


    /**
     * this the ensureCapacity()
     */
    private void ensureCapacity() {
        if ((enqueueIndex + 2) % queue.length == dequeueIndex) {
            T[] oldContents = queue;
            int oldSize = oldContents.length - 1;
            int newSize = 2 * oldSize;
            queue = (T[])new Object[newSize + 1];

            int j = dequeueIndex;
            for (int i = 0; i < oldSize; i++) {
                queue[i] = oldContents[j];
                j = (j + 1) % oldSize;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }

    }


    /**
     * this is the enqueue()
     * 
     * @param newEntry
     *            is T
     */
    public void enqueue(T newEntry) {

        ensureCapacity();

        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = newEntry;
        size++;
    }


    /**
     * this the getLengthOfUnderlyingArray()
     * 
     * @return queue length
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }


    /**
     * this the getFront()
     * 
     * @return queue index
     */
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * this is getSize()
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * this the isFull()
     * 
     * @return one less than length
     */
    public boolean isFull() {
        return size == queue.length - 1;
    }


    /**
     * this the toArray()
     * 
     * @return array
     * 
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] array = new Object[size];
        int index = dequeueIndex;
        for (int i = 0; i < size; i++) {
            array[i] = queue[index];
            index = incrementIndex(index);
        }
        return array;
    }

}
