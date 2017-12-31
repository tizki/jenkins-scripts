//prints all job names per jenkins throttle plugin category
import hudson.plugins.throttleconcurrents.*

jenkins = Jenkins.getInstance()
ThrottleJobProperty.DescriptorImpl descriptor = jenkins.getDescriptorByType(ThrottleJobProperty.DescriptorImpl.class)
categories = descriptor.getCategories()
propertiesMap =  descriptor.propertiesByCategory

propertiesMap.each { categoryName, subMap ->
  println "******** Name ${categoryName} ********"
  subMap.each {propertyName, value ->
    println ("         Job Name: ${propertyName.owner.name}")
}
}
