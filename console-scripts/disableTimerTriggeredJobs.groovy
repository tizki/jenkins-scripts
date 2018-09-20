/**
 *
 * This script disables all jobs that have TimerTrigger or PeriodicFolderTrigger (WorkflowMultiBranchProject)
 *
 * */
import jenkins.model.Jenkins
import hudson.model.*
import hudson.triggers.*
import com.cloudbees.hudson.plugins.folder.computed.PeriodicFolderTrigger

def items = Jenkins.instance.getAllItems()
items.each { item ->
    if(item.hasProperty('triggers')){
        item.triggers.values().each { trigger ->
            if(trigger instanceof TimerTrigger || trigger instanceof PeriodicFolderTrigger) {
                println "Disabling project with timer trigger: ${item.name}"
                item.setDisabled(true)
            }
        }
    }
}