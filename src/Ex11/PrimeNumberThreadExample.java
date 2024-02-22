package Ex11;

public class PrimeNumberThreadExample {
    public static void main(String[] args) {
        // Tạo một đối tượng PrimeNumberThread và bắt đầu nó
        PrimeNumberThread primeNumberThread = new PrimeNumberThread(1, 10000);
        primeNumberThread.start();
    }
}

class PrimeNumberThread extends Thread {
    private int start;
    private int end;

    public PrimeNumberThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("Danh sách các số nguyên tố từ " + start + " đến " + end + ":");
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Phương thức kiểm tra số nguyên tố
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}