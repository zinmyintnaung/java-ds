public class LinkedList {
    public Node head;

	public LinkedList() {
		this.head = null;
	}

    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(String data){
        Node tail = this.head;

        if(tail == null){
          this.head = new Node(data);
        }else{
          while(tail.getNextNode() != null){
            tail = tail.getNextNode();
          }
          tail.setNextNode(new Node(data));
        }
    }

    public String removeHead(){
        Node removedHead = this.head;
        if(removedHead == null){
          return null;
        }
        this.head = removedHead.getNextNode();
        return removedHead.data;
    }

    public String printList(){
        String output = "<head> ";
        Node currentNode = this.head;

        while(currentNode != null){
          output += currentNode.data + " ";
          currentNode = currentNode.getNextNode();
        }
        output += "<tail>";

        System.out.println(output);
        return output;
    }

    public static LinkedList createList(int size) {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= size; i++) {
          list.addToTail(Integer.toString(i));
        }
        return list;
    }

    public static void main(String []args) {

        // TO TEST BASIC OPERATION
        // LinkedList seasons = new LinkedList();
        // seasons.addToHead("summer");
        // seasons.addToHead("spring");
        // seasons.addToTail("fall");
        // seasons.addToTail("winter");
        // seasons.printList();
        // seasons.removeHead();
        // seasons.printList();

        // TO TEST SWAP FUNCTION
        // LinkedList testList = new LinkedList();
        // for (int i = 0; i <= 10; i++) {
        //     testList.addToTail(Integer.toString(i));
        // }

        // testList.printList();
        // swapNodes(testList, "11", "7");
        // testList.printList();

        LinkedList myCreatedList = LinkedList.createList(10);
        Node searchNode = LinkedList.nthLastNode(myCreatedList, 1);
        System.out.println(searchNode.data);
        
        Node searchMiddle = LinkedList.findMiddle(myCreatedList);
        System.out.println(searchMiddle.data);

        Node searchMiddleAlt = LinkedList.findMiddleAlt(myCreatedList);
        System.out.println(searchMiddleAlt.data);
    }

    public static void swapNodes(LinkedList list, String data1, String data2) {
        System.out.println("Swapping " + data1 + " with " + data2);
      
        Node node1Prev = null;
        Node node2Prev = null;
        Node node1 = list.head;
        Node node2 = list.head;
    
        if (data1 == data2) {
          System.out.println("Elements are the same - no swap to be made");
          return;
        }
      
        while (node1 != null) {
        
          if (node1.data.equals(data1)) { //node1.data == data1 this won't work because String is object in Java
            break;
          }
          node1Prev = node1;
          node1 = node1.getNextNode();
        }
      
        while (node2 != null) {
          if (node2.data.equals(data2)) {
            break;
          }
          node2Prev = node2;
          node2 = node2.getNextNode();
        }
      
        if (node1 == null || node2 == null) {
          System.out.println("Swap not possible - one or more element is not in the list " + "Value 1: " + node1 + ", Value 2: " + node2);
          return;
        }
    
        if (node1Prev == null) {
          list.head = node2;
        } else {
          node1Prev.setNextNode(node2);
        }
    
        if (node2Prev == null) { 
          list.head = node1;
        } else {
          node2Prev.setNextNode(node1);
        }
      
        Node temp = node1.getNextNode();
        node1.setNextNode(node2.getNextNode());
        node2.setNextNode(temp); 
    }

    public static Node nthLastNode(LinkedList list, int n) {
        Node current = null;
        Node tailSeeker = list.head;
        int count = 0;
        while (tailSeeker != null) {
          tailSeeker = tailSeeker.getNextNode();
          if (count >= n) {
            if (current == null) {
              current = list.head;
            }
            current = current.getNextNode();
          }
          count++;
        }
        return current;
    }

    public static Node findMiddle(LinkedList linkedList) {
        Node fast = linkedList.head;
        Node slow = linkedList.head;
      
        while (fast != null) {
          fast = fast.getNextNode();
          if (fast != null) {
            fast = fast.getNextNode();
            slow = slow.getNextNode();
          }
        }
        return slow;
    }

    public static Node findMiddleAlt(LinkedList linkedList) {
        int count = 0;
        Node fast = linkedList.head;
        Node slow = linkedList.head;
      
        while(fast != null) {
          fast = fast.getNextNode();
          if (count % 2 != 0) {
            if(fast != null){ //Remove this check to return right-weighted middle, i,e, to return 6 for 1 to 10 list
                slow = slow.getNextNode();
            }
          }
          count++;
        }
        return slow;
    }
}
