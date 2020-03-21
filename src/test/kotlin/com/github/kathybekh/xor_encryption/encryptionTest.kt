package com.github.kathybekh.xor_encryption

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Tests {

    @Test
    fun encryptAndDecryptFile() {
        val input = "input/to_encrypt";
        val tmp = "out/encrypted.txt";
        val output = "out/decrypted.txt";
//        encryptFile(input, "BC12", tmp)
//        encryptFile(tmp, "BC12", output)

        assertEquals(File(input).readText(), File(output).readText())
    }

}
