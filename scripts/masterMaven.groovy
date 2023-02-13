mavenJob('example') {
  environmentVariables {
    propertiesFile("scripts/test.properties")
  }
  
  preBuildSteps {
    remoteTrigger('my_host', 'pipeline_with_params') {
      parameter('param', 'test')
      blockBuildUntilComplete()
      shouldNotFailBuild(true)
    }
    shell("echo 'run before Maven'") 	
  }
}
