import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode front;      // a PersonNode pointer that tracks first node in the list
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination            

   // Constructs the circular linked list from the given file and sets a random elimination count
   public JosephusSim(String fileName) {
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         while (file.hasNextLine()) {
            String name = file.nextLine().trim();
            if (!name.isEmpty()) {
               add(name);
               size++;
            }
         }
         file.close();
         
         // make the ring circular by attaching last node's next to front
         if (front != null) {
            PersonNode curr = front;
            while (curr.next != null) {
               curr = curr.next;
            }
            curr.next = front;
         }
         
         // generate, print, and save the random elimination count
         Random rand = new Random();
         eliminationCount = rand.nextInt(size / 2) + 1;
         System.out.println("=== Elimination count is " + eliminationCount + " ===");

      } catch (FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // Helper method to add a new PersonNode to the end of the singly linked list
   private void add (String val) {
      if (front == null) {
         front = new PersonNode(val);
      } else {
         PersonNode curr = front;
         while (curr.next != null) {
            curr = curr.next;
         }
         curr.next = new PersonNode(val);
      }
   }
   
   public void eliminate() {
      // count to the elimination count
      
      // print who will be eliminated
      
      // eliminate the person and update "front" of the circle and size

   }
   
   // Returns true if only one person remains in the circle, false otherwise
   public boolean isOver() {
      return size == 1;
   }
   
   public String toString() {
      // if there's only one person left, print them as the last survivor
      
      // if many, print survivors (watch out for infinite loop since list is circular)

      return "";
   }
}
