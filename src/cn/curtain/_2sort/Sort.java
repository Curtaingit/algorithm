package cn.curtain._2sort;

/**
 * @author Curtain
 * @date 2018/9/29 16:40
 */
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    //比较
    protected boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }

    //交换
    protected void swap(T[] a, int i, int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
