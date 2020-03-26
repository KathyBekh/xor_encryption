package com.github.kathybekh.xor_encryption

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import java.io.File
import java.nio.file.Paths
import kotlin.experimental.xor


/**
 * Вариант 2 -- шифрация

Шифрация (-c) или дешифрация (-d) указанного (в аргументе командной строки) файла.
Выходной файл указывается как -o filename.txt, по умолчанию имя формируется из имени входного файла с добавлением расширения.
Алгоритм шифрации XOR. Ключ указывается после -c или -d в шестнадцатеричной системе, длина ключа -- любое целое количество байт.

Command Line: ciphxor [-c key] [-d key] inputname.txt [-o outputname.txt]

Кроме самой программы, следует написать автоматические тесты к ней.
 */

fun main(args: Array<String>) = Ciphxor().main(args)

class Ciphxor : CliktCommand() {

    private val key by option("-c", "-d", help = "use for encrypt [-c key] or for decrypt [-d key]").required()
    private val inputFile by argument(help = "specify the path to the file")
    private val outputFile by option("-o", help = "specify the path to the encrypt file")
    override fun run() {

        val output = if (outputFile == null) {
            "$inputFile.txt"
        } else {
            createPath(outputFile!!)
        }

        if (keyValidate(key)) {
            encryptFile(inputFile, key, output!!)
        } else println("the key must be written in positive hexadecimal notation")

    }

    fun createPath(path: String): String {
        val path1 = Paths.get(path)
        if (path1.nameCount > 1) {
            path1.parent.toFile().mkdirs()
        }
        return path
    }

    private fun keyValidate(key: String): Boolean {
        val permissibleValue = listOf(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F'
        )
        for (c in key) {
            if (c !in permissibleValue) return false
        }
        return true
    }


    fun encryptFile(text: String, key: String, outputName: String) {

        val listForWrite = mutableListOf<Byte>()
        val bytes = File(text).inputStream().buffered()
//        val bytes2 = File(text).readBytes()

        var count = 0
        for (byte in bytes) {
            val encrypted = byte xor key[count % key.length].toString().toInt(16).toByte()
            listForWrite.add(encrypted)
            count += 1
        }

        File(outputName).writeBytes(listForWrite.toByteArray())
    }

}
