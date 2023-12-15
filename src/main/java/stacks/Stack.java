package stacks;

import java.util.Arrays;

public class Stack {

  private final Integer[] arr;
  private int top;
  private int first;

  private int size = 0;
  private final int capacity;

  public Stack(int capacity) {
    this.arr = new Integer[capacity];
    this.capacity = capacity;
    this.top = -1;
    this.first = -1;
  }

  public int push(int value) {
    if(size == capacity) return -1;
    if(size == 0) first = value;

    arr[size] = value;
    top = value;
    ++size;

    return value;
  }

  public int pop() {

    if (isEmpty()) return -1;

    int value = arr[size - 1];

    arr[size - 1] = null;
    --size;

    if (size == 0) {
      top = -1;
      first = -1;
    } else {
      top = arr[size - 1];
    }

    return value;
  }

  public int peek() {
    return top;
  }

  public int getFirst() {
    return first;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public String getStack() {
    return String.join(
        " ",
        Arrays.stream(arr).map(x -> {
          if(x == null) return "";
          return x.toString();
        }).toList()
    ).trim();
  }


  public int getCapacity() {
    return this.capacity;
  }

  public int getSize() {
    return size;
  }
}
