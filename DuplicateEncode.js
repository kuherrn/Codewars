// https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/javascript

function duplicateEncode(word) {
    let arr = word.toLowerCase().split("");
    const arrCounter = [];

    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length; j++) {
            if (i === j) {
                continue;
            } else if (arr[i] === arr[j]) {
                arrCounter[i] = ")";
                break;
            } else {
                arrCounter[i] = "(";
            }
        }
        counter = 0;
    }
    
    return arrCounter.join("");
}

duplicateEncode("din"); // Returns (((
duplicateEncode("recede"); // Returns ()()()
duplicateEncode("Success"); // Returns )())())
duplicateEncode("(( @"); // Returns ))((


/* Best Solution

function duplicateEncode(word){
    return word
        .toLowerCase()
        .split('')
        .map( function (a, i, w) {
            return w.indexOf(a) == w.lastIndexOf(a) ? '(' : ')'
        })
        .join('');
}

*/