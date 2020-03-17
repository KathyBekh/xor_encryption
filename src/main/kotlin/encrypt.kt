import java.io.BufferedWriter
import java.io.File
import kotlin.experimental.xor


/**
 * Вариант 2 -- шифрация

Шифрация (-c) или дешифрация (-d) указанного (в аргументе командной строки) файла.
Выходной файл указывается как -o filename.txt, по умолчанию имя формируется из имени входного файла с добавлением расширения.
Алгоритм шифрации XOR. Ключ указывается после -c или -d в шестнадцатеричной системе, длина ключа -- любое целое количество байт.

Command Line: ciphxor [-c key] [-d key] inputname.txt [-o outputname.txt]

Кроме самой программы, следует написать автоматические тесты к ней.
 */


fun encryptFile(text: String, key: String, outputName: String ): BufferedWriter {
    val outputStream = File(outputName).bufferedWriter()

    File(text).forEachLine {
        outputStream.write(encryptString(it, key))
        outputStream.newLine()
    }
    outputStream.close()
    return outputStream
}

fun encryptString(str: String, key: String): String {
    var encryptedString = ""
    for (i in str.indices) {
        val keyToByte = key[i % key.length].toString().toInt(16).toByte()
        encryptedString = String(str.toByteArray().map { it xor keyToByte }.toByteArray())
    }
    return encryptedString
}

fun main() {
    val ab = '1'
    println(ab.toString().toBigInteger(16))
    println(ab.toString().toInt(16))
    println(ab.toInt())
    val blala = "Hello World! This, work, med, bed, corona, virus, table, cup."
    val ololo = "input/fileForEncrypted"
    println(blala)
    encryptFile(ololo, "5A2AB1C", "input/fileForDencrypted")
    encryptFile("input/fileForDencrypted", "5A2AB1C", "input/TowfileForDencrypted")
    println(encryptString(blala, "5A2AB1C"))
    println(encryptString("16", "B"))
    println(encryptString(encryptString(blala, "5A2AB1C"), "5A2AB1C"))

}



