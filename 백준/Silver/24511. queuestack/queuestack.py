input()
queueStack = input()
current = input()
input()
newNumber = input()

qs = queueStack.split(' ')
arr = current.split(' ')
nNarr = newNumber.split(' ')

count = 0

answer = []

for i in reversed(range(len(qs))):
    if qs[i] == '0':
        count += 1
        if len(answer) < len(nNarr):
            answer.append(arr[i])
        

for i in range(len(nNarr) - count):
    answer.append(nNarr[i])

for a in answer:
    print(a, end=' ')