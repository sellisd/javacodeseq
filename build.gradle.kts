plugins {
    java
    application
}

group = "org.sellisd"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.javaparser:javaparser-core:3.17.0")
    implementation("info.picocli:picocli:4.5.2")
}

application{
    mainClass.set("codeseq.CodeSeq")
}