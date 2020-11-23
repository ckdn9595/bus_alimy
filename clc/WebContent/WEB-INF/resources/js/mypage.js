$(document).ready(function(){
	// Get the Sidebar
	var mySidebar = document.getElementById("mySidebar");
	
	// Get the DIV with overlay effect
	var overlayBg = document.getElementById("myOverlay");
	
	// Toggle between showing and hiding the sidebar, and add overlay effect
	function w3_open() {
	  if (mySidebar.style.display === 'block') {
	    mySidebar.style.display = 'none';
	    overlayBg.style.display = "none";
	  } else {
	    mySidebar.style.display = 'block';
	    overlayBg.style.display = "block";
	  }
	};
	
	// Close the sidebar with the close button
	function w3_close() {
	  mySidebar.style.display = "none";
	  overlayBg.style.display = "none";
	};
	
	$('#delbtn').click(function(){
		
		$('input').removeClass('w3-hide');
		$('#redelbtn').removeClass('w3-hide');
		$('#deletebtn').removeClass('w3-hide');
		$(this).addClass('w3-hide');
	});
	$('#redelbtn').click(function(){
		$('input').addClass('w3-hide');
		$('#delbtn').removeClass('w3-hide');
		$('#deletebtn').addClass('w3-hide');
		$(this).addClass('w3-hide');
	});
	$('#deletebtn').click(function(){
		var vv = $('input:checked').val();
		alert(vv);
		
	})
})