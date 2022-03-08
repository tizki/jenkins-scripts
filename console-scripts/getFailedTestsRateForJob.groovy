def jenkins = Jenkins.instance
def jobName = "test.Backstage.UI.Docker"
def job = jenkins.getItem(jobName)
def buildNumber = 11981
//def bld = job.getBuildByNumber(buildNumber)
def blds = job.getBuilds()
def map = [:]

blds.each { bld ->
    if(Result.UNSTABLE.equals(bld.result)){
        bld.getAction(hudson.tasks.junit.TestResultAction.class)?.getResult().getFailedTests().each { test ->
            String testKey = "${test.className}.${test.name}"
            if(map.containsKey(testKey)){
                map[testKey]++
            }
            else{
                map[testKey]=1
            }
        }
    }
}
println map



