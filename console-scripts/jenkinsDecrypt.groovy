//This script can be used in order to decrypt password from Jenkins' credentials.xml file
//The passwords in the file are hashed using Jenkins' key. In order to un-hash them:
// 1.Copy the required password
// 2. open Jenkins script console  http://your-jenkins/script
// 3. exectue the following code:
def ENCRYPTED_PASSWORD = "paste the password here"
println( hudson.util.Secret.decrypt("${ENCRYPTED_PASSWORD}") )
