package mumei.battleroyale.Utils;

public class GameStatus {
    public static boolean status;
    private static int time;

    //ゲーム中のset
    public static void setgame(boolean statuss){
        status = statuss;
    }
    public static boolean getgame(){
        return status;
    }

    public static int getTime(){
        return time;
    }
    public static void setTime(int time){
        this.time = time;
    }


}
