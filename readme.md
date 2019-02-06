QA Challenge-
Requirements-
1. JDK 1.8
2. Maven 3.6.0
Steps to execute the tests.
1. Launch the cmd prompt
	cd <projectdirectory>
2. To execute Smoke Test Suite
	mvn -Psmoketest clean test
3. To execute Regression Test Suite
	mvn -Pregtest clean test
Access the Test Reports
<projectdirectory>\target\surefire-reports\html\index.html

