public class ItemManager {
   public static void main(String[] args) {
      Item<Integer> itemInt = new Item<Integer>(19);
      Item<Character> itemChar = new Item<Character>('m');

      itemInt.updateCount(19);
      itemInt.updateCount(39);

      itemChar.updateCount('c');
      itemChar.updateCount('u');
   }
}