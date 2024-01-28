public class IntNode2 {
    private int value;
    private IntNode nextIntNodePtr;

    IntNode2() {
        this.value = 0;
        this.nextIntNodePtr = null;
    }

    IntNode2(int val) {
        this.value = val;
        this.nextIntNodePtr = null;
    }

    IntNode2(int val, IntNode nextLoc) {
        this.value = val;
        this.nextIntNodePtr = nextLoc;
    }

    void InsertAfter(IntNode nodeLoc) {
        IntNode tmpNext = null;

        tmpNext = this.nextIntNodePtr;
        this.nextIntNodePtr = nodeLoc;
        nodeLoc.nextIntNodePtr = tmpNext;
    }

    int GetValue() {
        return this.value;
    }

    IntNode GetNext() {
        return this.nextIntNodePtr;
    }

    void PrintData() {
        System.out.println(this.value);
    }
}