package list;

public class LinkedList {
  private Node head;
  private Node tail;

  public LinkedList() {}

  public void add(Integer value) {

    Node node = new Node(value);

    if(this.head == null) {
      this.head = node;
      this.tail = node;
      return;
    }

    tail.next = node;
    tail = tail.next;
  }

  public void addAtBeginning(Integer value) {
    Node node = new Node(value);

    if(this.head == null) {
      this.head = node;
      this.tail = node;
      return;
    }

    node.next = this.head;
    this.head = node;
  }

  public void addAtEnd(Integer value) {
    Node node = new Node(value);

    if(this.tail == null) {
      this.head = node;
      this.tail = node;
      return;
    }

    tail.next = node;

    tail = tail.next;
  }

  public void addAt(int index, Integer value) {
    // TODO MAKE IT INSERTS AT INDEX
    Node node = new Node(value);

    if (index == 0) {
      addAtBeginning(value);
    }

    Node current = this.head;

    int i = 0;
    boolean isInserted = false;

    while (current != null) {

      if (i == index) {
        node.next = current;

        current.next = node;
        isInserted = true;
        break;
      }

      current = current.next;
      ++i;
    }

    if(!isInserted) System.out.println("Index out of bound");

  }

  public Integer getFirstValue() {
    return this.head.value;
  }

  public Node getFirstNode() {
    return this.head;
  }

  public Integer getLastValue() {
    return this.tail.value;
  }

  public Node getLastNode() {
    return this.tail;
  }

  public Node getNode(int index) {
    return null;
  }

  public Integer getValue(int index) {
    return null;
  }

}
