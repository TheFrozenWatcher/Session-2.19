package Ex5;

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(10); // Ngủ 10 mili giây giữa các số lẻ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(15); // Ngủ 15 mili giây giữa các số chẵn
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        // Tạo đối tượng OddThread và EvenThread
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        oddThread.setPriority(Thread.MAX_PRIORITY);
        evenThread.setPriority(Thread.MIN_PRIORITY);

        // Bắt đầu thực thi các thread
        oddThread.start();
        evenThread.start();

        try {
            // Sử dụng join để chờ cho thread OddThread hoàn thành trước khi tiếp tục
            oddThread.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread Finished");
    }
}