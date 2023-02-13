mavenJob('example') {
  preBuildSteps {
    remoteTrigger('my_host', 'pipeline_with_params') {
      parameterFile("${WORKSPACE}scripts/test.parameters")
      blockBuildUntilComplete()
      shouldNotFailBuild(true)
    }
    shell("echo 'run before Maven'") 	
  }
}
