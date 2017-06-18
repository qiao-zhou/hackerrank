n = int(input())

lst = []

'''
12
insert 0 5
insert 1 10
insert 0 6
print 
remove 6
append 9
append 1
sort 
print
pop
reverse
print
'''

for i in range(n):
    input_arr = input().split(" ")
    if input_arr[0] == "insert":
        lst.insert(int(input_arr[1]),int(input_arr[2]))
    elif input_arr[0] == "print":
        print(lst)
    elif input_arr[0] == "remove":
        lst.remove(int(input_arr[1]))
    elif input_arr[0] == "append":
        lst.append(int(input_arr[1]))
    elif input_arr[0] == "pop":
        lst.pop()
    elif input_arr[0] == "sort":
        lst.sort()
    elif input_arr[0] == "reverse":
        lst.reverse()
    
    