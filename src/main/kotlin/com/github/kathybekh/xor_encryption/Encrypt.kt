package com.github.kathybekh.xor_encryption

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


fun encryptFile(text: String, key: String, outputName: String ) {

    val listForWrite = mutableListOf<Byte>()
    val bytes = File(text).readBytes()
    var count = 0
    for (byte in bytes) {
        val encrypted = byte xor key[count % key.length].toString().toInt(16).toByte()
        listForWrite.add(encrypted)

        count += 1
    }
    File(outputName).writeBytes(listForWrite.toByteArray())
}

//fun encryptKey (key: String): Byte = key.
//
//
//fun encrypt(bytes: Byte, key: Byte): List<Byte> {
//    var encryptedString = Byte()
////    for (c in key.indices) {
////        val keyToByte = key[c % key.size].toString().toInt(16).toByte()
//        encryptedString = bytes xor key[0]
//    }
//    return encryptedString
//}

//fun encryptBytes(bytes: List<Byte>, key: List<Byte>): List<Byte> {
//    println(bytes[0])
//    println(bytes[0].toChar())
////    for (byte in bytes) {
////        byte.toChar(
////    }
//    return emptyList()
//}

fun help() {
    println("Please use -c key inputname.txt -o outputname.txt")
}

fun createNonUtf8File() {
    val byte : Byte = -1;
    println(Integer.toBinaryString(byte.toInt()))
    File("wrong").writeBytes(arrayOf(byte).toByteArray())
    println(File("wrong").readText())
    println(File("wrong").readBytes()[0])
}

fun main(args: Array<String>) {
    encryptFile("input/fileForEncrypted", "BCF12", "out/decrypted")
    encryptFile("out/decrypted","BCF12", "input/TowfileForDencrypted")

}



