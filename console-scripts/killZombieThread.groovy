//Kills a zombie build thread by finishing the executor
def comp = Jenkins.instance.getComputer(computerName)
//print all executors
comp.getExecutors()..each{
    println it
}

//kill with condition (for example executor with number == 1 
comp.getExecutors().findAll{ it.number == 1}.each{
    it.finish2()
}
