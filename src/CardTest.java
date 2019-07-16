import java.util.Scanner;



public class CardTest {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        Deck theDeck = new Deck();
        theDeck.shuffle();


        // Cards for the user
       int acesUser = 0;
       int acesDealer = 0;

        Card cardOneUser = theDeck.draw();
        if (cardOneUser.getBJValue() == 11){
            acesUser++;
        }
        System.out.println("\nThe first card for the user is: " + cardOneUser);
        System.out.println("Your card value is: " + cardOneUser.getBJValue());

        Card cardTwoUser = theDeck.draw();
        if (cardTwoUser.getBJValue() == 11){
            acesUser++;
        }
        System.out.println("\nThe second card for the user is: " + cardTwoUser);
        System.out.println("Your card value is: " + cardTwoUser.getBJValue());

        int valueHandUser = cardOneUser.getBJValue() + cardTwoUser.getBJValue();
        System.out.println("\nValue of your hand is: " + valueHandUser);



        System.out.println("\n-----------------------------------------------------------------");
        //Cards for the computer
        Card cardOneDealer = theDeck.draw();
        if (cardOneDealer.getBJValue() == 11){
            acesDealer++;
        }
        System.out.println("\nThe first card for the dealer is: " + cardOneDealer);
        System.out.println("Their card value is: " + cardOneDealer.getBJValue());

        Card cardTwoDealer = theDeck.draw();
        if (cardTwoDealer.getBJValue() == 11){
            acesDealer++;
        }
        System.out.println("\nThe second card for the dealer is: " + cardTwoDealer);
        System.out.println("Their card value is: " + cardTwoDealer.getBJValue());

        int valueHandDealer = cardOneDealer.getBJValue() + cardTwoDealer.getBJValue();
        System.out.println("\nValue of dealer's hand is: " + valueHandDealer);

        System.out.println("\n-----------------------------------------------------------------");

        // Let the user continue playing
        System.out.println("Would you like to continue picking cards?");
        System.out.println("Press 1 for YES");
        System.out.println("Press 2 for NO");
        int userAnswer = scnr.nextInt();
        while (userAnswer == 1){
            Card cardThreeUser = theDeck.draw();
            valueHandUser += cardThreeUser.getBJValue();
            System.out.println("The value of your hand is now: " + valueHandUser);
            System.out.println("\nWould you like to continue picking cards?");
            System.out.println("Press 1 for YES");
            System.out.println("Press 2 for NO");
            userAnswer = scnr.nextInt();
        } if (userAnswer == 2){
            System.out.println("Thanks for playing");
            System.out.println("The value of your hand is: " + valueHandUser);
        }


        // Let the dealer continue playing until it reaches 21
        while (valueHandDealer <= 17){
            Card cardThreeDealer = theDeck.draw();
            valueHandDealer += cardThreeDealer.getBJValue();
        }
        System.out.println("The value of the dealer's hand is: " + valueHandDealer);


        // determine if ace values should be subtracted from the user and dealer

        if ((acesUser > 0) && (valueHandUser > 21)){
            valueHandUser -= 10;
        }

        if ((acesDealer > 0) && (valueHandDealer > 21)){
            valueHandDealer -= 10;
        }

        // Determine the winner

        if ((valueHandUser > valueHandDealer) && (valueHandUser <= 21)) {
            System.out.println("User wins!");
        }
        if ((valueHandDealer > valueHandUser)&& (valueHandDealer <= 21)){
            System.out.println("Dealer wins!");
        }

        if (valueHandUser > 21) {
            System.out.println("Dealer wins!");
        }
        if (valueHandDealer > 21) {
            System.out.println("User wins!");
        }
    }
}
