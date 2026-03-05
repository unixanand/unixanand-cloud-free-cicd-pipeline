pipelineJob('non-cloud-ci-cd') {

    description('Automated CI/CD pipeline for streamlit application')

    properties {
        disableConcurrentBuilds()
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/unixanand/unixanand-cloud-free-cicd-pipeline.git')
                    }
                    branch('*/main')
                }
            }
            scriptPath('Jenkins/Jenkinsfile')
            lightweight(true)
        }
    }

    triggers {
        githubPush()
    }
}
