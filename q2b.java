import java.util.ArrayList;
import java.util.StringJoiner;

public class q2b {

    public class Items{
        private int data;
        private int count;

        public Items(int data, int count) {
            this.data = data;
            this.count = count;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
    //the function is declared to find element which is exist or not in items objects
    public void find_Element(int[] array,int divider){
        ArrayList result=new ArrayList();
        StringJoiner list = new StringJoiner(",");
        Items[] items=new Items[divider-1];
        for (int i = 0; i <items.length ; i++) {
            items[i]=new Items(0,0);
        }
        for (int temp:array
             ) {
            int index=index_found(items,temp);
            if(index>=0){
                items[index].setCount(items[index].getCount()+1);//if the value is detected in the items set counter is increased by one
            }
            else{
                addtoArray(items,temp);
            }
        }
        for (int i = 0; i < items.length; i++) {
            int cnt = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == items[i].getData()) {
                    cnt++;
                }
            }
            if (cnt > (array.length / divider)) {
                list.add(String.valueOf(items[i].getData()));
            }
        }
        System.out.println("The answer is :{"+list.toString()+"}");

    }
    public int index_found(Items[] items,int index){
        for (int i = 0; i < items.length; i++) {
            if (items[i].getData()==index){
                return i;
            }
        }
        return -1;
    }

    public void addtoArray(Items[] items, int data) {
// check is array is full or not
        for (Items temp:items
             ) {
            if (temp.getCount()==0){
                temp.setData(data);
                return;
            }

        }
// if we have reached here means array is full
// reduce the counter of every element
        for (Items temp:items
             ) {
            temp.setCount(temp.getCount()-1);
        }
    }
    public static void main(String[] args) {

        int[] array = { 11,12,12,12,21,36,43,43,12,27,36,36,4,45,12,43,59,81,21,12,27};
        q2b solution=new q2b();
        solution.find_Element(array,9);
    }
}