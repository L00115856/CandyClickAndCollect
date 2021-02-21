package candyclickandcollect;

import java.util.Scanner;
import java.util.Date;

public class CandyCollection {

	  // Create an array of 12 candy products.
	 private static int[] candyproducts= new int[12];
	 
	 public static void main(String args[]) {
   System.out.println("Welcome to Andy Candy Click and Collect!");
    System.out.println("Limited Edition Homebaked treats in one fabulous candy order!");
	System.out.println();


        //setting all candyproduct orders equal to 0 (aka Empty)
        for (int i = 0; i < 12; i++) {

            candyproducts[i] = 0;
        }
        
// Setup our scanner and default the choice to brownies.
         Scanner s = new Scanner(System.in);
         int choice = 1;
      
    // Ask user for a brownie or an cupcakes choice and store their choice.
  System.out.print("Please enter 1 for brownies, 2 for cupcakes, or 0 to exit: ");
  choice = s.nextInt();
//While their choice is not the one for exit, execute our booking.

       while (choice != 0) {

           int ordernumber = 0;



  // If they chose a Brownie , attempt to order it it.

     if (choice == 1) {

    ordernumber = orderBrownies();

 // No Brownies  available, try booking an cupcake  instead.

     if (ordernumber == -1) {

       ordernumber = orderCupcake();

                

    if (ordernumber != -1) {

        System.out.println("Sorry, we were not able to take a Brownie order. But do have a cupcake order slots.");
         //replace boardingpAAss with order confirmation
       printOrder(ordernumber);

           }

        }

      else {

                   // 	Ordering a brownie  was successful.

                   System.out.println("You are in luck, we have brownies available!");

                   printOrder(ordernumber);

               }

           }           else if (choice == 2) {



               // If they chose booking an isle, check to see if it is available.

               ordernumber = orderCupcake();

            

               // If not available, see if we have window seats available.
  	if (ordernumber == -1) {

                   ordernumber = orderBrownies();



                   if (ordernumber != -1) {

                       System.out.println("Sorry, we were not able to take cupcake order. But do have a brownie orders.");

                       printOrder(ordernumber);

                  }

               }

               else {

                   // Ordering cupcake was successful.

                   System.out.println("You are in luck, we cupcakes available!");

                   printOrder(ordernumber);

               }
         }

           else {

               // Print an error message if they did not choose 1, 2, or 0 for their choice.

               System.out.println("Invalid choice made. Please try again!");

               choice = 0;

           }





           // No window or aisle seats were available. 
         if (ordernumber == -1) {

               System.out.println("We are sorry, there are no brownies or cupcake order slots available.");

               System.out.println();

           }





           // Reprompt for a choice

           System.out.print("Please enter 1 for Brownie, 2 for cupcakes, or 0 to exit: ");

           choice = s.nextInt();

       }


          

   }

	// This function checks for window seats and returns seat number or -1 if full.
	 
	     private static int orderBrownies() {
	         for (int i = 0; i < 6; i++) {
	
	             if (candyproducts[i] == 0) {
	 
	                 candyproducts[i] = 1;
	 
	                 return i + 1;
	 
	             }
	 
	         }
	         return -1;
	 	     }

	     // This function checks to see if any cupcakes were available, -1 if full.
	
	     private static int orderCupcake() {
	         for (int i = 6; i < 12; i++) {
	 
	             if (candyproducts[i] == 0) {
	 
	           candyproducts[i] = 1;
	
	 return i + 1;
	 
	             }
	
	  }
	   return -1;

	  
	  }
	 
	  

	
  // This simply prints out a nice little order message with their order number and date of issue.
	 
	 private static void printOrder(int ordernumber) {
	 
  Date timenow = new Date();
	 
  System.out.println();
	
  System.out.println("Date: " + timenow.toString());
	
   System.out.println("Order number for Brownies: " + ordernumber);
	 
	System.out.println("This order is non-refundable and non-transferable.");
   System.out.println("Enjoy your treats.");
	 
    System.out.println();
	 
	     }
	 
	 

}
