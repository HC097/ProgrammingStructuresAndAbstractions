public class StringBufferTest{
    public static void main(String[] args){
        StringBuffer s =  new StringBuffer("Oklahoma City");

        s.insert(8, "ABC");// insertString, insertInt, insertDouble that and more you would have to do if not for method overloading.
        System.out.println(s);

        s.insert(0, 5);
        System.out.println(s);

        s.insert(1, true);
        System.out.println(s);

        s.insert(5, 41.35d);
        System.out.println(s);

        s.insert(8, 41.35f);
        System.out.println(s);

        char arr[] = {'j','a','v','a'};

        s.insert(2, arr);
        System.out.println(s);
    }
}