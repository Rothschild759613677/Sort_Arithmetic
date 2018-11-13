package com.limitless.select_arithmetic;

public class SelectArithmetic {

    private static int[] arrays = {19, 3, 5, 29, 15, 28, 11};


    //冒 择 路(插入) 希 快 归 堆
    public static void main(String[] args) {

//        printlnArray("冒泡排序前的打印---------------------");
//        bubblingSort(arrays);
//        printlnArray("冒泡排序后的打印---------------------");

//        printlnArray("选择排序前的打印---------------------");
//        selectSort(arrays);
//        printlnArray("选择排序后的打印---------------------");


//        printlnArray("插入排序前的打印---------------------");
//        insertSort(arrays);
//        printlnArray("插入排序后的打印---------------------");


//        printlnArray("希尔排序前的打印---------------------");
//        shellSort(arrays);
//        printlnArray("希尔排序后的打印---------------------");

//        printlnArray("快速排序前的打印---------------------");
//        quickSort(arrays, 0, arrays.length - 1);
//        printlnArray("快速排序后的打印---------------------");


//        printlnArray("归并排序前的打印---------------------");
//        arrays = mergeSort(arrays, 0, arrays.length - 1);
//        printlnArray("归并排序后的打印---------------------");


//        printlnArray("堆排序前的打印---------------------");
//        heapSort(arrays);
//        printlnArray("堆排序后的打印---------------------");
    }


    /**
     * 冒泡排序  从小到大
     */
    private static void bubblingSort(int[] arr) {
        int temp;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                ++num;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("选择的次数" + num);
    }

    /**
     * 选择排序  从小到大
     */
    private static void selectSort(int[] arr) {
        int temp;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ++num;
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println("选择的次数" + num);
    }


    /**
     * 插入排序  从小到大
     */
    private static void insertSort(int[] arr) {

        int temp;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                ++num;
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("选择的次数" + num);

    }

    /**
     * 希尔排序  从小到大
     */
    private static void shellSort(int[] arr) {

        //增量
        int incrementNum = arr.length / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < arr.length; i++) {
                //进行插入排序
                for (int j = i; j < arr.length - incrementNum; j = j + incrementNum) {
                    if (arr[j] > arr[j + incrementNum]) {
                        int temple = arr[j];
                        arr[j] = arr[j + incrementNum];
                        arr[j + incrementNum] = temple;
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum / 2;
        }

    }

    /**
     * 快速排序  从小到大
     */
    private static void quickSort(int[] a, int low, int high) {

        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key) {
                //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            }

            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }

            //从前往后比较
            while (end > start && a[start] <= key) {
                //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            }

            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。
            // 左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) {
            //左边序列。第一个索引位置到关键值索引-1
            quickSort(a, low, start - 1);
        }
        if (end < high) {
            //右边序列。从关键值索引+1到最后一个
            quickSort(a, end + 1, high);
        }

    }

    /**
     * 归并排序  从小到大
     */
    private static int[] mergeSort(int[] a, int low, int high) {

        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖num数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }


    /**
     * 堆排序  从小到大
     */
    private static void heapSort(int[] arr) {

        // 循环建立初始堆
        for (int i = arr.length / 2; i >= 0; i--) {
            HeapAdjust(arr, i, arr.length - 1);
        }
        // 进行n-1次循环，完成排序
        for (int i = arr.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(arr, 0, i);
        }
    }

    private static void HeapAdjust(int[] arr, int parent, int length) {

        int temp = arr[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[child])
                break;

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[child];

            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        arr[parent] = temp;

    }


    private static void printlnArray(String name) {

        System.out.println(name);
        for (int anArray : arrays) {
            System.out.print(anArray + "\t");
        }
        System.out.println();
    }

}
