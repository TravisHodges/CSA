public class LoopingMediaLib
{
    public static void main(String[] args)
    {
       for(int i=0; i < 10; i++){
           System.out.println(MediaFile.readString());
       }
       MediaFile.saveAndClose();
       System.out.println();

       String songInfo =  MediaFile.readString();
       while (songInfo != null) {
           System.out.println(songInfo);
           songInfo = MediaFile.readString();
       }
       songInfo = MediaFile.readString();
       while (songInfo != null){
           String title = songInfo.substring(0, songInfo.indexOf("|"));
           System.out.println("Title:" + title);
       }


    }
}


