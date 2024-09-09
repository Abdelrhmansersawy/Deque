package deque;

public class ArrayDeque<T> {
    private T List[];
    private int head, tail;
    private int size = 0;
    private final int INT_SIZE = 8;
    private final int factor = 2;
    public ArrayDeque(){
        List = (T[]) new Object[INT_SIZE];
        head = tail = -1;
        size = 0;
    }
    public ArrayDeque(int size){
        List = (T[]) new Object[INT_SIZE];
        head = tail = -1;
        this.size = 0;
    }
    private void resize(int capacity){

    }
    private void extrend(){
        if(size == List.length){
            resize(List.length * factor);
        }
    }

    public void addFirst(T item){
        extrend();
        if(isEmpty()){
            head = tail = 0;
        }else{
            if(head == 0){
                head = size - 1;
            }else{
                head--;
            }
        }
        List[head] = item;
    }
    public void addLast(T item){
        extrend();
        if(tail == size - 1){
            tail = 0;
        }else{
            tail++;
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return  size;
    }
    public void printDeque(){
        if(size == 0) return;
        int iterator = head;
        do{

        }while()
    }
    public T removeFirst(){
        if(size == 0) return null;
        T item = List[head];
        if(head == size - 1){
            head = 0;
        }
        else{
            head++;
        }
        return item;
    }
    public T removeLast(){
        if(size == 0) return null;
        T item = List[tail];
        if(tail == 0){
            tail = size - 1;
        }else{
            tail--;
        }
        return  item;
    }
    public T get(int index){
        if(index >= size) return null;
        index = (tail + index) % size;
        return List[index];
    }
}
