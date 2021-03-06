import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
    application
}

object DependencyVersions {
    const val truth = "1.1.3"
    const val mockk = "1.12.1"
}

group = "com.lucaszeta"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.google.truth:truth:${DependencyVersions.truth}")
    testImplementation("io.mockk:mockk:${DependencyVersions.mockk}")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        outputs.upToDateWhen { false }
        showStandardStreams = true
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
