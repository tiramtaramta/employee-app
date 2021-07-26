import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	kotlin("plugin.jpa") version "1.5.10"
	kotlin("plugin.allopen") version "1.5.10"
	kotlin("kapt") version "1.2.71"
	id("com.google.protobuf") version "0.8.16"
}

allOpen {
	annotation("org.springframework.ws.server.endpoint.annotation.Endpoint")
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		"classpath"(group = "com.google.protobuf", name = "protobuf-gradle-plugin", version = "0.8.16")
	}
}

repositories {
	mavenCentral()
}

sourceSets {
	main {
		java {
			setSrcDirs(listOf("src/main/java","build/generated/source/proto/main/java"))
		}
	}
}

dependencies {
	implementation("org.apache.cxf:cxf-spring-boot-starter-jaxws:3.4.4")
	implementation("org.glassfish.main.javaee-api:javax.jws:3.1.2.2")
	implementation("javax.xml.bind:jaxb-api:2.3.1")
	implementation("org.glassfish.jaxb:jaxb-runtime:3.0.1")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	implementation("org.springframework.boot:spring-boot-starter-amqp")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.google.protobuf:protobuf-java:3.17.3")

	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("io.springfox:springfox-swagger-ui:3.0.0")
	implementation("io.springfox:springfox-swagger2:3.0.0")
	implementation("org.springdoc:springdoc-openapi-ui:1.5.0")
	implementation("org.springdoc:springdoc-openapi-data-rest:1.5.0")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.5.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	kapt("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

springBoot {
	mainClass to "com.example.employees.EmployeeApplication"
}
