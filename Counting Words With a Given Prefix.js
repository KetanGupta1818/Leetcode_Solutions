var prefixCount = function(words, pref) {
    return words.filter(w=>w.substring(0,pref.length)===pref).length;
};
