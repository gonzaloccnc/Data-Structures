package trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.runtime.ObjectMethods;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

  @Test
  @DisplayName("Should return null when the class is instanced using empty constructor")
  void instanceEmpty() {
    BinaryTree binaryTree = new BinaryTree();

    assertNull(binaryTree.getRoot());
  }

  @Test
  @DisplayName("Should return value not null when the class is instanced using constructor with value")
  void instanceWithValue() {
    BinaryTree binaryTree = new BinaryTree(25);

    assertNotNull(binaryTree.getRoot());
  }

  @Test
  @DisplayName("Should insert to left when value is less than root value")
  void insertLeft() {
    BinaryTree binaryTree = new BinaryTree(90);
    binaryTree.insert(25);

    assertEquals(25, binaryTree.getRoot().left.value);
    assertEquals(binaryTree.getRoot(), binaryTree.getRoot().left.parent);

    binaryTree.insert(21);
    binaryTree.insert(50);
    binaryTree.insert(15);
    binaryTree.insert(54);

    TreeNode current = binaryTree.getRoot();
    TreeNode fullLeft = null;

    while (current != null) {
      if(current.left == null) fullLeft = current;
      current = current.left;
    }

    assertNotNull(fullLeft);
    assertEquals(15, fullLeft.value);
  }

  @Test
  @DisplayName("Should insert to right when value is greater than root value")
  void insertRight(){
    BinaryTree binaryTree = new BinaryTree(90);
    binaryTree.insert(100);

    assertEquals(100, binaryTree.getRoot().right.value);
    assertEquals(binaryTree.getRoot(), binaryTree.getRoot().right.parent);

    binaryTree.insert(190);
    binaryTree.insert(20);
    binaryTree.insert(140);
    binaryTree.insert(10);
    binaryTree.insert(195);
    binaryTree.insert(205);

    TreeNode current = binaryTree.getRoot();
    TreeNode fullRight = null;

    while (current != null) {
      if(current.right == null) fullRight = current;
      current = current.right;
    }

    assertNotNull(fullRight);
    assertEquals(205, fullRight.value);

  }

  @Test
  @DisplayName("Should return a string with the order in 'Pre-Order' from the next tree in all methods for Pre-Order")
  void printPreOrder() {
    BinaryTree tree = new BinaryTree(25);
    String expect = "25 20 18 13 19 24 22 21 90 81 94";

    tree.insert(20);
    tree.insert(18);
    tree.insert(90);
    tree.insert(81);
    tree.insert(24);
    tree.insert(22);
    tree.insert(21);
    tree.insert(13);
    tree.insert(94);
    tree.insert(19);

    assertEquals(expect, tree.printPreOrderLoop());
    assertEquals(expect, tree.printPreOrderRecursive());
    assertEquals(expect, tree.printPreOrderWithStack());
  }

}
