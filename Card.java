import java.util.ArrayList;
import java.util.Random;

public class Card {

    //フィールド
    private ArrayList<Integer> cards;//手札のカード
    private Umpire umpire;
    Random random = new Random();//乱数用

    //コンストラクタ
    public Card(ArrayList<Integer> cards){
        this.cards = cards;
    }

    //*---手札の表示---*
    public void show(){
        System.out.println("---現在の手札---");
        for(int card: cards){
            System.out.print(card + " ");
        }
        System.out.println();
    }

    //*---カードを引く---*
    public void draw(){
        cards.add(random.nextInt(12)+1);
    }

    //*---手札確認(21を超えていないかどうか)---*
    public int checkHand(){
        int total;//手札の合計値

        //手札の合計値を計算する
        total = calculateTotal(cards);

        //手札判定
        return total;
    }

    //*---手札の合計値を計算---*
    public int calculateTotal(ArrayList<Integer> cards){

        int total = 0;//手札の合計値
        int aceCount = 0;//手札のエースの数

        //合計値を求める
        for(int card: cards){
            if(card > 1 && card < 11){//2~10の数字ならそのまま足す
                total += card;
            } else if (card > 10){//J~Kなら10を足す
                total += 10;
            } else {//Aの処理は別途行うため、何枚あるかだけカウントしておく
                aceCount++;
            }
        }

        //エースがあれば別途処理
        if(aceCount != 0) total = calculateAce(total, aceCount);
        return total;
    }

    //*---エースの処理---*
    private int calculateAce(int total, int aceCount){

        int[] acePattern1 = {1, 11};//エースが1枚のとき
        int[] acePattern2 = {2, 12};//エースが2枚のとき
        int[] acePattern3 = {3, 13};//エースが3枚のとき
        int[] acePattern4 = {4, 14};//エースが4枚のとき
        int value = 21 - total;//手札の余力(後いくつまでカードを持てるか)

        //エースの枚数により分岐処理
        switch(aceCount){
            case(1):
                if(value >= acePattern1[1]) total += acePattern1[1];//エースを11としても問題ないなら11として足す
                else total += acePattern1[0];//そうでなければ1として足す
                break;
            case(2):
                if(value >= acePattern2[1]) total += acePattern2[1];
                else total += acePattern2[0];
                break;
            case(3):
                if(value >= acePattern3[1]) total += acePattern3[1];
                else total += acePattern3[0];
                break;
            case(4):
                if(value >= acePattern4[1]) total += acePattern4[1];
                else total += acePattern4[0];
                break;
        }
        return total;
    }

    //セッター
    public void setCards(ArrayList<Integer> cards){
        this.cards = cards;
    }
    //ゲッター
    public ArrayList<Integer> getCards(){
        return cards;
    }

}
