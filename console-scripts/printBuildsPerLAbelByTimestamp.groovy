def jenkins = Jenkins.instance
def jobName = "myJob"
def labelName = "myLabel"
def bldNum = 123
def label = jenkins.getLabel(labelName)

def job = jenkins.getItem(jobName)
def bld = job.getBuildByNumber(bldNum)
long hourIInMillis = 3600000
long dayInMillis = hourIInMillis * 2
long halfHourIInMillis = 1800000
long quarterHourIInMillis = 900000
def endTime =  bld.getTimeInMillis()
long startTime = endTime-dayInMillis
label.nodes.each{
  def node = it
  println "******* ${node.getDisplayName()} ********"
  def blds = job.getBuilds().byTimestamp(startTime,endTime).node(node)
  println "amount: ${blds.size()}, ${blds}"
}

println "***************** END ************************"
