# cli-tool
-----------

## this CLI tool accepts a string and does the following to it:
- converts the string to uppercase and outputs it to stdout.
- converts the string to alternate upper and lower case and outputs it to stdout.
- creates a CSV file named "string.csv" in the "cli-tool" folder, from the string by making each character a column in the CSV format and then output "CSV created!" to stdout.

### Example: when the input: "hello world", we should see the following in stdout:
    HELLO WORLD
    hElLo wOrLd
    CSV created! 
    ...and a CSV file containing the following: h,e,l,l,o, ,w,o,r,l,d

## you can run the code in  2 ways:

## prequisites
- java 8 is installed on your machine
- docker or maven 3.x is installed on your maching

## 1.via maven
- clone this repo to your machine
- navigate to cli-tool folder 
- run the command "mvn clean install"
- now go to a CMD/CLI and run the command "java -jar cli-tool-1.0-SNAPSHOT-jar-with-dependencies.jar" 

## 2.via docker
- navigate to CMD/CLI 
- run command "docker pull vaibhavg12/cli-tool"
- run command "docker run -i -t vaibhavg12/cli-tool"
- this will run the docker image in interactive, enabling you to enter the string to be transformed
