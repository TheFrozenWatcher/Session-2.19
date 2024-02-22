package Ex10;

import java.util.Scanner;

public class run {
    public static void main(String[] args) {
        // Nhập số giây từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số giây bạn muốn thread ngủ: ");
        int seconds = scanner.nextInt();

        // Tạo một đối tượng Thread và bắt đầu thực thi
        SleepThread sleepThread = new SleepThread(seconds);
        sleepThread.start();
    }

}

class SleepThread extends Thread {
    private int seconds;

    public SleepThread(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        try {
            // Ngủ theo số giây được nhập từ người dùng
            System.out.println("Thread đang ngủ...");
            Thread.sleep(seconds * 1000);
            System.out.println("Thread đã kết thúc ngủ.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}