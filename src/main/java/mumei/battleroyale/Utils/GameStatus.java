package mumei.battleroyale.Utils;

public class GameStatus {
    public static boolean status;


    //ゲーム中のset
    public static void setgame(boolean statuss){
        status = statuss;
    }
    public boolean getgame(){
        return this.status;
    }


}
