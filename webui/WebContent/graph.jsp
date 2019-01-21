<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Graph Showing Real-Time Flow Rate</title>

<link href="assets/css/graphs.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/stock/modules/export-data.js"></script>

<script type="text/javascript">
function check() {
    document.getElementById("myCheck").checked = true;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
      /* alert("Okay");*/
      }
    };
    xhttp.open("GET", "new_test.jsp?op=1", true);
    xhttp.send();
}

function uncheck() {
    document.getElementById("myCheck").checked = false;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
    	  /*alert("Okay");*/
      }
    };
    xhttp.open("GET", "new_test.jsp?op=2", true);
    xhttp.send();
 
}


var timeout = setInterval(reloadChat, 0500);    
function reloadChat () {

     $('#textshow').load('water_reading.jsp');
}

var timeout1 = setInterval(reloadChat1, 0500);    
function reloadChat1 () {

     $('#textshow1').load('level_sensor.jsp');
}

var timeout2 = setInterval(reloadChat2, 0500);    
function reloadChat2 () {

     $('#textshow2').load('total_volume.jsp');
}
</script>

</head>
<body>



<div id="flowrate1">
<div id="t1"><h2>Water Meter Sensor Reading</h2> (In Litres/minutes)
</div>
<hr>
<div id="textshow" align="Right" class="text1"></div>

</div>

<div id="flowrate2">
<div id="t1"><h2>Level Indicator Sensor Reading </h2> (In Centimeters)
</div>
<hr>
<div id="textshow1" align="Right" class="text1"></div>
</div>


<div id="flowrate3">
<div id="t1"><h2>Motor Switch ON/OFF</h2> (Depending upon level)
</div>
<hr>

</div> 

<div id="flowrate4">
<div id="t1"><h2>Total Volume of Water</h2> (In Litres) 
<hr>
<div id="textshow2" align="Right" class="text1"></div>
</div>

</div>

<div id="waterflowGraph">

</div>


<div id="toggles">
<input type="checkbox" id="myCheck" class="button1">
<button class="button1" onclick="check()">ON</button>
<button class="button1" onclick="uncheck()">OFF</button>
</div>
<script src="assets/js/plugins/chart.js"></script>
</body>
</html>