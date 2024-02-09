public class Queue {

    public LinkedList queue;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;
    
    public Queue() {
      this(DEFAULT_MAX_SIZE);
    }
    
    public Queue(int maxSize){
      this.queue = new LinkedList();
      this.size = 0;
      this.maxSize = maxSize;
    }

    // Define hasSpace() below
    public boolean hasSpace(){
        if(this.size < this.maxSize){
          return true;
        }
        return false;
    }
  
      // Define isEmpty() below
    public boolean isEmpty(){
        if(this.size == 0){
          return true;
        }
        return false;
    }
     
    // Define enqueue() below
    public void enqueue(String data){
        if(this.size < this.maxSize){
            this.queue.addToTail(data);
            this.size++;
            System.out.println("Added " + data + "! Queue size is now " + this.size);
        }else{
            throw new Error("Queue is full!");
        }
       
    }
    
    public String dequeue() {
        if(this.size == 0){
            throw new Error("Queue is empty!");
        }
        String data = this.queue.removeHead();
        this.size--;
        System.out.println("Removed " + data + "! Queue size is now " + this.size);
        return data;
    }
  
    public String peek() {
        if(this.size == 0){
            return null;
        }
        return this.queue.head.data;
    }

    public static void main(String[] args) {
    
      Queue coffeeOrder = new Queue();
      System.out.println("coffeeOrder queue has " + coffeeOrder.size + " orders.");
      coffeeOrder.enqueue("latte");
      coffeeOrder.enqueue("espresso");
      coffeeOrder.enqueue("cappuccino");
    
    }
}