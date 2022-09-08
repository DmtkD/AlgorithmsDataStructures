public class AVLTree {
   private Node root;

   private int height(Node n) {
      if (n == null)
         return 0;
      return n.height;
   }

   private int getBalance(Node N) {
      if (N == null)
         return 0;
      return height(N.left) - height(N.right);
   }

   private Node rightRotate(Node y) {
      Node x = y.left;
      Node T2 = x.right;
      x.right = y;
      y.left = T2;

      y.height = Math.max(height(y.left), height(y.right)) + 1;
      x.height = Math.max(height(x.left), height(x.right)) + 1;

      return x;
   }

   private Node leftRotate(Node x) {
      Node y = x.right;
      Node T2 = y.left;
      y.left = x;
      x.right = T2;

      x.height = Math.max(height(x.left), height(x.right)) + 1;
      y.height = Math.max(height(y.left), height(y.right)) + 1;

      return y;
   }

   private Node insert(Node node, int key) {
      if (node == null)
         return new Node(key);

      if (key < node.key)
         node.left = insert(node.left, key);
      else if (key > node.key)
         node.right = insert(node.right, key);
      else
         throw new RuntimeException("Duplicate Key!");

      node.height = 1 + Math.max(height(node.left), height(node.right));
      int balance = getBalance(node); // height(N.left) - height(N.right)


      // Left Left Case
      if (balance > 1 && key < node.left.key)
         return rightRotate(node);

      // Right Right Case
      if (balance < -1 && key > node.right.key)
         return leftRotate(node);

      // Left Right Case
      if (balance > 1 && key > node.left.key) {
         node.left = leftRotate(node.left);
         return rightRotate(node);
      }

      // Right Left Case
      if (balance < -1 && key < node.right.key) {
         node.right = rightRotate(node.right);
         return leftRotate(node);
      }

      return node;
   }

   public void insert(int key) {
      root = insert(root, key);
   }

   public void delete(int value) {
      //TODO delete
   }

   public void print() {
     root.printSubTree();
   }
}
