input()
arr = input().split(' ')
x = input()

x = int(x)

for i in range(len(arr)):
    arr[i] = int(arr[i])

arr.sort()

front = 0
back = len(arr) - 1

answer = 0

while front < back:
    num = arr[front] + arr[back]
    if num < x:
        front += 1
    elif num > x:
        back -= 1
    else:
        answer += 1
        front += 1
        back -=1

print(answer)