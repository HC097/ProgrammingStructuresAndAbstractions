public class PairManager {
    public static void main(String[] args) {
        Pair<Integer> twoInts = new Pair<Integer>(17, 26);
        Pair<Double> twoDbls = new Pair<Double>(35.2, 50.9);
        Pair<Character> twoChars = new Pair<Character>('d', 'q');

        System.out.println(twoInts.chooseItem());
        System.out.println(twoDbls.chooseItem());
        System.out.println(twoChars.chooseItem());
    }
}