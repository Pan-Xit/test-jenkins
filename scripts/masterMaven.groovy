mavenJob('example') {
  preBuildSteps {
    remoteTrigger('my_host', 'pipeline_with_params') {
      parameters('jobName', 'jobName')
      blockBuildUntilComplete()
      shouldNotFailBuild(true)
    }
    shell("echo 'run before Maven'") 	
  }
}
