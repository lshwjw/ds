package com.example.ds.labuladong.dynamic;

public class TestSafe {

    public static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        TestSafe t1 = new TestSafe();
        TestSafe t2 = new TestSafe();
        System.out.println(t1.a);
        System.out.println(t2.a);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t1.a++;
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t2.a++;
            }
        }).start();
        Thread.sleep(10000);
        System.out.println(t1.a);
        System.out.println(t2.a);
        System.out.println(TestSafe.a);
    }

}

