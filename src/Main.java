import api.SpotifyDB;
public class Main {
    public static void main(String[] args) {
        SpotifyDB spot = new SpotifyDB();
        System.out.println(spot.createPlaylist("11vYnWjFxgXBgw2aC6Rb8"));
    }
}