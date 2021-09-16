package com.ttsr.homework1.threads;

public class PingPong {
    public static void main(String[] args) {
        PingPongThread pingThread = new PingPongThread("ping");
        PingPongThread pongThread = new PingPongThread("pong");
        pingThread.start();
        pongThread.start();
    }

}
class PingPongThread extends Thread{

    private final String word;

    private static String turn;

    private static final Object lock = new Object();

    PingPongThread(String targetWord){
        this.word = targetWord;
    };

    @Override
    public void run() {
        while (true) {
           synchronized (lock){
               if(!word.equals(turn)){
                   turn = word;
                   System.out.println(word);
                   try {
                       sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        }
    }
}
