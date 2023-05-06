plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.12.5")
    implementation ("javax.ws.rs:javax.ws.rs-api:2.1")
    implementation ("org.glassfish.jersey.core:jersey-client:2.33")
    implementation ("org.glassfish.jersey.media:jersey-media-json-jackson:2.33")
    implementation ("org.springframework.boot:spring-boot-starter-web:2.6.0")
    implementation("junit:junit:4.13.1")
    testImplementation ("org.springframework.boot:spring-boot-starter-test:2.6.0")
    testImplementation ("junit:junit:4.13")
}

tasks.test {
    useJUnitPlatform()
}