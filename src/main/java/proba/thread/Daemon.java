package proba.thread;

/**
 * Java Concurrency Interview Questions (+ Answers)
 * https://www.baeldung.com/java-concurrency-interview-questions
 */
public class Daemon
{
  public static void main(String[] args)
  {
    Thread daemonThread = new Thread(() -> System.out.println( "Hello from daemon!"));

    daemonThread.setName( "XXXXXXXXXXXXXXXXXXXXXXXXXX");
//    daemon.setDaemon( true);
    daemonThread.start();
  }
}
