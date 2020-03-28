package com.github.kathybekh.xor_encryption

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.io.File

internal class Cipher {

    @Test
    fun keyCheck() {
        assert(CipherXor().keyValidate("Bc12"))
        assert(CipherXor().keyValidate("0"))
        assertFalse(CipherXor().keyValidate("utno"))
        assertFalse(CipherXor().keyValidate("-123445"))
        assertFalse(CipherXor().keyValidate(""))
        assertFalse(CipherXor().keyValidate("*&^#"))
    }
    

    @Test
    fun encryptFileCheck() {
        CipherXor().createPath("one/two/three/1.txt")
        val a = CipherXor().encryptFile("input/to_encrypt", "50", "one/two/three/1.txt")
        CipherXor().createPath("one/two/three/2.txt")
        val b =CipherXor().encryptFile("one/two/three/1.txt", "50", "one/two/three/2.txt")
        assertEquals(a,b)
        File("one").deleteRecursively()
    }


}