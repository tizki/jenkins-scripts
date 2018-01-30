#!/usr/bin/env bash
jobName=$1
jenkinsUrl=$2
if [ -z jobName ]; then
   echo "job name was not given. The script gets 2 parameters:\n  1. job name\n 2. Jenkins URL (default is localhost)"
   exit 1
fi
if [ -z $jenkinsUrl ]; then
  echo "Using default Jenkins URL"
  jenkinsUrl="http://localhost:8080"
fi
jsonResponse=$(curl -s -g  "$jenkinsUrl/job/$jobName/api/json?tree=builds[building]")
builds=$(echo $jsonResponse | jq '.builds | map(select(.building == true)) | length')
echo "There are currently $builds running builds of the job $jobName"