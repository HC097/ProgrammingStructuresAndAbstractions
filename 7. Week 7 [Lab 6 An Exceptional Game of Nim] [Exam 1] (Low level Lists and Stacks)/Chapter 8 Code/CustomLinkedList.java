public class CustomLinkedList {
    public static void main(String[] args) {
        IntNode headObj;  // Create IntNode reference variables
        IntNode nodeObj1;
        IntNode nodeObj2;
        IntNode nodeObj3;
        IntNode currObj;

        // Front of nodes list
        headObj = new IntNode(-1);

        // Insert more nodes
        nodeObj1 = new IntNode(555);
        headObj.insertAfter(nodeObj1);

        nodeObj2 = new IntNode(999);
        nodeObj1.insertAfter(nodeObj2);

        nodeObj3 = new IntNode(777);
        nodeObj1.insertAfter(nodeObj3);

        // Print linked list
        currObj = headObj;
        while (currObj != null) {
            currObj.printNodeData();
            currObj = currObj.getNext();
        }
    }
}