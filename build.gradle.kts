plugins {
    kotlin("jvm") version "1.9.20"
    id("org.jetbrains.dokka") version "1.9.20"
    id("maven-publish")
}

group = "com.github.ks288"
version = "1.0.0"

val dokkaDir = "documentation"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
        }
    }
}

tasks.dokkaHtml {
    outputDirectory.set(rootDir.resolve("$dokkaDir/html"))
}

tasks.dokkaJavadoc {
    outputDirectory.set(rootDir.resolve("$dokkaDir/javadoc"))
}

// Dokka HTML document generation task
tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("html-docs")
}

// Dokka JavaDoc task for potential Maven deployment requirements
tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}
