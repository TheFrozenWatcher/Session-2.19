package Ex4;

public class run {
    public static void main(String[] args) {
        // Tạo 2 đối tượng NumberGenerator
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();

        // Tạo 2 đối tượng Thread với generator tương ứng
        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);

        // Thiết lập priority cho thread (tùy chọn)
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        // Bắt đầu thực thi thread
        thread1.start();
        thread2.start();
    }
}

class NumberGenerator implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i + ", HashCode: " + hashCode());
            try {
                // Ngủ 500 milliseconds giữa các lần in
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}