package arrays;

public class Main {
  public static void main(String[] args) {
    IntegerArray array = new IntegerArray(5);

    array.push(1);
    array.push(101);
    array.insertAt(2, 5);
    array.push(42);
    array.replaceAt(2, 24);
    array.replaceAt(3, 21);
    array.push(100); // doesn't insert it's OK
    array.push(4);

    System.out.println(array);

    array.deleteAt(4);

    System.out.println(array + "length: " + array.length);

    array.deleteAt(3);

    System.out.println(array + "length: " + array.length);

    array.deleteAt(2);

    System.out.println(array + "length: " + array.length);

    array.push(100);

    array.clear();

    System.out.println(array + "length: " + array.length);
  }
}
