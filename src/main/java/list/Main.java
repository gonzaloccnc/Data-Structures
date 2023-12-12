package list;

public class Main {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();

    linkedList.add(24);
    linkedList.add(45);
    linkedList.add(90);
    linkedList.add(78);

//    linkedList.addAtBeginning(1);
//    linkedList.addAtEnd(9999);

    linkedList.addAt(2, 17);

    System.out.printf("First value is %d", linkedList.getFirstValue());
    System.out.printf("%nFist node reference is %s", linkedList.getFirstNode());
    System.out.printf("%nLast value is %d", linkedList.getLastValue());
    System.out.printf("%nLast node reference is %s", linkedList.getLastNode());

    System.out.println(linkedList);
  }
}
