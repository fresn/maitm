chrome.webRequest.onBeforeRequest.addListener(function (details) {
        console.log(details.url);
        console.log(details.requestId);
    }
    , {urls: []}
    , ["requestBody"]);