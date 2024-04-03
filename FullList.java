@SuppressWarnings("unchecked")
class FullList<T> {

    private Object[] container;
    private int size;

    public FullList(){
        this.container = (T[]) new Object[0];
        this.size = 0;
    }

    public FullList(int size){
        this.container = (T[]) new Object[size];
        for(int i=0;i<size;i++){this.container[i]=null;}
        this.size = size;
    }

    public FullList(T[] list){
        this.container = list;
        this.size = list.length;
    }

    public int size(){
        return(this.size);
    }

    public T peek(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("precondition violated: valid index in list");
        } else {
            return((T) this.container[index]);
        }
    }

    public T pop(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("precondition violated: valid index in list");
        } else {
            T n = this.peek(index);
            this.container[index] = null;
            return(n);
        }        
    }

    public T swap(int index, T item){
        this.
    }

    public T sort(){
        if(T
    }
}