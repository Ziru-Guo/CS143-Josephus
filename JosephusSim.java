// Ziru Guo
// CS 143
// Program #5: Josephus Problem
// This class simulates the Josephus elimination game using a circularly linked list

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
   
   
   // Counts to the elimination count, removes that person, and updates front and size
   public void eliminate() {
      // find the node right before the person to be eliminated
      PersonNode prev = front;
      if (eliminationCount == 1) {
         while (prev.next != front) {
            prev = prev.next;
         }
      } else {
         for (int i = 1; i < eliminationCount - 1; i++) {
            prev = prev.next;
         }
      }
      // print who will be eliminated
      System.out.println(prev.next.name + " eliminated!\n");
      // eliminate the person and update "front" of the circle and size
      prev.next = prev.next.next;
      front = prev.next;
      size--;
   }
   
   
   // Returns true if only one person remains in the circle, false otherwise
   public boolean isOver() {
      return size == 1;
   }
   
   // Returns the last survivor if the game is over, or the list of remaining survivors
   public String toString() {
      if (isOver()) {
         return front.name + " is the last survivor!";
      }
      
      StringBuilder result = new StringBuilder("Remaining survivors: ");
      PersonNode curr = front;
      for (int i = 1; i <= size; i++) {
         result.append(i).append("-").append(curr.name);
         if (i < size) {
            result.append(", ");
         }
         curr = curr.next;
      }
      return result.toString();
   }
   
}