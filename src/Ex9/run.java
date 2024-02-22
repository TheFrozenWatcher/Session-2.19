package Ex9;

public class run {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.start();
    }
}

class Printer extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}