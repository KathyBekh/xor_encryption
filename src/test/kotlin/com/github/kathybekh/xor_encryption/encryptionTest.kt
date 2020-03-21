package com.github.kathybekh.xor_encryption

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Tests {
//    private fun assertFileContent(name: String, expectedContent: String) {
//        val file = File(name)
//        val content = file.readLines().joinToString("\n")
//        Assertions.assertEquals(expectedContent, content)
//    }

    @Test
    fun foo() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun encryptFile() {
        val input = "input/fileForEncrypted";
        val tmp = "out/encrypted.txt";
        val output = "out/decrypted.txt";
        encryptFile(input, "BC12", tmp)
        encryptFile(tmp, "BC12", output)

        assertEquals(File(input).readText(), File(output).readText())
    }

}
