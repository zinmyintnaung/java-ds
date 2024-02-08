public class DoublyLinkedList {
    public DoubleNode head;
    public DoubleNode tail;

    public DoublyLinkedList(){
      this.head = null;
      this.tail = null;
    }

    public void addToHead(String data){
        DoubleNode newHead = new DoubleNode(data);
        DoubleNode currentHead = this.head;
        
        if(currentHead != null){
          currentHead.setPreviousNode(newHead);
          newHead.setNextNode(currentHead);
        }
        this.head = newHead;
        
        if(this.tail == null){
          this.tail = newHead;
        }
    }

    public void addToTail(String data){
        DoubleNode newTail = new DoubleNode(data);
        DoubleNode currentTail = this.tail;
    
        if(currentTail != null){
          currentTail.setNextNode(newTail);
          newTail.setPreviousNode(currentTail);
        }
        this.tail = newTail;

        if(this.head == null){
          this.head = newTail;
        }
    }

    public String removeHead(){
        DoubleNode removedHead = this.head;
        if(removedHead == null){
          return null;
        }
        this.head = removedHead.getNextNode();

        if(this.head != null){
          this.head.setPreviousNode(null);
        }
        if(this.tail == removedHead){
            this.removeTail();
        }
        return removedHead.data;
    }

    public String removeTail(){
        DoubleNode removedTail = this.tail;
        if(removedTail == null){
            return null;
        }
        this.tail = removedTail.getPreviousNode();
        
        if(this.tail != null){
            this.tail.setNextNode(null);
        }
        if(this.head == removedTail){
            this.removeHead();
        }
        return removedTail.data;
    }

    public DoubleNode removeByData(String data){
        DoubleNode nodeToRemove = null;
        DoubleNode currentNode = this.head;
        while(currentNode != null){
          if(currentNode.data == data){
            nodeToRemove = currentNode;
            break;
          }
          currentNode = currentNode.getNextNode();
        }
        if(nodeToRemove == null){
          return null;
        }

        if(nodeToRemove == this.head){
            this.removeHead();
        }else if(nodeToRemove == this.tail){
            this.removeTail();
        }else{
            DoubleNode nextNode = nodeToRemove.getNextNode();
            DoubleNode previousNode = nodeToRemove.getPreviousNode();
            nextNode.setPreviousNode(previousNode);
            previousNode.setNextNode(nextNode);
        }

        return nodeToRemove;
    }

    public String printList() {
        DoubleNode currentNode = this.head;
        String output = "<head> ";
        while (currentNode != null) {
          output += currentNode.data + " ";
          currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        
        System.out.println(output);
        return output;
    }

    

    public static void main(String[] args) {
        DoublyLinkedList subway = new DoublyLinkedList();
        subway.addToHead("Times Square");
        subway.addToHead("Grand Central");
        subway.addToHead("Central Park");
        subway.addToTail("Penn Station");
        subway.addToTail("Wall Street");
        subway.addToTail("Brooklyn Bridge");
        subway.removeHead();
        subway.removeTail();
        subway.removeByData("Times Square");
        subway.printList();
    }
}
