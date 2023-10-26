/*
     Problem Statement: Given an array of N integers,
     write a program to implement the Bubble Sorting algorithm.


    Example 1:

    Input: N = 6, array[] = {13,46,24,52,20,9}
    Output: 9,13,20,24,46,52
    Explanation: After sorting we get 9,13,20,24,46,52

    Input: N = 5, array[] = {5,4,3,2,1}
    Output: 1,2,3,4,5
    Explanation: After sorting we get 1,2,3,4,5


    Time complexity: O(N2), (where N = size of the array), for the worst, and average cases.
    Space Complexity: O(1)

* */




public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr={5,3,8,1,0,2,5,6,7,8,1,1,0};
        System.out.println("The sorted array using bubble sort is:");
        Bubble_Sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

   public static void Bubble_Sort(int[] arr) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (arr[j] > arr[j + 1]) { 
                    int temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                } 
    } 
}
