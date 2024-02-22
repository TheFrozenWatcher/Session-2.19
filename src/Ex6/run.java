package Ex6;

import java.util.ArrayList;
import java.util.List;

public class run {
    public static void main(String[] args) {
        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();
        Thread thread1=new Thread(lazyPrimeFactorization);
        Thread thread2=new Thread(optimizedPrimeFactorization);
        thread1.start();
        thread2.start();
    }
}

class LazyPrimeFactorization implements Runnable {

    @Override
    public void run() {
        List<Integer> primeArray = new ArrayList<>();
        int count = 0;

        for (int i = 2; count < 31; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primeArray.add(i);
                System.out.println("Lazy factor: " + i);
                count++;
            }
        }
        if (count == 30) {
            System.out.println("Lazy process completed.");

        }
    }
}

class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        List<Integer> primeArray = new ArrayList<>();
        int count = 0;
        for (int i = 2; count < 31; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeArray.add(i);
                System.out.println("Optimized factor: " + i);
                count++;
            }
        }
        if (count == 30) {
            System.out.println("Optimized process completed.");
        }
    }
}