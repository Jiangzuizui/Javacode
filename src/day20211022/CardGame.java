package day20211022;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardGame {
    char[] suits={'♥','♠','♦','♣'};
    String[] ranks={"A","2","3","4","5","6",
    "7","8","9","10","J","Q","K"};
    public List<Card> buyCard(){
        List<Card> cards=new ArrayList<>(52);
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                cards.add(new Card(suits[i],ranks[j]));
            }
        }

        return cards;
    }

    public void swap(List<Card> cards,int i,int j){
        Card temp=cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j,temp);

    }

    public void shuffle(List<Card> cards){
        Random r=new Random();
        for(int i=cards.size()-1;i>0;i--){
            int j=r.nextInt(i);
            swap(cards,i,j);
        }
    }

    public static void main(String[] args) {
        CardGame cg=new CardGame();
        List<Card> cards=cg.buyCard();
        System.out.println(cards);

        cg.shuffle(cards);
        System.out.println(cards);

        List<List<Card>> hands=new ArrayList<>(3);
        hands.add(new ArrayList<>(5));
        hands.add(new ArrayList<>(5));
        hands.add(new ArrayList<>(5));

        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                hands.get(j).add(cards.remove(0));

            }
        }
        System.out.println("cards中剩余的牌:");
        System.out.println(cards);
        System.out.println(cards.size());

        System.out.println("A中剩余的牌:");
        System.out.println(hands.get(0));

        System.out.println("B中剩余的牌:");
        System.out.println(hands.get(1));

        System.out.println("C中剩余的牌:");
        System.out.println(hands.get(2));
    }
}

