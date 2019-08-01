package summer.hoilday.thread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ����������ʵ���߳�ͬ�� LinkedBlockingQueue��ʹ��
 * 
 * @author XIEHEJUN
 * 
 */
public class BlockingSynchronizedThread {
    /**
     * ����һ���������������洢������������Ʒ
     */
    private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
    /**
     * ����������Ʒ����
     */
    private static final int size = 10;
    /**
     * ���������̵߳ı�־��Ϊ0ʱ������������Ʒ���̣߳�Ϊ1ʱ������������Ʒ���߳�
     */
    private int flag = 0;

    private class LinkBlockThread implements Runnable {
        @Override
        public void run() {
            int new_flag = flag++;
            System.out.println("�����߳� " + new_flag);
            if (new_flag == 0) {
                for (int i = 0; i < size; i++) {
                    int b = new Random().nextInt(255);
                    System.out.println("������Ʒ��" + b + "��");
                    try {
                        queue.put(b);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("�ֿ��л�����Ʒ��" + queue.size() + "��");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } else {
                for (int i = 0; i < size / 2; i++) {
                    try {
                        int n = queue.take();
                        System.out.println("��������ȥ��" + n + "����Ʒ");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("�ֿ��л�����Ʒ��" + queue.size() + "��");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingSynchronizedThread bst = new BlockingSynchronizedThread();
        LinkBlockThread lbt = bst.new LinkBlockThread();
        Thread thread1 = new Thread(lbt);
        Thread thread2 = new Thread(lbt);
        thread1.start();
        thread2.start();

    }

}