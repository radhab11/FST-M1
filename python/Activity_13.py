
def calculate_sum(numbers):
    sum = 0
    for number in numbers:
        sum += number
    return sum

numList = [10, 15, 20, 35]

res = calculate_sum(numList)

print("The sum of all elements: " + str(res))