import java.util.Scanner;

/* A stopwatch class that keeps track of a startTime and endTime.
 */
class Stopwatch {
  private long startTime;
  private long endTime;

  /* Default constructor, sets start and end to 0.
   */
  Stopwatch() {
    startTime = 0;
    endTime = 0;
  }

  /* Sets startTime to current time, resets endtime to 0.
   */
  void start() {
    startTime = System.currentTimeMillis();
    endTime = 0;
  }

  /* Sets endtime to current time.
   */
  void stop() {
    endTime = System.currentTimeMillis();
  }

  /* Returns how much time has passed between startTime and endTime
   * Or, if endTime is zero, between startTime and current time.
   */
  double getTimeSeconds() {
    long end;

    // We haven't started yet.
    if (startTime == 0) {
      return 0;
    }

    // If the stopwatch hasn't been stopped yet, show intermediate time.
    if (endTime == 0) {
      end = System.currentTimeMillis();
    }
    else {
      end = endTime;
    }

    // convert milliseconds to seconds.
    return (end - startTime) / 1000.0;
  }
}


class Main {
  /* Create a stopwatch and allows user to interact with it.
   */
  public static void main(String[] args) {
    Stopwatch sw = new Stopwatch();
    Scanner input = new Scanner(System.in);
    String command;

    System.out.println("Commands are:\nstart stop show exit");

    // Keep reading commands forever until "exit".
    while (true) {
      command = input.nextLine();

      if (command.equals("start")) {
        System.out.println("Starting..");
        sw.start();
      }
      else if (command.equals("stop")) {
        System.out.println("Stopping..");
        sw.stop();
      }
      else if (command.equals("show")) {
        System.out.printf("Time passed is %.2fs\n", sw.getTimeSeconds());
      }
      else if (command.equals("exit")) {
        System.out.println("Bye");
        break;
      }
    }
  }
}

