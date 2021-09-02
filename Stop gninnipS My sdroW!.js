// https://www.codewars.com/kata/5264d2b162488dc400000001/train/javascript

function spinWords(string){
    const array = [];
    let str = '';

    const arr = string.split(' ');
    for (let word of arr) {
        if (word.length >= 5) {
            for (let i = word.length - 1; i >= 0; i--) {
                str += word[i];
            }
            array.push(str);
            str = '';
        } else {
            array.push(word);
        }
    }

   return array.join(' ');
}

spinWords("This is a test"); // "This is a test"
spinWords("This is another test"); // "This is rehtona test"

/* Best Solution

function spinWords(words){
  return words.split(' ').map(function (word) {
    return (word.length > 4) ? word.split('').reverse().join('') : word;
  }).join(' ');
}

*/