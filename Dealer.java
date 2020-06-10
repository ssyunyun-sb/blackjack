import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dealer {

    //フィールド
    private ArrayList<Integer> dealerCards;//手札のカード
    private int total;//手札の合計値
    private Card card;
    Random random = new Random();//乱数用

    //コンストラクタ
    public Dealer(){
        //1~13の初期手札を2枚用意する
        dealerCards = new ArrayList<Integer>(Arrays.asList(random.nextInt(12)+1, random.nextInt(12)+1));
        card = new Card(dealerCards);
    }

    //ターン開始
    public void start(){

        boolean endFlag = false;//ターン終了かどうかの判定フラグ

        Scanner scanner = new Scanner(System.in);
        System.out.print("ディーラーのターンです。Enterキーを押して下さい。");
        scanner.nextLine();//Enterキー入力待ち

        card.show();//初期手札の表示
        total = card.checkHand();//手札の合計値確認

        while(!endFlag) {
            if(total >= 17){
                endFlag = true;
            } else {
                card.draw();//カードを引く
                card.show();//カードを表示
                total = card.checkHand();//手札の合計値確認
            }
        }//while閉じ
        card.setCards(dealerCards);//手番が終わったら手札をセットしておく
    }//start閉じ

    //ゲッター
    public ArrayList<Integer> getCards(){
        return dealerCards;
    }
    public int getTotal(){
        return total;
    }

    //セッター
    public void setTotal(int total){
        this.total = total;
    }

}