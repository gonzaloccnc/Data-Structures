package queues;

public class Queue {

  private QueueNode head;
  private QueueNode tail;

  private int size = 0;

  public String[] getQueue() {
    String[] queue = new String[size];

    QueueNode current = head;
    int i = 0;

    while (current != null) {
      queue[i] = current.value;
      current = current.next;
      ++i;
    }

    return queue;
  }

  public void enqueue(String value) {
    QueueNode newNode = new QueueNode(value);

    if (head == null) head = newNode;
    else tail.next = newNode;

    tail = newNode;

    ++size;
  }

  public void dequeued() {
    if (head != null) {
      QueueNode nodeToDelete = head;
      head = head.next;
      nodeToDelete.next = null;
      --size;

      if (head == null) {
        tail = null;
        size = 0;
      }
    }

  }

  public void deleteAt(int index) {
    if(head == null || index < 0 || index >= size) return;

    QueueNode current = head;
    QueueNode before = null;

    int i = 0;

    while (current != null) {

      if(index == i) {

        if (index == 0) {

          if (head == tail) {
            tail = null;
          }

          head = head.next;

          --size;
          break;
        }

        before.next = current.next;

        if(index == size - 1) {
          tail = before;
        }

        --size;
        break;
      }

      before = current;
      current = current.next;
      ++i;
    }
  }

  public String getHead() {
    if (head == null) return null;

    return head.value;
  }

  public int getSize() {
    return size;
  }

  public QueueNode getTail() {
    return tail;
  }
}
