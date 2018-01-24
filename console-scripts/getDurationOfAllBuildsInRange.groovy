def jenkins = Jenkins.instance
def jobName = "jobName"
def job = jenkins.getItem(jobName)
def bldNumRange = 3241291..3241421
def map =[:]
bldNumRange.each{ num ->
    def bld = job.getBuildByNumber(num)
    map.put(bld, bld.duration)
}

// sort from shortest to longest
map = map.sort {it.value}
