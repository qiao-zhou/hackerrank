# -*- coding: utf-8 -*-
"""
Created on Sun Dec  4 11:27:55 2016

@author: Zhou Qiao

Insertion Sort - Part 1

Input:
5
2 4 6 8 3

Output:
2 4 6 8 8 
2 4 6 6 8 
2 4 4 6 8 
2 3 4 6 8 


"""

n = int(input())
input_list = list(map(int, input().split()))

e = input_list[-1]
for i in reversed(range(0, n-1)):
    if e < input_list[i]:
        input_list[i+1] = input_list[i]
        print(*input_list, sep=' ')
    else: 
        input_list[i+1] = e
        print(*input_list, sep=' ')
        break
if input_list[0] > e:
    input_list[0] = e
    print(*input_list, sep=' ')