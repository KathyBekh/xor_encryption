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
    val keyToByte = key.toByte()
    return String(str.toByteArray().map { it xor keyToByte }.toByteArray())
}

fun main() {
    val blala = "Hello World! This, work, med, bed, corona, virus, table, cup."
    val ololo = "input/fileForEncrypted"
    println(blala)
    encryptFile(ololo, "25", "input/fileForDencrypted")
    encryptFile("input/fileForDencrypted", "25", "input/TowfileForDencrypted")
    println(encryptString(blala, "25"))
    println(encryptString(encryptString(blala, "25"), "25"))

}



