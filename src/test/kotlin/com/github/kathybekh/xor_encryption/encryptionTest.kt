package com.github.kathybekh.xor_encryption

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import java.io.File



internal class Cipher {

    @Test
    fun keyCheckCorrect() {
        assert(CipherXor().keyValidate("Bc12"))
        assert(CipherXor().keyValidate("0"))
    }

    @Test
    fun keyCheckIncorrect() {
        assertFalse(CipherXor().keyValidate("utno"))
        assertFalse(CipherXor().keyValidate("-123445"))
        assertFalse(CipherXor().keyValidate(""))
        assertFalse(CipherXor().keyValidate("*&^#"))
    }

    @Test
    fun encryptFileCheckCorrect() {
        CipherXor().createPathForLastElement("one/two/three/1.txt")
        CipherXor().encryptFile("input/to_encrypt", "50", "one/two/three/1.txt")
        CipherXor().encryptFile("one/two/three/1.txt", "50", "one/two/three/2.txt")
        assertEquals(File("input/to_encrypt").readText(), File("one/two/three/2.txt").readText())
        File("one").deleteRecursively()
    }

    @Test
    fun encryptFileCheckIncorrect() {

    }
}