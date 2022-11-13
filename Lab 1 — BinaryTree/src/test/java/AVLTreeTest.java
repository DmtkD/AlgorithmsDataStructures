import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;


class AVLTreeTest {

   @Test
   void insert() throws NoSuchFieldException, IllegalAccessException {
      AVLTree tree = new AVLTree();
      tree.insert(40);
      tree.insert(50);
      tree.insert(20);

      Field privateField = AVLTree.class.getDeclaredField("root");
      privateField.setAccessible(true);
      Node root = (Node) privateField.get(tree);
      Assertions.assertEquals(root.key, 40);
      Assertions.assertEquals(root.left.key, 20);
      Assertions.assertEquals(root.right.key, 50);
   }

   @Test
   void delete() throws NoSuchFieldException, IllegalAccessException {
      AVLTree tree = new AVLTree();
      tree.insert(40);
      tree.insert(50);
      tree.insert(20);
      tree.insert(70);

      tree.delete(40);

      Field privateField = AVLTree.class.getDeclaredField("root");
      privateField.setAccessible(true);
      Node root = (Node) privateField.get(tree);
      Assertions.assertEquals(root.key, 50);
      Assertions.assertEquals(root.left.key, 20);
      Assertions.assertEquals(root.right.key, 70);
   }
}