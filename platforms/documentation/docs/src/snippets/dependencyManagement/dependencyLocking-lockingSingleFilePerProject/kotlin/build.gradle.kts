plugins {
    java
}

repositories {
    mavenCentral()
}

// tag::locking-file-name[]
val scalaVersion = "2.12"
dependencyLocking {
    lockFile = file("$projectDir/locking/gradle-${scalaVersion}.lockfile")
}
// end::locking-file-name[]

// tag::ignore-dependencies[]
dependencyLocking {
    ignoredDependencies.add("com.example:*")
}
// end::ignore-dependencies[]

// tag::locking-explicit[]
// tag::locking-single[]
configurations {
    compileClasspath {
        resolutionStrategy.activateDependencyLocking()
    }
// end::locking-single[]
    runtimeClasspath {
        resolutionStrategy.activateDependencyLocking()
    }
    annotationProcessor {
        resolutionStrategy.activateDependencyLocking()
    }
// tag::locking-single[]
}
// end::locking-single[]

dependencies {
    implementation("org.springframework:spring-beans:5.2.22")
    constraints {
        implementation("org.springframework:spring-webmvc:5.2.22")
        implementation("org.springframework:spring-web:5.2.22")
        implementation("org.springframework:spring-core:5.2.22")
        implementation("org.springframework:spring-expression:5.2.22")
        implementation("org.springframework:spring-context:5.2.22")
    }
}
// end::locking-explicit[]
