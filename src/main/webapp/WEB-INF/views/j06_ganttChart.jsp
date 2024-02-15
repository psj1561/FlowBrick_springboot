
<!DOCTYPE html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>Basic initialization</title>
   <script src="${path}/a00_com/gantt/codebase/dhtmlxgantt.js"></script>
   <link href="${path}/a00_com/gantt/codebase/dhtmlxgantt.css" rel="stylesheet">
	<style>
		html, body {
			height: 100%;
			padding: 0px;
			margin: 0px;
			overflow: hidden;
		}
	</style>
</head>
<body>
	<div id="gantt_here" style='width:100%; height:100%;'></div>
	
	<script>
		gantt.config.date_format = "%d-%m-%Y";
		gantt.init("gantt_here");
		
		
		gantt.load("http://localhost:2222/getGanttChart.do", "json")
		var dp = new gantt.dataProcessor("apiUrl");
		dp.init(gantt);
		dp.setTransactionMode("REST");
		dp.deleteAfterConfirmation = true;
		
		
		/*
		var xhr = gantt.ajax;
		xhr.get("http://localhost:2222/getGanttTask.do").then(function(response_tasks) {
		    var gantttasks = JSON.parse(response_tasks.responseText); 
			console.log(gantttasks)
			xhr.get("http://localhost:2222/getGanttLinks.do").then(function(response_links) {
				var ganttlinks = JSON.parse(response_links.responseText); 
				console.log(ganttlinks)
				
				var finalparse={"tasks":gantttasks,"links":ganttlinks};
				console.log(finalparse)
				
				gantt.parse(finalparse)
			})
		});
		*/
		
		
		gantt.attachEvent("onBeforeTaskAdd", function(id,task){
		    task.sortorder = 0;
		    return true;
		});
		
		
		gantt.config.columns=[
		    {name:"text",       label:"Task name",  width:'*' },
		    {name:"start_date", label:"Start time",align: "center" , width:'*'},
		    {name:"duration",   label:"Duration",  align: "center" , width:'*'},
		    {name:"teamname",   label:"Team name", align: "center" , width:'*'},
		    {name:"add",        label:"" }
		];
		
		
		
		/*
		gantt.parse({
			data: [
				{ id: 1, text: "Project #2", start_date: "01-04-2023", duration: 18, teamname:"team1", progress: 0.4, open: true },
				{ id: 2, text: "Task #1", start_date: "02-04-2023", duration: 8, teamname:"team2", progress: 0.6, parent: 1 },
				{ id: 3, text: "Task #2", start_date: "11-04-2023", duration: 8, teamname:"team3", progress: 0.6, parent: 1 },
				{ id: 4, text: "Project #8", start_date: "11-04-2023", duration: 12, teamname:"team4", progress: 1.0, open: true}
			],
			links: [
				{id: 1, source: 1, target: 2, type: "0"},
				{id: 2, source: 2, target: 3, type: "0"},
				{id: 3, source: 3, target: 4, type: "0"}
			]
		});
		*/
		

		//gantt.selectTask("2"); // it doesn't open the lightbox for detail but just highlight the selected task.
		

		/*
		var taskId = gantt.addTask({ // it's different to createTask. Because it doesn't show up lightbox but directively add the task. 
		    id:11,
		    text:"Task #55",
		    start_date:"03-04-2023",
		    duration:12,
		    teamname:"team5"
		}); //, "project_2", 0 is omitted at the last part.
		//<"project_2" is optional, the parent's id> and <0 is optional, the position the task will be added into (0 or greater)>

		
		
		var taskId = gantt.createTask({ // it's different to addTask. Because it show up lightbox but addTask doesn't.
		    id:10,
		    text:"Task #5",
		    start_date:"02-09-2023",
		    duration:28,
		    teamname:"jangjang"
		}); //, "project_2", 0 is omitted at the last part.
		//<"project_2" is optional, the parent's id> and <0 is optional, the position the task will be added into (0 or greater)>
		*/
		

		
	</script>
</body>