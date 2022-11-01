load("@rules_java//java:defs.bzl", "java_library", "java_binary")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "java-maven-lib",
    srcs = glob(["src/main/java/com/demo/*.java"]),
    deps = [
      "@maven//:org_projectlombok_lombok",
      "@maven//:com_google_inject_guice",
      "@maven//:com_google_inject_extensions_guice_servlet",
      "@maven//:com_google_inject_extensions_guice_persist",
      "@maven//:aopalliance_aopalliance",
      "@maven//:org_eclipse_jetty_jetty_server",
      "@maven//:org_eclipse_jetty_jetty_servlet",
      "@maven//:org_eclipse_jetty_jetty_util",
      "@maven//:org_slf4j_slf4j_api",
      "@maven//:org_slf4j_slf4j_simple",
      "@maven//:javax_servlet_javax_servlet_api",
      "@maven//:javax_inject_javax_inject",
      "@maven//:jakarta_servlet_jakarta_servlet_api",
    ],
)

java_binary(
  name = "GuiceExample",
  main_class="com.demo.Example3",
  runtime_deps = [":java-maven-lib"],
)