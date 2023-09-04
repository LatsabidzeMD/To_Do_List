package com.example.latsabidze

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {

    val FILENAME = "listinfo.dat"

    fun writeData(item: ArrayList<String>, contex: Context) {
        var fos: FileOutputStream = contex.openFileOutput(FILENAME, Context.MODE_PRIVATE)

        var oas = ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()
    }

    fun readData(contex: Context): ArrayList<String> {
        var itemList: ArrayList<String>

        try {
            var fis: FileInputStream = contex.openFileInput(FILENAME)
            var ois = ObjectInputStream(fis)
            itemList = ois.readObject() as ArrayList<String>
        }catch (e: FileNotFoundException){
            itemList = ArrayList()
        }


        return itemList
    }
}
