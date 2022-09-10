# JIRA RESTAssured

## General Information

Point 1- Installed the latest version of Jira that is 9.x 
Point 2- I was facing issue because it said that supported a specific version of the JVM but I had a updated version of JVM that was 11 but installed JIRA supported 8 so I had to change files to run it that I found it from the online portal 
Point 3- Applying the changes in some environmental file I could see that I was not able to successfully launch jira when I was trying to write startup.sh 
Point 4-Thereafter I spend time because my Jenkins server was running on the port 8080 and assume that was the default port to run JIRA too 
Point 5- finally after trying all hacks and reading all the documents to rectify, I had to drop the idea of installing 9 and my final Resort was installing one version down and I installed 8.2 
Point 6- Create an account into the Jira successfully as well 
Point 7- Tried Authenticating via Basic Auth but did n work 
Point 8-Finally after lot of head spinning and grasping the atlasssian docs  
Authentication did work with Cookie authentication using basic username and password 

This framework applies the page Object Model to automation the WEB UI.
Its a one stop solution if you are looking out for a readymade solution for Behaviorial driven Cucumber Maven based framework.

## Technologies Used
-Maven
-RestAssured
-Junit


## Features
ometimes it is kinda confusing as I had to circle around trying authentication types like Cookie and Basic Auth as some docs mentioned that Cookie Authentication is not supported in latest versions.

For me Cookie Authentication did work well with POSTMAN 
JIRA StandAlone software

In case u have Jenkins and JIRA running in same port 
It does not really matter changing ports as the service u want u can start and fetch from same port http://localhost:8080

Links that can help are below



## Setup
Create a maven project in your IDE and import the project 
The POM.xml has all necessary jars and have customisable versions to run the project 

## Links
API Token (for basic Auth) : https://id.atlassian.com/manage-profile/security/api-tokens
Cookie based authentication : https://developer.atlassian.com/server/jira/platform/cookie-based-authentication/
Base 64 URL : https://easy64.org/
JIRA API’s : https://docs.atlassian.com/software/jira/docs/api/REST/8.22.6/#worklog-getWorklogsForIds
JIRA REST API’s : https://developer.atlassian.com/server/jira/platform/rest-apis/
Latest top 7 problems with JIRA : https://community.atlassian.com/t5/Jira-articles/Top-7-problems-in-your-Jira-issues-that-seriously-reduce-your/ba-p/1038259

Mnemonic to verify API’s : https://www.soldevelo.com/blog/top-7-problems-in-jira-issues-that-seriously-reduce-your-teams-effectiveness/
If u want read more on API:  https://youintechnology.com/10-crucial-facts-about-api/
POISED



## Project Status
Project is: _complete_ for API dry run Automation.


## Acknowledgements
Give credit here.

- Many thanks to...
- This project makes use of JIRA Open source API


## Contact
Created by Chinzaa - feel free to contact me!


