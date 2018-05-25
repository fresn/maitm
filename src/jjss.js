document.AjaxConns = [];
document.getAjaxReadyStatus = function () {
    var state = false;
    document.AjaxConns.forEach(function (value, index) {
        if (value.readyState !== 4) {
            state = state || true;

        }
    });
    return state;
};
document.addAjaxConn = function (conn) {
    document.AjaxConns.push(conn)
};
(function (open) {
    XMLHttpRequest.prototype.open = function (method, url, async, user, pass) {
        document.addAjaxConn(this);
        this.addEventListener("readystatechange", function () {
            console.log(document.getAjaxReadyStatus());

            if (this.readyState === 1) {
                this.StateOPENED = Date.now();
            } else if (this.readyState === 2) {
                this.StateHEADERS_RECEIVED = Date.now();
            } else if (this.readyState === 3) {
                this.StateLOADING = Date.now();
            } else if (this.readyState === 4) {
                this.StateDONE = Date.now();
            }
        }, false);

        open.call(this, method, url, async, user, pass);
    };

})(XMLHttpRequest.prototype.open);

