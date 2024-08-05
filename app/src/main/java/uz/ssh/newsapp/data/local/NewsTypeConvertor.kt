package uz.ssh.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import uz.ssh.newsapp.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }
    @TypeConverter
    fun stringToSource(string: String): Source {
        val list = string.split(",")
        return Source(list[0], list[1])
    }
}