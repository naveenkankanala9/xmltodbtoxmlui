$(document).ready(function() {
	$('#databaseTable').DataTable({
		select : {
			style : 'multi'
		}
	});

	$("#removeSelected").submit(function() {
		var ids = [];
		// replace 3 with column number with primary key
		$("#databaseTable tr.selected td:nth-child(3)").each(function() {
			ids.push($(this).text());
		});
		if (ids.length === 0) {
			return false;
		} else {
			$('#rows').val(ids);
			return true;
		}
	});
});