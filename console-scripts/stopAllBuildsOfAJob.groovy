/**
 * This scripts stop all running builds of a specific job
 */

def jenkins = Jenkins.instance
def jobName = "myJob"

def job = jenkins.getItemByFullName(jobName)
for (build in job.builds) {
    if (!build.isBuilding()) { continue; }
    println "going to stop ${build}"
    build.doStop();
}