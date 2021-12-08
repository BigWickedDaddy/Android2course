package com.itis.a1semitis

object SongRepository {
    var songList:List<Song> = getSong()

    fun getSong():List<Song> {
        return arrayListOf(
            Song(R.drawable.ic_launcher_foreground,"Daughter1",R.raw.home,"home"),
            Song(R.drawable.ic_launcher_foreground,"Daughter2",R.raw.run,"run"),
            Song(R.drawable.ic_launcher_foreground,"Daughter1",R.raw.home,"home"),
            Song(R.drawable.ic_launcher_foreground,"Daughter2",R.raw.run,"run"),
            Song(R.drawable.ic_launcher_foreground,"Daughter1",R.raw.home,"home"),
            Song(R.drawable.ic_launcher_foreground,"Daughter2",R.raw.run,"run"),
        )
    }

    fun getPosition(author:String,title:String):Int{
        for(i in 1 until songList.size){
            if(songList[i].title == title && songList[i].author == author){
                return i
            }
        }
        return 0
    }
}