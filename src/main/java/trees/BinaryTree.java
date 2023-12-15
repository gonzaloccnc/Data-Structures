package trees;

import java.util.Stack;

public class BinaryTree {
  private TreeNode root;

  public BinaryTree() {
    this.root = null;
  }

  public BinaryTree(int root) {
    this.root = new TreeNode(root);
  }

  public void insert(int value) {
    root = insertNode(root, value);
  }

  private TreeNode insertNode(TreeNode treeNode, int value) {
    if (treeNode == null) {
      treeNode = new TreeNode(value);
      return treeNode;
    }

    if (value < treeNode.value) {
      treeNode.left = insertNode(treeNode.left, value);
      treeNode.left.parent = treeNode;
    } else if (value > treeNode.value) {
      treeNode.right = insertNode(treeNode.right, value);
      treeNode.right.parent = treeNode;
    }

    return treeNode;
  }

  public String printPreOrderWithStack() {
    // root, left, right
    StringBuilder builder = new StringBuilder();
    if(root == null) return builder.toString();

    Stack<TreeNode> stack = new Stack<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode current = stack.pop();

      builder.append(current.value).append(" ");

      if (current.right != null) {
        stack.push(current.right);
      }

      if (current.left != null) {
        stack.push(current.left);
      }
    }

    return builder.toString().trim();
  }

  public String printPreOrderLoop() {
    // root, left, right

    StringBuilder builder = new StringBuilder();

    TreeNode current = root;
    while (current != null) {

      if (current.left == null) {
        builder.append(current.value).append(" ");
        current = current.right;
      }
      else {
        TreeNode predecesor = current.left;
        while (predecesor.right != null && predecesor.right != current) {
          predecesor = predecesor.right;
        }

        if (predecesor.right == null) {
          predecesor.right = current;
          builder.append(current.value).append(" ");
          current = current.left;
        }
        else {
          predecesor.right = null;
          current = current.right;
        }

      }

    }

    return builder.toString().trim();
  }

  public String printPreOrderRecursive() {
    return printPreOrderRecursive(this.root).trim();
  }

  private String printPreOrderRecursive(TreeNode root) {
    // root, left, right
    StringBuilder builder = new StringBuilder();

    if(root == null) return builder.toString();

    return builder
        .append(root.value)
        .append(" ")
        .append(printPreOrderRecursive(root.left))
        .append(printPreOrderRecursive(root.right))
        .toString();
  }

  public void printInOrder() {
    // left, root, right
  }

  public void printPostOrder() {
    // left, right, root
  }

  public TreeNode getRoot() {
    return this.root;
  }
}
