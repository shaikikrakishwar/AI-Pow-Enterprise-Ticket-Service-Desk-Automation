<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link rel="icon"
      type="image/png"
      href="images/favicon.png">
      <link rel="stylesheet"
href="css/style.css">

<title>AI Analytics Dashboard</title>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{

    min-height:100vh;

    background:linear-gradient(
        135deg,
        #1f4037,
        #3b5d50,
        #233329
    );

    color:white;

    padding:30px;
}

.backBtn{

    background:white;

    color:black;

    padding:10px 15px;

    border-radius:10px;

    text-decoration:none;

    font-weight:bold;
}

h1{

    text-align:center;

    margin:25px 0;
}

.container{

    display:grid;

    grid-template-columns:
    repeat(auto-fit,minmax(220px,1fr));

    gap:20px;
}

.card{

    background:
    rgba(255,255,255,0.1);

    padding:25px;

    border-radius:15px;

    text-align:center;

    backdrop-filter:blur(3px);
}

.number{

    font-size:35px;

    font-weight:bold;

    margin-top:10px;
}

.chart-container{

    margin-top:35px;

    display:grid;

    grid-template-columns:
    repeat(auto-fit,minmax(350px,450px));

    justify-content:center;

    gap:25px;
}

.chart-card{

    background:
    rgba(255,255,255,0.1);

    padding:20px;

    border-radius:15px;

    height:350px;
}

.chart-card h2{

    text-align:center;

    margin-bottom:10px;
}

canvas{

    background:white;

    border-radius:10px;

    padding:10px;

    max-width:100% !important;

    max-height:280px !important;
}

</style>

</head>

<body>

<a href="adminDashboard"
class="backBtn">

← Back to Admin Dashboard

</a>

<h1>

AI Analytics Dashboard

</h1>

<div class="container">

<div class="card">
<h2>Total Tickets</h2>
<div class="number">${totalTickets}</div>
</div>

<div class="card">
<h2>Open Tickets</h2>
<div class="number">${openTickets}</div>
</div>

<div class="card">
<h2>Closed Tickets</h2>
<div class="number">${closedTickets}</div>
</div>

<div class="card">
<h2>High Priority</h2>
<div class="number">${highPriority}</div>
</div>

<div class="card">
<h2>At Risk Tickets</h2>
<div class="number">${atRiskTickets}</div>
</div>

</div>

<div class="chart-container">

<div class="chart-card">
<h2>Status Distribution</h2>
<canvas id="statusChart"></canvas>
</div>

<div class="chart-card">
<h2>Ticket Overview</h2>
<canvas id="overviewChart"></canvas>
</div>

<div class="chart-card">
<h2>Category Distribution</h2>
<canvas id="categoryChart"></canvas>
</div>

<div class="chart-card">
<h2>Priority Distribution</h2>
<canvas id="priorityChart"></canvas>
</div>
<div class="card">

<h2>Older Than 3 Days</h2>

<div class="number">

${olderThan3Days}

</div>

</div>
<div class="chart-card">

<h2>Ticket Aging Report</h2>

<canvas id="agingChart"></canvas>

</div>

<div class="card">

<h2>Older Than 7 Days</h2>

<div class="number">

${olderThan7Days}

</div>

</div>

<div class="card">

<h2>Older Than 15 Days</h2>

<div class="number">

${olderThan15Days}

</div>

</div>

</div>

<script>

const openTickets =
${openTickets};

const closedTickets =
${closedTickets};

const highPriority =
${highPriority};

const atRiskTickets =
${atRiskTickets};

const networkCount =
${networkCount};

const softwareCount =
${softwareCount};

const hardwareCount =
${hardwareCount};

const accessCount =
${accessCount};

const highCount =
${highCount};

const mediumCount =
${mediumCount};

const lowCount =
${lowCount};

const olderThan3Days =
	${olderThan3Days};

	const olderThan7Days =
	${olderThan7Days};

	const olderThan15Days =
	${olderThan15Days};
/* Status Pie Chart */

new Chart(
document.getElementById(
'statusChart'),
{
type:'pie',

data:{
labels:[
'Open',
'Closed'
],

datasets:[{
data:[
openTickets,
closedTickets
]
}]
},

options:{
responsive:true,
maintainAspectRatio:false
}
});

/* Overview Bar Chart */

new Chart(
document.getElementById(
'overviewChart'),
{
type:'bar',

data:{
labels:[
'Open',
'Closed',
'High Priority',
'At Risk'
],

datasets:[{
label:'Tickets',

data:[
openTickets,
closedTickets,
highPriority,
atRiskTickets
]
}]
},

options:{
responsive:true,
maintainAspectRatio:false
}
});

/* Category Pie Chart */

new Chart(
document.getElementById(
'categoryChart'),
{
type:'pie',

data:{
labels:[
'NETWORK',
'SOFTWARE',
'HARDWARE',
'ACCESS'
],

datasets:[{
data:[
networkCount,
softwareCount,
hardwareCount,
accessCount
]
}]
},

options:{
responsive:true,
maintainAspectRatio:false
}
});

/* Priority Doughnut Chart */

new Chart(
document.getElementById(
'priorityChart'),
{
type:'doughnut',

data:{
labels:[
'HIGH',
'MEDIUM',
'LOW'
],

datasets:[{
data:[
highCount,
mediumCount,
lowCount
]
}]
},

options:{
responsive:true,
maintainAspectRatio:false
}
});
new Chart(
		document.getElementById(
		'agingChart'),
		{
		type:'bar',

		data:{
		labels:[
		'> 3 Days',
		'> 7 Days',
		'> 15 Days'
		],

		datasets:[{
		label:'Aging Tickets',

		data:[
		olderThan3Days,
		olderThan7Days,
		olderThan15Days
		]
		}]
		},

		options:{
		responsive:true,
		maintainAspectRatio:false
		}
		});

</script>

</body>
</html>