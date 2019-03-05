# actiplanner
Final Project for CSIS 3475 (data structures and algorithms).

Actiplanner is a fitness planner which helps users to plan for indoor and outdoor activities. The planner suggests some activities to the users based on the weather data of the day, which helps users to make more realistic activity plans. The users are able to make their own plans for five days in advance with the suggested activities by the planner.<br />
Actiplanner retrieves json weather data from API called "OpenWeatherMap". Retrieved json data is decoded to java format so that the planner can give some suggestions to it's users based on the accurate weather data. 

<h6>Algorithms used (Project Requirements)</h6>
<table>
  <tr>
    <th>Algorithm</th>
    <th>Description</th>
  </tr>
    <td>Socket/Network</td>
    <td>To send the weather data from server to client.</td>
  <tr>
    <td>Binary Search Tree</td>
    <td>To search for the coolest and warmest temperature and to get data on the specific data for recommendation.</td>
  </tr>
    <td>QuickSort</td>
    <td>To sort data by temperature.</td>
  <tr>
    <td>File Handling</td>
    <td>To read json string and convert to the java object in the application.</td>
  </tr>
  <tr>
    <td>Linked List</td>
    <td>To store activity data in a linked list.</td>
  </tr>
</table>
