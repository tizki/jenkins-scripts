def jenkins = Jenkins.instance

long hourInMillis = 3600000
long dayInMillis = hourInMillis*24
long halfHourIInMillis = 1800000
long quarterHourIInMillis = 900000

def labelName = "myLabel"
def label = jenkins.getLabel(labelName)

def getBuildsForLabelInTimeFrame(String label, long startTime, long endTime){
  label.nodes.each{
    def node = it
    println "******* ${node.getDisplayName()} ********"
    def blds = job.getBuilds().byTimestamp(startTime,endTime).node(node)
    println "amount: ${blds.size()}, ${blds}"
  }
}

//get builds of a job that run at the hour before a specific build started
def jobName = "myJob"
def bldNum = 123
def job = jenkins.getItem(jobName)
def bld = job.getBuildByNumber(bldNum)
long endTime =  bld.getTimeInMillis()
long startTime = endTime-hourInMillis

getBuildsForLabelInTimeFrame(label, startTime, endTime)

//get builds of a job that ran in the last half an hour
endTime = new Date().getTime()
startTime = endTime - halfHourIInMillis
getBuildsForLabelInTimeFrame(label, startTime, endTime)


println "***************** END ************************"
