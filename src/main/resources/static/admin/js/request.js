const request = (url, method, param) => {
    const config = {
        url: url,
    }
    config.method = method;
    if (method.toLowerCase() === "get") {
        config.param = param;
    } else {
        config.data = param;
    }
    config.success = (res) => {
        if (res.code === 200) {
            successAlert(res.message)
        } else {
            errorAlert(res.message)
        }
    }
    config.error = (res) => {
        errorAlert(res.message)
    }
    $.ajax(config)
}

(function () {
    return request
}())