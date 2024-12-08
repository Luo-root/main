import java.util.Arrays;

class  MyArrayList <T>{
    int count = 0;
    T[] array = null;
    private int size = 0;
    public void add(T num){
        if(size == array.length){
            array = Arrays.copyOf(array, size * 2);
            size = size*2;
        }
        array[count++] = num;
    }
    public T get(int index){
        return array[index];
    }
    public void remove(int index){
        array[index] = null;
    }
    public void clear(){
        array = null;
    }
    public int getcount(){
        return count;
    }
    public T[] toArray(){
        return array;
    }
}