<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebSocket Client</title>
    <script type="text/javascript">
        var ws;

        function openWS() {
            ws = new WebSocket("ws://localhost:8080/restful-server/websocket-stream");
            ws.onopen = function () {
                document.getElementById("log").innerHTML =
                        document.getElementById("log").innerHTML + "<br/>" + "ws opened";
            };
            ws.onmessage = function (evt) {
                var msg = evt.data;
                document.getElementById("log").innerHTML =
                        document.getElementById("log").innerHTML + "<br/>" + "got message: " + msg;
            };
            ws.onclose = function () {
                document.getElementById("log").innerHTML =
                        document.getElementById("log").innerHTML + "<br/>" + "ws closed";
            };
        }
        function closeWS() {
            ws.close();
        }
        function sendMessage() {
            ws.send(document.getElementById("message").value);
            document.getElementById("message").value = "";
        }
    </script>
</head>
<body>
<div>
    <label for="message">Type your message:</label><input type="text" id="message"/>
    <input type="button" onclick="sendMessage()" value="send"/>
    <input type="button" onclick="openWS()" value="open"/>
    <input type="button" onclick="closeWS()" value="close"/>
</div>
<div id="log" style="align-items: flex-start"></div>
</body>
</html>