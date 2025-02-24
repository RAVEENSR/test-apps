--------------------------------------------------------------------
	JAX-RS security-check 1.0.0 Service
	Author : Sanjeewa Malalgoda
--------------------------------------------------------------------

Run Sample
==========

01. Run mvn clean install in /security-check directory
02. Then it will create security-check.war file. You need to deolpy it in application server.(cp target/security-check.war /home/sanjeewa/work/packs/wso2as-5.2.1/repository/deployment/server/webapps/security-check.war)
03. Create test case according to following request formats.
04. Then run the script and check output in response.


Requests should be send with following format:

HTTP GET - Read file (complete file path)
https://localhost:9443/security-check/directFile?fileName=repository/conf/axis2/axis2.xml

HTTP POST - Create file (complete file path)
https://localhost:9443/security-check/directFile?fileName=repository/conf/axis2/axis2.xml-dummy

HTTP DELETE - Delete file in Server (complete file path)
https://localhost:9443/security-check/directFile?fileName=repository/conf/axis2/axis2.xml-dummy

HTTP GET - Read file (file path from carbon server home)
https://localhost:9443/security-check/file?fileName=repository/conf/axis2/axis2.xml

HTTP POST - Create file (file path from carbon server home)
https://localhost:9443/security-check/file?fileName=repository/conf/axis2/axis2.xml-dummy

HTTP DELETE - Delete file in Server (file path from carbon server home)
https://localhost:9443/security-check/file?fileName=repository/conf/axis2/axis2.xml-dummy

HTTP GET - Read system property
https://localhost:9443/security-check/systemProperty/java.home

HTTP POST - Copy files in server using carbon Utility methods
https://localhost:9443/security-check/fileCopy?source=repository/conf/axis2/axis2.xml&destination=repository/conf/axis2/axis2.xml-dummy

HTTP POST - Delete files in server using carbon Utils
https://localhost:9443/security-check/fileDelete?path=repository/conf/axis2/axis2.xml_PT

HTTP POST - Get registryDBConfig as string
https://localhost:9443/security-check/registryDBConfig

HTTP POST - Get userManagerDBConfig config as string
https://localhost:9443/security-check/userManagerDBConfig

HTTP GET - Get network configs as string
https://localhost:9443/security-check/networkConfigs

HTTP GET - Get server configuration as string
https://localhost:9443/security-check/serverConfiguration

HTTP POST - Get network configs as string
https://localhost:9443/security-check/networkConfigs?hostName=test.org&mgtHostName=test1.org

HTTP POST - Generate OOM
https://localhost:9443/security-check/memory?operation=oom

HTTP POST - Generate high CPU
https://localhost:9443/security-check/memory?operation=cpu

HTTP POST - Generate system call
https://localhost:9443/security-check/memory?operation=kill
