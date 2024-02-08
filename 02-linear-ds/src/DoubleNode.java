public class DoubleNode {

    public String data;
    private DoubleNode next;
    private DoubleNode previous;
  
    public DoubleNode(String data) {
      this.data = data;
      this.next = null;
    }
    
    public void setNextNode(DoubleNode node) {
      this.next = node;
    }
  
    public void setPreviousNode(DoubleNode node) {
      this.previous = node;
    }
  
    public DoubleNode getNextNode() {
      return this.next;
    }
  
    public DoubleNode getPreviousNode() {
      return this.previous;
    }
  
}