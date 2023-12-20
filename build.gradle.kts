
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

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
}

tasks.test {
    // Use the built-in JUnit support of Gradle.
    useJUnitPlatform()
}