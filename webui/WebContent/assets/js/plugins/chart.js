var wf_graph,waterflow;

$(document).ready(function(){
	initializeGraph();
	loadInitialData();
	setInterval(fetchData,5000);
});
function parseDate(time){
	var t = time.split(" ");
	var p = t[0].split("/");
	var q = t[1].split(":");
	var res = Date.UTC(p[2],p[1]-1,p[0],q[0],q[1],q[2]);
	return res;
}

function plotData(data){
	if( data.type == "plotData"){
		loadInitialData(data.data);
	}
}

function loadInitialData(){
	$.post('retrieve',function(data,status){
		var json = JSON.parse(data);
		plotDataTH_P(json.data);
	});
}

function plotDataTH_P(data) {
    waterflow = wf_graph.series[0];
    
    var tD=[];
	var time;
	
	if(data != undefined){
		for(var i=0;i<data.length;i++){
			time = parseDate(data[i].time);
			tD.push([time,parseFloat(data[i].value)]);
		}
		
	}
	
	waterflow.setData(tD);
	
}

function fetchData(){
	$.post('fetchData',function(data,status){
		var dt = JSON.parse(data);
		updateGraphs(dt);
	});
}

function updateGraphs(data){
	console.log(data);
	console.log(waterflow.data[waterflow.data.length-1].x);
	if(data!=undefined){
		var time = parseDate(data.time);
		console.log(time);
		if(waterflow.data[waterflow.data.length-1].x != time ){
			waterflow.addPoint( [time, parseFloat(data.value) ] );
			wf_graph.redraw();	
		}
		else console.log("same data");
		
	}
}


function initializeGraph(){
		
		if( wf_graph == undefined )
			wf_graph = Highcharts.stockChart('waterflowGraph', {
				 
			    rangeSelector: {
			        buttons: [{
			            count: 10,
			            type: 'minute',
			            text: '10M'
			        }, {
			            count: 20,
			            type: 'minute',
			            text: '20M'
			        }, {
			            type: 'all',
			            text: 'All'
			        }],
			        inputEnabled: true
			    },
			    title: {
			        text: 'Water Flow Rate'
			    },
			    credits:{
			    	enabled: false
			    },

			    exporting: {
			        enabled: true
			    },
			    
			    legend: {
			    	enabled: true,
			    	backgroundColor: '#DFE4E7',
			    	itemHoverStyle: {
			            color: '#FF0000'
			        }
			    },
			    tooltip: {
			        pointFormat: '<span style="color:black">{series.name}</span>: <b>{point.y:.2f}</b>'
			    },
			    xAxis: {
			    	title: { 
			    		text: "Time",
			    		align: "middle"
			    	},
			    	
			    },
			    yAxis: [{ 
			    	title: { 
			    		text: "Water Flow Rate (in litres/min)",
			    		align: "middle"
			    	},
			    	labels :{
			    		format: '{value}'
			    	},
			    	lineWidth: 2,  
			        min: 0,
			        offset: 2,
			        tickWidth: 1,
			        opposite: false
			    }]
			    ,
			    series: [{
			    	yAxis: 0,
			        name: 'Water Flow Rate (in litres/minute)',
			        color: '#FF0000',
			        lineWidth: 1,
			        	
			    }]
			});
}
