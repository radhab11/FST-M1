
fruit_shop = {
    "apple": 10,
    "kiwi": 15,
    "banana": 5,
    "orange": 20,
    "lichi": 25 
}

key_to_check = input("what are you looking for?").lower()

if(key_to_check in fruit_shop):
    print("Yes, the fruit is available")
else:
    print("No, the fruit is not available")
