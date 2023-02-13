mavenJob('example') {
  parameters {
    stringParam('WORKSPACE_PATH', "${WORKSPACE}")
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
