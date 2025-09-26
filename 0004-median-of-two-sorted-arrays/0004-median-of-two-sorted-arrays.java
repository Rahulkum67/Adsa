class Solution {
    public static int[] margearray(int[] x,int[] y){
        int i=0,j=0,k=0;
        int arr[]=new int[x.length+y.length];
        while(i<x.length && j< y.length){
            if(x[i]<y[j]){
                arr[k++]=x[i++];
            }
            else{
                arr[k++]=y[j++];
            }
        }
        while(i<x.length){
            arr[k++]=x[i++];
        }
        while(j<y.length){
            arr[k++]=y[j++];
        }
        return arr;
    }
    public static double margearraymedian(int[] x,int[] y){
        int[] arr=margearray(x,y);
        int n=arr.length;
        if (n % 2 == 0) {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0; 
        } else {
            return arr[n / 2]; 
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double a=margearraymedian(nums1,nums2);
        return a;
        
    }

}