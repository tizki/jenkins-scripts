def jenkins = Jenkins.instance
def cps = jenkins.getComputers()
cps.each{ cp ->
  println "Node name: ${cp.getDisplayName()} OS: ${cp.getSystemProperties()['os.name']}, version: ${cp.getSystemProperties()['os.version']}"
}
cps[0].getSystemProperties().each {
  println it
}
