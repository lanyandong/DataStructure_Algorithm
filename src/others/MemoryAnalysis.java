package others;


// 利用Java的内存回收机制，进行内存使用情况分析
public class MemoryAnalysis {

    public static void main(String args[]){

        Runtime r = Runtime.getRuntime();

        long mem1, mem2;
        Integer ints[] = new Integer[1000];
        System.out.println("the total memory size is " + r.totalMemory());

        mem1 = r.freeMemory();
        System.out.println("the memory size before gc is " + mem1);
        r.gc();
        mem1 = r.freeMemory();
        System.out.println("the memory size after gc is " + mem1);

        // 数组存值
        for(int i = 0; i < 1000; i++)
            ints[i] = new Integer(i);
        mem2 = r.freeMemory();
        System.out.println("the memory size after allocation is " + mem2);
        System.out.println("the memory size used by allocation is " + (mem1 - mem2));

        // 数组置null
        for(int i = 0; i < 1000; i++)
            ints[i] = null;
        r.gc();

        mem2 = r.freeMemory();
        System.out.println("the memory size after gc is " + mem2);

    }
}
