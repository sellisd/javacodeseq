plugins {
    java
    application
}

group = "org.sellisd"
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.javaparser:javaparser-core:3.26.3")
    implementation("info.picocli:picocli:4.7.6")
}

application{
    mainClass.set("codeseq.CodeSeq")
}