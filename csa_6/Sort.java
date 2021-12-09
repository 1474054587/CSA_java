package csa_6;

import java.util.Arrays;

public class Sort {
    public int[] useMethod(int n, int[] arr) {
        long start,end;
        switch (n) {
            case 0:
                start = System.nanoTime();
                arr = bubbleSort(arr);
                end = System.nanoTime();
                System.out.println("BubbleSort 用时："+(end-start));
                return arr;
            case 1:
                start = System.nanoTime();
                arr = insertSort(arr);
                end = System.nanoTime();
                System.out.println("InsertSort 用时："+(end-start));
                return arr;
            case 2:
                start = System.nanoTime();
                arr = quickSort(arr);
                end = System.nanoTime();
                System.out.println("QuickSort 用时："+(end-start));
                return arr;
            case 3:
                start = System.nanoTime();
                arr = mergeSort(arr);
                end = System.nanoTime();
                System.out.println("MergeSort 用时："+(end-start));
                return arr;
            case 4:
                start = System.nanoTime();
                arr = heapSort(arr);
                end = System.nanoTime();
                System.out.println("HeapSort 用时："+(end-start));
                return arr;
            default:
                return null;
        }
    }

    public int[] bubbleSort(int[] arr) {
        if (arr.length<=1){
            return arr;
        }
        int temp;
        for(int i = 0; i< arr.length-1; i++){
            for(int j = 0; j< arr.length-i-1; j++){
                if(arr[j+1]< arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] insertSort(int[] arr) {
        if (arr.length<=1){
            return arr;
        }
        int temp;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            temp = arr[i];
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public int[] quickSort(int[] arr) {
        if (arr.length<=1){
            return arr;
        }
        qs(arr, 0, arr.length - 1);
        return arr;
    }
    private void qs(int[] arr, int left, int right) {
        if(left > right) {
            return;
        }
        int middle = arr[left];
        int i = left, j = right;
        while(i != j) {
            while(arr[j] >= middle && i < j) {
                j--;
            }
            while(arr[i] <= middle && i < j) {
                i++;
            }
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = middle;
        qs(arr, left, i - 1);
        qs(arr, i + 1, right);
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length<=1){
            return arr;
        }
        int middle = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        merge(arr, mergeSort(left), mergeSort(right));
        return arr;
    }
    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        for (int index = 0; index < arr.length; index++) {
            if (i>=left.length){
                arr[index]=right[j++];
            }else if(j>=right.length){
                arr[index]=left[i++];
            }else if (left[i]<right[j]){
                arr[index]=left[i++];
            }else {
                arr[index]=right[j++];
            }
        }
    }

    public int[] heapSort(int []arr){
        for(int i=arr.length/2-1;i>=0;i--){
            adjust(arr,i,arr.length);
        }
        for(int i = arr.length-1; i >0; i--){
            int temp=arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr,0,i);
        }
        return arr;
    }
    private void adjust(int []arr, int first, int last){
        int temp = arr[first];
        for(int i = first *2+1; i < last; i = i *2+1){
            if(i +1< last && arr[i]<arr[i +1]){
                i++;
            }
            if(arr[i] >temp){
                arr[first] = arr[i];
                first = i;
            }else{
                break;
            }
        }
        arr[first] = temp;
    }
}