import com.cloudbees.hudson.plugins.folder.computed.DefaultOrphanedItemStrategy

def className = org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject.class

//single job
def jobName = "myMultibranchJob"
def job = jenkins.model.Jenkins.instance.getItem(jobName)
updateJob(job)

//all jobs
//def allProjects =  jenkins.model.Jenkins.instance.getAllItems(className)
//allProjects.each { job -> updateJob(job) }

def updateJob(def job){
  println "updating job: ${job.getDisplayName()}"
  

  println "Before update"
  println "isAbortBuilds: ${job.getOrphanedItemStrategy().isAbortBuilds()}"
  println "isPruneDeadBranches: ${job.getOrphanedItemStrategy().isPruneDeadBranches()}"
  
  DefaultOrphanedItemStrategy defaultOrphanedItemStrategy = new DefaultOrphanedItemStrategy(true, null, null)
  defaultOrphanedItemStrategy.setAbortBuilds(true)
  job.setOrphanedItemStrategy(defaultOrphanedItemStrategy)
  
  println "After update"
  println "isAbortBuilds: ${job.getOrphanedItemStrategy().isAbortBuilds()}"
  println "isPruneDeadBranches: ${job.getOrphanedItemStrategy().isPruneDeadBranches()}"
}
