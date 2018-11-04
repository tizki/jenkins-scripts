/**
 *
 * This script disables all jobs with SCM trigger
 *
 * */
import jenkins.model.Jenkins
import hudson.model.*
import hudson.triggers.*

def items = Jenkins.instance.getAllItems()
items.each { item ->
    if(item.hasProperty('triggers')){
        item.triggers.values().each { trigger ->
            if(trigger instanceof SCMTrigger) {
                println "Disabling project with SCM trigger: ${item.name}"
                item.setDisabled(true)
            }
        }
    }
}
