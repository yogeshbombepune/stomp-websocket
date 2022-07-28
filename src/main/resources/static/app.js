var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#datafeed").html("");
}

function connect() {
    var socket = new SockJS('http://localhost:9999/mockdatafeed');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/feeds', function (data) {
            showStocks(data.body);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello-stock-exchange", {}, JSON.stringify({'name': $("#name").val()}));
}

function showStocks(message) {
	$("#datafeed").html("");
	var data = JSON.parse(message);
	data.forEach(function(item){
		var tr = $("<tr />");
		tr.append("<td>" + item.stockName + "</td>");
		tr.append("<td>" + item.currency + "</td>");
		tr.append("<td>" + Number(item.price).toFixed(2)  + "</td>");
		$("#datafeed").append(tr);
	})
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});