let map = new Map();
let charSet = "1234567890qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
var encode = function (longUrl) {
    let en =  getCode(longUrl);
    map.set(longUrl,en);
    map.set(en,longUrl);
    return map.get(longUrl);
};
var decode = function (shortUrl) {
    return map.get(shortUrl);
};
let getCode = function (longUrl) {
    let s = "";
    for (let i = 0; i < 6; i++) {
        let r = Math.floor(Math.random() * charSet.length);
        s.concat(charSet.substring(r, r + 1));
    }
    return s;
}
