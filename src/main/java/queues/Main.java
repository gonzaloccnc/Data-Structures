package queues;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Queue queue = new Queue();

    queue.enqueue("Fsl");
    queue.enqueue("Sl");
    queue.enqueue("Tl");
    queue.enqueue("Ftl");

    Arrays.stream(queue.getQueue()).forEach( x -> System.out.printf("%s ", x));
    System.out.println();

    queue.dequeued();

    Arrays.stream(queue.getQueue()).forEach( x -> System.out.printf("%s ", x));
    System.out.println();

    queue.deleteAt(2);

    Arrays.stream(queue.getQueue()).forEach( x -> System.out.printf("%s ", x));
    System.out.println();

    queue.deleteAt(1);

    Arrays.stream(queue.getQueue()).forEach( x -> System.out.printf("%s ", x));
    System.out.println();

    queue.deleteAt(0);

    Arrays.stream(queue.getQueue()).forEach( x -> System.out.printf("%s ", x));
    System.out.println();

    System.out.println(queue.getHead());
    System.out.println(queue.getSize());
  }
}
