package Ex8;

import java.util.Scanner;

public class run {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số cần thay đổi giá trị:");
        int sharedVariable=sc.nextInt();
        SharedObject sharedObject=new SharedObject(sharedVariable);
        Increase increase=new Increase(sharedObject);
        Decrease decrease=new Decrease(sharedObject);
        increase.start();
        decrease.start();
    }
}

class SharedObject {
    public int sharedVariable;

    public SharedObject(int sharedVariable) {
        this.sharedVariable = sharedVariable;
    }
}


class Increase extends Thread {
    public static SharedObject sharedObject;
    public Increase(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 21; i++) {
            while (true) {
                sharedObject.sharedVariable++;
                System.out.println("Số tăng lên: " + sharedObject.sharedVariable);

                try {
                    Thread.sleep(100); // Ngủ 100 milliseconds giữa mỗi lần tăng
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Decrease extends Thread {
    public static SharedObject sharedObject;

    public Decrease(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 21; i++) {

            while (true) {
                sharedObject.sharedVariable--;
                System.out.println("Số giảm: " + sharedObject.sharedVariable);

                try {
                    Thread.sleep(150); // Ngủ 150 milliseconds giữa mỗi lần giảm
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}