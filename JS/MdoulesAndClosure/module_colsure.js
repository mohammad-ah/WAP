window.onload = function () {
    var textArea = document.getElementById("textArea");
    var accountInfoList = [];
    var newAccount;

    document.getElementById("form").onsubmit = function () {
        newAccount = account();
        newAccount.addAccount();
        accountInfoList.push(newAccount);

        var accounts = "";
        for (var i = 0; i < accountInfoList.length; i++) {
            accounts += accountInfoList[i].value() + "\n";
        }
        textArea.value = accounts;
        document.getElementById("form").reset();
        return false;
    }
}


var account = (function() {
    var name = "";
    var deposit = 0;

    return {
        addAccount: function() {
            name = document.getElementById("accountName").value;
            deposit = document.getElementById("deposit").value;
        },
        value: function () {
            return "Account name: " + name + " Balance: " + deposit;
        }
    }
});

var timer = null;
var rubyTimer = (function () {
    if (timer == null) {
        timer = setInterval(rudy, 1000);
    } else {
        clearInterval(timer);
        timer = null;
    }

    function rudy() {
        document.getElementById("output").innerHTML += " Rudy!";
    }
});