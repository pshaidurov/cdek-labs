package lab_7_col;

public class MrArrayList<T> {

    private T[] array;

    private final int INIT_SIZE = 1;

    private final int CUT_RATE = 4;

    private int pointer = 0;

    public MrArrayList() {
        array = (T[]) new Object[INIT_SIZE];
    }

    public void add(T item) {
        if (pointer == array.length - 1) {
            resize(array.length + 1);
        }
        array[pointer++] = item;
    }

    public void add(int index, T item) {
        for (int i = pointer; i > index; i--) {
            array[index] = array[i - 1];
        }
        pointer++;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = (T[]) newArray;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public int size() {
        return pointer;
    }

    public void show() {
        for (T elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++) {
            array[i] = array[i + 1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE) {
            resize(array.length / 2);
        }
    }

}