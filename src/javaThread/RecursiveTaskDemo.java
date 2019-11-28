package javaThread;

import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo extends RecursiveTask<Integer>{

	private static final long serialVersionUID = 5056163483331741058L;

	/**
     *  ÿ��"С����"���ֻ��ӡ70����
     */
    private static final int MAX = 70;
    private int arr[];
    private int start;
    private int end;


    public RecursiveTaskDemo(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // ��end-start��ֵС��MAXʱ�򣬿�ʼ��ӡ
        if((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }else {
            System.err.println("=====����ֽ�======");
            // ��������ֽ������С����
            int middle = (start + end) / 2;
            RecursiveTaskDemo left = new RecursiveTaskDemo(arr, start, middle);
            RecursiveTaskDemo right = new RecursiveTaskDemo(arr, middle, end);
            // ����ִ������С����
            left.fork();
            right.fork();
            // ������С�����ۼӵĽ���ϲ�����
            return left.join() + right.join();
        }
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	int arr[] = new int[1000];
        Random random = new Random();
        int total = 0;
        // ��ʼ��100������Ԫ��
        for (int i = 0; i < arr.length; i++) {
            int temp = random.nextInt(100);
            // ������Ԫ�ظ�ֵ,��������Ԫ�ص�ֵ��ӵ�total�ܺ���
            total += (arr[i] = temp);
        }
        System.out.println("��ʼ��ʱ���ܺ�=" + total);

        // ��������Runtime.getRuntime().availableProcessors()����ֵ��Ϊ�����Ĳ����̵߳�ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // �ύ�ɷֽ��PrintTask����
//        Future<Integer> future = forkJoinPool.submit(new RecursiveTaskDemo(arr, 0, arr.length));
//        System.out.println("����������ܺ�="+future.get());


        Integer integer = forkJoinPool.invoke( new RecursiveTaskDemo(arr, 0, arr.length)  );
        System.out.println("����������ܺ�=" + integer);

        // �ر��̳߳�
        forkJoinPool.shutdown();
        
	}

	
	

}
