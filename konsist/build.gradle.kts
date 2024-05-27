plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation(libs.konsist)
    testImplementation(platform(libs.kotest.bom))
    testImplementation(libs.kotest)
    testImplementation(platform(libs.junit.jupiter.bom))
    testImplementation(libs.junit.jupiter.api)

    testRuntimeOnly(libs.junit.jupiter.engine)
}
