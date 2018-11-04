#for each successfull build of that job, get the parameters that contains the expersions in their name and equlas to value
def jen = Jenkins.instance
def jobName = "myJob"
def job = jen.getItem(jobName)
String expression = "myExp"
String value = "myValue"
def builfdByResult = job.getBuilds().findAll{ it.getResult().toString() == "SUCCESS"}.each{
  println "********************"
  println it.getTime()
  println it.getAction(ParametersAction.class).getParameters().findAll { param -> param.name.contains(expression) && value.equals(param.value)}
}
