package Ex1;

public class run {
    public static void main(String[] args) {
        TimerThread timerThread=new TimerThread();
        timerThread.start();
    }
}

class TimerThread extends Thread{
    @Override
    public void run(){
        for (int i=1;i<=10;i++){
            try{
                Thread.sleep(1000);
                System.out.println(i+"s");

            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Kết thúc đếm.");
    }
}