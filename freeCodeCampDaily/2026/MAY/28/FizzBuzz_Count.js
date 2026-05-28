/*
Given a start and end number, count the number of fizz and buzz appearances in the range (inclusive).

Numbers divisible by 3 count as a fizz.
Numbers divisible by 5 count as a buzz.
Numbers divisible by both 3 and 5 count as both a fizz and a buzz.
Return an object or dictionary with the counts in the format: { fizz, buzz }.
*/

// The Actual logic | Start
function fizzBuzzCount(start, end) {
    let fizzBuzzObj = {
        fizz: 0,
        buzz: 0
    };
    for (let currentVal = start; currentVal <= end; currentVal++) {
        const isFizz = currentVal % 3 === 0;
        const isBuzz = currentVal % 5 === 0;
        if(isFizz && isBuzz){
            ++fizzBuzzObj.fizz; ++fizzBuzzObj.buzz;
        }else if (isFizz) {
            // console.log(currentVal, " Div by 3");
            ++fizzBuzzObj.fizz;
        } else if (isBuzz) {
            // console.log(currentVal, " Div by 5");
            ++fizzBuzzObj.buzz;
        }
    }
    console.log("For ", start, " : ", end, " Object is : ", fizzBuzzObj);
    return fizzBuzzObj;
}
// The Actual logic | END

// The Testcases presented

fizzBuzzCount(1, 11);
fizzBuzzCount(14, 41);
fizzBuzzCount(24, 100);
fizzBuzzCount(-635, -14);
fizzBuzzCount(-5432, 6789);