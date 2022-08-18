pipelineJob('DEVOPS/dotnet-example') {
    displayName('DEVOPS » dotnet-example')
    description('Build dotnet application ')

    parameters {
        string {
            name('BRANCH_NAME')
            defaultValue('main')
            description('Builds master branch by default')
        }
        booleanParam {
            name('CLEAN_WORKSPACE_POST_BUILD')
            defaultValue(false)
            description('Clean Workspace post-build?')
        }
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/vijwani/Jenkins-test.git')
                        credentials('github-verifyvalid')
                    }
                    branch('*/${BRANCH_NAME}')
                }
            }
            scriptPath('pipelines/dotnet-example.groovy')
        }
    }
}
