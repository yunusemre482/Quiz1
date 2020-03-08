import java.util.Iterator;
import java.util.StringJoiner;
@SuppressWarnings("unchecked")
public class q1<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
        Node(Item item) {
            this.item = item;
        }
    }
    private int size;
    private Node first;

    public void add(Item item) {
        Node newNode = new Node(item);
        newNode.next = first;

        first = newNode;
        size++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        q1<Comparable> linkedList = createList();
        StringJoiner UnsortedList = new StringJoiner(" ");
        q1.Node temp=linkedList.first;
        while (temp!=null){
            UnsortedList.add(String.valueOf(temp.item));
            temp=temp.next;
        }
        System.out.println("Unsorted List: "+UnsortedList.toString());
        q1.Node newSourceNode = MergeSort(linkedList.first);
        linkedList.first = newSourceNode;

        StringJoiner sortedList = new StringJoiner(" ");
        while(newSourceNode != null) {
            sortedList.add(String.valueOf(newSourceNode.item));
            newSourceNode = newSourceNode.next;
        }

        System.out.println("Sorted list: " + sortedList.toString());
    }

    private static q1<Comparable> createList() {
        q1<Comparable> linkedList = new q1<>();
        linkedList.add(-21);
        linkedList.add(12);
        linkedList.add(17);
        linkedList.add(5);
        linkedList.add(523);
        linkedList.add(-2);
        linkedList.add(10);
        linkedList.add(22);
        linkedList.add(-97);
        linkedList.add(45);
        return linkedList;
    }

    private static q1.Node MergeSort(q1<Comparable>.Node sourceNode) {
        if (sourceNode == null || sourceNode.next == null) {
            return sourceNode;
        }

        q1<Comparable>.Node lower = sourceNode;
        q1<Comparable>.Node middle = sourceNode;
        q1<Comparable>.Node high = sourceNode;
        q1<Comparable>.Node currentNode = sourceNode;

        boolean secondSet = false;

        while (currentNode != null && currentNode.next != null) {

            if (currentNode.item.compareTo(currentNode.next.item) > 0) {
                if (!secondSet) {
                    middle = currentNode;
                    secondSet = true;
                } else {
                    high = currentNode;
                    lower = merging(lower, middle, high);
                    middle = high;
                }
            }
            currentNode = currentNode.next;
        }

        if (high.next != null && currentNode != null) {
            lower = merging(lower, middle, currentNode);
        }

        return lower;
    }

    private static q1<Comparable>.Node merging(q1<Comparable>.Node lower, q1<Comparable>.Node middle,q1<Comparable>.Node high) {
        q1<Comparable>.Node leftNode = lower;
        q1<Comparable>.Node rightNode = middle.next;
        q1<Comparable>.Node newlower;
        q1<Comparable>.Node afterLastNode = high.next;
        q1<Comparable>.Node temp;

        if (leftNode.item.compareTo(rightNode.item) <= 0) {
            newlower = leftNode;
            temp = leftNode;
            leftNode = leftNode.next;
        } else {
            newlower = rightNode;
            temp = rightNode;
            rightNode = rightNode.next;
        }

        while(leftNode != middle.next && rightNode != high.next) {
            if (leftNode.item.compareTo(rightNode.item) <= 0) {
                temp.next = leftNode;
                temp = leftNode;
                leftNode = leftNode.next;
            } else {
                temp.next = rightNode;
                temp = rightNode;
                rightNode = rightNode.next;
            }
        }

        if (leftNode == middle.next) {
            temp.next = rightNode;
        } else {
            temp.next = leftNode;
            middle.next = afterLastNode;
        }
        return newlower;
    }
}
