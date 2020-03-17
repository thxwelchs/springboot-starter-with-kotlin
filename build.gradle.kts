import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
    kotlin("plugin.jpa") version "1.3.61"
    kotlin("kapt") version "1.3.61"
    idea
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}
allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

val querydslVersion = "4.2.1"
val swaggerVersion = "2.9.2"
val swaggerAnnotationVersion = "1.5.21"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter-security")

    // swagger
    implementation("io.springfox:springfox-swagger2:$swaggerVersion") {
        exclude("io.swagger:swagger-annotations")
        exclude("io.swagger:swagger-models")
    }
    implementation("io.springfox:springfox-swagger-ui:$swaggerVersion")
    // swagger ui 접속시 NumberFormatException 해결
    implementation("io.swagger:swagger-annotations:$swaggerAnnotationVersion")
    implementation("io.swagger:swagger-models:$swaggerAnnotationVersion")

    //query-dsl
    implementation("com.querydsl:querydsl-jpa:$querydslVersion")
    implementation("com.querydsl:querydsl-sql:$querydslVersion")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jpa")

    //logging
    implementation("io.github.microutils:kotlin-logging:1.7.6")

    // Hibernate5Module이 지연로딩 되는 객체의 프로퍼티 직렬화를 가능하게 해준다. (jackson ObjectMapper support)
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-hibernate5:2.9.8")

    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

// queryDSL Qclass 저장위치
idea {
    module {
        val kaptMain = file("$buildDir/generated/source/kapt/main")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
