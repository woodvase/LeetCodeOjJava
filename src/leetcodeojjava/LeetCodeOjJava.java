/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeojjava;

/**
 *
 * @author yoli
 */
public class LeetCodeOjJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        System.out.print(findMedianSortedArrays(new int[]{2,3}, new int[]{4,5}));
    }
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    // http://www.lifeincode.net/programming/leetcode-median-of-two-sorted-arrays-java/
    public static double findMedianSortedArrays(int A[], int B[]) {
       int la = A.length;
       int lb = B.length;
       if((la + lb) % 2 > 0)
       {
           int k = (la + lb) / 2 + 1;
           return (double)findMedianSortedArraysHelper(A, 0, la -1, B, 0, lb -1, k);
       }
       else
       {
           int k = (la + lb) / 2;
           return (double)(findMedianSortedArraysHelper(A,0, la -1, B, 0, lb - 1, k) + 
                   findMedianSortedArraysHelper(A, 0, la - 1, B, 0, lb - 1, k + 1)) * 0.5;
       }
    }
    private static int findMedianSortedArraysHelper(int A[], int startA, int endA, int B[], int startB, int endB, int k)
    {
        if(startA > endA) return B[startB + k - 1];
        if(startB > endB) return A[startA + k - 1];
        int midA = startA + (endA - startA) / 2;
	int midB = startB + (endB - startB) / 2;
 
        if(A[midA] <= B[midB])
        {
            if((midA - startA) + (midB - startB) >= k - 1)
            {
                return findMedianSortedArraysHelper(A, startA, endA, B, startB, midB - 1, k);
            }
            else
            {
                return findMedianSortedArraysHelper(A, midA + 1, endA, B, startB, endB, k - (midA - startA) - 1);
            }
        }
        else
        {
            if((midA - startA) + (midB - startB) >= k -1)
            {
                return findMedianSortedArraysHelper(A, startA, midA - 1, B, startB, endB, k);
            }
            else
            {
                return findMedianSortedArraysHelper(A, startA, endA, B, midB + 1, endB, k - (midB - startB) - 1);
            }
        }
    }    
}
