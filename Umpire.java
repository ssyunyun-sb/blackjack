import java.util.ArrayList;
import java.util.Scanner;

//審判クラス
public class Umpire {

    //勝敗判定
    public void judge(Player player, Dealer dealer){

        //メッセージ出力
        Scanner scanner = new Scanner(System.in);
        System.out.print("勝敗判決に移ります。Enterキーを押して下さい。");
        scanner.nextLine();//Enterキー入力待ち
        System.out.println("-----勝敗判定-----");

        //お互いのカードを表示
        printAllCards(player, dealer);
        //勝者を決定
        String winner = decideWinner(player, dealer);

        //勝者を表示
        System.out.println("========================");
        System.out.println("||    " + winner + "    ||");
        System.out.println("========================");
    }

    //お互いのカードを表示
    private void printAllCards(Player player, Dealer dealer){

        ArrayList<Integer> playerCards = player.getCards();//プレイヤーの手札
        ArrayList<Integer> dealerCards = dealer.getCards();//ディーラーの手札

        System.out.print("プレイヤーの手札: ");
        for(int i: playerCards) System.out.print(i + "  ");
        System.out.println("  Total: " + player.getTotal());

        System.out.print("ディーラーの手札: ");
        for(int i: dealerCards) System.out.print(i + "  ");
        System.out.println("  Total: " + dealer.getTotal());

    }

    //勝者を決定
    private String decideWinner(Player player, Dealer dealer){

        String winner = "Player wins";//初期値に"Player wins"を入れておく
        int pTotal = player.getTotal();//Playerの合計値
        int dTotal = dealer.getTotal();//Dealerの合計値

        if(pTotal > 21){//Playerが21超えていたらディーラーの勝ち
            winner = "Dealer  wins";
        } else if(dTotal <= 21 && (dTotal > pTotal)){//Dealerが21超えておらず、Playerより大きい数字であればディーラーの勝ち
            winner = "Dealer  wins";
        } else if(dTotal == pTotal){
            winner = "    Draw    ";
        }
        return winner;
    }

}
