/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 */
public class Bb {
    public static void main(String[] args) {
//        原数组
        int []arr={1,3,5,6};
        //如果不存在,插入后的数组
        int []arr2=new int[arr.length+1];
        //目标值
        int target=22;
        int i = searchInsert2(arr, target);
        System.out.println(i);
    }
    public static int searchInsert(int[] arr, int target) {
        //索引位置
        int index=-1;
        //遍历查询,看原数组是否存在目标值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==target){
                index=i;
            }
        }
        //如果存在输出索引
        if (index>=0) System.out.println(index);
            //如果不存在
        else {
            for (int i = 0; i < arr.length; i++) {
                //判断目标值与数组元素的大小
                //这里的index指的是要插入的索引位置  int []arr={1,3,5,6};   2
                if (arr[i]<target ){
//                    arr2[i]=arr[i];
                    index=i+1;
                }else {
                    index=i;
                    return index;
//                    arr2[i+1]=arr[i];
                }
            }
            //将目标值插入插入合适的索引位置
//            arr2[index]=target;
        }
        /*for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }*/
        return index;
    }

        public static int searchInsert2(int[] arr, int target) {
            //索引位置
            int index=-1;
            //遍历查询,看原数组是否存在目标值
            for (int i = 0; i < arr.length; i++) {
                /*if (arr[i]==target){
                    index=i;
                    return index;
                }else*/ if (arr[i]<target ){
                    index=i+1;
                }else if(arr[i]>=target ){
                    index=i;
                    return index;
                }
            }
            return index;
        }
}
