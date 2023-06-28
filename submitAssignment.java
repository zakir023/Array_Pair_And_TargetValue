import java.util.*;
public class submitAssignment {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 2, -4, -6, -2, 8 };  //given the array
        int targetValue = 4;   // this is the target value

        Arrays.sort(arr);        //now sort the Array

        ArrayList<Integer> ans = findPairArray(arr, targetValue, arr.length);
        System.out.println("Required combination of  target digit:");
        System.out.println(ans);   //print the pair Array element
    }

    public static int search(int[] arr, int start, int end, int x, int targetValue) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (x == arr[mid])
                return arr[mid];
            else if (arr[mid] > x)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return arr[arr.length - 1];
    }

    public static ArrayList<Integer> findPairArray(int[] arr, int targetValue, int n) {
        ArrayList<Integer> list = new ArrayList<>();  //create the ArrayList
        for (int i = 0; i < n; i++) {
            int x = targetValue - arr[i];
            // System.out.print(x+" ");
            if (x == search(arr, i + 1, n - 1, x, targetValue)) {
                list.add(arr[i]);
                list.add(x);
            }
        }
        return list;
    }
}