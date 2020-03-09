import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class q3 {

    public void solution_A(int[] array_A,int[] array_B){
        StringJoiner listA = new StringJoiner(",");
        StringJoiner listB = new StringJoiner(",");
        for (int i = 0; i <array_A.length ; i++) {
            listA.add(String.valueOf(array_A[i]));
        }
        System.out.println("List A={ "+listA.toString()+"}");
        for (int i = 0; i <array_B.length ; i++) {
            listB.add(String.valueOf(array_B[i]));
        }
        System.out.println("List B={ "+listB.toString()+"}");
        int [] newArray=new int[array_A.length+array_B.length];
        int cnt=0;
        for (int i = 0; i <array_A.length; i++) {
            newArray[cnt++]=array_A[i];
        }
        for (int i = 0; i <array_B.length ; i++) {
            newArray[cnt++]=array_B[i];
        }
        Arrays.sort(newArray);
        ArrayList union=new ArrayList();
        int temp=newArray[0];
        union.add(newArray[0]);
        for (int i = 0; i <newArray.length ; i++) {
            if(temp!=newArray[i]){
                union.add(newArray[i]);
                temp=newArray[i];
            }
        }
        StringJoiner list = new StringJoiner(",");
        for (int i = 0; i <union.size(); i++) {
            list.add(String.valueOf(union.get(i)));
        }

        System.out.println("Solution A -- Unsorted way : {"+list.toString()+"}");

    }
    private static void solution_B(int[] firstArr, int[] secondArr) {
        int i = 0;
        int j = 0;
        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        StringJoiner union = new StringJoiner(",");
        while (i < firstArr.length && j < secondArr.length) {
            if (firstArr[i] < secondArr[j]) {
                union.add(String.valueOf(firstArr[i]));
                i++;
            } else if (secondArr[j] < firstArr[i]) {
                union.add(String.valueOf(secondArr[j]));
                j++;
            } else {
                union.add(String.valueOf(firstArr[i]));
                i++;
                j++;
            }
        }
        while (i < firstArr.length) {
            union.add(String.valueOf(firstArr[i]));
            i++;
        }
        while (j < secondArr.length) {
            union.add(String.valueOf(secondArr[j]));
            j++;
        }

        System.out.println("Solution B -- Sorted way :{"+union.toString()+"}");
    }
    public static void main(String[] args) {
        int[] array_A={7,1,2,25,4,5,6,7,8,9,17,21,22};
        int[] array_B={8,9,3,12,11,13,2,4,10};
        q3 solution=new q3();
        solution.solution_A(array_A,array_B);
        solution.solution_B(array_A,array_B);

    }

}



