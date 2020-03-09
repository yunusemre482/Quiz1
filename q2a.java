import java.util.StringJoiner;
public class q2a {
    public static void main(String[] args) {

        int[] array={1,1,1,2,3,5,5,3,2,76,45,23,12,12,3,2,4,23};
        mergeSort(array,array.length);
        int divider=10;
        int cnt=0,temp=array[0];
        StringJoiner list = new StringJoiner(",");
        for (int i = 0; i <array.length; i++) {
            if(temp==array[i]){
                cnt ++;
            }
            else{
                if(cnt>(array.length/divider)){
                    list.add(String.valueOf(temp));
                }
                cnt=1;
                temp=array[i];
            }

        }
        System.out.println(array.length/divider);
        System.out.println("{"+list.toString()+"}");
    }
    public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){

        int i=0,l=0,r = 0;
        //The while loops check the conditions for merging
        while(l<left_size && r<right_size){

            if(left_arr[l]<right_arr[r]){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
            arr[i++] = right_arr[r++];
        }
    }

    public static void mergeSort(int [] arr, int len){
        if (len < 2){return;}

        int mid = len / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[len-mid];

        //Dividing array into two and copying into two separate arrays
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k = k+1;
            }
        }
        // Recursively calling the function to divide the subarrays further
        mergeSort(left_arr,mid);
        mergeSort(right_arr,len-mid);
        // Calling the merge method on each subdivision
        merge(left_arr,right_arr,arr,mid,len-mid);
    }

}
