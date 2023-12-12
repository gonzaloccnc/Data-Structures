package arrays;

import java.util.Arrays;

public class IntegerArray {
  private Integer[] root;
  public Integer capacity = 0;
  public Integer length = 0;

  public IntegerArray(int capacity) {
    this.root = new Integer[capacity];
    this.capacity = capacity;
  }

  public void push(int value) {
    if(isFull()) return;

    root[this.length] = value;
    ++this.length;
  }

  public void replaceAt(int position, int value) {
    if (position >= this.root.length) return;

    this.root[position] = value;

    this.length = position < this.length
        ? this.length
        : position + 1;
  }

  public void insertAt(int position, int value) {
    if (position >= this.root.length) return;

    Integer currentValue = this.root[position];
    Integer aux;
    this.root[position] = value;

    for (int i = position + 1; i < this.root.length; i++) {
      aux = this.root[i];
      this.root[i] = currentValue;
      currentValue = aux;
    }

    this.length = position <= this.length
        ? this.length + 1
        : position +1;
  }

  // TODO WHEN POSITION IS 0 LENGTH IS ALWAYS 0
  public void deleteAt(int position) {
    this.root[position] = null;

    this.length = position < this.length
        ? position
        : this.length;
  }

  public void clear() {
    this.root = new Integer[capacity];
    this.length = 0;
  }

  public Integer getValue(int index) {
    return this.root[index];
  }

  public boolean isFull() {
    return this.root.length == this.length;
  }

  public Integer binarySearch() {
    return 0;
  }

  public Integer linearSearch(int value) {

    for (Integer integer : this.root) {
      if (integer != null && integer == value) return integer;
    }

    return null;
  }

  public void bubbleSort() {
    int i, j, temp;
    boolean swapped;
    for (i = 0; i < this.root.length - 1; i++) {
      swapped = false;
      for (j = 0; j < this.root.length - i - 1; j++) {
        if (this.root[j] > this.root[j + 1]) {

          temp = this.root[j];
          this.root[j] = this.root[j + 1];
          this.root[j + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped)
        break;
    }
  }

  public void quickSort(Integer low, Integer high) {
    var arr = this.root;

    if (low < high) {

      // pi is partitioning index, arr[p]
      // is now at right place
      int pi = partition(arr, low, high);

      // Separately sort elements before
      // partition and after partition
      quickSort(low, pi - 1);
      quickSort(pi + 1, high);
    }
  }

  private int partition(Integer[] arr, Integer low, Integer high)
  {
    // Choosing the pivot
    int pivot = arr[high];

    // Index of smaller element and indicates
    // the right position of pivot found so far
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {

      // If current element is smaller than the pivot
      if (arr[j] < pivot) {

        // Increment index of smaller element
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return (i + 1);
  }

  private void swap(Integer[] arr, Integer i, Integer j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  @Override
  public String toString() {
    return Arrays.toString(root);
  }
}
