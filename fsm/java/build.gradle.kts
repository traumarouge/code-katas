plugins {
    application
}

application {
    mainClassName = "fsm.Main"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

version = "0.0.1-SNAPSHOT"

tasks.withType<JavaCompile> {
    with(options) {
        compilerArgs.add("-Xlint:deprecation")
        compilerArgs.add("-Xlint:unchecked")
        compilerArgs.add("-parameters")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = application.mainClassName
    }
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.1")
}