import java.util.Scanner;

class Main {
  /*
   * Allows user to control our Queue class.
   */
  public static void main(String[] args) {
    Queue queue = new Queue();
    Scanner input = new Scanner(System.in);
    String command;

    System.out.println("Commands:");
    System.out.println("- enqueue");
    System.out.println("- dequeue");
    System.out.println("- size");
    System.out.println("- exit");

    // Loops until "exit" is given.
    while (true) {
      command = input.nextLine();
      command = command.trim();

      // Asks for a number to put in the queue.
      if (command.equals("enqueue")) {
        System.out.println("What's the number?");
        double number = input.nextDouble();
        input.nextLine();
        queue.enqueue(number);
        System.out.printf("Added number %.2f to the queue.\n", number);
      }
      // removes a number from the queue and prints it
      else if (command.equals("dequeue")) {
        System.out.printf("Removed the number %.2f.\n", queue.dequeue());
      }
      // Prints how many elements are in the queue
      else if (command.equals("size")) {
        System.out.printf("There are %d elements in the queue.\n", queue.getSize());
      }
      // exit
      else if (command.equals("exit")) {
        System.out.println("Buh-bye.");
        break;
      }
      // bad input
      else {
        System.out.println("Invalid command.");
      }
    }
  }
}


class Queue {
  private double[] elements;
  private int nrElements;

  /* Default constructor, sets length of internal array to 5.
   */
  Queue() {
    nrElements = 0;
    elements = new double[5];
  }


  /* If our array is full, we can double it in size.
   */
  private void increaseSize() {
    // create empty array with double size
    double[] copy = new double[elements.length * 2];

    // copy elements into new array
    for (int i = 0; i < elements.length; i++) {
      copy[i] = elements[i];
    }

    // reassign elements to the new array
    elements = copy;
  }


  /* Checks if our array has space, makes it bigger if we need it to be
   * then adds the number to it.
   */
  void enqueue(double number) {
    // increase size if necessary.
    if (nrElements >= elements.length) {
      increaseSize();
    }

    elements[nrElements] = number;
    nrElements++;
  }


  /* If there are numbers in our queue, removes element from queue. 
   */
  double dequeue() {
    if (isEmpty()) {
      return 0;
    }

    double number = elements[0];
    nrElements--;

    // shift all elements to the left to move up the queue
    for (int i = 0; i < nrElements; i++) {
      elements[i] = elements[i+1];
    }

    return number;
  }


  /* Returns true if queue is empty.
   */
  boolean isEmpty() {
    if (nrElements == 0) {
      return true;
    }

    return false;
  }


  /* Returns how many elements are in our queue.
   */
  int getSize() {
    return nrElements;
  }
}

