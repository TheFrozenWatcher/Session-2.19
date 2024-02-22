package Ex7;

public class run {
    public static void main(String[] args) {
        RandomNumber randomNumber=new RandomNumber();
        randomNumber.start();
    }
}

class RandomNumber extends Thread{
    @Override
    public void run(){
        System.out.println(Math.ceil(Math.random()*99999999));
    }
}
