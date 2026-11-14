import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.language.jvm.tasks.ProcessResources
import java.time.LocalDate

plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>().configureEach {
    options.encoding = "UTF-8"
}

tasks.withType<ProcessResources>().configureEach {
    filteringCharset = "UTF-8"
}

// --- генерация build-info.txt ---

val generatedResourcesDir = layout.buildDirectory.dir("generated/resources/main")

sourceSets {
    main {
        resources {
            srcDir(generatedResourcesDir)
        }
    }
}

val generateBuildInfo by tasks.registering {
    group = "build"
    description = "Генерация build-info.txt с версией и датой сборки"

    outputs.dir(generatedResourcesDir)
    outputs.upToDateWhen { false }

    doLast {
        val outDir = generatedResourcesDir.get().asFile
        outDir.mkdirs()
        val file = File(outDir, "build-info.txt")
        val date = LocalDate.now().toString()
        file.writeText("Version: ${project.version}\nBuild date: $date\n")
    }
}

tasks.named<ProcessResources>("processResources") {
    dependsOn(generateBuildInfo)
}