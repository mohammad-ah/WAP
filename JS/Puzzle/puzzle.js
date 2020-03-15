$(document).ready(function(){
    init();

    setMovablePieces();

    move();

    $("#shufflebutton").click(function(){

        $(".puzzlepiece").css('border', '5px solid black');
        $(".puzzlepiece").css('height', '90px');
        $(".puzzlepiece").css('width', '90px');

        var puzzleArea = document.getElementById('puzzlearea');
        var divs = puzzleArea.getElementsByTagName("div");

        for (var i=0; i< divs.length; i++) {


            var div = divs[i];
            if(i == 15)
            {
                break;
            }
            div.innerText = i + 1;
        }

        var timer = setInterval(shuffle,5);
        setTimeout(function(){
            clearTimeout(timer);
            shuffle();
            setMovablePieces();
        },500);

    });
});

init = function() {
    var puzzleArea = document.getElementById('puzzlearea');
    var divs = puzzleArea.getElementsByTagName("div");

    // initialize each piece
    for (var i=0; i< divs.length; i++) {


        var div = divs[i];

        // calculate x and y for this piece
        var x = ((i % 4) * 100) ;
        var y = (Math.floor(i / 4) * 100) ;

        div.style.left = x + 'px';
        div.style.top = y + 'px';


        if(i === 15) {
            div.className = "whiteBox";
            return;
        }

        // set basic style and background
        div.className = "puzzlepiece";

        div.style.backgroundImage = 'url("background.jpg")';
        div.style.backgroundPosition = -x + 'px ' + (-y) + 'px';

        // store x and y for later
        div.x = x;
        div.y = y;

        // console.log(div.innerText)
    }
};

setMovablePieces = function() {
    var whiteBoxLeft = parseInt($(".whiteBox").css("left"));
    var whiteBoxTop = parseInt($(".whiteBox").css("top"));
    var whiteBoxRight = parseInt($(".whiteBox").css("left")) + 100;
    var whiteBoxBottom = parseInt($(".whiteBox").css("top")) + 100;

    $("#puzzlearea div").each(function(idx){
        $(this).removeClass('movablepiece');
        // console.log(idx + ", " + parseInt($(this).css("left")) + "==" + whiteBoxLeft + ", " + (parseInt($(this).css("top"))) + "==" +  whiteBoxBottom);
        // console.log(idx + ", " + parseInt($(this).css("left")) + "==" + whiteBoxLeft + ", " + (parseInt($(this).css("top"))+100) + "==" +  whiteBoxTop);
        // console.log(idx + ", " + parseInt($(this).css("top")) + "==" + whiteBoxTop + ", " + (parseInt($(this).css("left"))+100) + "==" +  whiteBoxLeft);
        // console.log(idx + ", " + parseInt($(this).css("top")) + "==" + whiteBoxTop + ", " + (parseInt($(this).css("left"))) + "==" +  whiteBoxRight);

        if(parseInt($(this).css("top")) == whiteBoxTop && (parseInt($(this).css("left")) + 100) == whiteBoxLeft
        || parseInt($(this).css("top")) == whiteBoxTop && parseInt($(this).css("left")) == whiteBoxRight
        || parseInt($(this).css("left")) == whiteBoxLeft && parseInt($(this).css("top")) == whiteBoxBottom
        || parseInt($(this).css("left")) == whiteBoxLeft && (parseInt($(this).css("top")) + 100) == whiteBoxTop){
            $(this).addClass('movablepiece');
        }
    });
};

move = function() {
    $('#puzzlearea div').click(function () {
        if($(this).hasClass('movablepiece'))
        {
            var whiteBoxLeft = parseInt($(".whiteBox").css("left"));
            var whiteBoxTop = parseInt($(".whiteBox").css("top"));

            var pieceLeft = parseInt($(this).css("left"));
            var pieceTop = parseInt($(this).css("top"));

            $(this).css('left', whiteBoxLeft + 'px');
            $(this).css('top', whiteBoxTop + 'px');

            $('.whiteBox').css('left', pieceLeft + 'px');
            $('.whiteBox').css('top', pieceTop + 'px');

            setMovablePieces();

            checkWin();
        }
    })
};

checkWin = function() {
    var pass = true;
    $("#puzzlearea div").each(function(idx){

        // calculate x and y for this piece
        var x = ((idx % 4) * 100) ;
        var y = (Math.floor(idx / 4) * 100) ;

        console.log($(this).css('top') + ' == ' + y + 'px')
        console.log($(this).css('left') + ' == ' + x + 'px')

        if(parseInt($(this).css('top')) != y || parseInt($(this).css('left')) != x)
        {
            pass = false;
        }
    });

    if(pass)
    {
        $("#puzzlearea div").removeClass('movablepiece');
        $(".puzzlepiece").css('border', 'none');
        $(".puzzlepiece").css('height', '100px');
        $(".puzzlepiece").css('width', '100px');

        var puzzleArea = document.getElementById('puzzlearea');
        var divs = puzzleArea.getElementsByTagName("div");

        // initialize each piece
        for (var i=0; i< divs.length; i++) {


            var div = divs[i];
            div.innerText = "";
        }

    }
};


shuffle = function () {
    var arr = [];
    while(arr.length < 16){
        var r = Math.floor(Math.random() * 16);
        if(arr.indexOf(r) === -1) arr.push(r);
    }
    console.log(arr);

    var puzzleArea = document.getElementById('puzzlearea');
    var divs = puzzleArea.getElementsByTagName("div");

    // initialize each piece
    for (var i=0; i< divs.length; i++) {
        var div = divs[i];

        // calculate x and y for this piece
        var x = ((arr[i] % 4) * 100) ;
        var y = (Math.floor(arr[i] / 4) * 100) ;

        div.style.left = x + 'px';
        div.style.top = y + 'px';


        if(i === 15) {
            div.className = "whiteBox";
            return;
        }

        x = ((i % 4) * 100) ;
        y = (Math.floor(i / 4) * 100) ;

        // set basic style and background
        div.className = "puzzlepiece";

        div.style.backgroundImage = 'url("background.jpg")';
        div.style.backgroundPosition = -x + 'px ' + (-y) + 'px';

        // store x and y for later
        div.x = x;
        div.y = y;
    }

}