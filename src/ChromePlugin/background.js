(function () {
    function findC(tar) {
        document.AjaxConns.find()
    }

    document.AjaxConns = [];
    document.getAjaxReadyStatus = function () {
        let state = false;
        document.AjaxConns.forEach(function (value, index) {
            if (value.readyState !== 4) {
                state = state || true;
            }
        });
        return state;
    };

    document.getAjaxReadyData = function () {
        return JSON.stringify(document.AjaxConns);
    };


    document.addAjaxConn = function (conn) {
        document.AjaxConns.push(conn)
    };

    class ConnItem {
        constructor() {
            this.requestId = "";
            this.timeOpen = "";
            this.timeSendReq = "";
            this.timeRep = "";
            this.timeClose = "";
            this.Url = "";
            this.RedirectUrl = "";
            this.state = ""
        }
    }

    chrome.webRequest.onBeforeRequest.addListener(
        function (details) {
            console.log(details.timeStamp + " : " + details.requestId.toString() + " state open");
            let localConnI = new ConnItem();
            localConnI.requestId = details.requestId.toString();
            localConnI.timeOpen = details.timeStamp;
            localConnI.Url = details.url;
            document.AjaxConns.push(localConnI);
        }, {urls: []},
        ['requestBody']
    );

    chrome.webRequest.onSendHeaders.addListener(
        function (details) {
            console.log(details.timeStamp + " : " + details.requestId.toString() + " state sending");
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).timeSendReq = details.timeStamp;
        }, {urls: []},
        ['requestHeaders']
    );

    chrome.webRequest.onBeforeRedirect.addListener(
        function (details) {
            console.log(details.timeStamp + " : " + details.requestId.toString() + " Redirect to " + details.redirectUrl);
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).RedirectUrl = details.redirectUrl;
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).timeClose = details.timeStamp;
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).state = details.statusCode
        },
        {urls: []},
        ['responseHeaders']
    );

    chrome.webRequest.onResponseStarted.addListener(
        function (details) {
            console.log(details.timeStamp + " : " + details.requestId.toString() + " state sending");
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).timeRep = details.timeStamp;
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).state = details.statusCode
        }, {urls: []}, ['responseHeaders']
    );

    chrome.webRequest.onCompleted.addListener(
        function (details) {
            console.log(details.timeStamp + " : " + details.requestId.toString() + " state completed");
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).timeClose = details.timeStamp;
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).state = details.statusCode
        }
        , {urls: []}, ['responseHeaders']
    );

    chrome.webRequest.onErrorOccurred.addListener(
        function (details) {
            console.log(details.timeStamp + " : " + details.requestId.toString() + " state err");
            document.AjaxConns.find(function (element) {
                return element.requestId === details.requestId
            }).state = details.statusCode
        }, {urls: []}
    );

    chrome.runtime.onMessage.addListener(function (request, sender, sendResponse) {
        if (request.command === "getAjaxReadyData") {
            sendResponse(document.getAjaxReadyData());
        }
    });

})();

