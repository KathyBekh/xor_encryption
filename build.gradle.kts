plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.61"
    application
}

application {
    mainClassName = "com.github.kathybekh.xor_encryption.CipherXorKt"
//    mainClassName = "com.amyris.graph.cli.CliKt"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.github.ajalt:clikt:2.6.0")

    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.0")
}

val fatJar = task("fatJar", type = Jar::class) {
    baseName = "${project.name}-fat"
    manifest {
        attributes["Implementation-Title"] = "Gradle Jar File Example"
        attributes["Main-Class"] = "com.github.kathybekh.xor_encryption.EncryptKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}

//tasks.withType<Jar>() {
//    manifest {
//        attributes["Main-Class"] = "com.github.kathybekh.xor_encryption.CipherXorKt"
////        attributes["Main-Class"] = "com.github.ajalt.clikt.core.CliktCommand,"
//    }
//    configurations["compileClasspath"].forEach { file: File ->
//        from(zipTree(file.absoluteFile))
//    }
//}

//jar {
//    manifest {
//        attributes 'Main-Class': 'com.amyris.graph.cli.CliKt'
//    }
//}