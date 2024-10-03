*Here you can find my first AQA project.*

** SetUp 
to setup it correctly you have to:
1. Have Jenkins installed locally on you PC.
2. Run docker-compose file in docker.
3. Run selenium/standalone-firefox:latest image by next command:
*   docker run -d -p 4444:4444 -p 7900:7900 --network myNetwork --name selenium-firefox --shm-size="2g" selenium/standalone-firefox:latest
5. Add local Jenkins and selenium-firefox in one network by next command:
- docker network connect jenkins selenium-firefox

** Update ip address in code:
Local IP address of the PC has been used to run tests. So it might be changed regarding PC and network where tests are running.
For now it should be chenged in next classes:
1. APITests.java - variable: baseUrl
2. LoginData.java - variable: loginUrl

** Run tests
1. Go to Jenkins by http://localhost:8080/
2. configure Jenkins
3. create job with ProjectUrl https://github.com/KateViter/course-work/
4. configure job
5. run job
6. check Allure Report

** Awailable test runs by next pom files:
1. clean test -Dsurefire.suiteXmlFiles=src/test/resources/AllTests.xml - to run all tests
2. clean test -Dsurefire.suiteXmlFiles=src/test/resources/APItests.xml - to run API tests
3. clean test -Dsurefire.suiteXmlFiles=src/test/resources/UITests.xml - to run UI tests

P.S. some settings, steps and configurations probably wasn't described. I'll update them later when find it ^_^
