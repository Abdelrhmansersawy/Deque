package deque;

public class LinkedListDeque<T> {

    private Node headSentinel, tailSentinel;
    private int size;
    public LinkedListDeque(){
        headSentinel = new Node();
        tailSentinel = new Node();

        headSentinel.setPrev(tailSentinel);
        headSentinel.setNext(tailSentinel);
        
        tailSentinel.setPrev(headSentinel);
        tailSentinel.setNext(headSentinel);

        size = 0;
    }
    public void addFirst(T item){
        headSentinel.setNext(new Node(item , headSentinel , headSentinel.next));
    }
    public void addLast(T item){
        tailSentinel.setPrev(new Node(item, tailSentinel.prev , tailSentinel));
    }
    public T removeFirst(){
        if(size == 0) return null;
        Node removedNode = headSentinel.getNext();
        headSentinel.setNext(removedNode.getNext());
        removedNode.next.setPrev(headSentinel);
        --size;
        return removedNode.data;
    }
    public T removeLast(){
        if(size == 0) return null;
        Node removedNode = tailSentinel.getPrev();
        tailSentinel.setPrev(removedNode.getPrev());
        removedNode.getPrev().setNext(tailSentinel);
        --size;
        return  removedNode.data;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node iterator = headSentinel;
        System.out.print('{');
        while (iterator.next != tailSentinel){
            System.out.print(iterator.getNext().getData() + " ");
            iterator = iterator.getNext();
        }
        System.out.println('}'); // newline
    }

    public T get(int index){
        if(index >= size) return null; // try to access out-of-boundaries
        Node iterator = headSentinel;
        while (index > 0){
            iterator = iterator.getNext();
            index--;
        }
        return iterator.getNext().getData();
    }
    private class Node{
        private T data;
        private Node next, prev;
        Node(){}
        Node(T item){
            data = item;
            next = prev = null;
        }
        Node(T item , Node prev , Node next){
            this.data = item;
            this.prev = prev;
            this.next = next;
        }
        T getData(){
            return data;
        }
        void setData(T data){
            this.data = data;
        }
        Node getNext(){
            return next;
        }
        void setNext(Node next){
            this.next = next;
        }
        Node getPrev(){
            return  prev;
        }
        void setPrev(Node prev){
            this.prev = prev;
        }

    }
}
