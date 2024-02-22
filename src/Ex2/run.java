package Ex2;

public class run {
    public static void main(String[] args) {
        CalculateTotalThread total=new CalculateTotalThread();
        total.start();
    }
}

class CalculateTotalThread extends Thread{
    @Override
    public void run(){
        int sum=0;
        for (int i=1;i<=1000;i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}