# -*- coding: utf-8 -*-
"""
Created on Sat Dec  3 20:46:39 2016

@author: Zhou Qiao

Find the Second Largest Number

Input
5
2 3 6 6 5

Output
5
"""

n, input_list = int(input()),input().split(" ")

input_list = list(map(int, input_list))

sorted_list = sorted(set(input_list))

print(sorted_list[-2])