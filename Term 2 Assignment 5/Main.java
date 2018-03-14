import java.util.*;

public class Main {
     
  

     public static void main (String[] args) {
          GameWheel wheel = new GameWheel();
          ArrayList<PrizeCard> playerOne = new ArrayList<PrizeCard>();
          ArrayList<PrizeCard> playerTwo = new ArrayList<PrizeCard>();
          while(playerOne.size() < 5){
               PrizeCard newCard = wheel.spinWheel();
               if(!playerOne.contains(newCard)){
                    playerOne.add(newCard);
               }
          }
       
          while(playerTwo.size() < 5){
               PrizeCard newCard = wheel.spinWheel();
               if(!playerTwo.contains(newCard)){
                    playerTwo.add(newCard);
               }
          }
          int playerOneTotal = 0;
          int playerTwoTotal = 0;
          
          for(PrizeCard card : playerOne){
               playerOneTotal += card.getPrizeAmount();
          }
          
          for(PrizeCard card : playerTwo){
               playerTwoTotal += card.getPrizeAmount();
          }
          
          System.out.println("Player 1 Total: $" + playerOneTotal);
          for(PrizeCard card : playerOne){
               System.out.println(card.toString());
          }
          System.out.println("\nPlayer 2 Total: $" + playerTwoTotal);
          for(PrizeCard card : playerTwo){
               System.out.println(card.toString());
          }
          int difference = playerOneTotal - playerTwoTotal;
          if(difference > 0){
               System.out.println("\nPlayer 1 won by $" + difference + "!");
          }
          else if(difference < 0){
               System.out.println("\nPlayer 2 won by $" + Math.abs(difference) + "!");
          }
          else if(difference == 0){
               System.out.println("\nIt's a tie!");
          }
     }
     
     
     

}
