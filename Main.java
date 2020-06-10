public class Main{
    public static void main(String[] args){

        //インスタンス生成
        Player player = new Player();//プレイヤー
        Dealer dealer = new Dealer();//ディーラー
        Umpire umpire = new Umpire();//審判

        //ゲーム開始
        player.start();//プレイヤーのターン
        System.out.println();
        dealer.start();//ディーラーのターン
        System.out.println();

        //勝敗判定
        umpire.judge(player, dealer);
    }
}
