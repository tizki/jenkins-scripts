# Enable CSRF Protection

1. Enable the CSRF protects either from Jenkins configuration or by using a script.
 see [Jenkins Wiki - CSRF Protection](https://wiki.jenkins.io/display/JENKINS/CSRF+Protection)
  
 2. Get the crumb token. you can get it with the following command: 
``` 
 wget -q --auth-no-challenge --user USERNAME --password PASSWORD --output-document \
 - 'http://localhost:8080/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,":",//crumb)'
 ```
 The answer would be:
 ```
 Jenkins-Crumb:<yourJenkinsCrumbToken>
 ```
 
 3. Get the API token for your user, by going to http://YOUR_JENKINS/YOUR_USERNAME/configure 
 
4. Use the token in your REST calls. for example, the following call get all builds of a job, 
and display the building attribute without CSRF Protection.
```aidl
curl -s -g  "YOUR_JENKINS/job/JOB_NAME/api/json?tree=builds[building]
```
When CSRF Protection is enabled, the command would be:
```aidl
curl -u "YOUR_USERNAME:API_TOKEN" -H "Jenkins-Crumb:<yourJenkinsCrumbToken>" \
-g "http://YOUR_JENKINS:8080/job/JOB_NAME/api/json?tree=builds[building]"
```


 