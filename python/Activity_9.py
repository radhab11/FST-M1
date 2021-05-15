firstList = [15, 20, 30, 15, 55]
secondList = [10, 23, 32, 11, 59]

print("First List", firstList)
print("Second List", secondList)

thirdList = []

for num in firstList:
    if ( num % 2 !=0):
        thirdList.append(num)

for num in secondList:
    if ( num % 2 ==0):
        thirdList.append(num)        

print("The Result is: ", thirdList)        