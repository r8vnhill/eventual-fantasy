plugins {
    id("java")
}

group = "cl.ravenhill"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.jetbrains:annotations:23.0.0")
    implementation("net.jqwik:jqwik:1.6.5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0-M1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0-M1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}