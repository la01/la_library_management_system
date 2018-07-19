$(function() {
    console.log("initialize");
    $("#address_zip").focusout(function() {
        getDataFromPostal();
    });
});

function getDataFromPostal() {
    const url = "https://postcode-jp.appspot.com/api/postcode?apiKey=ysqsRxpUcmTsderSgzxzuu8W1sOqsObHXR7LmuA&general=true&office=true&postcode="
    + document.getElementById("address_zip").value;
    $.ajax({
        type: "GET",
        url: url,
        success: function(msg){
            document.getElementById("address_state_town_street").value = msg["data"][0]["allAddress"];
        }
    });
}