/**
 * Project: Definery
 * Class: reportEntryAttempt.js
 * Created by Meesh
 * 10/10/15
 */


function init(){
    var button = document.getElementById("submitEntry");
    button.onclick = reportEntryAttempt;
}

function reportEntryAttempt(){
    var form = document.getElementById("form");
    var testOutput = document.getElementById("outputDiv");
    var word = document.getElementById("word").value;
    var pos = document.getElementById("pos").value;
    var pronunciation = document.getElementById("pronunciation").value;
    var pocketDefinition = document.getElementById("pocket_definition").value;
    var completeDefinition = document.getElementById("complete_definition").value;
    var usage = document.getElementById("usage").value;
    var variations = document.getElementById("variations").value;
    var etymology = document.getElementById("etymology_roots").value;

    //var entry = [];
    //entry.push(word, pos, pronunciation, pocketDefinition, completeDefinition, usage, variations, etymology);
    //var entryValue = entry.valueOf();

    var sampleEntry = word + "<br />" +
                      pos + "<br />" +
                      pronunciation + "<br />" +
                      pocketDefinition + "<br />" +
                      completeDefinition + "<br />" +
                      usage + "<br />" +
                      variations + "<br />" +
                      etymology + "<br />";

    testOutput.innerHTML = sampleEntry;

    form.reset();
    return false;
}