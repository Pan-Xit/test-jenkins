mavenJob('example') {
  preBuildSteps {
    remoteTrigger('my_host', 'pipeline_with_params') {
      parameterFile("scripts/test.parameters")
      blockBuildUntilComplete()
      shouldNotFailBuild(true)
    }
    shell("echo 'run before Maven'") 	
  }
}
