/**
    * Project: Definery
    * Class: submitVote.js
    * Created by Meesh
    * 11/21/15
    */


var voteCount = document.getElementById("voteCount").valueOf();


function init(){
    var button = document.getElementById("voteHitbox");
    button.onclick = sendVoteToEntry();
}

function sendVoteToEntry() {
    voteCount = voteCount + 1;
    document.getElementById("voteCount").innerHTML = voteCount;

    /*
    var printCart = document.createTextNode(this.value + " was added to the cart.");

    cart.appendChild(printCart);
    cart.appendChild(br());

    if(output) {
        output.parentNode.replaceChild(cart, output);
    } else {
        document.body.appendChild(cart);
    }
    */
}
