import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Card{
    int size;            //牌的大小
    String color;        //牌的花色

    public Card(){

    }

    public Card(int size, String color){
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        String newSize = null;
        //如果牌的大小是1、11、12、13将其转化
        if(size == 1){
            newSize = "A";
        }else if(size == 11){
            newSize = "J";
        }else if(size == 12){
            newSize = "Q";
        }else if(size == 13){
            newSize = "K";
        }else{
            newSize = String.valueOf(size);
        }
        return String.format("(%s, %s)", newSize, color);
    }
}
public class DeckDemo {
    public static final String[] s = {"♥", "♣", "♦", "♠"};
    //创建一幅新的牌
    public  List<Card> creatCard(List<Card> deck){
        //将52张牌，13种不同的大小，四种花色尾插入线性表中
        for(int i = 0 ; i < 13; i++){
            for(int j = 0; j < 4; j++){
                String color = s[j];
                Card card = new Card(i + 1, color);
                deck.add(card);
            }
        }
        return deck;
    }
    //洗牌
    public List<Card> newCard(List<Card> deck){
        Random rand = new Random();
        //将牌从最后线性表中最后一个开始遍历，每次将遍历到的牌和它前面的任意一个牌调换，以达到洗牌的目的
        for(int i = deck.size() - 1; i > 0; i--){
            swap(deck, i, rand.nextInt(i));
        }
        return deck;
    }
    //交换表中两个位置的值
    public void swap(List<Card> deck, int i , int j){
        Card temp = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, temp);
    }
    //发牌
    //numCard表示每个人抓几张牌，numPerson表示有几个人抓牌
    public void send(List<Card> deck, List<List<Card>> person, int numCard, int numPerson){
        //首先给存储这个人信息的线性表分配容量
        for(int i = 0; i < numPerson; i++){
            person.add(new ArrayList<>());
        }
        //给每个人一次发一张牌，共发五次（所以这里要将牌数作为外循环，否则将人作为外循环会一次性给一个人发完牌）
        for(int i = 0; i < numCard; i++){
            for(int j = 0; j < numPerson; j++){
                Card card = deck.get(0);                //取出线性表中第一张的牌
                person.get(j).add(card);                //将这个牌发给第j个人
                card = deck.remove(0);           //删除线性表中第一张牌，后边的牌依次向前挪
            }
        }
    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        DeckDemo p = new DeckDemo();
        deck = p.creatCard(deck);
        System.out.println("一幅扑克牌：");
        System.out.println(deck);
        deck = p.newCard(deck);
        System.out.println("均匀洗牌后：");
        System.out.println(deck);
        List<List<Card>> person = new ArrayList<>();           //创建一个存储人信息的线性表，线性表里每个位置又存放着这个人所持有牌的线性表
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发给的人数：");
        int numPerson = scanner.nextInt();
        System.out.println("每个人发5张牌");
        p.send(deck, person, 5, numPerson);
        for(int i = 0; i < numPerson; i++){
        System.out.println("第" + (i + 1) + "个人的牌是：" + person.get(i));
        }
        System.out.println("牌堆剩余的牌有："+ deck);
    }
}
