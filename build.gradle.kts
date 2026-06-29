plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ksp)
    alias(libs.plugins.micronaut.minimal.library)
}


java {
    toolchain { languageVersion = JavaLanguageVersion.of(25) }
    withSourcesJar()
}

kotlin {
    jvmToolchain(25)
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(platform(libs.kotlin.bom))
    api(platform(libs.kotlinx.coroutines.bom))
    api(platform(libs.micronaut.bom))
    api(libs.micronaut.kotlin.runtime)
    api(libs.micronaut.serde.jackson)
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    ksp(libs.micronaut.serde.processor)


    compileOnly("io.papermc.paper:paper-api:${libs.versions.paper.get()}")

    api(libs.kotlinx.coroutines.core)
    api("com.fasterxml.jackson.module:jackson-module-kotlin")

    api(libs.cloud.core)
    api(libs.cloud.annotations)
    api(libs.cloud.kotlin.coroutines)
    api(libs.cloud.kotlin.coroutines.annotations)
    api(libs.cloud.kotlin.extensions)
    api(libs.cloud.paper)
}