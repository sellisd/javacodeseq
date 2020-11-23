plugins {
    java
}

group = "org.sellisd"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    implementation("com.github.javaparser:javaparser-core:3.17.0")
}
