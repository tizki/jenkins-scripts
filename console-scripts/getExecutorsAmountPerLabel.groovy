/**
 * Created by tidhar on 1/24/18.
 * prints the amount of executors for each node with a specific label
 */

def jenkins = Jenkins.instance
def labelName = "myLabel"
def label = jenkins.getLabel(labelName)
int total = 0
def nodeNames = []
label.nodes.each{
    def node = it
    def amount = node.getNumExecutors()
    nodeNames.add(node.getDisplayName())
    println "******* ${node.getDisplayName()} ${amount}********"
    total += amount
}

println "Total executors for label ${labelName}: ${total}"
