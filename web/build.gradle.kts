plugins {
    kotlin("jvm")
    id("com.bmuschko.docker-java-application")
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


docker {
    javaApplication {
        maintainer.set("Sebastian Heil <mail@sebastianheil.de>")
        ports.set(listOf(8000))
        images.set(
            setOf(
                "ghcr.io/sebokopter/randomizer-web:${project.version}",
                "ghcr.io/sebokopter/randomizer-web:latest"
            )
        )
    }
}


dependencies {
    implementation(project(":domain"))
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-server-core:1.5.1")
    implementation("io.ktor:ktor-server-netty:1.5.1")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}