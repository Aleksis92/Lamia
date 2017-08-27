
$("document").ready(function(){
        $("#button-window-autorization").click(function(){
        	$("#wrap").css("display", "block");
			$("#window").css("display", "block");
    });   
        $("#wrap").click(function(){
        	$("#wrap").css("display", "none");
			$("#window").css("display", "none");
    });  
})