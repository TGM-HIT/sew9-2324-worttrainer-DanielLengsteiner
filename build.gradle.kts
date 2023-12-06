plugins {
    id("java")
    id("application")
}

group = "at.ac.tgm.dlengsteiner"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.json:json:20231013")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "at.ac.tgm.dlengsteiner.Main"
}
