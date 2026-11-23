import java.util.*;

public class JosephusDriver {

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      JosephusSim simulation = new JosephusSim("people.txt");
      
      while(!simulation.isOver()) {
         System.out.println(simulation);
         System.out.println("\nContinue elimination? <press enter>");
         console.nextLine(); // make the user hit enter to continue
         simulation.eliminate();
      }
      
      System.out.println(simulation);
   }

}

/*
 === Elimination count is 4 ===
 Remaining survivors: 1-Ziru, 2-Marshall, 3-Sophie, 4-Mohamed, 5-Unumergen, 6-Anthony, 7-Angel, 8-Lukas, 9-Phoung, 10-Maharshi, 11-Mya, 12-Yunfeng
 
 Continue elimination? <press enter>
 
 Mohamed eliminated!
 
 Remaining survivors: 1-Unumergen, 2-Anthony, 3-Angel, 4-Lukas, 5-Phoung, 6-Maharshi, 7-Mya, 8-Yunfeng, 9-Ziru, 10-Marshall, 11-Sophie
 
 Continue elimination? <press enter>
 
 Lukas eliminated!
 
 Remaining survivors: 1-Phoung, 2-Maharshi, 3-Mya, 4-Yunfeng, 5-Ziru, 6-Marshall, 7-Sophie, 8-Unumergen, 9-Anthony, 10-Angel
 
 Continue elimination? <press enter>
 
 Yunfeng eliminated!
 
 Remaining survivors: 1-Ziru, 2-Marshall, 3-Sophie, 4-Unumergen, 5-Anthony, 6-Angel, 7-Phoung, 8-Maharshi, 9-Mya
 
 Continue elimination? <press enter>
 
 Unumergen eliminated!
 
 Remaining survivors: 1-Anthony, 2-Angel, 3-Phoung, 4-Maharshi, 5-Mya, 6-Ziru, 7-Marshall, 8-Sophie
 
 Continue elimination? <press enter>
 
 Maharshi eliminated!
 
 Remaining survivors: 1-Mya, 2-Ziru, 3-Marshall, 4-Sophie, 5-Anthony, 6-Angel, 7-Phoung
 
 Continue elimination? <press enter>
 
 Sophie eliminated!
 
 Remaining survivors: 1-Anthony, 2-Angel, 3-Phoung, 4-Mya, 5-Ziru, 6-Marshall
 
 Continue elimination? <press enter>
 
 Mya eliminated!
 
 Remaining survivors: 1-Ziru, 2-Marshall, 3-Anthony, 4-Angel, 5-Phoung
 
 Continue elimination? <press enter>
 
 Angel eliminated!
 
 Remaining survivors: 1-Phoung, 2-Ziru, 3-Marshall, 4-Anthony
 
 Continue elimination? <press enter>
 
 Anthony eliminated!
 
 Remaining survivors: 1-Phoung, 2-Ziru, 3-Marshall
 
 Continue elimination? <press enter>
 
 Phoung eliminated!
 
 Remaining survivors: 1-Ziru, 2-Marshall
 
 Continue elimination? <press enter>
 
 Marshall eliminated!
 
 Ziru is the last survivor!
*/