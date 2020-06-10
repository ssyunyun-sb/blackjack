import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Player {

    //フィールド
    private ArrayList<Integer> playerCards;//手札のカード
    private int total;//手札の合計値
    private Card card;
    Random random = new Random();//乱数用

    //コンストラクタ
    public Player(){
        //1~13の初期手札を2枚用意する
        playerCards = new ArrayList<Integer>(Arrays.asList(random.nextInt(12)+1, random.nextInt(12)+1));
        card = new Card(playerCards);
    }

    //*---ターン開始---*
    public void start(){

        boolean endFlag = false;//ターン終了かどうかの判定フラグ

        card.show();//初期手札の表示
        total = card.checkHand();//手札の合計値確認

        //プレイヤーの入力
        Scanner scanner = new Scanner(System.in);
        while(!endFlag) {
            System.out.print("カードを引きますか？　(Yes: 1, No: 2) -> ");
            int select = scanner.nextInt();

            if (select == 1) {//カードを引く処理
                card.draw();//カードを引く
                card.show();//カードを表示
                total = card.checkHand();//手札の合計値確認
                if (total > 21){
                    System.out.println("21を超えたのでターンを強制終了します。");
                    endFlag = true;//21超えたらendFlagを立てる
                }
            } else if (select == 2) {//カードを引かずに終わる処理
                endFlag = true;
            } else {
                System.out.println("入力値が正しくありません。もう一度入力して下さい。");
            }
        }//while閉じ
        card.setCards(playerCards);//手番が終わったら手札をセットしておく
    }//start閉じ

    //ゲッター
    public ArrayList<Integer> getCards(){
        return playerCards;
    }

    public int getTotal(){
        return total;
    }

    //セッター
    public void setTotal(int total){
        this.total = total;
    }

}
