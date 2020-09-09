<h1> Expenditure Calculator </h1>
<br/>
<ol> <h1>About:-</h1>
 <li>   
<p> In this task I created an API to give the:-
    <ol>
      <li> The Current Day Expense</li>
      <li> Last Seven Days Expense</li>
      <li> Last One Month Expense</li>
      <li> Last Three Months Expenses</li>
      <li> The Current Month Debit Expense</li>
      <li> The Current Month Credit Expense</li>
      <li> The Last Quarter Details</li>
     </ol>
</p>
</li>
<br/><br/>
<li>
<h1> Running The Project</h1>
<h3> Method 1</h3>
  <p> Export the project to eclipse and run the project </p>
<h3> Method 2</h3>
  <p> Download The Project and extract it to any folder
    <ul>
      <li>Open cmd in that folder</li>
      <li>Run the mvn clean command</li>
      <li>Run the mvn install command</li>
      <li>After this go to the target folder and copy the snapshot.jar file generated to the desktop</li>
      <li>Open cmd and change the directory to desktop and run the following command</li>
      <li><b> java -jar {jar-file-name} </li>
     </ul>
    <p>
        </li>
      <br/><br/>
  <li>
 <h1> REST API Documentation </h1>
        <p> After starting the project goto the following link:- <br/>
          <b> http://localhost:8080/SSM-TASK/v2/api-docs </b>
          </p>
    </li>
    <br/><br/>
   <li>
       <h1> Multi-Threading </h1>
       <ul>
         <li> Implemented Using CompletedFuture<T> </li>
         <li> Multi-Threading Configurated in the AsyncConfig.java file that specifies the number of threads required and the number of threads to be in the blocking queue etc. and finally Initailses the thread using ThreadPoolTaskExecutor. </li>
 </li>
 <br/><br/>
   <li>
  <h1> Dump Folder:- </h1>
    <p> It contains:- </p>
    <ul>
        <li> The database dump </li>
        <li> The Sample Images Of Threads Executing The Methods </li>
        <li> The sample Input and Output Image of the Api. </li>
    </ul>
    </li>
    </ol>
        
  
