/*
    Problem Statement: Given an array of N integers,
    write a program to implement the Selection sorting algorithm.

    Example 1:

    Input: N = 6, array[] = {13,46,24,52,20,9}
    Output: 9,13,20,24,46,52
    Explanation: After sorting the array is: 9, 13, 20, 24, 46, 52

    Example 2:
    Input: N=5, array[] = {5,4,3,2,1}
    Output: 1,2,3,4,5
    Explanation: After sorting the array is: 1, 2, 3, 4, 5



    Time complexity: O(N^2), (where N = size of the array), for the best,
    worst, and average cases.
    Reason: If we carefully observe,
    we can notice that the outer loop, say i, is running from 0 to n-2 i.e. n-1 times,
    and for each i, the inner loop j runs from i to n-1. For, i = 0, the inner loop
    runs n-1 times, for i = 1, the inner loop runs n-2 times, and so on.
    So, the total steps will be approximately the following: (n-1) + (n-2) + (n-3) + ……..+ 3 + 2 + 1.
    The summation is approximately the sum of the first n natural numbers i.e. (n*(n+1))/2.
    The precise time complexity will be O(n2/2 + n/2).

    Space Complexity: O(1)

* */



public class Selection_Sort {
    public static void Selection_Sort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int mini=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[mini]){
                    mini=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[mini];
            arr[mini]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr={5,2,9,1,0,5,7,8,1,2,0};

        System.out.println("The sorted array using selection sort:");
        Selection_Sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
