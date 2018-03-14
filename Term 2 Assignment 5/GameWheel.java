import java.util.*;
import java.lang.*;

public class GameWheel {
  private ArrayList<PrizeCard> prizeCards;
  private int currentPos;
  
  public String getColor(PrizeCard card){
       if(card.getID() % 2 == 1){
            return "red";
       }
       else if(card.getID() % 10 == 0){
            return "black";
       }
       else{
            return "blue";
       }
  }

  public GameWheel() {
    prizeCards = new ArrayList<PrizeCard>();
    currentPos = 0;
    prizeCards = initGameWheel();
    prizeCards = scramble();
  }

  public ArrayList<PrizeCard> initGameWheel() {
    ArrayList<PrizeCard> init = new ArrayList<PrizeCard>();
    for (int i=1; i <= 40; i++) {
      if (i % 2 == 1)
        init.add(new PrizeCard(i, "red", i*10));
      else if (i%10 == 0)
        init.add(new PrizeCard(i, "black", i*200));
      else
        init.add(new PrizeCard(i, "blue", i*100));
    }
    return init;
  }

  public ArrayList<PrizeCard> getPrizeCards() {
    return prizeCards;
  }

  public ArrayList<PrizeCard> scramble() {
    ArrayList<PrizeCard> scrambled = new ArrayList<PrizeCard>();

    ArrayList<PrizeCard> reds = new ArrayList<PrizeCard>();
    ArrayList<PrizeCard> blues = new ArrayList<PrizeCard>();
    ArrayList<PrizeCard> blacks = new ArrayList<PrizeCard>();
    
       for(PrizeCard card : prizeCards){
            if(getColor(card).equals("black")){
                 blacks.add(card);
            }
            else if(getColor(card).equals("blue")){
                 blues.add(card);
            } else {
                 reds.add(card);
            }
       }
       
       reds = GameWheel.scrambleList(reds);
       blues = GameWheel.scrambleList(blues);
       blacks = GameWheel.scrambleList(blacks);
       
       int redIndex = 0;
       int blueIndex = 0;
       int blackIndex = 0;
       
       for(int i = 1;i <= 40;i++){
            if(i % 2 == 1){
                 scrambled.add(reds.get(redIndex));
                 redIndex += 1;
            }
            else if(i % 10 == 0){
                 scrambled.add(blacks.get(blackIndex));
                 blackIndex += 1;
            }
            else{
                 scrambled.add(blues.get(blueIndex));
                 blueIndex += 1;
            }
       }
       

    return scrambled;
  }
  
  public static ArrayList<PrizeCard> scrambleList(ArrayList<PrizeCard> list){
       ArrayList<PrizeCard> scrambled = new ArrayList<PrizeCard>();
       ArrayList<Integer> used = new ArrayList<Integer>();
       
       while(list.size() != scrambled.size()){
            for(PrizeCard card : list){
                 int random = (int)(Math.random() * list.size());
                 if(!used.contains(random)){
                      used.add(random);
                      scrambled.add(list.get(random));
                 }
            }
       }
       return scrambled;
  }

  public PrizeCard spinWheel() {
    //spin power between range of 1-100 (inclusive)
    int power = (int)(Math.random()*100 + 1);
    int newPos = (currentPos + power) % prizeCards.size();
    currentPos = newPos;
    return prizeCards.get(currentPos);
  }


}
