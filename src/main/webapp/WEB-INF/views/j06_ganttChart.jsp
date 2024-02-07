<!DOCTYPE html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>jQuery integration</title>
	<script src="https://code.jquery.com/jquery-1.7.1.min.js?v=8.0.6"></script>


   <script src="${path}/a00_com/gantt/codebase/dhtmlxgantt.js"></script>
   <link href="${path}/a00_com/gantt/codebase/dhtmlxgantt.css" rel="stylesheet">


	<script src="${path}/a00_com/gantt/common/testdata.js?v=8.0.6"></script>
	
	
	
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
<div class="mygantt" style='width:100%; height:100%;'></div>
<script>
	$(".mygantt").dhx_gantt({
		data: demo_tasks
	});
</script>
</body>