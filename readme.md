## Steps To SetUp the Project.

1. Clone the repository into a folder .
2. Open the project in eclipse .
3. In the DataBaseConnection.java file inside the constructor change the , username and password for the database and set your it according to your DB username and password.

**Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pill_reminder?user=your_user_name&password=your_db_password");**

4. Make use of the DB folder inside the repository to import the database . 

5. open Command Prompt inside the project directory and Run the command : **npm i** (requires nodeJS)
which will download all the node dependencies.

download  nodeJS from here [nodeJS](https://nodejs.org/en/download/)

6. Update the project by : 
right click on project name ->Maven->Update Project 

7. Run the project in the eclipse .

8. The Web App is up and running ....

