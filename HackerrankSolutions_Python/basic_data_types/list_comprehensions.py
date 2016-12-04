# -*- coding: utf-8 -*-
"""
Created on Sat Dec  3 20:11:36 2016

List Comprehensions

@author: Zhou Qiao
"""

'''
Input 
1
1
1
2

[[0, 0, 0], [0, 0, 1], [0, 1, 0], [1, 0, 0], [1, 1, 1]] 
'''

#x, y, z, n = int(input()), int(input()), int(input()), int(input())
x, y, z, n = (int(input()) for _ in range(4))


'''
Solution using nested loop
lst = list()
for i in range(x+1):
    for j in range(y+1):
        for k in range(z+1):
            if i + j + k != n:
                lst.append([i,j,k])
'''


# Solution using list comprehension 
lst = [[i,j,k] for i in range(x+1) for j in range(y+1) for k in range(z+1) if i+j+k != n]
print(lst)