const Toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 800
});

const successAlert = (msg) => {
    Toast.fire({
        icon: 'success',
        text: msg
    }).then(function () {
        window.location.reload()
    })
}

const errorAlert = (msg) => {
    Toast.fire({
        icon: 'error',
        text: msg
    }).then(function () {
        window.location.reload()
    })
}

const resultAlert = (msg, icon) => {
    Swal.fire({
        text: msg,
        icon: icon,
        showCancelButton: false,
        showCloseButton: false,
        showConfirmButton: false,
        timer: 800
    }).then(() => {
        window.location.reload()
    })
}

const deleteAlert = (url, method, data) => {
    Swal.fire({
        text: "是否要删除此数据?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '是',
        cancelButtonText: '否'
    }).then((result) => {
        if (result.isConfirmed) {
            const config = {
                url: url,
            }
            config.method = method;
            if (method.toLowerCase() === "get") {
                config.param = data;
            } else {
                config.data = data;
            }
            config.success = (res) => {
                if (res.code === 200) {
                    resultAlert(res.message, "success")
                } else {
                    resultAlert(res.message, "error")
                }
            }
            config.error = (res) => {
                resultAlert(res.message, "error")
            }
            $.ajax(config)
        }
    })
}

(function () {
    return {successAlert, errorAlert, resultAlert, deleteAlert}
}())