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

    features {
        bitbucketCloudConnection {
            id = "PROJECT_EXT_2"
            displayName = "BitbucketConnectionBefore"
            key = "adfadf"
            clientSecret = "credentialsJSON:bfc95e8f-9fb6-4020-8903-3125cdcdd446"
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
