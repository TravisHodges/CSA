public class FavoritesMediaLib
{
    public static void main(String[] args)
    {
        String songInfo = MediaFile.readString();

        System.out.println("My Favorite Songs In Order");
        System.out.println("---------------------------");

        int index = songInfo.indexOf("|");
        while (index > 0){
            String titleOfSong = songInfo.substring(0,index);
            songInfo = songInfo.substring(index + 1);
            index = songInfo.indexOf("|");
            String ratingstring = songInfo.substring(0, index);

            int rating = Integer.valueOf(ratingstring);

            if (rating > 7){
                System.out.println("Title " + titleOfSong + "(" + rating + ")");
            }
            songInfo = songInfo.substring(index + 1);
            index = songInfo.indexOf("|");
        }


    }
}