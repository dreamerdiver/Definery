/**
 * Project: Definery
 * Class: submitVote.js
 * Created by Meesh
 * 11/21/15
 */

(function init() {
    "use strict";
    var btn = document.getElementById("voteHitbox");
    btn.onclick = addVote;
    loadTasks();
}());

function addVote() {
    "use strict";
    var currentVote = document.getElementById("voteCount").value;
    var upVotedValue = currentVote + 1;

    //update the db
    "use strict";
    var xhr = new XMLHttpRequest();
    xhr.open("post", "insert.php");
    //callback
    xhr.onreadystatechange = function() {
        if(xhr.readyState==4) {
            addTaskToUI(xhr.responseText, upVotedValue);
        }
    };
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send("desc=" + upVotedValue);
}


function addTaskToUI(id, description) {
    "use strict";
    var taskList = document.getElementById("tasks"); //ui element
    var li = document.createElement("li");
    li.id = id;
    li.appendChild(document.createTextNode(description));

    var deleteButton = document.createElement("input");
    deleteButton.type="button";
    deleteButton.value = "delete";
    deleteButton.onclick = function() {
        //update the ui
        var liToRemove;
        liToRemove = this.parentNode;
        var taskId = liToRemove.id;
        liToRemove.parentNode.removeChild(liToRemove);
        //update the db
        var xhr = new XMLHttpRequest();
        xhr.open("post", "delete.php");
        //callback
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.send("id=" + taskId);
    };
    li.appendChild(deleteButton);
    taskList.appendChild(li);
}


function loadTasks() {
    "use strict";
    var xhr = new XMLHttpRequest();
    xhr.open("get", "todo.php");
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4) {
            //xhr.responseText stores json data as a string
            var tasks = JSON.parse(xhr.responseText);
            for(var i=0;i<tasks.length;i++) {
                addTaskToUI(tasks[i].id, tasks[i].description);
            }
        }
    };
    xhr.send(null);
}

/*
function init(){
    var button = document.getElementById("voteHitbox");
    button.onclick = sendVoteToEntry();
}

function sendVoteToEntry() {
    var voteCount = document.getElementById("voteCount").valueOf();
    voteCount += 1;
    document.getElementById("voteCount").innerHTML = voteCount;

    var printCart = document.createTextNode(this.value + " was added to the cart.");

    cart.appendChild(printCart);
    cart.appendChild(br());

    if(output) {
        output.parentNode.replaceChild(cart, output);
    } else {
        document.body.appendChild(cart);
    }

}



$(document).ready(function() {
    $("#container").find("div a").click(function() {
        $(this).parent().animate({
            width: '+=100px'
        }, 500);

        $(this).prev().html(parseInt($(this).prev().html()) + 1);
        return false;
    });
});
    */