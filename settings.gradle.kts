

plugins {
    id("com.gradle.enterprise") version("3.15.1")
}

gradleEnterprise {
    if (System.getenv("CI") != null) {
        buildScan {
            publishAlways()
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            termsOfServiceAgree = "yes"
        }
    }
}



rootProject.name = "sew9-2324-worttrainer-DanielLengsteiner"

