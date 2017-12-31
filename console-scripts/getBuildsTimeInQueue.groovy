//The following script prints the time each build spent in the queue
def jenkins = Jenkins.instance
def jobName = PUT_YOUR_JOB_NAME
def job = jenkins.getItem(jobName)
def builds = job.getBuilds()
builds.each { build ->
    def action = build.getAction(jenkins.metrics.impl.TimeInQueueAction.class)
    def timeInQ = action.getQueuingDurationMillis()
    def totalTimeInQ
    if (timeInQ > 60000){
        totalTimeInQ = "${timeInQ / 60000} minutes"
    }
    else{
        totalTimeInQ = "${timeInQ / 1000} seconds"
    }
    println "${build.number} ${totalTimeInQ}"
}
