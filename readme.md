Name: MilestonePlanner

Description
MilestonePlanner is a java web application that helps a user to create milestones with actual and completion date. On this application, a user can:
•	add a milestone, 
•	remove a milestone, 
•	edit a milestone, and can also 
•	share a milestone with another user of his choice

Requirement
This is a java-built web application using Maven in IntelliJ IDEA. To run this application successfully, you need the following tools: 
•	Tomcat 9.0.17 
•	IntelliJ IDE
•	H2 Database
•	Java SDK 11.0.3 (64-bit)

Usage
After checking that you have the tools mentioned above installed, then here is the process of the usage: 
	1.	Open your IntelliJ IDE
	2.	On your IDE, click Open then locate “Milestone Planner”. After opening, this takes time to load the application, and build the project as well as processing all the required dependencies and necessary files
	3.	Run your Tomcat 9.0.17 . This also takes time. It builds and check the resource files. So, wait until it completes the compilation successfully. Once it is done to build and deployment, the milestoneplanner:war explode which then launch the application in the browser. 
	4.	The user can then start to play around with the application. 
	5.	A new user requires to sign up first. After signing up successfully, the web loads a login page. Once the user logins successfully, he is taken to his dashboard with empty milestones. This user can then choose to add a milestone or more. 
	6.	This user can also choose to share his/her milestones. If so, he clicks on the share button, which then displays a link that the one he wants to share with can use to access his milestones. 
	7.	To use the shareable link, copy it, log out, and sign in as another user. Then paste the link you copied in a specified slot called “insert link”, and then click import. This takes you a list of shared milestones. 
	8.	Once user finishes using the application, he can choose to terminate the session by clicking the logout button. 

Support
In case you find any bug, or issue in our codes, please create a pull request. We will be happy to chat more and apply the feedback. 

Roadmap
This is the first phase of our application. In the near future, we are planning to include more features especially security related. We take care of our users’ information; thus, their data privacy and confidentiality are our number one priority.  Now, a user can login using his email and any password either be strong or not. However, in the second phase, we want to make it a requirement for a user to create strong password. Next, we need to include also a two-factor authentication option using SMS or call.  

Authors and acknowledgment
This application was built by a team of three ALC Students: Yonas Chapi, Faouzi Jedidi, and Heritier Muhire. 
We would like to appreciate the consistency support of our module leader, Katrin. She helps us with additional notes, guidance, and resources to complete this coursework. We also appreciate, Mr Tabot, our facilitator for consistency follow-up and guidance in the time we were working on this project. 


