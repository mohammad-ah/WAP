$(document).ready(function(){

    $("#start").click(function(){

        function winner() {
            $("#status").text("You Win :)");
            $(".boundary").off("mouseenter");
            $("#maze").off("mouseleave");
            $(".boundary").addClass("win");
        }

        function loser() {
            $(".boundary").addClass("fail");
            $("#status").text("You Lose :(");
        }


        // reset
        $(".boundary").removeClass("fail");
        $(".boundary").removeClass("win");

        // start game
        $("#status").text("started.....");


        

        $(".boundary").on("mouseenter",function(){
           loser();
        });
        

        $("#maze").on("mouseleave",function(){
           loser();
        });

       

        $("#end").on("mouseenter",function(){
           winner();
        });

    });

});
