load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "4.2"
RULES_JVM_EXTERNAL_SHA = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
maven_install(
    artifacts = [
      "org.projectlombok:lombok:1.18.24",
      "com.google.inject:guice:5.1.0",
      "com.google.inject.extensions:guice-servlet:5.1.0",
      "com.google.inject.extensions:guice-persist:5.0.1",
      "junit:junit:4.13.2",
      "org.slf4j:slf4j-api:2.0.3",
      "org.slf4j:slf4j-simple:2.0.3",
      "org.mockito:mockito-core:4.8.0",
      "aopalliance:aopalliance:1.0",
      "org.eclipse.jetty:jetty-server:11.0.7",
      "org.eclipse.jetty:jetty-servlet:11.0.7",
      "org.eclipse.jetty:jetty-util:11.0.7",
      "javax.servlet:javax.servlet-api:4.0.1",
      "javax.inject:javax.inject:1",
      "jakarta.servlet:jakarta.servlet-api:5.0.0",
    ],
    repositories = [
        "https://repo.maven.apache.org/maven2/",
        "https://maven.google.com",
    ],
)