/*
    the order of growth of the overall running time of this algorithm :
    T(n)=3T(n/3)+ O(n) = O(nlogn) with base 3
 */

import java.util.*;
public class q4
{
    // Function for 3-way merge sort process
    public static void Third_way_merge_sort(Integer[] dividedArr)
    {
        // if array is empty returns null
        if (dividedArr == null)
            return;

        // creating duplicate of given array
        Integer[] firstArr = new Integer[dividedArr.length];

        // copied items of given array into other array
        for (int i = 0; i < firstArr.length; i++)
            firstArr[i] = dividedArr[i];

        Third_way_merge_sortRec(firstArr, 0, dividedArr.length, dividedArr);

        // copy back elements of duplicate array to another array
        for (int i = 0; i < firstArr.length; i++)
            dividedArr[i] = firstArr[i];
    }

    /* the lower is minumum index and upper is the maximum index in the array */
    public static void Third_way_merge_sortRec(Integer[] dividedArr,
                                        int lower, int high, Integer[] destArray)
    {
        // if array has just one items do nothing
        if (high - lower < 2)
            return;

        // divided array into third parts
        int middile1 = lower + ((high - lower) / 3);
        int middile2 = lower + 2 * ((high - lower) / 3) + 1;

        // all of arrays sorted recursively
        Third_way_merge_sortRec(destArray, lower, middile1, dividedArr);
        Third_way_merge_sortRec(destArray, middile1, middile2, dividedArr);
        Third_way_merge_sortRec(destArray, middile2, high, dividedArr);

        // merging arrays
        merge(destArray, lower, middile1, middile2, high, dividedArr);
    }

    public static void merge(Integer[] dividedArr, int lower,
                             int middile1, int middile2, int high,
                             Integer[] destArray)
    {
        int i = lower, j = middile1, k = middile2, l = lower;

        // choose smaller of the smallest in third part of array
        while ((i < middile1) && (j < middile2) && (k < high))
        {
            if (dividedArr[i].compareTo(dividedArr[j]) < 0)
            {
                if (dividedArr[i].compareTo(dividedArr[k]) < 0)
                    destArray[l++] = dividedArr[i++];

                else
                    destArray[l++] = dividedArr[k++];
            }
            else
            {
                if (dividedArr[j].compareTo(dividedArr[k]) < 0)
                    destArray[l++] = dividedArr[j++];
                else
                    destArray[l++] = dividedArr[k++];
            }
        }

        // case where first and second ranges have remaning value
        while ((i < middile1) && (j < middile2))
        {
            if (dividedArr[i].compareTo(dividedArr[j]) < 0)
                destArray[l++] = dividedArr[i++];
            else
                destArray[l++] = dividedArr[j++];
        }

        // case where second and third ranges have remaining value
        while ((j < middile2) && (k < high))
        {
            if (dividedArr[j].compareTo(dividedArr[k]) < 0)
                destArray[l++] = dividedArr[j++];

            else
                destArray[l++] = dividedArr[k++];
        }

        while ((i < middile1) && (k < high))
        {
            if (dividedArr[i].compareTo(dividedArr[k]) < 0)
                destArray[l++] = dividedArr[i++];
            else
                destArray[l++] = dividedArr[k++];
        }

        // copied remaining values from the first part
        while (i < middile1)
            destArray[l++] = dividedArr[i++];

        // copied remaining values from the second part
        while (j < middile2)
            destArray[l++] = dividedArr[j++];

        // copied remaining values from the third part
        while (k < high)
            destArray[l++] = dividedArr[k++];
    }
    public static void main(String args[])
    {
        StringJoiner unsortedList = new StringJoiner(",");
        Integer[] list_of_int = new Integer[]  {1,12,-23,45,44,23,12,29,62,17,36,99,31,12,11};
        for (int temp:list_of_int
             ) {
            unsortedList.add(String.valueOf(temp));

    }
        Third_way_merge_sort(list_of_int);

        StringJoiner list = new StringJoiner(",");
        for (int i :list_of_int
             ) {
            list.add(String.valueOf(i));
        }
        System.out.println("3-Way Merge Unsorted Array: {"+unsortedList.toString()+"}");
        System.out.println("3-Way Merge Sorted Array: {"+list.toString()+"}");

    }
}