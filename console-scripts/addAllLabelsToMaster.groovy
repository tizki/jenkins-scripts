/**
 *
 * This script add all existing labels to the master node
 *
 * */

def j = Jenkins.instance
def lables = j.labels

//filter labels by pattern (slave and agent0 are examples)
def filteredLabels = lables.findAll { label -> label.displayName.startsWith("slave") || label.displayName.contains("agent0") }

//filter specific labels (filtering master label and filterThisLabel label
def specificLabelsToFilter = [j.getLabel("master"), j.getLabel("filterThisLabel")]
filteredLabels.addAll(specificLabelsToFilter)
def labelsToAssign =  lables - filteredLabels
println "Assigins the following labels to the master node: ${labelsToAssign}"

def masterNode = j.getNode("master")
masterNode.setLabelString(labelsToAssign)
