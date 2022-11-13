public class Main {
   public static void main(String[] args) {
      AVLTree tree = new AVLTree();

      /* Constructing tree given in the above figure */
      tree.insert(10);
      tree.insert(20);
      tree.insert(30);
      tree.insert(40);
      tree.insert(50);
      tree.insert(25);

      tree.print();

      tree.delete(40);
      tree.delete(30);

      tree.print();
   }
}