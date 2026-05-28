# Given a start and end number, count the number of fizz and buzz appearances in the range (inclusive).

# Numbers divisible by 3 count as a fizz.
# Numbers divisible by 5 count as a buzz.
# Numbers divisible by both 3 and 5 count as both a fizz and a buzz.
# Return an object or dictionary with the counts in the format: { fizz, buzz }.

def fizz_buzz_count(start, end):
    fizzBuzzDict = {
        "fizz": 0,
        "buzz": 0
    }
    for eachVal in range(start, end+1):
        # print(eachVal)
        isFizz = eachVal % 3 == 0
        isBuzz = eachVal % 5 == 0
        if isFizz and isBuzz:
            fizzBuzzDict["fizz"]+=1
            fizzBuzzDict["buzz"]+=1
        elif isFizz:
            fizzBuzzDict["fizz"]+=1
        elif isBuzz:
            fizzBuzzDict["buzz"]+=1
    print(fizzBuzzDict)
    # print(fizzBuzzDict.items())
    return fizzBuzzDict

# Testcases 
fizz_buzz_count(1, 11);
fizz_buzz_count(14, 41);
fizz_buzz_count(24, 100);
fizz_buzz_count(-635, -14);
fizz_buzz_count(-5432, 6789);
