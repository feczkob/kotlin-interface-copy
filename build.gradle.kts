plugins {
    id("java")
    kotlin("jvm") version "1.9.0"
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}