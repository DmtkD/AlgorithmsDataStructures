public class Node {
   public int key;
   public int height = 1;
   public Node left;
   public Node right;

   public Node(int key) {
      this.key = key;
   }

   public static class Range {
      int leftBorder;
      int rightBorder;

      Range(int leftBorder, int rightBorder) {
         this.leftBorder = leftBorder;
         this.rightBorder = rightBorder;
      }

      public int middle() {
         return (leftBorder + rightBorder) / 2;
      }
   }


   // Author Oleh Dzhumyk
   public void printSubTree() {
      int width = (int) Math.pow(2, height + 1) - 1;

      String[][] outputArray = new String[height + 1][width];

      setUpTreeTo(outputArray, this, 0, new Range(0, width));

      printing(outputArray, this.getCellSize());
   }

   private void setUpTreeTo(String[][] tree, Node node, int level, Range range) {
      if (node != null) {
         Range leftRange = new Range(range.leftBorder, range.middle() - 1);
         Range rightRange = new Range(range.middle() + 1, range.rightBorder);

         setUpTreeTo(tree, node.right, level + 1, rightRange);

         tree[level][range.middle()] = node.key + "";

         setUpTreeTo(tree, node.left, level + 1, leftRange);

      } else {
         tree[level][range.middle()] = "[]";
      }

   }

   private int getCellSize() {
      Node runNode = this;
      while (runNode.right != null) {
         runNode = runNode.right;
      }
      return ("" + runNode.key).length();
   }

   private void printing(String[][] outputArray, int cellSize) {
      char space = ' ';
      boolean trigger = false;
      for (String[] integers : outputArray) {
         for (String integer : integers) {

            if (integer == null) {
               for (int i = 0; i < cellSize; i++) {
                  System.out.print(space);
               }
            } else {

               for (int i = 0; i < cellSize - (integer + "").length(); i++) {
                  System.out.print(space);
               }

               System.out.print(integer);

               if (trigger) {
                  trigger = false;
                  space = '•';
               } else {
                  trigger = true;
                  space = ' ';
               }

            }
         }
         System.out.println();
      }
      for (int i = 0; i < outputArray[0].length; i++) {
         for (int j = 0; j < cellSize; j++) {
            System.out.print("◆");
         }
      }
      System.out.println();
   }
}
