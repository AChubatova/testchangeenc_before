import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.bitbucketCloudConnection

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.1"

project {

    buildType(BuildConfig)
    buildType(ConfigAfter)

    template(Template_1)

    features {
        bitbucketCloudConnection {
            id = "PROJECT_EXT_2"
            displayName = "BitbucketConnectionBefore"
            key = "adfadf"
            clientSecret = "credentialsJSON:aea5f48f-9bb1-4ea3-9d00-bd8260b50dcf"
        }
    }
}

object BuildConfig : BuildType({
    name = "build config"

    params {
        password("par_before", "credentialsJSON:6ddc6bf1-b702-487c-a1be-4c270f20738c", label = "param_before")
    }

    vcs {
        root(DslContext.settingsRoot)
    }
})

object ConfigAfter : BuildType({
    name = "config_after"

    params {
        password("parAfter", "credentialsJSON:23fe38f4-6f2d-41e9-b5f0-d56f410bf391")
    }
})

object Template_1 : Template({
    id("Template")
    name = "template"

    params {
        password("template par", "credentialsJSON:04b27692-afbd-4555-90dc-050dd6689956")
    }
})
