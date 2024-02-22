package Ex3;

public class run {
    public static void main(String[] args) {
        OddNumberPrinter oddNumberPrinter=new OddNumberPrinter();
        oddNumberPrinter.start();
        EvenNumberPrinter evenNumberPrinter=new EvenNumberPrinter();
        evenNumberPrinter.start();
    }
}

class OddNumberPrinter extends Thread{
    @Override
    public void run(){
        for (int i=1;i<=1000;i++){
            if (i%2!=0){
                System.out.println(i);
            }
        }
    }
}class EvenNumberPrinter extends Thread{
    @Override
    public void run(){
        for (int i=1;i<=1000;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}