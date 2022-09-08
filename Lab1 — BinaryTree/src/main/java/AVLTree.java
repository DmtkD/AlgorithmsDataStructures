public class AVLTree {
   private Node root;

   private int height(Node node) {
      if (node == null)
         return 0;
      return node.height;
   }

   private int getBalance(Node node) {
      if (node == null)
         return 0;
      return height(node.left) - height(node.right);
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

   private Node minKeyNode(Node node)
   {
      Node current = node;
      while (current.left != null)
         current = current.left;

      return current;
   }

   private Node delete(Node node, int key) {
      if (key < node.key)
         node.left = delete(node.left, key);
      else if (key > node.key)
         node.right = delete(node.right, key);
      else
      {
         if ((node.left == null) || (node.right == null))
         {
            Node temp = null;
            if (node.left == null)
               temp = node.right;
            else
               temp = node.left;

            if (temp == null)
            {
               temp = node;
               node = null;
            } else
               node = temp;
         } else {
            Node temp = minKeyNode(node.right);
            node.key = temp.key;
            node.right = delete(node.right, temp.key);
         }
      }

      if (node == null)
         return node;

      node.height = Math.max(height(node.left), height(node.right)) + 1;
      int balance = getBalance(node);

      // Left Left Case
      if (balance > 1 && getBalance(node.left) >= 0)
         return rightRotate(node);

      // Left Right Case
      if (balance > 1 && getBalance(node.left) < 0)
      {
         node.left = leftRotate(node.left);
         return rightRotate(node);
      }

      // Right Right Case
      if (balance < -1 && getBalance(node.right) <= 0)
         return leftRotate(node);

      // Right Left Case
      if (balance < -1 && getBalance(node.right) > 0)
      {
         node.right = rightRotate(node.right);
         return leftRotate(node);
      }

      return node;
   }

   public void delete(int key) {
      root = delete(root, key);
   }

   public void print() {
     root.printSubTree();
   }
}
