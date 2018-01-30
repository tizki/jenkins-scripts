/**
 * Created by tidhar on 1/24/18.
 * print the amount of test cases per test class
 */

def jenkins = Jenkins.instance
def jobName = "jobName"
def job = jenkins.getItem(jobName)
def buildNumber = 111
def bld = job.getBuildByNumber(buildNumber)
def map = [:]

bld.getAction(hudson.tasks.junit.TestResultAction.class).getResult().getChildren().each { pkg ->
    pkg.getChildren().each {  clazz ->
        def caseAmount = clazz.getChildren().size()
        map.put("${pkg.displayName}:${clazz.displayName}",caseAmount)
    }

}

sortedMap = map.sort{ it.value}
sortedMap.each { k,v ->
    println "${k}:${v}"
}
