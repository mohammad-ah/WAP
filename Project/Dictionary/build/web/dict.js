$(document).ready(function(){

    $("#search-submit").click(function () {
        search();
    });

    $("#searchbar_input").keyup(function(e){
        if(e.keyCode == 13)
        {
            search();
        }
    });

    $(document).on('click', '.relativBox', function () {
        search($(this).context.innerText)
    });

});

search = function (searchWord) {
    $("#title").empty();
    $("#title").append(`<h2>Search your word and click search button or press enter</h2>`);
    $("#definitions").empty();

    if(!searchWord){
        searchWord = $("#searchbar_input").val();
    }

    $.ajax({
        url: "search",
        method: 'GET',
        dataType: 'json',
        data: {'q': searchWord},
        success: (response) => {
            console.log(response);
            searchWord = searchWord.charAt(0).toUpperCase() + searchWord.substring(1).toLowerCase();

            if ("undefined" === typeof (response[searchWord])) {
                $("#definitions").append(`<p class="error">Word doesn't exist</p>`);
                $(".content").css('background-color', 'unset');
                return;
            } else {
                $("#definitions").append(`<p class=\"word\" id=\"word\">` + searchWord + `</p>\n` +
                    `<hr class=\"separator\">`);
            }

            $(".content").css('background-color', 'white');

            $.each(response[searchWord], function (index, value) {
                $("#definitions").append(`<p class=\"wordType\">` + parseInt(index + 1) + ' ' + value.wordtype + `</p>\n` +
                    `<p class=\"definition\">` + value.definition + `</p>`);
            });

            var counter = 0;

            $.each(response, function (index, value) {
                if(counter == 12)
                {
                    return;
                }
                if(searchWord !== index) {
                    $("#title").append(`<div class="relativBox">` + index + `</div>`);
                }
                counter++;
            });
        },
        error: (error) => {
            console.log(error);
        }
    });
}