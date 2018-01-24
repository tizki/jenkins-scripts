def jenkins = Jenkins.instance
def jobName = "myJob"
def bldNum = 123
def job = jenkins.getItem(jobName)
def bld = job.getBuildByNumber(bldNum)

long hourIInMillis = 3600000
long halfHourIInMillis = 1800000
long quarterHourIInMillis = 900000
long endTime =  bld.getTimeInMillis()
long startTime = endTime-halfHourIInMillis
jenkins.getComputers().each{
    def node = it.getNode()
    println "******* ${node.getDisplayName()} ********"
    println job.getBuilds().byTimestamp(startTime,endTime).node(node)
}

