# Mutation


Run This project at your end through mvn from command line.

Step 1 : mvn clean install
step 2 : mvn org.pitest:pitest-maven:mutationCoverage
===========================================================================

Unit Tests allows you to make big changes to code quickly.
You know it works now because you've run the tests,
when you make the changes you need to make, you need to get the tests working again.
This saves hours.

So now are the unit test coverage complete ? ,are they well written,does it ensure future code changes will be handled by your unit test ,
now that you can find through mutation testing.

Mutation Testing is a method of software testing where the source code gets modified step by step.
If there are no failing tests after a mutation to the code it is considered defective,
meaning that none of the existing tests detected the change to the source code,
which brings a possible risk to the application.


This project does the mutation test by using the Plugin only,and not at build time.

To perform mutation test at build time all the properties and tags related to PIT should be added in POM.xml

==========================================
Eclipse plugin : 


Visit page  : https://marketplace.eclipse.org/content/pitclipse

Find a install button ,drag drop that button in the eclipse .

Drag drop is a new feature called as market place client.

================================================
Points to remember : 

Follow the standard package structure of Maven.

src : main : java : package  = src : test : java : package

If the class name in the main is 
HelloWorld.java
The class name in the test should be
HelloWorldTest.java


=================================
Intellij Plugin : PIT mutation testing Idea plugin 


Visit page : https://plugins.jetbrains.com/plugin/?idea&pluginId=7119
Download the latest version ,as of feb-2016 it is 1.3.4. 
The fill will get downloaded as zip.

Now open Intellij and goto
File --> Setting --> plugins --> install from disk --> and point to downloaded zip file.

Thats all Intellij may ask to restart and you are done ,plugin gets installed.

Create a maven project,follow the pacakge structure and file name standard as mentioned above
Goto run --> edit configuration --> add a new configuration by clicking the "+" button
Provide the target classes as com.yourpackage.*
Rest src and target output comes filled.
Save it and run as PIT runner.

For more : http://blog.xebia.com/mutation-testing-how-good-are-your-unit-tests/

=============================================================
Exception and debugging.

All debugging has to be done through logs.
e.g :
Exception in thread "main" org.pitest.help.PitHelpError: All tests did not pass without mutation when calculating line coverage. Mutation testing requires a green suite.

Exception discussion : https://groups.google.com/forum/#!msg/pitusers/HdZN6H9s9p0/Fh6HK3VA-akJ
Debugging : Refer Logs at below location
<ProjectLocation>\target\test-output

===========================================
How to Run from Maven
Step 0 : Add below dependencies and maven plugin to your pom.xml ,and set your <targetClasses> and <targetTests>.
Step 1 : mvn clean install
step 2 : mvn org.pitest:pitest-maven:mutationCoverage

In Intellij use the Terminal dialog to execute the mvn commands.

For eclipse project you can go to the directory through command prompt and execute.

if Environment variable are not set for mvn
Just set it by referring below
https://maven.apache.org/install.html

1: JAVA_HOME : C:\Program Files (x86)\Java\jdk1.7.0_09\
2: PATH		: C:\apache-maven-3.3.9\bin

once these two variables are set in windows open cmd and check via command "mvn -v".
============================================
Sample pom.xml
------------------

    <dependencies>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
        <dependency>
            <groupId>org.pitest</groupId>
            <artifactId>pitest</artifactId>
            <version>1.1.4</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.pitest</groupId>
            <artifactId>pitest-maven</artifactId>
            <version>1.1.4</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.codehaus.plexus</groupId>
            <artifactId>plexus-utils</artifactId>
            <version>1.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>

    </dependencies>



    <build>
        <plugins>
        <plugin>
            <groupId>org.pitest</groupId>
            <artifactId>pitest-maven</artifactId>
            <version>1.1.4</version>
            <!-- Here you need to set the target classes <targetClasses>  <targetTests> will share same package-->
            <configuration>
                <historyInputFile>target/pitHistory.txt</historyInputFile>
                <historyOutputFile>target/pitHistory.txt</historyOutputFile>
                <targetClasses>
                    <param>com.Demo.*</param>
                </targetClasses>
                <targetTests>
                    <param>com.Demo.*</param>
                </targetTests>
                <outputFormats>
                    <outputFormat>XML</outputFormat>
                    <outputFormat>HTML</outputFormat>
                </outputFormats>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>org.pitest</groupId>
                    <artifactId>pitest</artifactId>
                    <version>1.1.4</version>
                </dependency>
                <dependency>
                    <groupId>org.pitest</groupId>
                    <artifactId>pitest-html-report</artifactId>
                    <version>1.1.4</version>
                </dependency>
                <dependency>
                    <groupId>org.pitest.quickbuilder</groupId>
                    <artifactId>quickbuilder</artifactId>
                    <version>1.2</version>
                </dependency>
                <dependency>
                    <groupId>org.apache.maven.shared</groupId>
                    <artifactId>maven-plugin-testing-harness</artifactId>
                    <version>1.1</version>
                </dependency>
                <dependency>
                    <groupId>org.apache.maven.shared</groupId>
                    <artifactId>maven-verifier</artifactId>
                    <version>1.3</version>
                </dependency>
                <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>4.11</version>
                </dependency>
            </dependencies>
        </plugin>
        </plugins>
    </build>


    </project>
