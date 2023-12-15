package trees;

public class Main {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(25);

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

    long start = System.currentTimeMillis();
    System.out.println("Start stack: 0s");

    System.out.println(tree.printPreOrderWithStack());

    float end = (System.currentTimeMillis() - start) / 1000f;
    System.out.printf("End stack %fs\n", end);

    long start2 = System.currentTimeMillis();
    System.out.println("Start recursive: 0s");

    System.out.println(tree.printPreOrderRecursive());

    float end2 = (System.currentTimeMillis() - start2) / 1000f;
    System.out.printf("End recursive %fs\n", end2);

    long start3 = System.currentTimeMillis();
    System.out.println("Start loop: 0s");

    System.out.println(tree.printPreOrderLoop());

    float end3 = (System.currentTimeMillis() - start3) / 1000f;
    System.out.printf("End loop %fs\n", end3);
  }
}
