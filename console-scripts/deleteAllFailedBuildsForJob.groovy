/*
* Warning!
* This script will delete all failed builds!
* make sure that you delete the builds of the correct job
* In order to make it delete the builds, change the dryRun to false
*
* */

def jenkins = Jenkins.instance
def jobName = "jobName"
def job = jenkins.getItem(jobName)
def blds = job.getBuilds()
def dryRun = true

println "Total amount of builds for job ${jobName}: ${blds.size()}"

failedBuilds = blds.findAll { it.result == Result.FAILURE}

println "Total amount of failed builds for job ${jobName}: ${failedBuilds.size()}"
if(!dryRun) {
    println "Deleting all failed builds"
    failedBuilds.each { b ->
        b.delete()
    }
}
else{
    println "Dry run, not deleting builds"
}

blds = job.getBuilds()
println "Total amount of builds for job after deletion ${jobName}: ${blds.size()}"