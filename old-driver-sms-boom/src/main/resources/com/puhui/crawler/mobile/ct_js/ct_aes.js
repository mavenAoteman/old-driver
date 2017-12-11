
function getAES(password){ //加密
    var n = password;
    var t = CryptoJS.MD5('login.189.cn');
    var i = CryptoJS.enc.Utf8.parse(t);
    var r = CryptoJS.enc.Utf8.parse('1234567812345678');
    var u = CryptoJS.AES.encrypt(n, i, {
        iv: r
    });
    return (u + '');
}