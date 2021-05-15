
str1 = "012"
num1 = 2
num2 = 0

for i in range(4):
    num1 +=2
    for j in range(len(str1)):
        num2 = num2 + num1

num3 = num2 % int(str1)
print(num3)


