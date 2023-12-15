package queues;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

  @Test
  @DisplayName("Should create empty queue and tail should be null")
  void createQueue() {
    Queue queue = new Queue();
    assertEquals(0, queue.getSize());
    assertNull(queue.getTail());
  }

  @Test
  @DisplayName("Should add to end of the current queue and tail should be update")
  void enqueue() {
    Queue queue = new Queue();

    queue.enqueue("first");
    assertEquals("first", queue.getTail().value);
    assertEquals(1, queue.getSize());

    queue.enqueue("second");
    assertEquals("second", queue.getTail().value);
    assertEquals(2, queue.getSize());

    queue.enqueue("third");
    assertEquals("third", queue.getTail().value);
    assertEquals(3, queue.getSize());

    queue.enqueue("fourth");
    assertEquals("fourth", queue.getTail().value);
    assertEquals(4, queue.getSize());

    assertEquals(
        "first second third fourth",
        convertToText(queue.getQueue())
    );

  }

  @Test
  @DisplayName("Should be dequeued the first value of the current queue and the tail should be update")
  void dequeued() {
    Queue queue = new Queue();
    String[] pos = new String[]{ "first", "second", "third", "fourth", "fifth", "sixth" };

    for (String p : pos) {
      queue.enqueue(p);
      assertEquals(p, queue.getTail().value);
    }

    queue.dequeued();
    assertEquals(5, queue.getSize());
    assertEquals("sixth", queue.getTail().value);
    assertEquals(
        "second third fourth fifth sixth",
        convertToText(queue.getQueue())
    );

    queue.dequeued();
    assertEquals(4, queue.getSize());
    assertEquals("sixth", queue.getTail().value);
    assertEquals(
        "third fourth fifth sixth",
        convertToText(queue.getQueue())
    );

    queue.dequeued();
    assertEquals(3, queue.getSize());
    assertEquals("sixth", queue.getTail().value);
    assertEquals(
        "fourth fifth sixth",
        convertToText(queue.getQueue())
    );

    queue.dequeued();
    assertEquals(2, queue.getSize());

    queue.dequeued();
    assertEquals(1, queue.getSize());

    queue.dequeued();
    assertEquals(0, queue.getSize());
    assertNull(queue.getTail());
  }

  @Test
  @DisplayName("Should delete an element of the current queue give an index and tail should be update")
  void deleteAt() {
    Queue queue = new Queue();

    queue.enqueue("first");
    queue.enqueue("second");
    queue.enqueue("third");
    queue.enqueue("fourth");
    queue.enqueue("fifth");
    queue.enqueue("sixth");

    // Shouldn't delete
    queue.deleteAt(1000);
    assertEquals(6, queue.getSize());
    assertEquals("sixth", queue.getTail().value);
    assertEquals(
        "first second third fourth fifth sixth",
        convertToText(queue.getQueue())
    );

    // Delete last in the queue and update the tail
    queue.deleteAt(5);
    assertEquals(5, queue.getSize());
    assertEquals("fifth", queue.getTail().value);
    assertEquals(
        "first second third fourth fifth",
        convertToText(queue.getQueue())
    );

    //Delete first in the queue and update the head and tail
    queue.deleteAt(0);
    assertEquals(4, queue.getSize());
    assertEquals("second", queue.getHead());
    assertEquals("fifth", queue.getTail().value);
    assertEquals(
        "second third fourth fifth",
        convertToText(queue.getQueue())
    );

    queue.dequeued();
    queue.dequeued();
    queue.dequeued();

    // only missing one value and the head and tail should be the same
    assertEquals(1, queue.getSize());
    assertEquals("fifth", queue.getTail().value);
    assertEquals("fifth", queue.getHead());

    // when delete an element use deleteAt() and give a correct index
    queue.deleteAt(0);
    assertEquals(0, queue.getSize());
    assertNull(queue.getHead());
    assertNull(queue.getTail());
  }

  String convertToText(String[] arr) {
    return String.join(" ", arr);
  }

}
